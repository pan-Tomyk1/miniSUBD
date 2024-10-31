package com.example.project.calculation_classes;

public final class Validation {
    public static boolean isInteger(String str) {
        return str.matches("-?\\d+");
    }
}
