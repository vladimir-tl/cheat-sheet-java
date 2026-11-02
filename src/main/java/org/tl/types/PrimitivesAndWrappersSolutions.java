package org.tl.types;

/**
 * SOLUTIONS for PrimitivesAndWrappersTasks.
 */
public class PrimitivesAndWrappersSolutions {

    public static void main(String[] args) {
        System.out.println(task1("250"));          // 250
        System.out.println(task2("12.5"));         // 12.5
        System.out.println(task3(42));             // 42
        System.out.println(task4(9, 2));           // 4.5
        System.out.println(task5(19.99));          // 19
        System.out.println(task6(2_000_000, 3_000)); // 6000000000
        System.out.println(task7(null));           // 0
        System.out.println(task8(1000, 1000));     // true
    }

    static int task1(String text) {
        return Integer.parseInt(text);
    }

    static double task2(String text) {
        return Double.parseDouble(text);
    }

    static String task3(int orderId) {
        return String.valueOf(orderId);
    }

    static double task4(int sum, int count) {
        return (double) sum / count;   // without (double) it is int division: 9 / 2 = 4
    }

    static int task5(double price) {
        return (int) price;            // narrowing: the fractional part is dropped
    }

    static long task6(int playsPerDay, int days) {
        return (long) playsPerDay * days;   // int * int would overflow before it becomes long
    }

    static int task7(Integer bonus) {
        return bonus == null ? 0 : bonus;   // unboxing null would throw NullPointerException
    }

    static boolean task8(Integer a, Integer b) {
        return a.equals(b);            // == compares objects: false for 1000 and 1000
    }
}
