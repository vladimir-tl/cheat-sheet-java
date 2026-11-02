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
     * - task1() -> {Anna=25, Bob=30, Eve=22}
     *
     * Hint: Create a `HashMap` and call `put(key, value)` for every customer.
     */
    static Map<String, Integer> task1() {
        return null;
    }

    /**
     * Ticket 2. Lookup in the CRM
     * A customer calls and gives their name. Find their age in the CRM.
     * If there is no card with this name, return -1.
     *
     * - Input: map, the cards (name -> age); key, the name.
     * - Return: the age for this name, or -1 if the name is not a key of the map.
     *
     * Examples:
     * - map {Anna=25, Bob=30}, key "Bob" -> 30
     * - map {Anna=25, Bob=30}, key "Tom" -> -1
     *
     * Hint: `getOrDefault(key, defaultValue)` returns the default when the key is missing.
     */
    static int task2(Map<String, Integer> map, String key) {
        return 0;
    }

    /**
     * Ticket 3. Is the customer registered?
     * Before creating a new card the agent checks that the customer does not have one yet.
     *
     * - Input: map, the cards (name -> age); key, the name.
     * - Return: true if the map has this key, otherwise false.
     *
     * Examples:
     * - map {Anna=25}, key "Anna" -> true
     * - map {Anna=25}, key "Tom" -> false
     *
     * Hint: A `Map` can check whether it has a key without reading the value.
     */
    static boolean task3(Map<String, Integer> map, String key) {
        return false;
    }

    /**
     * Ticket 4. List for the manager
     * The manager wants to see all customer cards. Go through the map and print every pair
     * as name=age, each on its own line.
     *
     * - Input: map, the cards (name -> age).
     * - Return: nothing, the method prints to the console.
     *
     * Expected output for {Anna=25, Bob=30} (the order of the lines may differ):
     *
     *   Anna=25
     *   Bob=30
     *
     * Hint: Loop over `map.entrySet()`; every entry has `getKey()` and `getValue()`.
     */
    static void task4(Map<String, Integer> map) {
    }

    /**
     * Ticket 5. Total of the order
     * The map holds the products of one order: the product name is the key, its price is
     * the value. The customer wants to know the total.
     *
     * - Input: map, the products (name -> price).
     * - Return: the sum of all the prices (all the values), or 0 for an empty map.
     *
     * Examples:
     * - {Vinyl=30, CD=15, Poster=5} -> 50
     * - {} -> 0
     *
     * Hint: `map.values()` gives all the prices; add them up in a loop.
     */
    static int task5(Map<String, Integer> map) {
        return 0;
    }

    /**
     * Ticket 6. Typo statistics
     * The quality team studies the messages of customers. Count how many times every character
     * appears in the text. Spaces and punctuation are characters too.
     *
     * - Input: s, the text.
     * - Return: a new map: character -> how many times it appears.
     *
     * Examples:
     * - task6("aab") -> {a=2, b=1}
     * - task6("hello") -> {h=1, e=1, l=2, o=1}
     * - task6("") -> {}
     *
     * Hint: Loop over `s.toCharArray()`. For every char `c` put `getOrDefault(c, 0) + 1`.
     */
    static Map<Character, Integer> task6(String s) {
        return null;
    }
}
