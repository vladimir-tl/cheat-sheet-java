package org.tl.collections.set;

import java.util.List;
import java.util.Set;

/**
 * PRACTICE TASKS: Set (very simple)
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work, and every ticket is one method that you have to finish.
 * Remember: a set keeps every element only once and has no fixed order, so {"Bob", "Anna"}
 * printed in a different order is still the same set. Here sets are written in curly braces,
 * but Java prints them in square brackets: System.out.println(set) shows [Anna, Bob].
 *
 * - Input: the parameters the method gets.
 * - Return: what the method must give back (or how it must change the set).
 * - Examples: inputs with their expected results. Run them in main to check yourself.
 *
 * Solutions are in SetSolutions.java; peek only after you've tried.
 */
public class SetTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Blocklist
     * The store starts a blocklist of customers who abuse the support. Nobody is on it yet.
     * Create an empty Set<String>. Names will be added to it later, so the set must allow adding.
     *
     * - Input: nothing, the method has no parameters (the brackets are empty).
     * - Return: a new empty set.
     *
     * Example:
     * - task1() -> {}
     *
     * Hint: `new HashSet<>()` gives an empty set you can add to.
     */
    static Set<String> task1() {
        return null;
    }

    /**
     * Ticket 2. VIP customers
     * The VIP customers are "Anna", "Bob" and "Eve". Create a set with these three names.
     *
     * - Input: nothing, the method has no parameters (the brackets are empty).
     * - Return: a new set with the three names.
     *
     * Example:
     * - task2() -> {"Anna", "Bob", "Eve"} (in any order)
     *
     * Hint: Create an empty `HashSet` and call `add` three times.
     */
    static Set<String> task2() {
        return null;
    }

    /**
     * Ticket 3. Newsletter sign-up
     * A customer subscribes to the newsletter. Add the name to the set of subscribers and tell
     * whether this is a new subscriber. If the name is already there, the set does not change.
     *
     * - Input: set, the subscribers; name, the customer.
     * - Return: true if the name was added (a new subscriber), false if it was already in the set.
     *
     * Examples:
     * - set {"Anna"}, name "Bob" -> true, the set becomes {"Anna", "Bob"}
     * - set {"Anna"}, name "Anna" -> false, the set stays {"Anna"}
     *
     * Hint: `add` already returns `true` or `false`: was the element new?
     */
    static boolean task3(Set<String> set, String name) {
        return false;
    }

    /**
     * Ticket 4. Is the customer blocked?
     * Before answering a chat the agent checks the blocklist.
     *
     * - Input: set, the blocklist; name, the customer.
     * - Return: true if the name is in the set, otherwise false.
     *
     * Examples:
     * - set {"spammer", "troll"}, name "troll" -> true
     * - set {"spammer", "troll"}, name "Anna" -> false
     *
     * Hint: `contains(x)` answers "is `x` in the set?".
     */
    static boolean task4(Set<String> set, String name) {
        return false;
    }

    /**
     * Ticket 5. How many subscribers?
     * Marketing wants to know the number of newsletter subscribers.
     *
     * - Input: set, the subscribers.
     * - Return: the number of names in the set.
     *
     * Examples:
     * - {"Anna", "Bob"} -> 2
     * - {} -> 0
     *
     * Hint: One method tells how many elements the set holds.
     */
    static int task5(Set<String> set) {
        return 0;
    }

    /**
     * Ticket 6. Unsubscribe
     * A customer unsubscribes from the newsletter. Remove the name from the set.
     * If the name is not in the set, nothing changes and nothing crashes.
     *
     * - Input: set, the subscribers; name, the customer.
     * - Return: nothing. Change the set you got.
     *
     * Examples:
     * - set {"Anna", "Bob"}, name "Bob" -> the set becomes {"Anna"}
     * - set {"Anna"}, name "Tom" -> the set stays {"Anna"}
     *
     * Hint: `remove(x)` deletes `x` from the set.
     */
    static void task6(Set<String> set, String name) {
    }

    /**
     * Ticket 7. Duplicate tickets
     * One customer can open several tickets, so the list of customer ids has repeats.
     * Make a set out of it: every customer id once.
     *
     * - Input: numbers, the customer id of every ticket.
     * - Return: a new set with the ids, without repeats.
     *
     * Examples:
     * - [1, 2, 2, 3] -> {1, 2, 3}
     * - [5, 5, 5] -> {5}
     *
     * Hint: `new HashSet<>(list)` copies the list and drops the repeats.
     */
    static Set<Integer> task7(List<Integer> numbers) {
        return null;
    }

    /**
     * Ticket 8. Unique customers today
     * How many different customers wrote to the support today? The list holds the customer id
     * of every ticket, and one customer can appear several times.
     *
     * - Input: numbers, the customer id of every ticket.
     * - Return: the number of different ids.
     *
     * Examples:
     * - [1, 2, 2, 3] -> 3
     * - [7, 7] -> 1
     * - [] -> 0
     *
     * Hint: Put the list into a set and ask the set for its `size()`.
     */
    static int task8(List<Integer> numbers) {
        return 0;
    }

    /**
     * Ticket 9. Double click on "Pay"
     * The system suspects that a customer clicked "Pay" twice and an order was submitted twice.
     * Check the list of order numbers for repeats.
     *
     * - Input: numbers, the order numbers.
     * - Return: true if at least one number appears more than once, otherwise false.
     *
     * Examples:
     * - [101, 102, 101] -> true
     * - [101, 102, 103] -> false
     *
     * Hint: If there are repeats, the set is smaller than the list.
     */
    static boolean task9(List<Integer> numbers) {
        return false;
    }

    /**
     * Ticket 10. Different letters in a promo code
     * The marketing team wants to know how many different characters a promo code uses.
     * A capital letter and a small letter are different characters ('A' is not 'a').
     *
     * - Input: text, the promo code.
     * - Return: the number of different characters in it.
     *
     * Examples:
     * - task10("hello") -> 4 (h, e, l, o)
     * - task10("aaa") -> 1
     * - task10("") -> 0
     *
     * Hint: Add every char of the text to a `Set<Character>`, then take its `size()`.
     */
    static int task10(String text) {
        return 0;
    }
}
