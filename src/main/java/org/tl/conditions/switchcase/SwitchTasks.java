package org.tl.conditions.switchcase;

/**
 * PRACTICE TASKS: switch
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work, and every ticket is one method that you have to finish with a switch.
 *
 * - Input: the parameters the method gets.
 * - Return: what the method must give back.
 * - Examples: calls with their expected results. Run them in main to check yourself.
 *
 * Solutions are in SwitchSolutions.java; peek only after you've tried.
 */
public class SwitchTasks {

    enum Direction {UP, DOWN, LEFT, RIGHT}

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Delivery day
     * The delivery system stores the day of the week as a number: 1 is Monday, 2 is Tuesday
     * ... 7 is Sunday. The e-mail to the customer must show the name of the day.
     *
     * - Input: day, a number.
     * - Return: "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" or "Sunday" for 1..7, and "Unknown" for any other number.
     *
     * Examples:
     * - task1(1) -> "Monday"
     * - task1(7) -> "Sunday"
     * - task1(9) -> "Unknown"
     *
     * Hint: One `case` per day and `default` for everything else.
     */
    static String task1(int day) {
        return null;
    }

    /**
     * Ticket 2. Reduced support hours
     * On weekends the support works with reduced hours. The days are numbered as in ticket 1:
     * 1 is Monday ... 6 is Saturday, 7 is Sunday.
     *
     * - Input: day, a number.
     * - Return: true for 6 and 7 (a weekend), false for any other number.
     *
     * Examples:
     * - task2(6) -> true
     * - task2(7) -> true
     * - task2(3) -> false
     * - task2(0) -> false
     *
     * Hint: One `case` can list several values: `case 6, 7 ->`.
     */
    static boolean task2(int day) {
        return false;
    }

    /**
     * Ticket 3. Billing period
     * A monthly subscription is charged for every day of the month, so billing needs
     * the number of days in the month. February always has 28 days here.
     *
     * - Input: month, a number (1 is January ... 12 is December).
     * - Return: 31 for months 1, 3, 5, 7, 8, 10, 12; 30 for 4, 6, 9, 11; 28 for 2; -1 for any other number.
     *
     * Examples:
     * - task3(1) -> 31
     * - task3(4) -> 30
     * - task3(2) -> 28
     * - task3(13) -> -1
     *
     * Hint: Group the months with the same number of days into one `case`.
     */
    static int task3(int month) {
        return 0;
    }

    /**
     * Ticket 4. Seasonal playlist
     * The main page shows a playlist for the current season. Find the season of the month.
     *
     * - Input: month, a number (1 is January ... 12 is December).
     * - Return: "Winter" for 12, 1, 2; "Spring" for 3, 4, 5; "Summer" for 6, 7, 8; "Autumn" for 9, 10, 11; "Not a month" for any other number.
     *
     * Examples:
     * - task4(1) -> "Winter"
     * - task4(7) -> "Summer"
     * - task4(10) -> "Autumn"
     * - task4(14) -> "Not a month"
     *
     * Hint: Three months per season, listed in one `case`.
     */
    static String task4(int month) {
        return null;
    }

    /**
     * Ticket 5. Voice bot
     * The voice bot hears a word and must turn it into a number for the phone menu.
     * It knows only three words, written in lower case.
     *
     * - Input: word, the recognised word.
     * - Return: 1 for "one", 2 for "two", 3 for "three", 0 for any other word.
     *
     * Examples:
     * - task5("one") -> 1
     * - task5("three") -> 3
     * - task5("five") -> 0
     *
     * Hint: `switch` works with `String` too: `case "one" ->`.
     */
    static int task5(String word) {
        return 0;
    }

    /**
     * Ticket 6. Refund calculator in the bot
     * A customer asks the chat bot to count something: two numbers and an operator between them.
     * The bot knows four operators: "+", "-", "*" and "/". The division is integer
     * division: 7 / 2 gives 3.
     *
     * - Input: a, the first number; operator, the operator as text; b, the second number.
     * - Return: the result of "a operator b", or 0 if the operator is unknown.
     *
     * Examples:
     * - task6(5, "+", 3) -> 8
     * - task6(5, "-", 3) -> 2
     * - task6(4, "*", 3) -> 12
     * - task6(7, "/", 2) -> 3
     * - task6(5, "%", 3) -> 0
     *
     * Hint: Switch on `operator` and compute `a + b`, `a - b` and so on in each `case`.
     */
    static int task6(int a, String operator, int b) {
        return 0;
    }

    /**
     * Ticket 7. Spelling hint
     * The bot helps customers who spell their name aloud, letter by letter.
     * For each letter it must know if it is a vowel. The vowels are a, e, i, o, u.
     * The letter always comes in lower case.
     *
     * - Input: c, one letter (a char).
     * - Return: true if c is a vowel, otherwise false.
     *
     * Examples:
     * - task7('a') -> true
     * - task7('u') -> true
     * - task7('b') -> false
     *
     * Hint: A `char` case uses single quotes: `case 'a', 'e' ->`.
     */
    static boolean task7(char c) {
        return false;
    }

    /**
     * Ticket 8. Customer rating
     * After a delivery the customer rates the order with a number from 1 to 5.
     * The report shows a word instead of the number.
     *
     * - Input: grade, the rating.
     * - Return: "Excellent" for 5, "Good" for 4, "Satisfactory" for 3, "Fail" for 2 or 1, "Invalid" for any other number.
     *
     * Examples:
     * - task8(5) -> "Excellent"
     * - task8(3) -> "Satisfactory"
     * - task8(1) -> "Fail"
     * - task8(0) -> "Invalid"
     *
     * Hint: Grades 1 and 2 can share one `case`: `case 2, 1 ->`.
     */
    static String task8(int grade) {
        return null;
    }

    /**
     * Ticket 9. Warehouse robot
     * The warehouse robot hit a wall and must turn back: go in the opposite direction.
     * UP and DOWN are opposite, LEFT and RIGHT are opposite.
     * Use a switch expression (return switch (...) { case ... -> ...; }).
     *
     * - Input: direction, one of UP, DOWN, LEFT, RIGHT.
     * - Return: the opposite direction.
     *
     * Examples:
     * - task9(Direction.UP) -> Direction.DOWN
     * - task9(Direction.LEFT) -> Direction.RIGHT
     *
     * Hint: Inside a `switch` on an enum, write the constants without the type: `case UP ->`.
     */
    static Direction task9(Direction direction) {
        return null;
    }

    /**
     * Ticket 10. Loyalty program
     * Customers of the loyalty program get a discount that depends on their card type.
     *
     * - Input: type, the card type as text.
     * - Return: the discount in percent: 20 for "gold", 10 for "silver", 5 for "bronze", 0 for any other type.
     *
     * Examples:
     * - task10("gold") -> 20
     * - task10("bronze") -> 5
     * - task10("platinum") -> 0
     *
     * Hint: One `case` per card type and `default -> 0`.
     */
    static int task10(String type) {
        return 0;
    }
}
