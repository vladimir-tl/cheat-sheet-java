package org.tl.collections.list;

import java.util.List;

/**
 * PRACTICE TASKS: List (very simple, no loops)
 *
 * You work in the support team of an online music store and look after the queue of customers
 * waiting for help. Every ticket below is a small situation from work, and every ticket is one
 * method that you have to finish. Each one needs just one or two List methods, no loops.
 *
 * - Input: the parameters the method gets.
 * - Return: what the method must give back (or how it must change the list).
 * - Examples: inputs with their expected results. Run them in main to check yourself.
 *
 * Solutions are in ListSolutions.java; peek only after you've tried.
 */
public class ListTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. New support queue
     * The shift starts and nobody is waiting yet. Create an empty list for the names
     * of the customers. Customers will be added to it later, so the list must allow adding.
     *
     * - Input: nothing, the method has no parameters (the brackets are empty).
     * - Return: a new empty list.
     *
     * Example:
     * - task1() -> []
     *
     * Hint: `new ArrayList<>()` gives an empty list you can add to.
     */
    static List<String> task1() {
        return null;
    }

    /**
     * Ticket 2. Morning shift
     * Three customers are already waiting: "Anna", "Bob" and "Eve", in this order.
     * Create a list with their names.
     *
     * - Input: nothing, the method has no parameters (the brackets are empty).
     * - Return: a new list with the three names.
     *
     * Example:
     * - task2() -> ["Anna", "Bob", "Eve"]
     *
     * Hint: Create an empty `ArrayList` and call `add` three times.
     */
    static List<String> task2() {
        return null;
    }

    /**
     * Ticket 3. Who is next?
     * The agent is free and calls the next customer: the one at the start of the queue.
     *
     * - Input: list, the queue (not empty).
     * - Return: the first name in the list.
     *
     * Examples:
     * - ["Anna", "Bob", "Eve"] -> "Anna"
     * - ["Tom"] -> "Tom"
     *
     * Hint: `get(index)` reads an element; the first index is `0`.
     */
    static String task3(List<String> list) {
        return null;
    }

    /**
     * Ticket 4. Who came last?
     * The supervisor asks who joined the queue most recently: that is the last name in the list.
     * The method must work for a list of any length.
     *
     * - Input: list, the queue (not empty).
     * - Return: the last name in the list.
     *
     * Examples:
     * - ["Anna", "Bob", "Eve"] -> "Eve"
     * - ["Tom"] -> "Tom"
     *
     * Hint: The last index is `size() - 1`.
     */
    static String task4(List<String> list) {
        return null;
    }

    /**
     * Ticket 5. How many are waiting?
     * The dashboard shows the number of customers in the queue.
     *
     * - Input: list, the queue.
     * - Return: the number of names in the list.
     *
     * Examples:
     * - ["Anna", "Bob", "Eve"] -> 3
     * - [] -> 0
     *
     * Hint: One method of `List` tells how many elements there are.
     */
    static int task5(List<String> list) {
        return 0;
    }

    /**
     * Ticket 6. A new customer joins
     * A customer with the given name joins the queue and stands at the end.
     *
     * - Input: list, the queue; name, the name of the new customer.
     * - Return: nothing. Change the list you got.
     *
     * Example:
     * - list ["Anna", "Bob"], name "Eve" -> the list becomes ["Anna", "Bob", "Eve"]
     *
     * Hint: `add(x)` puts `x` at the end of the list.
     */
    static void task6(List<String> list, String name) {
    }

    /**
     * Ticket 7. Name correction
     * The name of the first customer was typed wrongly. Put the correct name in its place.
     * The other names and the size of the list stay the same.
     *
     * - Input: list, the queue (not empty); name, the correct name.
     * - Return: nothing. Change the list you got.
     *
     * Example:
     * - list ["Ana", "Bob"], name "Anna" -> the list becomes ["Anna", "Bob"]
     *
     * Hint: `set(index, value)` replaces the element at that index.
     */
    static void task7(List<String> list, String name) {
    }

    /**
     * Ticket 8. Customer served
     * The first customer in the queue has been helped and leaves. Remove the first name;
     * everyone else moves one place forward.
     *
     * - Input: list, the queue (not empty).
     * - Return: nothing. Change the list you got.
     *
     * Example:
     * - ["Anna", "Bob", "Eve"] -> the list becomes ["Bob", "Eve"]
     *
     * Hint: `remove` with an `int` argument removes by index: `remove(0)`.
     */
    static void task8(List<String> list) {
    }

    /**
     * Ticket 9. Is the customer in the queue?
     * A customer calls and asks: "Am I already in the queue?"
     *
     * - Input: list, the queue; name, the name of the customer.
     * - Return: true if the name is in the list, otherwise false.
     *
     * Examples:
     * - list ["Anna", "Bob"], name "Bob" -> true
     * - list ["Anna", "Bob"], name "Eve" -> false
     *
     * Hint: There is a `List` method that answers "is it inside?" with `true` or `false`.
     */
    static boolean task9(List<String> list, String name) {
        return false;
    }

    /**
     * Ticket 10. Position in the queue
     * The customer asks: "What is my position?" Positions are indexes, so the first place is 0.
     *
     * - Input: list, the queue; name, the name of the customer.
     * - Return: the index of the name in the list, or -1 if the name is not in the list.
     *
     * Examples:
     * - list ["Anna", "Bob", "Eve"], name "Anna" -> 0
     * - list ["Anna", "Bob", "Eve"], name "Eve" -> 2
     * - list ["Anna", "Bob", "Eve"], name "Tom" -> -1
     *
     * Hint: `indexOf` returns the position, or `-1` if the element is not there.
     */
    static int task10(List<String> list, String name) {
        return 0;
    }

    /**
     * Ticket 11. Is the queue empty?
     * The agent wants to take a break, but only if nobody is waiting.
     *
     * - Input: list, the queue.
     * - Return: true if the list is empty, otherwise false.
     *
     * Examples:
     * - [] -> true
     * - ["Anna"] -> false
     *
     * Hint: `isEmpty()` answers this question directly.
     */
    static boolean task11(List<String> list) {
        return false;
    }

    /**
     * Ticket 12. Invoices from small to big
     * The list holds the totals of today's invoices in random order. The accountant wants
     * them sorted from the smallest to the biggest.
     *
     * - Input: numbers, the invoice totals.
     * - Return: nothing. Sort the list you got.
     *
     * Example:
     * - [300, 15, 120] -> the list becomes [15, 120, 300]
     *
     * Hint: The `Collections` class can sort a list in place.
     */
    static void task12(List<Integer> numbers) {
    }

    /**
     * Ticket 13. The biggest invoice
     * The manager wants to know the biggest invoice of the day.
     *
     * - Input: numbers, the invoice totals (not empty).
     * - Return: the biggest number in the list.
     *
     * Examples:
     * - [40, 250, 90] -> 250
     * - [7] -> 7
     *
     * Hint: The `Collections` class has a ready method for the biggest element.
     */
    static int task13(List<Integer> numbers) {
        return 0;
    }

    /**
     * Ticket 14. End of the shift
     * The shift is over and the queue is handed over to another team. Remove all names
     * from the list: the list itself stays, it just becomes empty.
     *
     * - Input: list, the queue.
     * - Return: nothing. Change the list you got.
     *
     * Example:
     * - ["Anna", "Bob"] -> the list becomes []
     *
     * Hint: One method removes all elements at once.
     */
    static void task14(List<String> list) {
    }
}
