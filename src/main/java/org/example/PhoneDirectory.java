package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneDirectory {
    private Map<String, List<String>> directory;

    public PhoneDirectory() {
        directory = new HashMap<>();
    }

    // Метод для добавления записи
    public void add(String lastName, String phoneNumber) {
        // Если фамилии нет в справочнике - создаем новую запись
        directory.putIfAbsent(lastName, new ArrayList<>());
        // Добавляем телефон к существующей фамилии
        directory.get(lastName).add(phoneNumber);
    }

    // Метод для поиска номеров по фамилии
    public List<String> get(String lastName) {
        // Возвращаем список номеров или пустой список, если фамилии нет
        return directory.getOrDefault(lastName, new ArrayList<>());
    }

    // Дополнительный метод для вывода всего справочника
    public void printAll() {
        for (Map.Entry<String, List<String>> entry : directory.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    // Пример использования
    public static void main(String[] args) {
        PhoneDirectory dir = new PhoneDirectory();

        // Добавляем записи
        dir.add("Иванов", "123-456");
        dir.add("Петров", "555-123");
        dir.add("Иванов", "789-012"); // Добавляем второй номер для Иванова

        // Поиск номеров
        System.out.println("Иванов: " + dir.get("Иванов"));
        System.out.println("Петров: " + dir.get("Петров"));
        System.out.println("Сидоров: " + dir.get("Сидоров")); // Нет в справочнике

        // Вывод всего справочника
        System.out.println("\nВесь справочник:");
        dir.printAll();
    }
}
