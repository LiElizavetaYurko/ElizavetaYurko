package org.example;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Student {
    private String name;
    private String group;
    private int course;
    private Map<String, Integer> grades;

    public Student(String name, String group, int course, Map<String, Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new HashMap<>(grades);
    }

    public double getAverageGrade() {
        return grades.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    public void promoteToNextCourse() {
        this.course++;
    }

    public String getName() {
        return name;
    }

    public int getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", group='" + group + '\'' +
                ", course=" + course +
                ", grades=" + grades +
                '}';
    }

    public static void removeUnderperformingStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    public static void promoteSuccessfulStudents(Set<Student> students) {
        students.forEach(student -> {
            if (student.getAverageGrade() >= 3.0) {
                student.promoteToNextCourse();
            }
        });
    }

    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Students on course " + course + ":");
        students.stream()
                .filter(student -> student.getCourse() == course)
                .forEach(student -> System.out.println(student.getName()));
    }

    public static void main(String[] args) {
        Set<Student> students = new HashSet<>();

        // Добавляем студентов
        students.add(new Student("Alice", "Group A", 1,
                Map.of("Math", 4, "Physics", 3, "Chemistry", 5)));
        students.add(new Student("Bob", "Group B", 2,
                Map.of("Math", 2, "Physics", 2, "Chemistry", 2)));
        students.add(new Student("Charlie", "Group C", 1,
                Map.of("Math", 5, "Physics", 5, "Chemistry", 5)));

        System.out.println("Initial students:");
        students.forEach(System.out::println);

        // Удаляем неуспевающих студентов
        removeUnderperformingStudents(students);
        System.out.println("\nAfter removing underperforming students:");
        students.forEach(System.out::println);

        // Переводим успешных студентов на следующий курс
        promoteSuccessfulStudents(students);
        System.out.println("\nAfter promoting successful students:");
        students.forEach(System.out::println);

        // Печатаем студентов по курсу
        System.out.println();
        printStudents(students, 2);
    }
}
