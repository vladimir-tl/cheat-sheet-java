package org.tl.theory;

/**
 * THEORY: warm-up patterns for the first LeetCode-style problems
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Arrays
 *   1. Scan: one pass and keep an answer
 *   2. Two pointers: from both ends to the middle
 *   3. Write pointer: write into the same array
 *
 * Numbers and chars
 *   4. Digits and chars: % 10, / 10 and char difference
 *
 * Traps
 *   5. Null guard and edge cases
 *   6. int overflow
 *
 * Practice: see org.tl.warmup (WarmupCheatSheet, WarmupTasks, WarmupSolutions).
 */
public class WarmupTheory {

    /**
     * 1. Scan: one pass and keep an answer
     *
     * Most easy problems are one loop over the array with a variable that keeps
     * the answer so far: a sum, a counter, "found or not".
     *
     * Think where to start the variable and what must happen with an empty array.
     */
    static void scan() {
        int[] numbers = {4, 9, 2, 8, 6};
        int evenCount = 0;                     // the answer so far
        for (int x : numbers) {
            if (x % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println(evenCount);         // 4
    }

    /**
     * 2. Two pointers: from both ends to the middle
     *
     * Two pointers: one index at the start (left), one at the end (right).
     * Do something with both, move them towards each other, stop when they meet.
     * This is how you handle pairs from both ends.
     */
    static void twoPointers() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            System.out.println(numbers[left] + numbers[right]);   // 7, 7, 7
            left++;
            right--;
        }
    }

    /**
     * 3. Write pointer: write into the same array
     *
     * Sometimes the result must be stored in the array itself, without a second one. Keep an index pos:
     * the place for the next good element. Read with the loop, write with pos.
     * Here: even numbers are collected at the start of the array.
     */
    static void writePointer() {
        int[] numbers = {3, 8, 5, 6, 1};
        int pos = 0;                           // the place for the next even number
        for (int x : numbers) {
            if (x % 2 == 0) {
                numbers[pos] = x;
                pos++;
            }
        }
        // the first pos cells now hold the even numbers: [8, 6, ...]
        System.out.println(pos);               // 2
    }

    /**
     * 4. Digits and chars: % 10, / 10 and char difference
     *
     * n % 10 is the last digit of n, n / 10 cuts it off.
     *
     * A char is a number: 'a' is 97, 'b' is 98, and so on. Letters go one after another,
     * so the difference of two chars is the distance between them.
     */
    static void digitsAndChars() {
        int n = 4072;
        System.out.println(n % 10);            // 2: the last digit
        System.out.println(n / 10);            // 407: without the last digit
        System.out.println('d' - 'a');         // 3: the position of the letter in the alphabet
    }

    /**
     * 5. Null guard and edge cases
     *
     * Before you use a value that can be null, check it. Calling a method on null throws
     * NullPointerException. && stops at the first false, so the check goes first.
     *
     * Also try every task with: an empty array, one element, all equal elements, zero, a negative number.
     */
    static void nullGuard() {
        String name = null;
        String shown = name == null ? "guest" : name;
        System.out.println(shown);                          // guest
        boolean longName = name != null && name.length() > 3;
        System.out.println(longName);                       // false: name.length() is never called
    }

    /**
     * 6. int overflow
     *
     * int arithmetic is done in int. If the result does not fit (the maximum is about 2.1 billion),
     * the number silently wraps around to a wrong one. Use long for an exact result;
     * Math.addExact and similar methods throw an exception instead of giving a wrong number.
     */
    static void overflow() {
        int max = Integer.MAX_VALUE;           // 2147483647
        System.out.println(max + 1);           // -2147483648: wraps around, no error
        System.out.println((long) max + 1);    // 2147483648
        // Math.addExact(max, 1) would throw ArithmeticException instead of a wrong number
    }
}
