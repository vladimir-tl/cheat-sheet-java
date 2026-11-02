package org.tl.conditions.ifelse;

/**
 * CHEAT SHEET: if-else
 *
 * Theory: see org.tl.theory.IfElseTheory
 */
public class IfElseCheatSheet {

    public static void main(String[] args) {
        simpleIf();
        ifElse();
        elseIfChain();
        logicalOperators();
        shortCircuit();
        strings();
        ternary();
        pitfalls();
    }

    /** 1. if: runs the block only when the condition is true */
    static void simpleIf() {
        int age = 20;
        if (age >= 18) {
            System.out.println("Adult");
        }
    }

    /** 2. if-else: exactly one of two blocks */
    static void ifElse() {
        int number = 7;
        if (number % 2 == 0) {
            System.out.println("Even");
        } else {
            System.out.println("Odd");
        }
    }

    /** 3. else if chain: the first true condition wins */
    static void elseIfChain() {
        int score = 85;
        if (score >= 90) {
            System.out.println("A");
        } else if (score >= 80) {
            System.out.println("B");
        } else if (score >= 70) {
            System.out.println("C");
        } else {
            System.out.println("F");
        }
    }

    /** 4. Logical operators: && (and), || (or), ! (not) */
    static void logicalOperators() {
        int age = 20;
        boolean hasTicket = true;

        if (age >= 18 && hasTicket) System.out.println("Come in");
        if (age < 12 || age > 65) System.out.println("Discount");
        if (!hasTicket) System.out.println("Buy a ticket");

        // range: write the variable twice
        if (age >= 10 && age <= 20) System.out.println("In the range");
    }

    /** 5. Short-circuit: put the safe check first */
    static void shortCircuit() {
        String text = null;
        if (text != null && text.length() > 3) { // no NullPointerException
            System.out.println("Long text");
        }
    }

    /** 6. Strings: equals(), not == */
    static void strings() {
        String answer = "yes";
        if ("yes".equals(answer)) {        // literal first: safe for null
            System.out.println("Agreed");
        }
        System.out.println("YES".equalsIgnoreCase(answer)); // true
    }

    /** 7. Ternary operator: condition ? ifTrue : ifFalse */
    static void ternary() {
        int age = 20;
        String status = age >= 18 ? "adult" : "minor";
        System.out.println(status);
    }

    /** 8. Common mistakes */
    static void pitfalls() {
        // no braces: only the first line belongs to the if

        // semicolon after if(...) -> empty body

        // if (x = 5) instead of if (x == 5)

        // strings compared with == instead of equals()

        // else-if order: put the strictest condition first (score > 90 before score > 50)

        // 10 <= x <= 20 does not compile: write x >= 10 && x <= 20
    }
}
