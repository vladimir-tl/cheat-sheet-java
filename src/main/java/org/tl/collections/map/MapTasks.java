package org.tl.collections.map;

import java.util.Map;

/**
 * PRACTICE TASKS: Map
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work, and every ticket is one method that you have to finish.
 * Maps are written here as {key=value, ...}, the way Java prints them. A HashMap has
 * no fixed order, so the pairs may be printed in a different order.
 *
 * - Input: the parameters the method gets.
 * - Return: what the method must give back (or what it must print).
 * - Examples: inputs with their expected results. Run them in main to check yourself.
 *
 * Solutions are in MapSolutions.java; peek only after you've tried.
 */
public class MapTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Customer cards
     * The CRM stores a card for every customer: the name is the key, the age is the value.
     * Create a Map<String, Integer> with three customers, for example Anna 25, Bob 30 and Eve 22.
     *
     * - Input: nothing, the method has no parameters (the brackets are empty).
     * - Return: a new map with three name -> age pairs.
     *
     * Example:
     * - createCustomers() -> {Anna=25, Bob=30, Eve=22}
     *
     * Hint: Create a `HashMap` and call `put(key, value)` for every customer.
     */
    static Map<String, Integer> createCustomers() {
        return null;
    }

    /**
     * Ticket 2. Find a customer's age by name
     * A customer calls support and gives their name. Find their age in the CRM.
     * If there is no card with this name, return -1. That way the code that called
     * the method knows the customer wasn't found.
     *
     * - Input: customers, the customer cards: the key is the name, the value is the age; name, the name the customer gave.
     * - Return: the customer's age, or -1 if there is no such name in the map.
     *
     * Examples:
     * - customers {Anna=25, Bob=30}, name "Bob" -> 30
     * - customers {Anna=25, Bob=30}, name "Tom" -> -1
     *
     * Hint: `customers.get(name)` returns null for a missing name, and null can't become an int.
     * `customers.getOrDefault(name, -1)` returns the age if the name is there and -1 if it isn't.
     */
    static int findAgeByName(Map<String, Integer> customers, String name) {
        return 0;
    }

    /**
     * Ticket 3. Is the customer registered?
     * Before creating a new card the agent checks that the customer does not have one yet.
     *
     * - Input: customers, the customer cards (name -> age); name, the name to check.
     * - Return: true if there is such a name in the map, otherwise false.
     *
     * Examples:
     * - customers {Anna=25}, name "Anna" -> true
     * - customers {Anna=25}, name "Tom" -> false
     *
     * Hint: A `Map` can check whether it has a key without reading the value.
     */
    static boolean hasCustomer(Map<String, Integer> customers, String name) {
        return false;
    }

    /**
     * Ticket 4. List for the manager
     * The manager wants to see all customer cards. Go through the map and print every pair
     * as name=age, each on its own line.
     *
     * - Input: customers, the customer cards (name -> age).
     * - Return: nothing, the method prints to the console.
     *
     * Expected output for {Anna=25, Bob=30} (the order of the lines may differ):
     *
     *   Anna=25
     *   Bob=30
     *
     * Hint: Loop over `customers.entrySet()`; every entry has `getKey()` and `getValue()`.
     */
    static void printCustomers(Map<String, Integer> customers) {
    }

    /**
     * Ticket 5. Total of the order
     * The map holds the products of one order: the product name is the key, its price is
     * the value. The customer wants to know the total.
     *
     * - Input: prices, the products of the order (name -> price).
     * - Return: the sum of all the prices (all the values), or 0 for an empty map.
     *
     * Examples:
     * - {Vinyl=30, CD=15, Poster=5} -> 50
     * - {} -> 0
     *
     * Hint: `prices.values()` gives all the prices; add them up in a loop.
     */
    static int orderTotal(Map<String, Integer> prices) {
        return 0;
    }

    /**
     * Ticket 6. Typo statistics
     * The quality team studies the messages of customers. Count how many times every character
     * appears in the text. Spaces and punctuation are characters too.
     *
     * - Input: text, the customer's message.
     * - Return: a new map: character -> how many times it appears.
     *
     * Examples:
     * - countChars("aab") -> {a=2, b=1}
     * - countChars("hello") -> {h=1, e=1, l=2, o=1}
     * - countChars("") -> {}
     *
     * Hint: Loop over `text.toCharArray()`. For every char `c` put `getOrDefault(c, 0) + 1`.
     */
    static Map<Character, Integer> countChars(String text) {
        return null;
    }
}
