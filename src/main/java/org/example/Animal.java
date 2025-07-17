package org.example;

public class Animal {
    private static int animalCount = 0;
    private String name;
    public Animal(String name) {
        this.name = name;
        animalCount++;
    }
    public void run(int distance) { }
    public void swim(int distance) { }
    public String getName() {
        return name;
    }
    public static int getAnimalCount() {
        return animalCount;
    }
}
