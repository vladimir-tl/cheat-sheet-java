package org.tl.arrays;

import java.util.Arrays;

/**
 * CHEAT SHEET: arrays
 *
 * Theory: see org.tl.theory.ArrayTheory
 */
public class ArrayCheatSheet {

    public static void main(String[] args) {
        creating();
        readAndChange();
        adding();
        printing();
        looping();
        copying();
    }

    /** 1. Creating: with values, or empty with a size */
    static void creating() {
        int[] numbers = {10, 20, 30};        // I know the values
        int[] empty = new int[5];            // I know only the size: [0, 0, 0, 0, 0]
        String[] names = new String[3];      // [null, null, null]
        System.out.println(Arrays.toString(numbers) + " " + Arrays.toString(empty) + " " + Arrays.toString(names));
    }

    /** 2. Read and change: array[index], length */
    static void readAndChange() {
        int[] numbers = {10, 20, 30};
        numbers[1] = 99;                                 // {10, 99, 30}
        System.out.println(numbers[0]);                  // 10
        System.out.println(numbers.length);              // 3 (no parentheses)
        System.out.println(numbers[numbers.length - 1]); // 30: the last one
    }

    /** 3. Adding: an array can't grow, so make a bigger copy */
    static void adding() {
        int[] numbers = {10, 20, 30};
        numbers = Arrays.copyOf(numbers, numbers.length + 1); // {10, 20, 30, 0}
        numbers[numbers.length - 1] = 40;                     // {10, 20, 30, 40}
        System.out.println(Arrays.toString(numbers));
    }

    /** 4. Printing: Arrays.toString, not println(array) */
    static void printing() {
        int[] numbers = {10, 20, 30};
        System.out.println(Arrays.toString(numbers)); // [10, 20, 30]
    }

    /** 5. Looping: for by index and for-each */
    static void looping() {
        int[] numbers = {10, 20, 30};
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(i + ": " + numbers[i]);
        }
        for (int number : numbers) {
            System.out.println(number);
        }
    }

    /** 6. Copy: b = a is NOT a copy, it is a second name for the same array */
    static void copying() {
        int[] a = {1, 2, 3};
        int[] same = a;                           // the same array
        int[] copy = Arrays.copyOf(a, a.length);  // a real copy
        same[0] = 100;                            // a is {100, 2, 3}
        System.out.println(Arrays.toString(a) + " " + Arrays.toString(copy));
        System.out.println(Arrays.equals(a, same)); // compare values: true
    }
}
