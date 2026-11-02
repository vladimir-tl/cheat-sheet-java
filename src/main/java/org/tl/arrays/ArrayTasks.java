package org.tl.arrays;

/**
 * PRACTICE TASKS: arrays (very simple)
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work, and every ticket is one method that you have to finish.
 *
 * - Input: the parameters the method gets.
 * - Return: what the method must give back (or how it must change the array).
 * - Examples: inputs with their expected results. Run them in main to check yourself.
 *
 * Solutions are in ArraySolutions.java; peek only after you've tried.
 */
public class ArrayTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Top-5 chart
     * The weekly chart has five places. Prepare them: create an int array that holds
     * the numbers 1, 2, 3, 4, 5 in this order.
     *
     * - Input: nothing, the method has no parameters (the brackets are empty).
     * - Return: the new array.
     *
     * Example:
     * - task1() -> [1, 2, 3, 4, 5]
     *
     * Hint: An array with known values can be written right away in curly braces: `new int[]{...}`.
     */
    static int[] task1() {
        return null;
    }

    /**
     * Ticket 2. Empty seat map
     * An online concert has n seats. Create the seat map: an int array with n cells.
     * Every cell must be 0, which means "free" (a new int array is filled with zeros anyway).
     *
     * - Input: n, the number of seats (n >= 0).
     * - Return: the new array of length n.
     *
     * Examples:
     * - task2(3) -> [0, 0, 0]
     * - task2(0) -> []
     *
     * Hint: `new int[size]` makes an array of the given size; every cell is already `0`.
     */
    static int[] task2(int n) {
        return null;
    }

    /**
     * Ticket 3. Who is first?
     * The array holds the numbers of the customers waiting in the queue, the first one
     * at the beginning. Return the number of the customer who is first.
     *
     * - Input: arr, the queue (at least one element).
     * - Return: the first element of the array.
     *
     * Examples:
     * - [17, 4, 9] -> 17
     * - [5] -> 5
     *
     * Hint: Indexes start from `0`.
     */
    static int task3(int[] arr) {
        return 0;
    }

    /**
     * Ticket 4. The latest order
     * The array holds order numbers in the order they arrived, so the latest one is at the end.
     * The method must work for an array of any length.
     *
     * - Input: arr, the order numbers (at least one element).
     * - Return: the last element of the array.
     *
     * Examples:
     * - [101, 102, 103] -> 103
     * - [42] -> 42
     *
     * Hint: The last index is one less than the length: `arr.length - 1`.
     */
    static int task4(int[] arr) {
        return 0;
    }

    /**
     * Ticket 5. Promo price
     * The first cell of the price array holds the price of the album of the day.
     * Today it is on promo: put 100 into the first cell. Do not touch the other cells.
     *
     * - Input: arr, the prices (at least one element).
     * - Return: nothing. Change the array you got.
     *
     * Example:
     * - the array was [250, 80, 40], after the call it is [100, 80, 40]
     *
     * Hint: Write into a cell the same way you read it, but on the left side of `=`.
     */
    static void task5(int[] arr) {
    }

    /**
     * Ticket 6. Queue length
     * How many customers are in the queue? That is how many cells the array has.
     *
     * - Input: arr, the queue.
     * - Return: the length of the array.
     *
     * Examples:
     * - [5, 8, 1] -> 3
     * - [] -> 0
     *
     * Hint: An array has a `length` field, without parentheses.
     */
    static int task6(int[] arr) {
        return 0;
    }

    /**
     * Ticket 7. A new order arrives
     * The array holds the order numbers. A new order with the number value arrives.
     * An array cannot grow, so make a NEW array one cell longer: copy the old orders into it
     * and put value into the last cell. The old array must stay as it was.
     *
     * - Input: arr, the old orders; value, the number of the new order.
     * - Return: the new array.
     *
     * Examples:
     * - arr [1, 2, 3], value 4 -> [1, 2, 3, 4]
     * - arr [], value 7 -> [7]
     *
     * Hint: An array can't grow. `Arrays.copyOf(arr, newLength)` makes a bigger copy; then fill its last cell.
     */
    static int[] task7(int[] arr, int value) {
        return null;
    }

    /**
     * Ticket 8. Report for the manager
     * The manager wants to see the order numbers as readable text, in square brackets
     * and separated by a comma and a space.
     *
     * - Input: arr, the order numbers.
     * - Return: the array as text.
     *
     * Examples:
     * - [1, 2, 3] -> "[1, 2, 3]"
     * - [] -> "[]"
     *
     * Hint: The `Arrays` class has a ready method that turns an array into text like `[1, 2, 3]`.
     */
    static String task8(int[] arr) {
        return null;
    }

    /**
     * Ticket 9. Daily revenue
     * The array holds the amounts of today's orders. Add them all up.
     *
     * - Input: arr, the order amounts.
     * - Return: the sum of all the elements, or 0 for an empty array.
     *
     * Examples:
     * - [10, 25, 5] -> 40
     * - [] -> 0
     *
     * Hint: Start with `sum = 0` and add every element to it in a for-each loop: `sum += x`.
     */
    static int task9(int[] arr) {
        return 0;
    }

    /**
     * Ticket 10. Safe backup
     * Before a risky edit you back up the array of prices. The backup must be an independent
     * copy: a new array with the same numbers. If someone changes the copy later, the original
     * must not change. Note: return arr is not a copy, both names would point to the same array.
     *
     * - Input: arr, the prices.
     * - Return: a new array with the same elements.
     *
     * Example:
     * - [5, 10, 15] -> [5, 10, 15]; after copy[0] = 99 the original is still [5, 10, 15]
     *
     * Hint: `Arrays.copyOf` with the same length makes a new, independent array.
     */
    static int[] task10(int[] arr) {
        return null;
    }
}
