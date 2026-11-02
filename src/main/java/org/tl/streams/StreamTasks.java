package org.tl.streams;

import java.util.List;
import java.util.Map;

/**
 * PRACTICE TASKS: Stream API
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work, and every ticket is one method that you have to finish.
 * Solve each one with a stream (no for loops). The input list must not be changed.
 *
 * - Input: the parameters the method gets.
 * - Return: what the method must give back.
 * - Examples: inputs with their expected results. Run them in main to check yourself.
 *
 * Solutions are in StreamSolutions.java; peek only after you've tried.
 */
public class StreamTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Big invoices
     * The accountant wants to check only the large invoices: those with a total greater than 100.
     * Keep them in the same order as in the input.
     *
     * - Input: totals, the invoice totals.
     * - Return: a new list with the totals greater than 100.
     *
     * Examples:
     * - [50, 120, 300, 100] -> [120, 300] (100 is not greater than 100)
     * - [10, 20] -> []
     *
     * Hint: `stream()`, then `filter` with a condition, then `toList()`.
     */
    static List<Integer> task1(List<Integer> totals) {
        return null;
    }

    /**
     * Ticket 2. Prices in cents
     * The payment system works with cents, not euros. Turn every price into cents
     * (multiply by 100), keeping the order.
     *
     * - Input: prices, the prices in euros.
     * - Return: a new list with the prices in cents.
     *
     * Examples:
     * - [5, 12] -> [500, 1200]
     * - [] -> []
     *
     * Hint: `map` changes every element: `p -> p * 100`.
     */
    static List<Integer> task2(List<Integer> prices) {
        return null;
    }

    /**
     * Ticket 3. Label printer
     * The label printer prints only capital letters. Turn every customer name into upper case.
     *
     * - Input: names, the customer names.
     * - Return: a new list with the same names in upper case, in the same order.
     *
     * Example:
     * - ["Anna", "bob"] -> ["ANNA", "BOB"]
     *
     * Hint: `map` with a method reference: `String::toUpperCase`.
     */
    static List<String> task3(List<String> names) {
        return null;
    }

    /**
     * Ticket 4. Urgent tickets
     * The list holds the priority of every open ticket: 1 means "urgent", bigger numbers
     * are less urgent. How many urgent tickets are there?
     *
     * - Input: priorities, the priority of every ticket.
     * - Return: how many elements are equal to 1 (as a long, because count() returns a long).
     *
     * Examples:
     * - [1, 3, 1, 2] -> 2
     * - [2, 3] -> 0
     *
     * Hint: `filter` the urgent ones, then `count()`.
     */
    static long task4(List<Integer> priorities) {
        return 0;
    }

    /**
     * Ticket 5. Revenue of the day
     * The list holds the totals of today's invoices. Add them up.
     *
     * - Input: totals, the invoice totals.
     * - Return: the sum of all the totals, or 0 for an empty list.
     *
     * Examples:
     * - [10, 25, 5] -> 40
     * - [] -> 0
     *
     * Hint: `mapToInt(Integer::intValue)` gives an `IntStream`, and it has `sum()`.
     */
    static int task5(List<Integer> totals) {
        return 0;
    }

    /**
     * Ticket 6. Average rating
     * Customers rated the support from 1 to 5. Find the average rating, with the fractional part.
     *
     * - Input: ratings, the ratings.
     * - Return: the average of the ratings, or 0 if the list is empty (nobody has rated yet).
     *
     * Examples:
     * - [5, 4] -> 4.5
     * - [5, 4, 3] -> 4.0
     * - [] -> 0.0
     *
     * Hint: `IntStream` has `average()`; it returns an `OptionalDouble`, so use `orElse(0)` for an empty list.
     */
    static double task6(List<Integer> ratings) {
        return 0;
    }

    /**
     * Ticket 7. The biggest invoice
     * The manager wants to see the biggest invoice of the day.
     *
     * - Input: totals, the invoice totals.
     * - Return: the biggest total, or -1 if the list is empty (no invoices today).
     *
     * Examples:
     * - [40, 250, 90] -> 250
     * - [] -> -1
     *
     * Hint: `max(Integer::compare)` returns an `Optional`; `orElse(-1)` handles an empty list.
     */
    static int task7(List<Integer> totals) {
        return 0;
    }

    /**
     * Ticket 8. Top 3 invoices
     * The manager wants the three biggest invoices, the biggest first.
     * If there are fewer than three invoices, return all of them, the biggest first.
     *
     * - Input: totals, the invoice totals.
     * - Return: a new list with at most 3 biggest totals, sorted from big to small.
     *
     * Examples:
     * - [5, 12, 8, 20, 3] -> [20, 12, 8]
     * - [7, 9] -> [9, 7]
     *
     * Hint: `sorted(Comparator.reverseOrder())`, then `limit(3)`.
     */
    static List<Integer> task8(List<Integer> totals) {
        return null;
    }

    /**
     * Ticket 9. Countries of our customers
     * The list holds the country of every order, so countries repeat. Marketing wants
     * every country once, in the order in which it first appears.
     *
     * - Input: countries, the country of every order.
     * - Return: a new list without repeats.
     *
     * Example:
     * - ["USA", "Brazil", "USA", "Estonia"] -> ["USA", "Brazil", "Estonia"]
     *
     * Hint: One stream operation removes repeats and keeps the order.
     */
    static List<String> task9(List<String> countries) {
        return null;
    }

    /**
     * Ticket 10. Any refund?
     * The list holds the movements of an account: a payment is a positive number,
     * a refund is a negative number. Is there at least one refund?
     *
     * - Input: movements, the account movements.
     * - Return: true if at least one number is less than 0, otherwise false.
     *
     * Examples:
     * - [50, -20, 30] -> true
     * - [50, 30] -> false
     * - [0] -> false
     *
     * Hint: `anyMatch` answers "is there at least one?".
     */
    static boolean task10(List<Integer> movements) {
        return false;
    }

    /**
     * Ticket 11. All orders paid?
     * The list holds the paid amount of every order. An order is paid if its amount is greater
     * than 0. Are all the orders paid?
     *
     * - Input: amounts, the paid amounts.
     * - Return: true if every amount is greater than 0, otherwise false. For an empty list return true (no unpaid orders).
     *
     * Examples:
     * - [10, 20] -> true
     * - [10, 0, 20] -> false
     * - [] -> true
     *
     * Hint: `allMatch` answers "are all of them...?".
     */
    static boolean task11(List<Integer> amounts) {
        return false;
    }

    /**
     * Ticket 12. First long title
     * The radio host needs a long track title. Find the first title that is longer
     * than 10 characters.
     *
     * - Input: titles, the track titles.
     * - Return: the first title with more than 10 characters, or "none" if there is no such title.
     *
     * Examples:
     * - ["Intro", "Bohemian Rhapsody", "Yesterday Once More"] -> "Bohemian Rhapsody"
     * - ["Intro", "Help"] -> "none"
     *
     * Hint: `filter` by `length()`, then `findFirst()`, then `orElse("none")`.
     */
    static String task12(List<String> titles) {
        return null;
    }

    /**
     * Ticket 13. Mailing list
     * The e-mail tool wants all the customer names in one line, separated by a comma and a space.
     * There is no comma after the last name.
     *
     * - Input: names, the customer names.
     * - Return: one text with all the names.
     *
     * Examples:
     * - ["Anna", "Bob", "Eve"] -> "Anna, Bob, Eve"
     * - ["Anna"] -> "Anna"
     * - [] -> ""
     *
     * Hint: `collect(Collectors.joining(", "))` glues strings with a separator.
     */
    static String task13(List<String> names) {
        return null;
    }

    /**
     * Ticket 14. Customers per country
     * The list holds the country of every order. How many orders came from each country?
     *
     * - Input: countries, the country of every order.
     * - Return: a map: country -> number of orders from it. The numbers are Long, because counting() counts in long.
     *
     * Examples:
     * - ["USA", "Brazil", "USA"] -> {USA=2, Brazil=1}
     * - [] -> {}
     *
     * Hint: `Collectors.groupingBy(c -> c, Collectors.counting())` counts each value.
     */
    static Map<String, Long> task14(List<String> countries) {
        return null;
    }
}
