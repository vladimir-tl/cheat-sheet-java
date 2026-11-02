package org.tl.collections.list;

import java.util.List;

/**
 * PRACTICE TASKS: List (very simple, no loops)
 *
 * You work in the support team of an online music store. Every task is a small
 * situation from work. Implement the methods and check them in main.
 * Solutions are in ListSolutions.java; peek only after you've tried.
 */
public class ListTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. New support queue
     * The shift starts and nobody is waiting yet. Create an empty list for the names of customers
     * and return it.
     */
    static List<String> task1() {
        return null;
    }

    /**
     * Ticket 2. Morning shift
     * Three customers are already waiting: "Anna", "Bob", "Eve" (in this order).
     * Create a list with their names and return it.
     */
    static List<String> task2() {
        return null;
    }

    /**
     * Ticket 3. Who is next?
     * Return the name of the customer who is first in the queue.
     */
    static String task3(List<String> list) {
        return null;
    }

    /**
     * Ticket 4. Who came last?
     * Return the name of the customer who joined the queue last.
     */
    static String task4(List<String> list) {
        return null;
    }

    /**
     * Ticket 5. How many are waiting?
     * Return the number of customers in the queue.
     */
    static int task5(List<String> list) {
        return 0;
    }

    /**
     * Ticket 6. A new customer joins
     * A customer with the given name joins the queue. Add the name to the end of the list.
     */
    static void task6(List<String> list, String name) {
    }

    /**
     * Ticket 7. Name correction
     * The first customer's name was typed wrongly. Replace the first name in the list
     * with the correct one.
     */
    static void task7(List<String> list, String name) {
    }

    /**
     * Ticket 8. Customer served
     * The first customer in the queue has been helped and leaves. Remove the first name from the list.
     */
    static void task8(List<String> list) {
    }

    /**
     * Ticket 9. Is the customer in the queue?
     * A customer calls and asks: "Am I already in the queue?" Return true if the name is in the list.
     */
    static boolean task9(List<String> list, String name) {
        return false;
    }

    /**
     * Ticket 10. Position in the queue
     * The customer asks: "What is my position?" Return the index of the name in the list
     * (0 is the first place), or -1 if the name is not in the list.
     */
    static int task10(List<String> list, String name) {
        return 0;
    }

    /**
     * Ticket 11. Is the queue empty?
     * The agent wants to take a break. Return true if nobody is waiting.
     */
    static boolean task11(List<String> list) {
        return false;
    }

    /**
     * Ticket 12. Invoices from small to big
     * The list holds the totals of today's invoices. Sort it in ascending order.
     */
    static void task12(List<Integer> numbers) {
    }

    /**
     * Ticket 13. The biggest invoice
     * Which invoice total in the list is the biggest?
     */
    static int task13(List<Integer> numbers) {
        return 0;
    }

    /**
     * Ticket 14. End of the shift
     * The shift is over and the queue is handed over to another team. Remove all names from the list.
     */
    static void task14(List<String> list) {
    }
}
