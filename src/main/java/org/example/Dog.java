package org.example;

class Dog extends Animal {
    private static int dogCount = 0;
    private final int MAX_RUN_DISTANCE = 500;
    private final int MAX_SWIM_DISTANCE = 10;
    public Dog(String name) {
        super(name);
        dogCount++;
    }
    @Override
    public void run(int distance) {
        if (distance <= 0){
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }
        else if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать больше " + MAX_RUN_DISTANCE + " м.");
        }
    }
    @Override
    public void swim(int distance) {
        if (distance <= 0){
            System.out.println(getName() + " не может проплыть " + distance + " м.");
        }
        else if (distance <= MAX_SWIM_DISTANCE) {
            System.out.println(getName() + " проплыл " + distance + " м.");
        } else {
            System.out.println(getName() + " не может проплыть больше " + MAX_SWIM_DISTANCE + " м.");
        }
    }
    public static int getDogCount() {
        return dogCount;
    }
}

