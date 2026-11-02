package org.tl.conditions.ifelse;

/**
 * PRACTICE TASKS: if-else
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work, and every ticket is one method that you have to finish.
 *
 * - Input: the parameters the method gets.
 * - Return: what the method must give back.
 * - Examples: calls with their expected results. Run them in main to check yourself.
 *
 * Solutions are in IfElseSolutions.java; peek only after you've tried.
 */
public class IfElseTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Charge or not?
     * The billing system sends you the amount n of one payment operation, in euros.
     * If n is greater than 0, money was taken from the customer: this is a charge.
     * If n is 0 or negative, it is not a charge (an empty operation or a refund).
     *
     * - Input: n, the amount of the operation.
     * - Return: true if the operation is a charge, otherwise false.
     *
     * Examples:
     * - task1(250) -> true
     * - task1(0) -> false
     * - task1(-40) -> false
     *
     * Hint: A comparison like `n > 0` is already a `boolean`, you can return it directly.
     */
    static boolean task1(int n) {
        return false;
    }

    /**
     * Ticket 2. Which queue?
     * Every ticket gets a number. Tickets with an even number go to queue A, all the others
     * go to queue B. A number is even if it divides by 2 without a remainder.
     *
     * - Input: n, the ticket number.
     * - Return: true if the ticket goes to queue A (n is even), false if it goes to queue B.
     *
     * Examples:
     * - task2(8) -> true
     * - task2(7) -> false
     * - task2(0) -> true
     *
     * Hint: The remainder of division by 2, `n % 2`, tells even from odd.
     */
    static boolean task2(int n) {
        return false;
    }

    /**
     * Ticket 3. The higher price
     * Two partner shops sell the same album: the first one for a euros, the second one for b euros.
     * The manager wants to know the higher of the two prices.
     * Compare the prices with if-else yourself, do not use Math.max.
     *
     * - Input: a and b, the two prices.
     * - Return: the bigger number. If the prices are equal, return either of them.
     *
     * Examples:
     * - task3(12, 15) -> 15
     * - task3(20, 9) -> 20
     * - task3(7, 7) -> 7
     *
     * Hint: Compare `a` and `b` with one `if` / `else`.
     */
    static int task3(int a, int b) {
        return 0;
    }

    /**
     * Ticket 4. Account movement
     * Every movement on a customer's account is a number n. The account statement shows
     * a word next to each movement, so the customer understands what happened.
     *
     * - Input: n, the movement.
     * - Return: "positive" if n > 0 (money came in), "negative" if n < 0 (money went out), "zero" if n is 0.
     *
     * Examples:
     * - task4(50) -> "positive"
     * - task4(-20) -> "negative"
     * - task4(0) -> "zero"
     *
     * Hint: Three cases: `if`, `else if`, `else`.
     */
    static String task4(int n) {
        return null;
    }

    /**
     * Ticket 5. Delivery window
     * The courier works only on the days from..to of the month, both ends included.
     * A customer asks for a delivery on day n.
     *
     * - Input: n, the day the customer wants; from and to, the first and the last working day of the courier.
     * - Return: true if n is inside the window (from <= n <= to), otherwise false.
     *
     * Examples:
     * - task5(5, 3, 10) -> true
     * - task5(3, 3, 10) -> true (the ends are included)
     * - task5(11, 3, 10) -> false
     *
     * Hint: Both conditions must be true: join them with `&&`.
     */
    static boolean task5(int n, int from, int to) {
        return false;
    }

    /**
     * Ticket 6. Best of three offers
     * Three suppliers offered to buy the old stock of vinyl records for a, b and c euros.
     * The store takes the biggest offer. Do not use Math.max.
     *
     * - Input: a, b and c, the three offers.
     * - Return: the biggest of the three numbers.
     *
     * Examples:
     * - task6(5, 9, 2) -> 9
     * - task6(10, 3, 10) -> 10
     * - task6(-1, -5, -3) -> -1
     *
     * Hint: Remember the biggest so far in a variable `max` and compare it with the other two.
     */
    static int task6(int a, int b, int c) {
        return 0;
    }

    /**
     * Ticket 7. Support quality grade
     * After a chat the customer rates the support with a score from 0 to 100.
     * The monthly report shows a letter grade instead of the score.
     *
     * - Input: score, a number from 0 to 100.
     * - Return: "A" for 90..100, "B" for 80..89, "C" for 70..79, "D" for 60..69, "F" for 0..59.
     *
     * Examples:
     * - task7(95) -> "A"
     * - task7(80) -> "B"
     * - task7(59) -> "F"
     *
     * Hint: Check from the highest grade down: `score >= 90` first, then `score >= 80` and so on.
     */
    static String task7(int score) {
        return null;
    }

    /**
     * Ticket 8. Content filter
     * The store hides some albums from young listeners. To decide what to show,
     * it needs the age group of the customer.
     *
     * - Input: age, the age of the customer in years.
     * - Return: "child" if age is under 13, "teenager" for 13..17, "adult" for 18 and older.
     *
     * Examples:
     * - task8(10) -> "child"
     * - task8(13) -> "teenager"
     * - task8(18) -> "adult"
     *
     * Hint: Check the youngest group first, then the next one; the rest is adult.
     */
    static String task8(int age) {
        return null;
    }

    /**
     * Ticket 9. Yearly subscription
     * In a leap year a yearly subscription has one extra day (366 instead of 365).
     * A year is a leap year if
     *
     * - it divides by 400, or
     * - it divides by 4, but does not divide by 100.
     *
     * - Input: year.
     * - Return: true if the year is a leap year, otherwise false.
     *
     * Examples:
     * - task9(2024) -> true
     * - task9(2023) -> false
     * - task9(1900) -> false (divides by 100, but not by 400)
     * - task9(2000) -> true (divides by 400)
     *
     * Hint: Divides by 4 and not by 100, OR divides by 400. Use `%`, `&&` and `||`.
     */
    static boolean task9(int year) {
        return false;
    }

    /**
     * Ticket 10. Cardboard stand
     * A customer wants to build a triangle stand for CDs from three cardboard strips
     * of lengths a, b and c. A triangle can be built only if every strip is shorter than
     * the other two together: a < b + c, b < a + c and c < a + b.
     *
     * - Input: a, b and c, the lengths of the strips.
     * - Return: true if the triangle can be built, otherwise false.
     *
     * Examples:
     * - task10(3, 4, 5) -> true
     * - task10(1, 2, 3) -> false (1 + 2 is not more than 3, the strips lie flat)
     * - task10(1, 1, 10) -> false
     *
     * Hint: Every pair of sides together must be longer than the third side: three checks like `a + b > c` joined with `&&`.
     */
    static boolean task10(int a, int b, int c) {
        return false;
    }

    /**
     * Ticket 11. Password on sign-up
     * A new customer chose a password. If the customer left the field empty,
     * the form sends null instead of a text. The password is accepted if it is not null
     * and has at least 8 characters.
     *
     * - Input: password, a text or null.
     * - Return: true if the password is accepted, otherwise false. The program must not crash on null.
     *
     * Examples:
     * - task11("secret123") -> true
     * - task11("abc") -> false
     * - task11(null) -> false
     *
     * Hint: Check `password != null` first, then the length; `&&` stops early if the first part is `false`.
     */
    static boolean task11(String password) {
        return false;
    }

    /**
     * Ticket 12. Label of one ticket
     * The helpdesk puts a label on every ticket, depending on its number n:
     *
     * - divides by 3 and by 5: "FizzBuzz" (an urgent ticket)
     * - divides only by 3: "Fizz" (a billing ticket)
     * - divides only by 5: "Buzz" (a shipping ticket)
     * - anything else: the number itself as text
     *
     * - Input: n, the ticket number.
     * - Return: the label of the ticket.
     *
     * Examples:
     * - task12(15) -> "FizzBuzz"
     * - task12(9) -> "Fizz"
     * - task12(10) -> "Buzz"
     * - task12(7) -> "7"
     *
     * Hint: Check "divides by 3 and by 5" FIRST (`n % 15 == 0`), otherwise Fizz catches 15. `String.valueOf(n)` turns the number into text.
     */
    static String task12(int n) {
        return null;
    }
}
