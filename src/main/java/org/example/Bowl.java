package org.example;

class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = foodAmount;
    }

    public boolean decreaseFood(int amount) {
        if (amount <= 0) {
            System.out.println("Нельзя забрать отрицательное или нулевое количество еды.");
            return false;
        }
        if (foodAmount >= amount) {
            foodAmount -= amount;
            return true;
        }
        return false;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("В миску добавлено " + amount + " еды. Теперь в миске " + foodAmount + " еды.");
        } else {
            System.out.println("Нельзя добавить отрицательное количество еды.");
        }
    }

    public int getFoodAmount() {
        return foodAmount;
    }
}
