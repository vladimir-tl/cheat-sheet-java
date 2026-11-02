package org.tl.loops.whileloop;

/**
 * SOLUTIONS for WhileTasks.
 */
public class WhileSolutions {

    static void task1() {
        int i = 1;
        while (i <= 10) {
            System.out.println(i);
            i++;
        }
    }

    static void task2() {
        int i = 10;
        while (i >= 1) {
            System.out.println(i);
            i--;
        }
    }

    static int task3(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i++;
        }
        return sum;
    }

    static int task4(int n) {
        if (n == 0) return 1;
        int digits = 0;
        while (n > 0) {
            n /= 10;
            digits++;
        }
        return digits;
    }

    static int task5(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10; // last digit
            n /= 10;
        }
        return sum;
    }

    static int task6(int n) {
        int reversed = 0;
        while (n > 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }
        return reversed;
    }

    static int task7(int n) {
        int steps = 0;
        while (n > 1) {
            n /= 2;
            steps++;
        }
        return steps;
    }

    static int task8(int a, int b) {
        while (b != 0) {
            int rest = a % b;
            a = b;
            b = rest;
        }
        return a;
    }

    static int task9(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            if (arr[i] < 0) return i;
            i++;
        }
        return -1;
    }

    static int task10(int n) {
        int steps = 0;
        while (n != 1) {
            if (n % 2 == 0) n /= 2;
            else n = 3 * n + 1;
            steps++;
        }
        return steps;
    }
}
