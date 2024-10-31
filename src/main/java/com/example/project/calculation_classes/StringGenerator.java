package com.example.project.calculation_classes;

import java.util.Random;

public class StringGenerator {

    public static String generateRandomString(int length) {
        if (length > 30) {
            length = 30; // Обмежуємо довжину до 50 символів
        }

        StringBuilder stringBuilder = new StringBuilder(length);
        Random random = new Random();
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(alphabet.length());
            stringBuilder.append(alphabet.charAt(index));
        }

        return stringBuilder.toString();
    }

}
