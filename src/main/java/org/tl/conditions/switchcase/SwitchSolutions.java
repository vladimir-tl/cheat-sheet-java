package org.tl.conditions.switchcase;

import org.tl.conditions.switchcase.SwitchTasks.Direction;

/**
 * SOLUTIONS for SwitchTasks.
 */
public class SwitchSolutions {

    static String task1(int day) {
        return switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Saturday";
            case 7 -> "Sunday";
            default -> "Unknown";
        };
    }

    static boolean task2(int day) {
        return switch (day) {
            case 6, 7 -> true;
            default -> false;
        };
    }

    static int task3(int month) {
        return switch (month) {
            case 2 -> 28;
            case 4, 6, 9, 11 -> 30;
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            default -> -1;
        };
    }

    static String task4(int month) {
        return switch (month) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Autumn";
            default -> "Not a month";
        };
    }

    static int task5(String word) {
        return switch (word) {
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            default -> 0;
        };
    }

    static int task6(int a, String operator, int b) {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> 0;
        };
    }

    static boolean task7(char c) {
        return switch (c) {
            case 'a', 'e', 'i', 'o', 'u' -> true;
            default -> false;
        };
    }

    static String task8(int grade) {
        return switch (grade) {
            case 5 -> "Excellent";
            case 4 -> "Good";
            case 3 -> "Satisfactory";
            case 2, 1 -> "Fail";
            default -> "Invalid";
        };
    }

    static Direction task9(Direction direction) {
        return switch (direction) {
            case UP -> Direction.DOWN;
            case DOWN -> Direction.UP;
            case LEFT -> Direction.RIGHT;
            case RIGHT -> Direction.LEFT;
        };
    }

    static int task10(String type) {
        return switch (type) {
            case "gold" -> 20;
            case "silver" -> 10;
            case "bronze" -> 5;
            default -> 0;
        };
    }
}
