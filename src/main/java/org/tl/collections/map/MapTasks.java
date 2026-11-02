package org.tl.collections.map;

import java.util.Map;

/**
 * PRACTICE TASKS: Map
 *
 * You work in the support team of an online music store. Every task is a small
 * situation from work. Implement the methods and check them in main.
 * Solutions are in MapSolutions.java; peek only after you've tried.
 */
public class MapTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Customer cards
     * The CRM stores a customer name and the age of the customer. Create a Map<String, Integer>
     * with three customers and their ages and return it.
     */
    static Map<String, Integer> task1() {
        return null;
    }

    /**
     * Ticket 2. Lookup in the CRM
     * A customer calls and gives their name. Return the age stored for this name,
     * or -1 if there is no such customer.
     */
    static int task2(Map<String, Integer> map, String key) {
        return 0;
    }

    /**
     * Ticket 3. Is the customer registered?
     * Return true if the map has a card for the given name.
     */
    static boolean task3(Map<String, Integer> map, String key) {
        return false;
    }

    /**
     * Ticket 4. List for the manager
     * The manager wants to see all customer cards. Print every pair as "name=age",
     * each on its own line.
     */
    static void task4(Map<String, Integer> map) {
    }

    /**
     * Ticket 5. Total of the order
     * The map holds the products of an order and their prices. Return the total price
     * (the sum of all values).
     */
    static int task5(Map<String, Integer> map) {
        return 0;
    }

    /**
     * Ticket 6. Typo statistics
     * The quality team studies the messages of customers. Count how many times every character
     * appears in the text. "aab" -> {a=2, b=1}.
     */
    static Map<Character, Integer> task6(String s) {
        return null;
    }
}
