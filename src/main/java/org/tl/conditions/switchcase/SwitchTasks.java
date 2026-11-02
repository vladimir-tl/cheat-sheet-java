package org.tl.conditions.switchcase;

/**
 * PRACTICE TASKS: switch
 *
 * Implement the methods and check them in main. Solutions are in SwitchSolutions.java;
 * peek only after you've tried.
 */
public class SwitchTasks {

    enum Direction {UP, DOWN, LEFT, RIGHT}

    public static void main(String[] args) {
        // check your solutions here
    }

    /** 1. Return the day name for 1..7 (1 = "Monday" ... 7 = "Sunday"), otherwise "Unknown". */
    static String task1(int day) {
        return null;
    }

    /** 2. Return true for weekend days (6 and 7), false for any other number. */
    static boolean task2(int day) {
        return false;
    }

    /** 3. Return the number of days in the month (1..12). February has 28. Others: -1. */
    static int task3(int month) {
        return 0;
    }

    /** 4. Return the season for the month: Winter (12, 1, 2), Spring (3-5), Summer (6-8), Autumn (9-11). */
    static String task4(int month) {
        return null;
    }

    /** 5. Return the number for the word: "one" -> 1, "two" -> 2, "three" -> 3, otherwise 0. */
    static int task5(String word) {
        return 0;
    }

    /**
     * 6. Calculator: return the result of a operator b for "+", "-", "*", "/".
     * For any other operator return 0.
     */
    static int task6(int a, String operator, int b) {
        return 0;
    }

    /** 7. Return true if the char is a vowel (a, e, i, o, u), false otherwise. Lower case only. */
    static boolean task7(char c) {
        return false;
    }

    /** 8. Return the text for the grade: 5 -> "Excellent", 4 -> "Good", 3 -> "Satisfactory", 2 or 1 -> "Fail", otherwise "Invalid". */
    static String task8(int grade) {
        return null;
    }

    /** 9. Return the opposite direction: UP <-> DOWN, LEFT <-> RIGHT. Use a switch expression. */
    static Direction task9(Direction direction) {
        return null;
    }

    /** 10. Return the discount in percent for the customer type: "gold" -> 20, "silver" -> 10, "bronze" -> 5, otherwise 0. */
    static int task10(String type) {
        return 0;
    }
}
