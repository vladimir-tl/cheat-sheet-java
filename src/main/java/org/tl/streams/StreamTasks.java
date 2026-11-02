package org.tl.streams;

import java.util.List;
import java.util.Map;

/**
 * PRACTICE TASKS: Stream API
 *
 * You work in the support team of an online music store. Every task is a small
 * situation from work. Solve each one with a stream (no for loops).
 * Implement the methods and check them in main.
 * Solutions are in StreamSolutions.java; peek only after you've tried.
 */
public class StreamTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Big invoices
     * The accountant wants to check only the large invoices.
     * From the invoice totals return those greater than 100.
     */
    static List<Integer> task1(List<Integer> totals) {
        return null;
    }

    /**
     * Ticket 2. Prices in cents
     * The payment system works with cents. Return the prices multiplied by 100:
     * [5, 12] -> [500, 1200].
     */
    static List<Integer> task2(List<Integer> prices) {
        return null;
    }

    /**
     * Ticket 3. Label printer
     * The label printer needs the customer names in upper case. "Anna" -> "ANNA".
     */
    static List<String> task3(List<String> names) {
        return null;
    }

    /**
     * Ticket 4. Urgent tickets
     * The list holds the priority of every ticket; 1 means "urgent".
     * How many urgent tickets are there?
     */
    static long task4(List<Integer> priorities) {
        return 0;
    }

    /**
     * Ticket 5. Revenue of the day
     * Return the sum of all the invoice totals.
     */
    static int task5(List<Integer> totals) {
        return 0;
    }

    /**
     * Ticket 6. Average rating
     * Customers rated the support from 1 to 5. Return the average rating,
     * or 0 if nobody has rated yet.
     */
    static double task6(List<Integer> ratings) {
        return 0;
    }

    /**
     * Ticket 7. The biggest invoice
     * Return the biggest invoice total, or -1 if there are no invoices.
     */
    static int task7(List<Integer> totals) {
        return 0;
    }

    /**
     * Ticket 8. Top 3 invoices
     * The manager wants the three biggest invoices, the biggest first.
     * [5, 12, 8, 20, 3] -> [20, 12, 8].
     */
    static List<Integer> task8(List<Integer> totals) {
        return null;
    }

    /**
     * Ticket 9. Countries of our customers
     * The list holds the country of every order. Return every country once,
     * in the order of the first appearance.
     */
    static List<String> task9(List<String> countries) {
        return null;
    }

    /**
     * Ticket 10. Any refund?
     * The list holds the movements of an account; a refund is a negative number.
     * Is there at least one refund?
     */
    static boolean task10(List<Integer> movements) {
        return false;
    }

    /**
     * Ticket 11. All orders paid?
     * The list holds the paid amounts of the orders. Are all the amounts greater than 0?
     */
    static boolean task11(List<Integer> amounts) {
        return false;
    }

    /**
     * Ticket 12. First long title
     * Find the first track title that is longer than 10 characters,
     * or return "none" if there is no such title.
     */
    static String task12(List<String> titles) {
        return null;
    }

    /**
     * Ticket 13. Mailing list
     * Make one line with all the customer names separated by a comma and a space:
     * ["Anna", "Bob", "Eve"] -> "Anna, Bob, Eve".
     */
    static String task13(List<String> names) {
        return null;
    }

    /**
     * Ticket 14. Customers per country
     * How many orders came from each country? Return a map: country -> number of orders.
     * ["USA", "Brazil", "USA"] -> {USA=2, Brazil=1}.
     */
    static Map<String, Long> task14(List<String> countries) {
        return null;
    }
}
