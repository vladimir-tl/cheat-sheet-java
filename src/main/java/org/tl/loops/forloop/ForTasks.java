package org.tl.loops.forloop;

/**
 * PRACTICE TASKS: the for loop
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work, and every ticket is one method that you have to finish with a for loop.
 *
 * - Input: the parameters the method gets.
 * - Return: what the method must give back (or what it must print).
 * - Examples: calls with their expected results. Run them in main to check yourself.
 *
 * Solutions are in ForSolutions.java; peek only after you've tried.
 */
public class ForTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Numbering for the daily report
     * The support lead wants a numbered list of the first 10 tickets for the daily report.
     * Print the numbers from 1 to 10, each on its own line.
     *
     * - Input: nothing, the method has no parameters (the brackets are empty).
     * - Return: nothing, the method prints to the console.
     *
     * Expected output (10 lines):
     *
     *   1
     *   2
     *   3
     *   ...
     *   10
     *
     * Hint: Start at `i = 1`, go while `i <= 10`, add 1 each step with `i++`.
     */
    static void task1() {
    }

    /**
     * Ticket 2. Operators on even lines
     * The support has phone lines 1..20, but today an operator is on duty only on the even
     * lines. Print the numbers of these lines: 2, 4, 6 ... 20, each on its own line.
     *
     * - Input: nothing, the method has no parameters (the brackets are empty).
     * - Return: nothing, the method prints to the console.
     *
     * Expected output (10 lines):
     *
     *   2
     *   4
     *   6
     *   ...
     *   20
     *
     * Hint: Start at `i = 2` and step by 2: `i += 2`.
     */
    static void task2() {
    }

    /**
     * Ticket 3. Countdown to the sale
     * The big sale starts in 10 seconds and the banner shows a countdown.
     * Print the numbers from 10 down to 1, each on its own line.
     *
     * - Input: nothing, the method has no parameters (the brackets are empty).
     * - Return: nothing, the method prints to the console.
     *
     * Expected output (10 lines):
     *
     *   10
     *   9
     *   8
     *   ...
     *   1
     *
     * Hint: Start at `i = 10` and go down with `i--`.
     */
    static void task3() {
    }

    /**
     * Ticket 4. Tracks sold this week
     * The store sells more every day: 1 track on day 1, 2 tracks on day 2, 3 tracks on day 3
     * and so on. How many tracks were sold in total in the first n days?
     * In other words, count 1 + 2 + ... + n.
     *
     * - Input: n, the number of days (n >= 1).
     * - Return: the total number of tracks.
     *
     * Examples:
     * - task4(5) -> 15 (1 + 2 + 3 + 4 + 5)
     * - task4(1) -> 1
     * - task4(10) -> 55
     *
     * Hint: Keep a `sum` variable outside the loop and do `sum += i` every step.
     */
    static int task4(int n) {
        return 0;
    }

    /**
     * Ticket 5. Playlist shuffles
     * A customer asks: "In how many different orders can I play n tracks?"
     * The answer is n! (n factorial) = 1 * 2 * 3 * ... * n. It grows very fast,
     * so the method returns a long.
     *
     * - Input: n, the number of tracks (n >= 0).
     * - Return: n! By definition 0! is 1.
     *
     * Examples:
     * - task5(3) -> 6 (1 * 2 * 3)
     * - task5(5) -> 120
     * - task5(0) -> 1
     *
     * Hint: Start the `result` with `1` (not `0`) and do `result *= i` every step.
     */
    static long task5(int n) {
        return 0;
    }

    /**
     * Ticket 6. The biggest invoice
     * The manager gives you the totals of today's invoices. Go through the array and find
     * the biggest total. Do not sort the array.
     *
     * - Input: arr, the invoice totals (at least one element).
     * - Return: the biggest number in the array.
     *
     * Examples:
     * - [40, 250, 90] -> 250
     * - [7] -> 7
     * - [-5, -2, -9] -> -2
     *
     * Hint: Take `arr[0]` as the current `max` and compare every next element with it.
     */
    static int task6(int[] arr) {
        return 0;
    }

    /**
     * Ticket 7. Profitable days
     * The array holds the profit of each day of the month. A positive number is a profit,
     * a negative number is a loss, 0 means the store earned nothing.
     * On how many days was the profit greater than 0?
     *
     * - Input: arr, the profit of each day.
     * - Return: the number of elements greater than 0.
     *
     * Examples:
     * - [100, -20, 0, 50] -> 2
     * - [-1, -2] -> 0
     *
     * Hint: A `count` starts at `0` and grows by 1 (`count++`) when the element is `> 0`.
     */
    static int task7(int[] arr) {
        return 0;
    }

    /**
     * Ticket 8. Promo code typed backwards
     * A customer typed the promo code from right to left. Restore it: build a new text
     * with the same characters in reverse order. Do not use StringBuilder.reverse().
     *
     * - Input: s, the text typed by the customer.
     * - Return: the same text backwards.
     *
     * Examples:
     * - task8("abc") -> "cba"
     * - task8("ELAS") -> "SALE"
     * - task8("") -> ""
     *
     * Hint: Go from the last index `s.length() - 1` down to `0` and append `s.charAt(i)`.
     */
    static String task8(String s) {
        return "";
    }

    /**
     * Ticket 9. Vowels in a song title
     * The marketing team analyses song titles. Count the vowels a, e, i, o, u in the title.
     * Capital letters count too: "A" is a vowel just like "a".
     *
     * - Input: s, the song title.
     * - Return: the number of vowels in it.
     *
     * Examples:
     * - task9("Hello World") -> 3 (e, o, o)
     * - task9("ABBA") -> 2
     * - task9("Rhythm") -> 0
     *
     * Hint: Turn the title to lower case first (`toLowerCase()`), then check every char against `"aeiou"`.
     */
    static int task9(String s) {
        return 0;
    }

    /**
     * Ticket 10. Lucky ticket number
     * A customer gets a bonus if the number of their ticket is a prime number.
     * A prime number is greater than 1 and divides only by 1 and by itself.
     * Check every possible divisor from 2 up to n - 1.
     *
     * - Input: n, the ticket number.
     * - Return: true if n is prime, otherwise false.
     *
     * Examples:
     * - task10(7) -> true
     * - task10(2) -> true
     * - task10(9) -> false (9 = 3 * 3)
     * - task10(1) -> false
     *
     * Hint: Numbers below 2 are not prime. If some `i` from 2 divides `n` (`n % i == 0`), it is not prime.
     */
    static boolean task10(int n) {
        return false;
    }

    /**
     * Ticket 11. Banner for the support page
     * The designer asks for a staircase made of stars, n rows high:
     * row 1 has one star, row 2 has two stars, and so on, row n has n stars.
     * You need two loops: one for the rows and one inside it for the stars of a row.
     *
     * - Input: n, the number of rows.
     * - Return: nothing, the method prints to the console.
     *
     * Expected output for n = 3:
     *
     *   *
     *   **
     *   ***
     *
     * Hint: The inner loop runs `i` times and prints `"*"` with `print`; after it call `println()`.
     */
    static void task11(int n) {
    }

    /**
     * Ticket 12. Ticket labels
     * The helpdesk prints the labels of all tickets 1..n, each on its own line.
     * The label depends on the ticket number:
     *
     * - divides by 3 and by 5: FizzBuzz (an urgent ticket)
     * - divides only by 3: Fizz (a billing ticket)
     * - divides only by 5: Buzz (a shipping ticket)
     * - anything else: the number itself
     *
     * - Input: n, the number of the last ticket.
     * - Return: nothing, the method prints to the console.
     *
     * Expected output for n = 15:
     *
     *   1
     *   2
     *   Fizz
     *   4
     *   Buzz
     *   Fizz
     *   7
     *   ...
     *   14
     *   FizzBuzz
     *
     * Hint: Loop from 1 to `n`; inside use an `if` / `else if` chain and check `% 15` first.
     */
    static void task12(int n) {
    }
}
