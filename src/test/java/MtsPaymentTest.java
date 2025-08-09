import org.junit.jupiter.api.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class MtsPaymentTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://www.mts.by");
        wait.until(ExpectedConditions.jsReturnsValue("return document.readyState === 'complete'"));
    }
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void testOnlinePaymentBlock() {
        try {
            WebElement acceptCookiesBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Принять') or contains(., 'Accept')]")
            ));
            acceptCookiesBtn.click();
            wait.until(ExpectedConditions.invisibilityOf(acceptCookiesBtn));
        } catch (TimeoutException e) {
            System.out.println("Cookies banner not found, continuing test");
        }
        WebElement title = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//h2[normalize-space()='Онлайн пополнение без комиссии']")
        ));
        Assertions.assertTrue(title.isDisplayed());
    }
    @Test
    public void testAllPaymentSystemLogos() {
        String[][] paymentLogos = {
                {"Visa", "visa"},
                {"Verified By Visa", "visa-verified"},
                {"MasterCard", "mastercard"},
                {"MasterCard Secure Code", "mastercard-secure"},
                {"Белкарт", "belkart"}
        };

        for (String[] logo : paymentLogos) {
            String altText = logo[0];
            String srcPart = logo[1];

            try {
                WebElement logoElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(String.format("//img[@alt='%s' and contains(@src, '%s')]", altText, srcPart))
                ));

                Assertions.assertTrue(logoElement.isDisplayed(),
                        String.format("Логотип %s не отображается", altText));

                System.out.printf("Логотип %s успешно проверен%n", altText);

            } catch (TimeoutException e) {
                Assertions.fail(String.format("Логотип %s не найден на странице", altText));
            }
        }
    }
    @Test
    public void testDetailsLinkSamePage() {
        try {
            acceptCookiesIfPresent();
            String originalUrl = driver.getCurrentUrl();

            WebElement detailsLink = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//a[contains(., 'Подробнее о сервисе')]")
            ));
            detailsLink.click();

            try {
                wait.until(ExpectedConditions.not(ExpectedConditions.urlToBe(originalUrl)));
            } catch (TimeoutException e) {
                WebElement content = wait.until(ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class, 'service-details')]")
                ));
                Assertions.assertTrue(content.isDisplayed(), "Контент о сервисе не отобразился");
            }
            Assertions.assertTrue(driver.getCurrentUrl().contains("poryadok-oplaty"),
                    "Не перешли на страницу с описанием сервиса");

        } catch (Exception e) {
            Assertions.fail("Test failed: " + e.getMessage());
        }
    }
    @Test
    public void testBePaidWidget() {
        acceptCookiesIfPresent();

        driver.findElement(By.id("connection-phone")).sendKeys("297777777");
        driver.findElement(By.id("connection-sum")).sendKeys("100");
        driver.findElement(By.xpath("//button[contains(., 'Продолжить')]")).click();

        WebElement iframe = new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.presenceOfElementLocated(
                        By.cssSelector("iframe.bepaid-iframe")
                ));
        driver.switchTo().frame(iframe);

        try {
            WebElement amountElement = new WebDriverWait(driver, Duration.ofSeconds(15))
                    .until(ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//span[contains(., 'BYN')]")
                    ));
            String amountText = amountElement.getText();
            Assertions.assertTrue(amountText.contains("100.00"),
                    "Сумма платежа не соответствует ожидаемой. Фактическая: " + amountText);
        } finally {
            driver.switchTo().defaultContent();
        }
    }

    private void acceptCookiesIfPresent() {
        try {
            WebElement acceptBtn = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(., 'Принять') or contains(., 'Accept')]")
            ));
            acceptBtn.click();
            wait.until(ExpectedConditions.invisibilityOf(acceptBtn));
        } catch (TimeoutException e) {
            System.out.println("Cookies banner not found");
        }
    }
}