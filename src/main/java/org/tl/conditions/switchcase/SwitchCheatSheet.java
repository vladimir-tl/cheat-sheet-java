package org.tl.conditions.switchcase;

/**
 * CHEAT SHEET: switch
 *
 * Theory: see org.tl.theory.SwitchTheory
 */
public class SwitchCheatSheet {

    enum Color {RED, GREEN, BLUE}

    public static void main(String[] args) {
        classic();
        fallThrough();
        withString();
        arrow();
        expression();
        severalValues();
        withEnum();
        yieldBlock();
        pitfalls();
    }

    /** 1. Classic switch: do not forget break */
    static void classic() {
        int day = 2;
        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday"); // this one
                break;
            default:
                System.out.println("Another day");
        }
    }

    /** 2. Fall-through: without break the next cases run too */
    static void fallThrough() {
        int n = 1;
        switch (n) {
            case 1:
                System.out.println("one");  // prints
            case 2:
                System.out.println("two");  // prints too (no break)
                break;
            default:
                System.out.println("default");
        }
    }

    /** 3. switch on a String (case-sensitive) */
    static void withString() {
        String command = "stop";
        switch (command) {
            case "start":
                System.out.println("Starting");
                break;
            case "stop":
                System.out.println("Stopping");
                break;
            default:
                System.out.println("Unknown");
        }
    }

    /** 4. Arrow form: no fall-through, no break */
    static void arrow() {
        int day = 3;
        switch (day) {
            case 1 -> System.out.println("Monday");
            case 2 -> System.out.println("Tuesday");
            case 3 -> System.out.println("Wednesday");
            default -> System.out.println("Another day");
        }
    }

    /** 5. Switch expression: returns a value (needs default) */
    static void expression() {
        int day = 3;
        String name = switch (day) {
            case 1 -> "Monday";
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            default -> "Another day";
        };
        System.out.println(name);
    }

    /** 6. Several values in one case */
    static void severalValues() {
        int month = 7;
        String season = switch (month) {
            case 12, 1, 2 -> "Winter";
            case 3, 4, 5 -> "Spring";
            case 6, 7, 8 -> "Summer";
            case 9, 10, 11 -> "Autumn";
            default -> "Not a month";
        };
        System.out.println(season);
    }

    /** 7. switch on an enum: all constants listed -> default is not needed */
    static void withEnum() {
        Color color = Color.GREEN;
        String hex = switch (color) {
            case RED -> "#FF0000";
            case GREEN -> "#00FF00";
            case BLUE -> "#0000FF";
        };
        System.out.println(hex);
        // In case labels write RED, not Color.RED (before Java 21).
    }

    /** 8. Block in a branch: yield returns the value */
    static void yieldBlock() {
        int score = 85;
        String grade = switch (score / 10) {
            case 10, 9 -> "A";
            case 8 -> {
                System.out.println("Almost excellent");
                yield "B";
            }
            default -> "C or lower";
        };
        System.out.println(grade);
    }

    /** 9. Common mistakes */
    static void pitfalls() {
        // forgot break in the classic form -> fall-through

        // switch on long / double / boolean does not compile -> use if-else

        // switch on null -> NullPointerException (check for null first)

        // a range (score > 50) is not possible in case -> use if-else

        // switch expression without default (and not all enum constants) does not compile

        // duplicate case values do not compile: case 1 ... case 1
    }
}
