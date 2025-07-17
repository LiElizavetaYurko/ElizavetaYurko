package org.example;

class Cat extends Animal {
    private static int catCount = 0;
    private final int MAX_RUN_DISTANCE = 200;
    private boolean isCatFull; // сытость кота
    private boolean hasEaten; // пытался ли кот есть

    public Cat(String name) {
        super(name);
        isCatFull = false;
        hasEaten = false;
        catCount++;
    }

    @Override
    public void run(int distance) {
        if (distance <= 0){
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }
        if (distance <= MAX_RUN_DISTANCE) {
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать больше " + MAX_RUN_DISTANCE + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать.");
    }

    public void eat(Bowl bowl, int amount) {
        if (bowl.decreaseFood(amount)) {
            isCatFull = true;
            System.out.println(getName() + " поел из миски и теперь сыт.");
        } else {
            System.out.println(getName() + " не смог поесть из миски. Недостаточно еды.");
        }
        hasEaten = true;
    }

    public boolean isCatFull() {
        return isCatFull;
    }

    public boolean hasEaten() {
        return hasEaten;
    }

    public static int getCatCount() {
        return catCount;
    }
}
