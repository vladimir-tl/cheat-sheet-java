package org.tl.conditions.ifelse;

/**
 * PRACTICE TASKS: if-else
 *
 * You work in the support team of an online music store. Every task is a small
 * situation from work. Implement the methods and check them in main.
 * Solutions are in IfElseSolutions.java; peek only after you've tried.
 */
public class IfElseTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Charge or not?
     * The billing system gives you an amount n. If it is greater than 0, it is a charge.
     * Is it a charge?
     */
    static boolean task1(int n) {
        return false;
    }

    /**
     * Ticket 2. Which queue?
     * Tickets with an even number go to queue A, the others to queue B.
     * Does the ticket number n go to queue A (is it even)?
     */
    static boolean task2(int n) {
        return false;
    }

    /**
     * Ticket 3. The higher price
     * Two partner shops sell the same album at prices a and b. Which price is higher?
     * Do not use Math.max.
     */
    static int task3(int a, int b) {
        return 0;
    }

    /**
     * Ticket 4. Account movement
     * Label the movement n on a customer's account: "positive" for money in,
     * "negative" for money out, "zero" for nothing.
     */
    static String task4(int n) {
        return null;
    }

    /**
     * Ticket 5. Delivery window
     * A courier can deliver on days from..to, both ends included.
     * Can the courier deliver on day n?
     */
    static boolean task5(int n, int from, int to) {
        return false;
    }

    /**
     * Ticket 6. Best of three offers
     * Three suppliers offered a, b and c. Which offer is the biggest?
     * Do not use Math.max.
     */
    static int task6(int a, int b, int c) {
        return 0;
    }

    /**
     * Ticket 7. Support quality grade
     * A customer rated the support from 0 to 100 points. Turn it into a grade:
     * 90 and more is "A", 80+ is "B", 70+ is "C", 60+ is "D", below 60 is "F".
     */
    static String task7(int score) {
        return null;
    }

    /**
     * Ticket 8. Content filter
     * The store hides some albums from young listeners. Return the age group of the customer:
     * under 13 is "child", under 18 is "teenager", otherwise "adult".
     */
    static String task8(int age) {
        return null;
    }

    /**
     * Ticket 9. Yearly subscription
     * A yearly subscription has an extra day in a leap year. A year is a leap year if it is
     * divisible by 4, but not by 100, unless it is divisible by 400. Is the year a leap year?
     */
    static boolean task9(int year) {
        return false;
    }

    /**
     * Ticket 10. Cardboard stand
     * A customer wants to build a triangle stand from three cardboard strips of lengths a, b, c.
     * It works only if each strip is shorter than the sum of the other two.
     * Can the triangle be built?
     */
    static boolean task10(int a, int b, int c) {
        return false;
    }

    /**
     * Ticket 11. Password on sign-up
     * A new customer chose a password. It is accepted if it is given (not null)
     * and has at least 8 characters. Is the password accepted?
     */
    static boolean task11(String password) {
        return false;
    }

    /**
     * Ticket 12. Label of one ticket
     * A ticket number divisible by 3 and 5 is "FizzBuzz" (urgent), divisible by 3 is "Fizz"
     * (billing), divisible by 5 is "Buzz" (shipping). Any other ticket is labelled with its
     * number as text. Return the label of the ticket n.
     */
    static String task12(int n) {
        return null;
    }
}
