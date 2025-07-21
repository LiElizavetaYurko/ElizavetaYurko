package org.example;

class MyArraySizeException extends Exception {
    public MyArraySizeException(String message) {
        super(String.format("MyArraySizeException: %s", message));
    }
}

class MyArrayDataException extends Exception {
    public MyArrayDataException(int row, int col, String value) {
        super(String.format("MyArrayDataException: Невалидное значение в ячейке [%d][%d]: '%s' (ожидалось число)", row, col, value));
    }
}