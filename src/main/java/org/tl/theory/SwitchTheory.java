package org.tl.theory;

/**
 * THEORY: switch
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Classic switch
 *   1. Syntax: switch, case, default
 *   2. break and fall-through
 *   3. What you can switch on
 *
 * Modern switch (Java 14+)
 *   4. Arrow form: case ->
 *   5. Switch as an expression: returns a value
 *   6. Several values in one case
 *   7. Block in a branch: yield
 *
 * Choosing
 *   8. switch or if-else?
 *
 * Practice: see org.tl.conditions.switchcase (SwitchCheatSheet, SwitchTasks, SwitchSolutions).
 */
public class SwitchTheory {

    /**
     * 1. Syntax: switch, case, default
     *
     * switch compares one value with several constants and runs the code of the matching case.
     * default runs when nothing matched (it is optional and can be anywhere, usually last).
     */
    static void syntax() {
        int day = 3;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday"); // this one runs
                break;
            default:
                System.out.println("Another day");
        }

        // case values must be constants: literals, final variables or enum constants.
        // case x: with a normal variable x does not compile.
    }

    /**
     * 2. break and fall-through
     *
     * In the classic switch, after the matching case Java keeps running ALL the next cases
     * until it meets break (or the end of the switch). This is called fall-through.
     * A forgotten break is the most common mistake with switch.
     */
    static void fallThrough() {
        int n = 1;

        // Forgot break: prints "one", "two" and "default"
        switch (n) {
            case 1:
                System.out.println("one");
            case 2:
                System.out.println("two");
            default:
                System.out.println("default");
        }

        // Fall-through can be useful on purpose, to group cases:
        switch (n) {
            case 1:
            case 2:
            case 3:
                System.out.println("small"); // for 1, 2 and 3
                break;
            default:
                System.out.println("big");
        }
    }

    /**
     * 3. What you can switch on
     *
     * Allowed: int, short, byte, char (and their wrappers Integer, Short, Byte, Character),
     * String and enum.
     * NOT allowed: long, float, double, boolean. Use if-else for them.
     *
     * String is compared with equals(), so it is case-sensitive: "Yes" and "yes" are different.
     * A null in switch throws NullPointerException.
     */
    static void types() {
        String command = "stop";
        switch (command) {
            case "start":
                System.out.println("Starting");
                break;
            case "stop":
                System.out.println("Stopping");
                break;
            default:
                System.out.println("Unknown command");
        }

        char grade = 'B';
        switch (grade) {
            case 'A':
                System.out.println("Excellent");
                break;
            case 'B':
                System.out.println("Good");
                break;
            default:
                System.out.println("Other");
        }

        // long big = 5L;
        // switch (big) { ... } // does not compile
    }

    /**
     * 4. Arrow form: case ->
     *
     * With -> only the code of the matching case runs. There is no fall-through,
     * so break is not needed. Shorter and safer: prefer it.
     */
    static void arrow() {
        int day = 3;

        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            default -> System.out.println("Another day");
        }

        // You can't mix case: and case -> in one switch.
    }

    /**
     * 5. Switch as an expression: returns a value
     *
     * A switch can produce a value, so you can assign it or return it. Put ; after the
     * closing brace. It must cover all the possible values: end it with default
     * (or list every enum constant), otherwise it does not compile.
     */
    static void expression() {
        int day = 3;

        String name = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Another day";
        };
        System.out.println(name); // Wednesday

        // Without default it does not compile: "the switch expression does not cover all possible input values"
    }

    /**
     * 6. Several values in one case
     *
     * In the modern form list the values with commas. It replaces the grouped cases
     * from section 2.
     */
    static void severalValues() {
        int month = 7;

        String season = switch (month) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Autumn";
            default -> "Not a month";
        };
        System.out.println(season); // Summer
    }

    /**
     * 7. Block in a branch: yield
     *
     * If a branch needs several lines, use a block { } and return the value with yield.
     * yield is for switch expressions, return would leave the whole method.
     */
    static void yieldValue() {
        int score = 85;

        String result = switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> {
                System.out.println("Almost excellent");
                yield "B";
            }
            default -> "C or lower";
        };
        System.out.println(result); // B
    }

    /**
     * 8. switch or if-else?
     *
     * switch: one variable compared with exact values (menu command, day of the week, enum).
     * if-else: ranges and conditions (age >= 18, x > 0 && x < 10), booleans, long and double.
     *
     * A range in switch is not possible: write if-else for it.
     */
    static void switchOrIf() {
        int age = 20;

        // Range -> if-else
        if (age < 18) {
            System.out.println("Minor");
        } else {
            System.out.println("Adult");
        }
    }
}
