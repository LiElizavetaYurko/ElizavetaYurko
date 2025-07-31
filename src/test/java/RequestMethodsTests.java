import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;

public class RequestMethodsTests {

    @Test
    public void testGetRequest() {
        RestAssured.given()
                .baseUri("https://postman-echo.com")
                .when()
                .get("/get?foo1=bar1&foo2=bar2")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"))
                .body("headers.host", equalTo("postman-echo.com"))
                .body("url", equalTo("https://postman-echo.com/get?foo1=bar1&foo2=bar2"));
    }

    @Test
    public void testPostRequest() {
        String requestBody = "{\"name\":\"John\", \"age\":30}";

        RestAssured.given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("John"))
                .body("json.age", equalTo(30))
                .body("headers.content-type", containsString("application/json"));
    }

    @Test
    public void testPutRequest() {
        String requestBody = "{\"title\":\"New Title\"}";

        RestAssured.given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.title", equalTo("New Title"));
    }

    @Test
    public void testPatchRequest() {
        String requestBody = "{\"value\":\"updated\"}";

        RestAssured.given()
                .baseUri("https://postman-echo.com")
                .contentType("application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("json.value", equalTo("updated"));
    }

    @Test
    public void testDeleteRequest() {
        RestAssured.given()
                .baseUri("https://postman-echo.com")
                .when()
                .delete("/delete")
                .then()
                .statusCode(200)
                .body("url", equalTo("https://postman-echo.com/delete"));
    }

}