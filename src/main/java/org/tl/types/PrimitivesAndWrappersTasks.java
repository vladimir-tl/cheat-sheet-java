package org.tl.types;

/**
 * PRACTICE TASKS: primitives and wrapper classes
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work, and every ticket is one method that you have to finish.
 *
 * - Input: the parameters the method gets.
 * - Return: what the method must give back.
 * - Examples: calls with their expected results. Run them in main to check yourself.
 *
 * Solutions are in PrimitivesAndWrappersSolutions.java; peek only after you've tried.
 */
public class PrimitivesAndWrappersTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Price from the form
     * The admin form sends the album price as text, for example "250". To do maths with it,
     * the program needs a number. The text is always a correct whole number.
     *
     * - Input: text, the price as text.
     * - Return: the same price as an int.
     *
     * Examples:
     * - task1("250") -> 250
     * - task1("-15") -> -15
     *
     * Hint: The `Integer` class has a method that parses text into an `int`.
     */
    static int task1(String text) {
        return 0;
    }

    /**
     * Ticket 2. Discount from the form
     * The discount comes as text and can have a fractional part, for example "12.5".
     * The text is always a correct number with a dot.
     *
     * - Input: text, the discount as text.
     * - Return: the same discount as a double.
     *
     * Examples:
     * - task2("12.5") -> 12.5
     * - task2("7") -> 7.0
     *
     * Hint: The `Double` class has a similar `parse...` method.
     */
    static double task2(String text) {
        return 0;
    }

    /**
     * Ticket 3. Order number in the e-mail
     * The e-mail template inserts only text, but the order number is an int.
     * Turn the number into text.
     *
     * - Input: orderId, the order number.
     * - Return: the same number as a String.
     *
     * Examples:
     * - task3(42) -> "42"
     * - task3(1005) -> "1005"
     *
     * Hint: `String.valueOf` turns almost anything into text.
     */
    static String task3(int orderId) {
        return null;
    }

    /**
     * Ticket 4. Average rating
     * An album got several ratings. You know their total sum and their number count.
     * The average is sum / count, but it must keep the fractional part.
     * Careful: in Java int / int drops the fraction, 9 / 2 gives 4.
     *
     * - Input: sum, the sum of the ratings; count, the number of ratings (count > 0).
     * - Return: the average as a double, with the fractional part.
     *
     * Examples:
     * - task4(9, 2) -> 4.5 (not 4.0)
     * - task4(10, 4) -> 2.5
     * - task4(6, 3) -> 2.0
     *
     * Hint: Cast one of the numbers to `double` BEFORE dividing: `(double) sum`.
     */
    static double task4(int sum, int count) {
        return 0;
    }

    /**
     * Ticket 5. Whole euros
     * The receipt printer prints only whole euros. Drop the cents: just cut off the fractional
     * part, do not round.
     *
     * - Input: price, the price with cents.
     * - Return: the whole part of the price as an int.
     *
     * Examples:
     * - task5(19.99) -> 19 (not 20)
     * - task5(5.0) -> 5
     * - task5(0.5) -> 0
     *
     * Hint: A cast `(int)` just drops the fractional part.
     */
    static int task5(double price) {
        return 0;
    }

    /**
     * Ticket 6. Plays for the whole period
     * A hit is played playsPerDay times a day for days days. Count the total number of plays:
     * playsPerDay * days. The result can be bigger than the biggest int (about 2.1 billion),
     * so the method returns a long, and the answer must be correct even for big numbers.
     *
     * - Input: playsPerDay, plays per day; days, the number of days.
     * - Return: the total number of plays as a long.
     *
     * Examples:
     * - task6(100, 30) -> 3000
     * - task6(2_000_000, 3_000) -> 6_000_000_000 (not a strange negative or small number)
     *
     * Hint: Cast one factor to `long` BEFORE multiplying, otherwise `int` overflows first.
     */
    static long task6(int playsPerDay, int days) {
        return 0;
    }

    /**
     * Ticket 7. Unknown bonus
     * A customer's bonus points come from another system as an Integer. If that system
     * does not know the points, it sends null. Treat unknown points as 0.
     *
     * - Input: bonus, the points or null.
     * - Return: the points as an int, or 0 if bonus is null. The program must not crash.
     *
     * Examples:
     * - task7(150) -> 150
     * - task7(null) -> 0
     *
     * Hint: Check `bonus == null` first; only then turn it into an `int`.
     */
    static int task7(Integer bonus) {
        return 0;
    }

    /**
     * Ticket 8. Same customer?
     * Two orders store the customer ids a and b as Integer objects (never null).
     * Check if both orders belong to the same customer, that is if the two ids are equal.
     * Make sure it works for big ids too: with 1000 and 1000 the answer must be true.
     *
     * - Input: a and b, the two customer ids.
     * - Return: true if the ids are equal, otherwise false.
     *
     * Examples:
     * - task8(1000, 1000) -> true
     * - task8(5, 5) -> true
     * - task8(5, 7) -> false
     *
     * Hint: `==` on `Integer` compares objects. Compare the values with `equals`.
     */
    static boolean task8(Integer a, Integer b) {
        return false;
    }
}
