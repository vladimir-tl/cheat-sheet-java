package org.tl.theory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * THEORY: Warm-up: ArrayList
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Basic operations
 *   1. size: how many elements
 *   2. get: read an element by its position
 *   3. add: put an element at the end
 *   4. Collections.reverse: reverse the same list
 *
 * Practice: see org.tl.warmup (WarmupListCheatSheet, WarmupListTasks, WarmupListSolutions).
 */
public class WarmupListTheory {

    /**
     * 1. size: how many elements
     *
     * size() returns the number of elements in the list. For an empty list it returns 0.
     * An array has the field length, a list has the method size(), with parentheses.
     */
    static void size() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        System.out.println(numbers.size());   // 3
    }

    /**
     * 2. get: read an element by its position
     *
     * get(position) returns the element at this position. Positions start from 0.
     * If the position does not exist, Java throws IndexOutOfBoundsException.
     */
    static void get() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        System.out.println(numbers.get(1));   // 20
    }

    /**
     * 3. add: put an element at the end
     *
     * add(element) puts the element at the end of the list, and the list grows by one.
     * This is the main difference from an array, whose size never changes.
     */
    static void add() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        System.out.println(numbers);          // [10, 20]
    }

    /**
     * 4. Collections.reverse: reverse the same list
     *
     * Collections.reverse(list) reverses the order of the elements. It returns nothing and
     * changes the list you pass to it. The class needs an import: java.util.Collections.
     */
    static void reverse() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        Collections.reverse(numbers);
        System.out.println(numbers);          // [3, 2, 1]
    }
}
