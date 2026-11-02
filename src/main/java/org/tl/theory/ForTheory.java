package org.tl.theory;

/**
 * THEORY: the for loop
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Basics
 *   1. Syntax and execution order: for (init; condition; update)
 *   2. Counting up, down and with a step
 *   3. Nested loops
 *
 * Controlling a loop
 *   4. break and continue
 *   5. Infinite loop
 *
 * Looping over data
 *   6. Array by index
 *   7. for-each
 *
 * Practice: see org.tl.loops.forloop (ForCheatSheet, ForTasks, ForSolutions).
 */
public class ForTheory {

    /**
     * 1. Syntax and execution order: for (init; condition; update)
     *
     * A loop repeats a block of code. Use for when you know in advance how many times
     * to repeat, or when you need a counter.
     *
     * The header has three parts, all optional, separated by ;
     *   - init:      runs once, usually declares the counter (int i = 0)
     *   - condition: checked before every iteration; the loop stops when it is false
     *   - update:    runs after every iteration, usually changes the counter (i++)
     *
     * Order: init -> condition -> body -> update -> condition -> body -> update ... -> condition is false -> exit.
     */
    static void syntax() {
        // Print 0 1 2 3 4:
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // The counter exists only inside the loop. This does not compile:
        // System.out.println(i);
    }

    /**
     * 2. Counting up, down and with a step
     *
     * Change the init, the condition and the update to get any sequence.
     * i++ is the same as i += 1; i-- is the same as i -= 1.
     */
    static void counting() {
        // Up: 1 2 3 4 5
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
        }

        // Down: 5 4 3 2 1
        for (int i = 5; i >= 1; i--) {
            System.out.println(i);
        }

        // Step 2: 0 2 4 6 8 10
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i);
        }

        // < excludes the end, <= includes it.
        // for (int i = 0; i < 3; i++)  -> 0 1 2   (3 iterations)
        // for (int i = 0; i <= 3; i++) -> 0 1 2 3 (4 iterations)
    }

    /**
     * 3. Nested loops
     *
     * A loop inside a loop. The inner loop runs fully for every iteration of the outer one:
     * 3 x 3 iterations = 9 runs of the body.
     */
    static void nested() {
        // Multiplication table 3 x 3:
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println(); // new line after each row
        }
        // 1  2  3
        // 2  4  6
        // 3  6  9
    }

    /**
     * 4. break and continue
     *
     * break leaves the loop completely. continue skips the rest of the current
     * iteration and goes to the update part.
     */
    static void breakAndContinue() {
        // continue: skip 3 -> 0 1 2 4 5 6 7 8 9
        for (int i = 0; i < 10; i++) {
            if (i == 3) continue;
            System.out.println(i);
        }

        // break: stop at 6 -> 0 1 2 3 4 5
        for (int i = 0; i < 10; i++) {
            if (i == 6) break;
            System.out.println(i);
        }

        // In nested loops break leaves only the INNER loop.
    }

    /**
     * 5. Infinite loop
     *
     * All three header parts are optional. Without a condition the loop never stops
     * by itself: leave it with break or return.
     */
    static void infinite() {
        int n = 0;
        for (;;) {
            n++;
            if (n > 3) break;
        }

        // A trap: a condition that is always true by mistake
        // for (int i = 0; i >= 0; i++) { ... } // i never becomes negative (until overflow)
    }

    /**
     * 6. Array by index
     *
     * Use an index when you need the position or want to change elements.
     * An array of length n has indexes 0 .. n-1. Length of an array is arr.length (no parentheses).
     */
    static void arrayByIndex() {
        int[] arr = {10, 20, 30};

        // Print every element:
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        // Double every element (changes the array):
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] * 2; // {20, 40, 60}
        }

        // A trap: <= instead of <. The array has 3 elements, index 3 does not exist:
        // for (int i = 0; i <= arr.length; i++) { arr[i] }
        // -> ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
    }

    /**
     * 7. for-each
     *
     * for (Type x : collection) takes elements one by one. It is shorter and has no
     * index to get wrong. Use it when you only read the elements.
     */
    static void forEach() {
        int[] arr = {10, 20, 30};

        for (int x : arr) {
            System.out.println(x);
        }

        // x is a COPY of the element. Changing x does not change the array:
        for (int x : arr) {
            x = x * 2; // arr is still {10, 20, 30}
        }

        // Need the index or want to change the elements -> use a loop by index (see 6).
        // Works the same for List: see ListTheory.
    }

    // A trap: a semicolon after the for header is an EMPTY body.
    // The block below is not part of the loop and runs once:
    //
    //   for (int i = 0; i < 5; i++);
    //   {
    //       System.out.println("hello"); // prints once, not 5 times
    //   }
}
