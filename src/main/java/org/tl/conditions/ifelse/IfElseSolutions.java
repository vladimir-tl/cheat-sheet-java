package org.tl.conditions.ifelse;

/**
 * SOLUTIONS for IfElseTasks.
 */
public class IfElseSolutions {

    static boolean task1(int n) {
        return n > 0;
    }

    static boolean task2(int n) {
        return n % 2 == 0;
    }

    static int task3(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    static String task4(int n) {
        if (n > 0) {
            return "positive";
        } else if (n < 0) {
            return "negative";
        } else {
            return "zero";
        }
    }

    static boolean task5(int n, int from, int to) {
        return n >= from && n <= to;
    }

    static int task6(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }

    static String task7(int score) {
        if (score >= 90) {
            return "A";
        } else if (score >= 80) {
            return "B";
        } else if (score >= 70) {
            return "C";
        } else if (score >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    static String task8(int age) {
        if (age < 13) {
            return "child";
        } else if (age < 18) {
            return "teenager";
        } else {
            return "adult";
        }
    }

    static boolean task9(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    static boolean task10(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }

    static boolean task11(String password) {
        return password != null && password.length() >= 8;
    }

    static String task12(int n) {
        if (n % 15 == 0) {
            return "FizzBuzz";
        } else if (n % 3 == 0) {
            return "Fizz";
        } else if (n % 5 == 0) {
            return "Buzz";
        } else {
            return String.valueOf(n);
        }
    }
}
