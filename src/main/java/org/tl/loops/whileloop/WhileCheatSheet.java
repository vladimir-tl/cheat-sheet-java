package org.tl.loops.whileloop;

/**
 * CHEAT SHEET: the while loop
 *
 * Theory: see org.tl.theory.WhileTheory
 */
public class WhileCheatSheet {

    public static void main(String[] args) {
        basic();
        countdown();
        unknownIterations();
        doWhile();
        breakAndContinue();
        infinite();
        pitfalls();
    }

    /** 1. Basic loop: 0 to 4 (the counter lives outside, you update it yourself) */
    static void basic() {
        int i = 0;
        while (i < 5) {
            System.out.println("i = " + i); // 0 1 2 3 4
            i++;
        }
    }

    /** 2. Countdown */
    static void countdown() {
        int n = 5;
        while (n > 0) {
            System.out.println(n); // 5 4 3 2 1
            n--;
        }
    }

    /** 3. Unknown number of iterations: digits of a number */
    static void unknownIterations() {
        int number = 12345;
        int digits = 0;
        while (number > 0) {
            number /= 10; // drop the last digit
            digits++;
        }
        System.out.println(digits); // 5
    }

    /** 4. do-while: the body runs at least once */
    static void doWhile() {
        int x = 10;
        do {
            System.out.println(x); // prints 10 even though x < 5 is false
        } while (x < 5);

        // with plain while this would print nothing:
        while (x < 5) {
            System.out.println(x);
        }
    }

    /** 5. break exits the loop, continue jumps to the next condition check */
    static void breakAndContinue() {
        int i = 0;
        while (i < 10) {
            i++;                   // update BEFORE continue, or you get an infinite loop
            if (i == 3) continue;  // skip 3
            if (i == 6) break;     // stop at 6
            System.out.println(i); // 1 2 4 5
        }
    }

    /** 6. Infinite loop (exit only via break/return) */
    static void infinite() {
        int n = 0;
        while (true) {
            if (++n > 3) break;
        }
    }

    /** 7. Common mistakes */
    static void pitfalls() {
        // forgot to update the variable -> infinite loop
        // int i = 0; while (i < 5) { System.out.println(i); }

        // semicolon after while -> empty body
        // while (i < 5); { i++; }

        // continue before the update -> infinite loop (see breakAndContinue)

        // condition is false from the start -> body never runs (use do-while if it must run once)

        // variables declared inside the body are not visible after the loop
    }
}
