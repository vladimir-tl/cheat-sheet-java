package org.tl.loops.forloop;

/**
 * SOLUTIONS for ForTasks.
 */
public class ForSolutions {

    static void task1() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i);
        }
    }

    static void task2() {
        for (int i = 2; i <= 20; i += 2) {
            System.out.println(i);
        }
    }

    static void task3() {
        for (int i = 10; i >= 1; i--) {
            System.out.println(i);
        }
    }

    static int task4(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    static long task5(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    static int task6(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) max = arr[i];
        }
        return max;
    }

    static int task7(int[] arr) {
        int count = 0;
        for (int x : arr) {
            if (x > 0) count++;
        }
        return count;
    }

    static String task8(String s) {
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }

    static int task9(String s) {
        int count = 0;
        for (char c : s.toLowerCase().toCharArray()) {
            if ("aeiou".indexOf(c) >= 0) count++;
        }
        return count;
    }

    static boolean task10(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static void task11(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void task12(int n) {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) System.out.println("FizzBuzz");
            else if (i % 3 == 0) System.out.println("Fizz");
            else if (i % 5 == 0) System.out.println("Buzz");
            else System.out.println(i);
        }
    }
}
