package org.tl.collections.set;

import java.util.List;
import java.util.Set;

/**
 * PRACTICE TASKS: Set (very simple)
 *
 * You work in the support team of an online music store. Every task is a small
 * situation from work. Implement the methods and check them in main.
 * Solutions are in SetSolutions.java; peek only after you've tried.
 */
public class SetTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Blocklist
     * The store starts a blocklist of customers who abuse the support. It is empty for now.
     * Create an empty Set<String> and return it.
     */
    static Set<String> task1() {
        return null;
    }

    /**
     * Ticket 2. VIP customers
     * The VIP customers are "Anna", "Bob" and "Eve". Create a set with these names and return it.
     */
    static Set<String> task2() {
        return null;
    }

    /**
     * Ticket 3. Newsletter sign-up
     * A customer subscribes to the newsletter. Add the name to the set of subscribers.
     * Return true if the customer is a new subscriber, false if they were already subscribed.
     */
    static boolean task3(Set<String> set, String name) {
        return false;
    }

    /**
     * Ticket 4. Is the customer blocked?
     * Return true if the name is in the set.
     */
    static boolean task4(Set<String> set, String name) {
        return false;
    }

    /**
     * Ticket 5. How many subscribers?
     * Return the number of subscribers in the set.
     */
    static int task5(Set<String> set) {
        return 0;
    }

    /**
     * Ticket 6. Unsubscribe
     * A customer unsubscribes from the newsletter. Remove the name from the set.
     */
    static void task6(Set<String> set, String name) {
    }

    /**
     * Ticket 7. Duplicate tickets
     * One customer can open several tickets, so the list of customer ids has repeats.
     * Return a set with every customer id once. [1, 2, 2, 3] -> {1, 2, 3}.
     */
    static Set<Integer> task7(List<Integer> numbers) {
        return null;
    }

    /**
     * Ticket 8. Unique customers today
     * How many different customers wrote to the support today? The list holds the customer id
     * of every ticket. [1, 2, 2, 3] -> 3.
     */
    static int task8(List<Integer> numbers) {
        return 0;
    }

    /**
     * Ticket 9. Double click on "Pay"
     * The system suspects that an order was submitted twice. Return true if the list of order
     * numbers contains at least one repeated number.
     */
    static boolean task9(List<Integer> numbers) {
        return false;
    }

    /**
     * Ticket 10. Different letters in a promo code
     * The marketing team wants to know how many different characters a promo code uses.
     * "hello" -> 4 (h, e, l, o).
     */
    static int task10(String text) {
        return 0;
    }
}
