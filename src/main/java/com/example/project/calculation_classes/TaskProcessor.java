package com.example.project.calculation_classes;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class TaskProcessor {
    public static final String NOT_RELEVANT_KEY_TYPE = "Помилка\n" +
            "У полі ключ необхідно вводиити тільки цілочильне значення";
    public static final String DUPLICATE_VALUE = "Помилка\n" +
            "Ключ із таким значенням уже існує!\n" +
            "Поміняйте значення ключа!";
    public static final String NOT_EXIST_DUPLICATE_VALUE = "Помилка\n" +
            "Ключа із таким значенням не існує!\n" +
            "Поміняйте значення ключа!";
    public static final String FILE_NAME = "myDataBase.txt";
    public static final String DATA_IS_OK = "З даними поки все ок\n";
    public static HashSet<Integer> hashSet = new HashSet<>();
    public static BTree<MyNode> bTree = new BTree<>(100);

    public TaskProcessor() {
    }

    public static String validateAddingKey(String keyValue) {
        if (!Validation.isInteger(keyValue)) {
            return NOT_RELEVANT_KEY_TYPE;
        }
        int key = Integer.parseInt(keyValue);
        if (hashSet.contains(key)) {
            return DUPLICATE_VALUE;
        }

        return DATA_IS_OK;
    }

    public static String validateDeletingKey(String keyValue) {
        if (!Validation.isInteger(keyValue)) {
            return NOT_RELEVANT_KEY_TYPE;
        }
        int key = Integer.parseInt(keyValue);
        if (!hashSet.contains(key)) {
            return NOT_EXIST_DUPLICATE_VALUE;
        }
        return DATA_IS_OK;
    }

    public static void addNode(int key, String value) {
        bTree.add(new MyNode(key, value));
        hashSet.add(key);
        System.out.println("Додавання ноду = " + key + " - " + value + " закінчене");
        bTreeToFile();
    }

    public static void deleteNode(int key) {
        bTree.remove(new MyNode(key, ""));
        hashSet.remove(key);
        System.out.println("Видалення ноду із ключом " + key + " закінчене");
        bTreeToFile();
    }

    public static void editNode(int key, String value) {
        deleteNode(key);
        addNode(key, value);
        System.out.println("Редагування ноду з ключем " + key + " - " + value + " закінчене");
        bTreeToFile();
    }

    public static void bTreeToFile() {
        List<MyNode> list = new ArrayList<>();
        for (MyNode myNode : bTree.toCollection()) {
            list.add(myNode);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (var i : list) {
                writer.write(i + "\n");
            }
            // Записуємо дані у файл
            System.out.println("Дані успішно записані у файл: " + FILE_NAME);
        } catch (IOException e) {
            System.err.println("Сталася помилка при записі у файл: " + e.getMessage());
        }
    }

    public static void fileToBTree() {
        try (Scanner scanner = new Scanner(new File(FILE_NAME))) {
            while (scanner.hasNext()) {
                int number = scanner.nextInt();  // Зчитуємо число
                hashSet.add(number);
                String text = scanner.nextLine().trim(); // Зчитуємо текст після числа і видаляємо зайві пробіли
                bTree.add(new MyNode(number, text)); // Додаємо зчитаний об'єкт в bTree
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не знайдено: " + e.getMessage());
        }
    }

    public static void deleteDatabase() {
        bTree.clear();
        try (FileWriter writer = new FileWriter(FILE_NAME, false)) {
            // Файл відкривається в режимі запису, що очищає його вміст
            // Нічого не записуємо, просто закриваємо writer
        } catch (IOException e) {
            System.err.println("Сталася помилка при очищенні файлу: " + e.getMessage());
        }
        hashSet.clear();
    }
}
