package org.tl.loops.whileloop;

/**
 * PRACTICE TASKS: the while loop
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work, and every ticket is one method that you have to finish with a while loop.
 *
 * - Input: the parameters the method gets.
 * - Return: what the method must give back (or what it must print).
 * - Examples: calls with their expected results. Run them in main to check yourself.
 *
 * Solutions are in WhileSolutions.java; peek only after you've tried.
 */
public class WhileTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Open tickets
     * The dashboard lists the numbers of the first 10 open tickets.
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
     * Hint: Create `i = 1` before the loop and don't forget `i++` inside, or the loop never ends.
     */
    static void task1() {
    }

    /**
     * Ticket 2. Server restart
     * Before a restart the status page shows a countdown.
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
     * Hint: Start at `i = 10` and do `i--` inside the loop.
     */
    static void task2() {
    }

    /**
     * Ticket 3. Loyalty points
     * A customer gets 1 point for the first order, 2 points for the second, 3 for the third
     * and so on. How many points does the customer have after n orders?
     * In other words, count 1 + 2 + ... + n.
     *
     * - Input: n, the number of orders (n >= 0).
     * - Return: the total number of points.
     *
     * Examples:
     * - task3(5) -> 15 (1 + 2 + 3 + 4 + 5)
     * - task3(1) -> 1
     * - task3(0) -> 0
     *
     * Hint: Two variables before the loop: `sum` and the counter `i`.
     */
    static int task3(int n) {
        return 0;
    }

    /**
     * Ticket 4. Length of an order number
     * The label printer must know how many digits the order number has, to choose the font size.
     * Hint: `n / 10` drops the last digit (`12345 / 10` is `1234`). Count how many times you can do it while `n > 0`. Careful with `n = 0`: it has 1 digit.
     *
     * - Input: n, the order number (n >= 0).
     * - Return: the number of digits in n. The number 0 has one digit.
     *
     * Examples:
     * - task4(12345) -> 5
     * - task4(7) -> 1
     * - task4(0) -> 1
     */
    static int task4(int n) {
        return 0;
    }

    /**
     * Ticket 5. Checksum of an order number
     * To catch typos the system checks the checksum of an order number: the sum of all its digits.
     * Hint: `n % 10` is the last digit (`123 % 10` is `3`), `n / 10` drops it (`123 / 10` is `12`).
     *
     * - Input: n, the order number (n >= 0).
     * - Return: the sum of the digits of n.
     *
     * Examples:
     * - task5(123) -> 6 (1 + 2 + 3)
     * - task5(9045) -> 18
     * - task5(0) -> 0
     */
    static int task5(int n) {
        return 0;
    }

    /**
     * Ticket 6. Reversed order number
     * The old warehouse system stores order numbers backwards. Turn the number around:
     * the last digit becomes the first. Work with digits (`% 10` and `/ 10`), not with text.
     *
     * - Input: n, the order number (n >= 0).
     * - Return: the number with the digits in reverse order.
     *
     * Examples:
     * - task6(123) -> 321
     * - task6(5) -> 5
     * - task6(1200) -> 21 (the zeros at the start disappear)
     *
     * Hint: Take the last digit with `n % 10` and append it: `reversed = reversed * 10 + digit`.
     */
    static int task6(int n) {
        return 0;
    }

    /**
     * Ticket 7. Shrinking an image
     * A product photo is n pixels wide. The site halves the width (integer division, n / 2)
     * again and again while it is wider than 1 pixel. How many halvings does it take?
     *
     * - Input: n, the width in pixels (n >= 1).
     * - Return: the number of halvings.
     *
     * Examples:
     * - task7(16) -> 4 (16, 8, 4, 2, 1)
     * - task7(10) -> 3 (10, 5, 2, 1)
     * - task7(1) -> 0
     *
     * Hint: While `n > 1`: do `n /= 2` and count the steps.
     */
    static int task7(int n) {
        return 0;
    }

    /**
     * Ticket 8. Equal packs of tracks
     * A customer has two playlists, one with a tracks and one with b tracks. They want to cut
     * both into packs of the same size with nothing left over, and the packs must be as big
     * as possible. That size is the greatest common divisor of a and b.
     * Find it with Euclid's algorithm: while b is not 0, replace the pair (a, b) with
     * (b, a % b). When b becomes 0, the answer is a.
     *
     * - Input: a and b, the sizes of the playlists (`a > 0`, `b > 0`).
     * - Return: the greatest common divisor of a and b.
     *
     * Examples:
     * - task8(12, 18) -> 6
     * - task8(20, 10) -> 10
     * - task8(7, 5) -> 1
     *
     * Hint: Euclid: while `b != 0`, replace `(a, b)` with `(b, a % b)`. The answer is `a`.
     */
    static int task8(int a, int b) {
        return 0;
    }

    /**
     * Ticket 9. The first refund
     * The array holds the movements of a customer's account in time order; a refund is
     * a negative number. Find where the first refund is: walk through the array and stop
     * at the first negative number.
     *
     * - Input: arr, the movements.
     * - Return: the index of the first negative number, or -1 if there is none.
     *
     * Examples:
     * - [50, 20, -10, -5] -> 2
     * - [-1, 5] -> 0
     * - [10, 20] -> -1
     *
     * Hint: Walk with an index while `i < arr.length`; return `i` as soon as `arr[i] < 0`.
     */
    static int task9(int[] arr) {
        return 0;
    }

    /**
     * Ticket 10. The support bot's number game
     * The support bot plays a game with a bored customer. It starts with the number n
     * and repeats one step until n becomes 1:
     *
     * - if n is even, divide it by 2
     * - if n is odd, n becomes 3 * n + 1
     *
     * - Input: n, the start number (n >= 1).
     * - Return: how many steps it took to reach 1.
     *
     * Examples:
     * - task10(6) -> 8 (6, 3, 10, 5, 16, 8, 4, 2, 1)
     * - task10(4) -> 2 (4, 2, 1)
     * - task10(1) -> 0
     *
     * Hint: Loop while `n != 1`, change `n` by the rule and count the steps.
     */
    static int task10(int n) {
        return 0;
    }
}
