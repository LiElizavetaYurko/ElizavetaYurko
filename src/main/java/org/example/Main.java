package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Dog dog1 = new Dog("Барсик");
        Cat cat1 = new Cat("Лилия");

        dog1.run(-1);
        dog1.run(0);
        dog1.run(1);
        dog1.run(499);
        dog1.run(500);
        dog1.run(501);
        dog1.swim(-1);
        dog1.swim(0);
        dog1.swim(1);
        dog1.swim(9);
        dog1.swim(10);
        dog1.swim(11);

        cat1.run(-1);
        cat1.run(0);
        cat1.run(1);
        cat1.run(199);
        cat1.run(200);
        cat1.run(201);
        cat1.swim(10);

        Bowl bowl = new Bowl(25);
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(new Cat("Гарфилд"));
        cats.add(new Cat("Саймон"));
        cats.add(new Cat("Бегемот"));

        for (Cat cat : cats) {
            cat.eat(bowl, 10);
        }

        System.out.println("\nСостояние котов:");
        for (Cat cat : cats) {
            System.out.println(cat.getName() + " сыт: " + cat.isCatFull() +
                    ", пытался есть: " + cat.hasEaten());
        }
        System.out.println("Остаток еды в миске: " + bowl.getFoodAmount());

        bowl.addFood(5);

        for (Cat cat : cats) {
            if (!cat.isCatFull()) {
                cat.eat(bowl, 10);
            }
        }

        System.out.println("\nВсего животных: " + Animal.getAnimalCount());
        System.out.println("Собак: " + Dog.getDogCount());
        System.out.println("Котов: " + Cat.getCatCount());
    }
}