package org.tl.theory;

/**
 * THEORY: if-else
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Basics
 *   1. Syntax: if
 *   2. if-else: two ways
 *   3. else if: many ways
 *
 * Conditions
 *   4. Comparison and logical operators
 *   5. Short-circuit: && and ||
 *   6. Comparing strings: equals, not ==
 *   7. Ternary operator: ?:
 *
 * Traps
 *   8. Braces, semicolon, = instead of ==, order of conditions
 *
 * Practice: see org.tl.conditions.ifelse (IfElseCheatSheet, IfElseTasks, IfElseSolutions).
 */
public class IfElseTheory {

    /**
     * 1. Syntax: if
     *
     * if runs a block of code only when the condition is true. The condition must be a
     * boolean expression (true or false). If it is false, the block is skipped.
     *
     * Always use braces { }, even for one line.
     */
    static void syntax() {
        int age = 20;

        if (age >= 18) {
            System.out.println("Adult"); // runs
        }

        if (age < 18) {
            System.out.println("Minor"); // skipped
        }
    }

    /**
     * 2. if-else: two ways
     *
     * else runs when the condition is false. Exactly one of the two blocks always runs.
     */
    static void ifElse() {
        int number = 7;

        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd"); // runs
        }
    }

    /**
     * 3. else if: many ways
     *
     * A chain of conditions. Java checks them from top to bottom and runs the FIRST block
     * whose condition is true; all the rest are skipped. The last else is optional: it runs
     * when nothing matched.
     */
    static void elseIf() {
        int score = 85;

        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B"); // runs, the chain stops here
        } else if (score >= 70) {
            System.out.println("C");
        } else {
            System.out.println("F");
        }
    }

    /**
     * 4. Comparison and logical operators
     *
     * Comparison (the result is boolean):
     *   ==  equal         !=  not equal
     *   >   greater       >=  greater or equal
     *   <   less          <=  less or equal
     *
     * Logical:
     *   &&  AND: both parts must be true
     *   ||  OR: at least one part must be true
     *   !   NOT: turns true into false and back
     *
     * && is evaluated before ||. Use brackets when you mix them.
     */
    static void operators() {
        int age = 20;
        boolean hasTicket = true;

        if (age >= 18 && hasTicket) {
            System.out.println("Come in");
        }

        if (age < 12 || age > 65) {
            System.out.println("Discount");
        }

        if (!hasTicket) {
            System.out.println("Buy a ticket");
        }

        // A range 10..20 needs && and the variable twice. This does NOT compile:
        // if (10 <= age <= 20) { ... }
        if (age >= 10 && age <= 20) {
            System.out.println("In the range");
        }

        // Brackets make the order clear:
        // true || false && false   -> true  (&& first: false, then true || false)
        // (true || false) && false -> false
    }

    /**
     * 5. Short-circuit: && and ||
     *
     * Java stops as soon as the result is known.
     *   a && b: if a is false, b is NOT evaluated (the result is already false).
     *   a || b: if a is true, b is NOT evaluated (the result is already true).
     *
     * It is used on purpose: put the safe check first.
     */
    static void shortCircuit() {
        String text = null;

        // Safe: text != null is false, so text.length() is never called
        if (text != null && text.length() > 3) {
            System.out.println("Long text");
        }

        // The wrong order crashes with NullPointerException:
        // if (text.length() > 3 && text != null) { ... }

        // The same idea protects from division by zero:
        int a = 10, b = 0;
        if (b != 0 && a / b > 2) {
            System.out.println("More than 2");
        }
    }

    /**
     * 6. Comparing strings: equals, not ==
     *
     * For objects `==` compares references (is it the same object?), not the text.
     * Always compare strings with equals().
     *
     * Put the literal first: "yes".equals(answer) works even if answer is null,
     * answer.equals("yes") throws NullPointerException.
     */
    static void strings() {
        String a = "hi";
        String b = new String("hi");

        System.out.println(a == b);          // false (!) two different objects
        System.out.println(a.equals(b));     // true: compares the text
        System.out.println("HI".equalsIgnoreCase(a)); // true: ignores case

        String answer = null;
        System.out.println("yes".equals(answer)); // false, no exception
        // answer.equals("yes");                  // NullPointerException
    }

    /**
     * 7. Ternary operator: ?:
     *
     * A short if-else that returns a value: condition ? valueIfTrue : valueIfFalse.
     * Good for simple choices. For longer logic use if-else; avoid nesting ternaries.
     */
    static void ternary() {
        int age = 20;

        String status = age >= 18 ? "adult" : "minor";
        System.out.println(status); // adult

        // The same with if-else:
        String status2;
        if (age >= 18) {
            status2 = "adult";
        } else {
            status2 = "minor";
        }

        int a = 3, b = 8;
        int max = a > b ? a : b;    // 8
    }

    /**
     * 8. Braces, semicolon, = instead of ==, order of conditions
     *
     * Four classic mistakes.
     */
    static void traps() {
        int x = 5;

        // 1. No braces: only the FIRST line belongs to the if
        // if (x > 10)
        //     System.out.println("big");
        //     System.out.println("always printed"); // not part of the if!
        // Also, else belongs to the NEAREST if. Braces remove all doubts.

        // 2. Semicolon after if: an EMPTY body, the block below always runs
        // if (x > 10); {
        //     System.out.println("always printed");
        // }

        // 3. = is assignment, == is comparison
        // if (x = 5) { ... }   // does not compile for int: int cannot be converted to boolean
        boolean flag = false;
        if (flag = true) {      // compiles (!): it ASSIGNS true, so the block always runs
            System.out.println("flag is now true");
        }

        // 4. Order of conditions in else-if: the first match wins
        int score = 95;
        if (score > 50) {
            System.out.println("Pass");        // prints, even for 95
        } else if (score > 90) {
            System.out.println("Excellent");   // never reached
        }
        // Check the strictest condition first: score > 90, then score > 50.
    }
}
