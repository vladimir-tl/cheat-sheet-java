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
 * Search and change
 *   5. contains and indexOf: is the element there, and where
 *   6. remove: by element or by position
 *   7. set and add(position, element): replace and insert
 *   8. isEmpty: is the list empty
 *
 * Loops over a list
 *   9. for-each: go through all elements
 *   10. Removing while looping
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

    /**
     * 5. contains and indexOf: is the element there, and where
     *
     * contains(element) returns true if the list has this element. indexOf(element) returns
     * its position, or -1 if it is not there. Both compare elements with equals, so they work for strings too.
     */
    static void containsAndIndexOf() {
        List<String> names = new ArrayList<>(List.of("Ann", "Bob"));
        System.out.println(names.contains("Bob"));   // true
        System.out.println(names.indexOf("Bob"));    // 1
        System.out.println(names.indexOf("Eve"));    // -1
    }

    /**
     * 6. remove: by element or by position
     *
     * remove(position) removes the element at this position. remove(element) removes the first equal element,
     * and does nothing if there is none. The elements after it move one position to the left.
     *
     * Trap: in a List<Integer> the call remove(1) means position 1, not the number 1.
     * To remove the number, write remove(Integer.valueOf(1)).
     */
    static void remove() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        numbers.remove(1);                           // position 1: [10, 30]
        numbers.remove(Integer.valueOf(10));         // the number 10: [30]
        System.out.println(numbers);                 // [30]
    }

    /**
     * 7. set and add(position, element): replace and insert
     *
     * set(position, element) writes over the old element, the size stays the same.
     * add(position, element) inserts the element, the size grows by one and the others move to the right.
     */
    static void setAndAddAt() {
        List<String> names = new ArrayList<>(List.of("Ann", "Bob"));
        names.set(1, "Eve");                         // [Ann, Eve]
        names.add(0, "Max");                         // [Max, Ann, Eve]
        System.out.println(names);
    }

    /**
     * 8. isEmpty: is the list empty
     *
     * isEmpty() returns true when the list has no elements. It means the same as size() == 0, but reads better.
     */
    static void isEmpty() {
        List<String> names = new ArrayList<>();
        System.out.println(names.isEmpty());         // true
        names.add("Ann");
        System.out.println(names.isEmpty());         // false
    }

    /**
     * 9. for-each: go through all elements
     *
     * for (int x : list) takes the elements one by one, from the first to the last. Use it when you
     * only read the elements and don't need their positions. A List<Integer> can be read into an int.
     */
    static void forEach() {
        List<Integer> numbers = new ArrayList<>(List.of(3, 8, 5));
        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }
        System.out.println(sum);                     // 16
    }

    /**
     * 10. Removing while looping
     *
     * Removing inside a for-each throws ConcurrentModificationException. Go by positions from the end
     * to the start: a removal then moves only elements you have already checked. Or use removeIf.
     */
    static void removeWhileLooping() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
        System.out.println(numbers);                 // [1, 3]

        List<Integer> other = new ArrayList<>(List.of(1, 2, 3, 4));
        other.removeIf(x -> x % 2 == 0);             // the same in one line
        System.out.println(other);                   // [1, 3]
    }
}
