package org.tl.arrays;

import java.util.Arrays;

/**
 * SOLUTIONS for ArrayTasks.
 */
public class ArraySolutions {

    static int[] task1() {
        return new int[]{1, 2, 3, 4, 5};
    }

    static int[] task2(int n) {
        return new int[n];
    }

    static int task3(int[] arr) {
        return arr[0];
    }

    static int task4(int[] arr) {
        return arr[arr.length - 1];
    }

    static void task5(int[] arr) {
        arr[0] = 100;
    }

    static int task6(int[] arr) {
        return arr.length;
    }

    static int[] task7(int[] arr, int value) {
        int[] bigger = Arrays.copyOf(arr, arr.length + 1);
        bigger[bigger.length - 1] = value;
        return bigger;
    }

    static String task8(int[] arr) {
        return Arrays.toString(arr);
    }

    static int task9(int[] arr) {
        int sum = 0;
        for (int x : arr) {
            sum += x;
        }
        return sum;
    }

    static int[] task10(int[] arr) {
        return Arrays.copyOf(arr, arr.length);
    }
}
