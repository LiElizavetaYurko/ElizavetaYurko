package org.example;

public class Main {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSing();
        printColor();
        compareNumbers();
        method5( 15, 1);
        method6(-1);
        method7 (0);
        method8 ("repeating string", 3);
        method9 ( 2025);
        method10(new int[] {1, 1, 0, 0, 1, 0, 1, 1, 0, 0});
        method11();
        method12(new int[] {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1});
        method13();
        method14(5, 1);
    }

    public static void printThreeWords(){
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void checkSumSing(){
        int a = 10, b = 20;
        if (a + b >= 0) {
            System.out.println("Сумма положительная");
        }
        else {
            System.out.println("Сумма отрицательная");
        }
    }
    public static void printColor() {
        int value = 110;
        if (value <= 0){
            System.out.println("Красный");
        }
        if (value > 0 && value <= 100){
            System.out.println("Желтый");
        }
        if (value > 100){
            System.out.println("Зеленый");
        }
    }
    public static void compareNumbers() {
        int a = 23;
        int b = 43;
        if (a >= b) {
            System.out.println("a >= b");
        }
        else {
            System.out.println("a<b");
        }
    }
    public static boolean method5(int x, int y){
        int z = x + y;
        if (z > 10 && z <= 20) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void method6(int x){
        if (x >= 0){
            System.out.println("Число положительное");
        }
        else {
            System.out.println("Число отрицательное");
        }
    }
    public static boolean method7(int x){
        if (x >= 0) {
            //System.out.println("false");
            return false;
        }
        else {
            //System.out.println("true");
            return true;
        }
    }
    public static void method8 (String s, int n){
        for (int i = 1; i <= n; i++){
            System.out.println(s);
        }
    }
    public static boolean method9 (int year){
        if (year % 400 == 0){
            //System.out.println("true");
            return true;
        }
        else if (year % 100 == 0){
            //System.out.println("false");
            return false;
        }
        else {
            //System.out.println(year % 4 == 0);
            return year % 4 == 0;
        }
    }
    public static void method10(int[] arr){
        //printArray(arr);
        for(int i=0; i<arr.length; i++){
            if(arr[i] == 0){
                arr[i] = 1;
            }
            else {
                arr[i] = 0;
            }
        }
        //printArray(arr);
    }
    public static void method11() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        //printArray(array);
    }
    public static void method12(int[] array) {
        //printArray(array);
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] *= 2;
            }
        }
        //printArray(array);
    }
    public static void method13() {
        int size = 4;
        int[][] matrix = new int[size][size];

        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
        //printMatrix(matrix);
    }
    public static int[] method14(int len, int initialValue) {
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = initialValue;
        }
        //printArray(array);
        return array;
    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}