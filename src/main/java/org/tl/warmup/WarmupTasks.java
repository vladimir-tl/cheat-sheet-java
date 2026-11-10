package org.tl.warmup;

/**
 * PRACTICE TASKS: warm-up (the first LeetCode-style problems)
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work, and every ticket is one method that you have to finish.
 * The tasks use only arrays, loops, primitives and null; no collections.
 * They go from easy to a bit harder. Always think about the edge cases: an empty array, null, zero.
 *
 * - Input: the parameters the method gets.
 * - Return: what the method must give back (or how it must change the array).
 * - Examples: inputs with their expected results. Run them in main to check yourself.
 *
 * Solutions are in WarmupSolutions.java; peek only after you've tried.
 */
public class WarmupTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Is the track in the playlist?
     * A playlist is an array of track ids. A customer asks whether one track is in it.
     *
     * - Input: ids, the track ids in the playlist; target, the id to look for.
     * - Return: true if target is in ids, otherwise false (also false for an empty array).
     *
     * Examples:
     * - task1([5, 8, 12], 8) -> true
     * - task1([5, 8, 12], 7) -> false
     * - task1([], 7) -> false
     *
     * Hint: Go through the array with a for loop and `return true` as soon as you meet the target; `return false` after the loop.
     */
    static boolean task1(int[] ids, int target) {
        return false;
    }

    /**
     * Ticket 2. Best seller
     * The array holds how many copies of each album were sold today. Find the biggest number.
     *
     * - Input: sales, the numbers of sold copies (all are 0 or more).
     * - Return: the biggest element, or -1 if the array is empty.
     *
     * Examples:
     * - task2([3, 17, 9]) -> 17
     * - task2([4]) -> 4
     * - task2([]) -> -1
     *
     * Hint: Start with the first element as the current maximum and compare every other element with it. Do not start with 0 if the data could be negative.
     */
    static int task2(int[] sales) {
        return 0;
    }

    /**
     * Ticket 3. Swap two tracks
     * Two tracks in a playlist have to change places.
     *
     * - Input: arr, the playlist; i and j, two valid indexes in it.
     * - Return: nothing. Change the array itself.
     *
     * Examples:
     * - arr = [1, 2, 3, 4], task3(arr, 0, 3) -> arr becomes [4, 2, 3, 1]
     * - arr = [1, 2, 3], task3(arr, 1, 1) -> arr stays [1, 2, 3]
     *
     * Hint: You need a third variable: save `arr[i]` in `temp`, then `arr[i] = arr[j]`, then `arr[j] = temp`.
     */
    static void task3(int[] arr, int i, int j) {
    }

    /**
     * Ticket 4. Play it backwards
     * Turn a playlist upside down: the last track becomes first, and so on.
     * Do it in the same array, do not create a new one.
     *
     * - Input: arr, the playlist.
     * - Return: nothing. Change the array itself.
     *
     * Examples:
     * - arr = [1, 2, 3, 4, 5], task4(arr) -> arr becomes [5, 4, 3, 2, 1]
     * - arr = [7, 8], task4(arr) -> arr becomes [8, 7]
     * - arr = [], task4(arr) -> arr stays []
     *
     * Hint: Two indexes, `left = 0` and `right = arr.length - 1`. Swap the elements, move both indexes towards each other, stop when `left >= right`.
     */
    static void task4(int[] arr) {
    }

    /**
     * Ticket 5. Is the chart sorted?
     * Check that a list of prices goes from the smallest to the biggest.
     * Equal neighbours are fine.
     *
     * - Input: prices, the array of prices.
     * - Return: true if every element is not smaller than the one before it. An empty array and an array of one element are sorted.
     *
     * Examples:
     * - task5([1, 3, 3, 8]) -> true
     * - task5([1, 5, 4]) -> false
     * - task5([]) -> true
     *
     * Hint: Compare each element with the previous one, starting from index 1. Find one pair that is in the wrong order and you can `return false` at once.
     */
    static boolean task5(int[] prices) {
        return false;
    }

    /**
     * Ticket 6. Zeros to the end
     * A report shows the number of downloads per day. Days without downloads are 0.
     * Move all zeros to the end, and keep the order of the other numbers.
     * Do it in the same array.
     *
     * - Input: arr, the downloads per day.
     * - Return: nothing. Change the array itself.
     *
     * Examples:
     * - arr = [0, 4, 0, 7, 9], task6(arr) -> arr becomes [4, 7, 9, 0, 0]
     * - arr = [1, 2], task6(arr) -> arr stays [1, 2]
     *
     * Hint: Keep a `pos` index, the place for the next non-zero number. Copy every non-zero element to `arr[pos++]`, then fill the rest of the array with zeros.
     */
    static void task6(int[] arr) {
    }

    /**
     * Ticket 7. Running total
     * The array holds the revenue for each day. For every day, the report must show
     * the total revenue from the first day up to that day.
     *
     * - Input: arr, the revenue per day.
     * - Return: a new array of the same length. The element at index i is the sum of arr[0..i].
     *
     * Examples:
     * - task7([1, 2, 3, 4]) -> [1, 3, 6, 10]
     * - task7([5, -2, 4]) -> [5, 3, 7]
     * - task7([]) -> []
     *
     * Hint: Keep one variable `sum`. In a loop add `arr[i]` to it and write `sum` to `result[i]`.
     */
    static int[] task7(int[] arr) {
        return null;
    }

    /**
     * Ticket 8. Two albums for the gift card
     * A gift card has an exact amount. Find two different albums whose prices add up to it.
     *
     * - Input: prices, the album prices; amount, the gift card amount.
     * - Return: an array of two indexes {i, j} with i < j and prices[i] + prices[j] == amount.
     *   If there is no such pair, return an empty array. If there are several pairs, any one is fine.
     *
     * Examples:
     * - task8([2, 7, 11, 15], 9) -> [0, 1]
     * - task8([3, 2, 4], 6) -> [1, 2]
     * - task8([1, 2], 10) -> []
     *
     * Hint: Two loops, one inside the other. The inner one starts at `i + 1`, so you never use the same album twice.
     */
    static int[] task8(int[] prices, int amount) {
        return null;
    }

    /**
     * Ticket 9. The lost ticket number
     * The tickets of a concert are numbered 0, 1, 2, ..., n. One number is missing from the array,
     * and the array is in no particular order.
     *
     * - Input: arr, with n elements, all different, each in the range 0..n.
     * - Return: the one number from 0..n that is not in the array.
     *
     * Examples:
     * - task9([3, 0, 1]) -> 2
     * - task9([0, 1]) -> 2
     * - task9([1]) -> 0
     *
     * Hint: You know what the sum of all numbers 0..n should be. Compare it with the real sum of the array.
     */
    static int task9(int[] arr) {
        return 0;
    }

    /**
     * Ticket 10. Chart labels
     * The chart page shows a label for each position from 1 to n:
     * "FizzBuzz" if the position is divisible by both 3 and 5, "Fizz" if by 3, "Buzz" if by 5,
     * and the position itself in all other cases.
     *
     * - Input: n, the number of positions (n >= 0).
     * - Return: one String with all labels separated by a comma and a space (", "), or "" for n = 0.
     *
     * Examples:
     * - task10(5) -> "1, 2, Fizz, 4, Buzz"
     * - task10(15) -> "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz"
     * - task10(0) -> ""
     *
     * Hint: Check "divisible by both 3 and 5" first, otherwise "Fizz" would win. Use `i % 3 == 0`. Append with StringBuilder, and add ", " only before every label except the first.
     */
    static String task10(int n) {
        return null;
    }

    /**
     * Ticket 11. Special offer code
     * A promo code is valid only if it is a prime number: it is bigger than 1 and divisible
     * only by 1 and by itself.
     *
     * - Input: n, the code.
     * - Return: true if n is prime, otherwise false.
     *
     * Examples:
     * - task11(7) -> true
     * - task11(12) -> false
     * - task11(1) -> false
     * - task11(2) -> true
     *
     * Hint: Handle n < 2 first. Then try the divisors 2, 3, ... while `d * d <= n`; if any divides n evenly, it is not prime.
     */
    static boolean task11(int n) {
        return false;
    }

    /**
     * Ticket 12. Mirror album title
     * Some album titles read the same forwards and backwards, like "level". Check a title.
     * Compare the characters exactly, upper and lower case letters are different.
     *
     * - Input: s, the title; it can be null.
     * - Return: true if s is a palindrome. Empty and one-letter strings are palindromes. For null return false.
     *
     * Examples:
     * - task12("level") -> true
     * - task12("abca") -> false
     * - task12("") -> true
     * - task12(null) -> false
     *
     * Hint: Check for null first. Then compare `s.charAt(left)` and `s.charAt(right)` while `left < right`, moving both inwards.
     */
    static boolean task12(String s) {
        return false;
    }

    /**
     * Ticket 13. Server rack size
     * A rack can only be ordered in sizes that are a power of two: 1, 2, 4, 8, 16, ...
     * Check a requested size.
     *
     * - Input: n, the requested size (can be 0 or negative).
     * - Return: true if n is 1, 2, 4, 8, ... and false otherwise.
     *
     * Examples:
     * - task13(16) -> true
     * - task13(12) -> false
     * - task13(1) -> true
     * - task13(0) -> false
     * - task13(-8) -> false
     *
     * Hint: While n is even, divide it by 2. In the end a power of two becomes exactly 1. Do not forget that n <= 0 is never a power of two.
     */
    static boolean task13(int n) {
        return false;
    }

    /**
     * Ticket 14. Total bonus points
     * Bonus points come from another system as an array of Integer. A customer without data has null
     * instead of a number. The array itself can also be null.
     *
     * - Input: bonuses, the points; null elements mean "unknown".
     * - Return: the sum of all known points. Unknown points count as 0. For a null array return 0.
     *
     * Examples:
     * - task14([10, null, 5]) -> 15
     * - task14([null, null]) -> 0
     * - task14(null) -> 0
     *
     * Hint: The array can be null, and so can each element. Unboxing null throws NullPointerException.
     */
    static int task14(Integer[] bonuses) {
        return 0;
    }

    /**
     * Ticket 15. Is the comment empty?
     * A customer sent a comment. A comment has text only if it is not null and contains
     * at least one character that is not a space.
     *
     * - Input: s, the comment; it can be null.
     * - Return: true if s has text, otherwise false.
     *
     * Examples:
     * - task15("great album") -> true
     * - task15("   ") -> false
     * - task15("") -> false
     * - task15(null) -> false
     *
     * Hint: Check `s == null` first, and only then call methods on s. Spaces at the start and end can be cut with `trim()`.
     */
    static boolean task15(String s) {
        return false;
    }

    /**
     * Ticket 16. Digit from a character
     * A serial number is read character by character. Turn a digit character into its number.
     *
     * - Input: c, one character.
     * - Return: the number 0..9 if c is a digit character '0'..'9', otherwise -1.
     *
     * Examples:
     * - task16('7') -> 7
     * - task16('0') -> 0
     * - task16('a') -> -1
     *
     * Hint: A char is a number in disguise. The characters '0'..'9' go one after another, so `c - '0'` gives the digit.
     */
    static int task16(char c) {
        return 0;
    }

    /**
     * Ticket 17. Total price without overflow
     * The total price of an order is price * quantity. Both numbers are ints, but the result
     * can be bigger than the biggest int (about 2.1 billion).
     *
     * - Input: price and quantity, two ints.
     * - Return: the exact product as a long.
     *
     * Examples:
     * - task17(3, 4) -> 12
     * - task17(2000000000, 3) -> 6000000000
     *
     * Hint: `price * quantity` is calculated in int and may overflow before it reaches the long. Make the calculation happen in long.
     */
    static long task17(int price, int quantity) {
        return 0;
    }
}
