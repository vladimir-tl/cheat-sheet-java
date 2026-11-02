package org.tl.loops.forloop;

/**
 * CHEAT SHEET: the for loop
 *
 * THEORY
 * A loop repeats a block of code while a condition is true. Use for when you know
 * in advance how many times to repeat (or you need a counter). Use for-each when you
 * just walk through every element. Use while when the number of repetitions is unknown.
 *
 * The three parts of the header are all optional:
 *   - initialization: runs once, usually declares the counter (int i = 0)
 *   - condition: checked before every iteration; the loop stops when it is false
 *   - update: runs after every iteration, usually changes the counter (i++)
 *
 * The counter declared in the header exists only inside the loop.
 * break leaves the loop completely; continue skips the rest of the current iteration.
 *
 * Syntax:
 *   for (initialization; condition; update) { body }
 *
 * Execution order:
 *   1. initialization (once)
 *   2. check condition -> false: exit the loop
 *   3. body
 *   4. update
 *   5. go back to step 2
 */
public class ForCheatSheet {

    public static void main(String[] args) {
        basic();
        reverse();
        step();
        nested();
        breakAndContinue();
        overArray();
        forEach();
        infinite();
        pitfalls();
    }

    /** 1. Basic loop: 0 to 4 */
    static void basic() {
        for (int i = 0; i < 5; i++) {
            System.out.println("i = " + i); // 0 1 2 3 4
        }
    }

    /** 2. Reverse order */
    static void reverse() {
        for (int i = 5; i > 0; i--) {
            System.out.println(i); // 5 4 3 2 1
        }
    }

    /** 3. Step other than 1 */
    static void step() {
        for (int i = 0; i <= 10; i += 2) {
            System.out.println(i); // 0 2 4 6 8 10
        }
    }

    /** 4. Nested loops: multiplication table */
    static void nested() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    /** 5. break exits the loop, continue jumps to the next iteration */
    static void breakAndContinue() {
        for (int i = 0; i < 10; i++) {
            if (i == 3) continue; // skip 3
            if (i == 6) break;    // stop at 6
            System.out.println(i); // 0 1 2 4 5
        }
    }

    /** 6. Iterate an array by index (when you need the index or want to modify elements) */
    static void overArray() {
        int[] arr = {10, 20, 30};
        for (int i = 0; i < arr.length; i++) { // arrays use length (no parentheses)
            arr[i] = arr[i] * 2;
        }
    }

    /** 7. for-each: when you don't need the index, read-only */
    static void forEach() {
        int[] arr = {10, 20, 30};
        for (int x : arr) {
            System.out.println(x);
        }
        // x is a copy of the value; you can't modify arr[i] through x
    }

    /** 8. Infinite loop (exit only via break/return) */
    static void infinite() {
        int n = 0;
        for (;;) {
            if (++n > 3) break;
        }
    }

    /** 9. Common mistakes */
    static void pitfalls() {
        // off-by-one: <= instead of < throws ArrayIndexOutOfBoundsException
        // for (int i = 0; i <= arr.length; i++) ...

        // semicolon after for -> empty body
        // for (int i = 0; i < 5; i++); { ... }

        // variable i is only visible inside the loop
    }
}
