package org.tl.conditions.switchcase;

/**
 * PRACTICE TASKS: switch
 *
 * You work in the support team of an online music store. Every task is a small
 * situation from work. Implement the methods and check them in main.
 * Solutions are in SwitchSolutions.java; peek only after you've tried.
 */
public class SwitchTasks {

    enum Direction {UP, DOWN, LEFT, RIGHT}

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Delivery day
     * The delivery system gives you the day of the week as a number: 1 is "Monday" ... 7 is "Sunday".
     * Return the name of the day, or "Unknown" for any other number.
     */
    static String task1(int day) {
        return null;
    }

    /**
     * Ticket 2. Reduced support hours
     * On weekends (days 6 and 7) the support works with reduced hours.
     * Is the day a weekend day? Any other number is not.
     */
    static boolean task2(int day) {
        return false;
    }

    /**
     * Ticket 3. Billing period
     * A monthly subscription is charged for every day of the month. How many days are in the
     * month (1..12)? February has 28. For any other number return -1.
     */
    static int task3(int month) {
        return 0;
    }

    /**
     * Ticket 4. Seasonal playlist
     * The store shows a playlist of the season. Return the season of the month:
     * Winter (12, 1, 2), Spring (3-5), Summer (6-8), Autumn (9-11).
     */
    static String task4(int month) {
        return null;
    }

    /**
     * Ticket 5. Voice bot
     * The voice bot recognises the words "one", "two" and "three" and turns them into numbers
     * 1, 2 and 3. Return 0 for any other word.
     */
    static int task5(String word) {
        return 0;
    }

    /**
     * Ticket 6. Refund calculator in the bot
     * A customer asks the bot to calculate "a operator b" for "+", "-", "*" or "/".
     * Return the result. For any other operator return 0.
     */
    static int task6(int a, String operator, int b) {
        return 0;
    }

    /**
     * Ticket 7. Spelling hint
     * The bot helps customers who spell their name aloud. Is the letter c a vowel
     * (a, e, i, o, u)? Lower case only.
     */
    static boolean task7(char c) {
        return false;
    }

    /**
     * Ticket 8. Customer rating
     * A customer rated the order with a number: 5 is "Excellent", 4 is "Good",
     * 3 is "Satisfactory", 2 or 1 is "Fail". Any other number is "Invalid".
     */
    static String task8(int grade) {
        return null;
    }

    /**
     * Ticket 9. Warehouse robot
     * The warehouse robot hit a wall and must turn back. Return the opposite direction:
     * UP and DOWN swap places, LEFT and RIGHT too. Use a switch expression.
     */
    static Direction task9(Direction direction) {
        return null;
    }

    /**
     * Ticket 10. Loyalty program
     * Customers of the loyalty program get a discount in percent: "gold" 20, "silver" 10,
     * "bronze" 5. Any other customer type gets 0.
     */
    static int task10(String type) {
        return 0;
    }
}
