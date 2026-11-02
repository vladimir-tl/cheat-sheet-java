package org.tl.theory;

/**
 * THEORY: the while loop
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Basics
 *   1. Syntax: while (condition)
 *   2. while or for?
 *   3. Run at least once: do-while
 *
 * Controlling a loop
 *   4. break and continue
 *   5. Infinite loop
 *
 * Practice: see org.tl.loops.whileloop (WhileCheatSheet, WhileTasks, WhileSolutions).
 */
public class WhileTheory {

    /**
     * 1. Syntax: while (condition)
     *
     * while repeats the body as long as the condition is true. The condition is checked
     * BEFORE every iteration, so the body may never run: if the condition is false from
     * the start, nothing happens.
     *
     * Order: condition -> body -> condition -> body ... -> condition is false -> exit.
     *
     * The counter lives outside the loop and YOU change it in the body.
     * If nothing in the body affects the condition, the loop never ends.
     */
    static void syntax() {
        // Print 0 1 2 3 4:
        int i = 0;
        while (i < 5) {
            System.out.println(i);
            i++; // without this line: infinite loop
        }

        // The condition is false from the start -> the body never runs:
        int x = 10;
        while (x < 5) {
            System.out.println(x); // not executed
        }
    }

    /**
     * 2. while or for?
     *
     * for: the number of repetitions is known, or you need a counter.
     * while: the number of repetitions is not known in advance; you repeat until
     * something happens.
     */
    static void whileOrFor() {
        // Known: exactly 5 times -> for
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }

        // Unknown: how many digits are in the number? It takes as many steps as it takes.
        int number = 12345;
        int digits = 0;
        while (number > 0) {
            number /= 10; // drop the last digit: 1234, 123, 12, 1, 0
            digits++;
        }
        System.out.println(digits); // 5
    }

    /**
     * 3. Run at least once: do-while
     *
     * In do-while the condition is checked AFTER the body, so the body runs at least once.
     * Note the semicolon after the closing parenthesis.
     */
    static void doWhile() {
        int x = 10;

        // x < 5 is false, but the body still runs once -> prints 10:
        do {
            System.out.println(x);
        } while (x < 5);

        // The same condition with plain while prints nothing:
        while (x < 5) {
            System.out.println(x);
        }
    }

    /**
     * 4. break and continue
     *
     * break leaves the loop completely. continue jumps straight to the next condition check.
     */
    static void breakAndContinue() {
        // break: stop at 6 -> 1 2 3 4 5
        int i = 0;
        while (i < 10) {
            i++;
            if (i == 6) break;
            System.out.println(i);
        }

        // A trap: continue BEFORE the update. i never changes, the loop never ends:
        // int j = 0;
        // while (j < 10) {
        //     if (j == 3) continue; // j stays 3 forever
        //     j++;
        // }
        // Update the counter before continue.
    }

    /**
     * 5. Infinite loop
     *
     * while (true) is a normal way to say "repeat until I say stop". Leave it with
     * break or return.
     */
    static void infinite() {
        int n = 0;
        while (true) {
            n++;
            if (n > 3) break;
        }

        // A trap: a semicolon after while is an EMPTY body. The loop spins forever:
        // int i = 0;
        // while (i < 5); { i++; }
    }
}
