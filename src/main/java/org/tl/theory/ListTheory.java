package org.tl.theory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * THEORY: List
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Creating a list
 *   1. What a List is
 *   2. List<String> names = new ArrayList<>(): what is on the left and on the right
 *   3. Immutable list: List.of
 *
 * Working with elements
 *   4. Add, get, size, isEmpty
 *   5. Change and remove: set, remove, clear
 *   6. Searching: contains, indexOf
 *   7. Sorting: Collections.sort, reverse, max, min
 *
 * Traps
 *   8. remove(int) or remove(Object)?
 *   9. IndexOutOfBoundsException
 *
 * Practice: see org.tl.collections.list (ListCheatSheet, ListTasks, ListSolutions).
 */
public class ListTheory {

    /**
     * 1. What a List is
     *
     * A List is an ordered collection that can contain duplicates. Every element has an
     * index, starting at 0. Unlike an array, a List can grow and shrink.
     *
     * Size: an array has .length, a List has .size().
     * Elements are objects: List<Integer>, not List<int> (see PrimitivesAndWrappersTheory).
     */
    static void whatIsList() {
        // ["Anna", "Bob", "Anna"]
        //    0       1      2      <- indexes
    }

    /**
     * 2. List<String> names = new ArrayList<>(): what is on the left and on the right
     *
     *   List<String>      - the TYPE of the variable (left side).
     *                       List is an interface: it only describes WHAT a list can do
     *                       (add, get, remove...), not HOW it is stored.
     *                       <String> says that the list holds Strings.
     *   names             - the variable name.
     *   new ArrayList<>() - the actual OBJECT created in memory (right side).
     *                       ArrayList is a class that implements List: it stores the
     *                       elements in an array inside and knows HOW to do all the operations.
     *   <>                - "diamond": the compiler infers <String> from the left side.
     *
     * You can't write new List<>(): an interface can't be instantiated.
     *
     * Why not ArrayList<String> names = new ArrayList<>()? It works, but declaring the
     * variable as List lets you switch the implementation later (e.g. new LinkedList<>())
     * by changing only the right side. The rest of the code uses only List methods and
     * stays the same. The same idea for methods: accept List<String> as a parameter,
     * not ArrayList<String>.
     *
     * ArrayList: stores elements in an array; fast get by index, slower insert/remove in
     * the middle. The default choice.
     */
    static void listVsArrayList() {
        List<String> names = new ArrayList<>(); // empty list
    }

    /**
     * 3. Immutable list: List.of
     *
     * List.of(...) creates a list that cannot be changed. add, remove, set and sort
     * throw UnsupportedOperationException.
     *
     * Need a list you can change? Copy it: new ArrayList<>(List.of(...)).
     */
    static void immutable() {
        List<String> fixed = List.of("Anna", "Bob");
        // fixed.add("Eve"); // UnsupportedOperationException

        List<String> changeable = new ArrayList<>(List.of("Anna", "Bob"));
        changeable.add("Eve"); // OK -> [Anna, Bob, Eve]
    }

    /**
     * 4. Add, get, size, isEmpty
     *
     * add(x) adds to the end. add(index, x) inserts at the index and moves the rest to the right.
     * get(index) returns the element. size() is the number of elements.
     */
    static void basics() {
        List<String> names = new ArrayList<>();

        names.add("Anna");     // [Anna]
        names.add("Bob");      // [Anna, Bob]
        names.add(0, "Eve");   // [Eve, Anna, Bob]

        names.get(0);          // "Eve"
        names.size();          // 3
        names.isEmpty();       // false
    }

    /**
     * 5. Change and remove: set, remove, clear
     *
     * set(index, x) replaces the element and returns the old one. remove(index) deletes
     * the element and shifts the rest to the left. remove("value") deletes the first
     * match. clear() removes everything.
     */
    static void changeAndRemove() {
        List<String> names = new ArrayList<>(List.of("Eve", "Anna", "Bob"));

        names.set(1, "Alex");  // [Eve, Alex, Bob]
        names.remove(0);       // by index -> [Alex, Bob]
        names.remove("Bob");   // by value -> [Alex]
        names.clear();         // []
    }

    /**
     * 6. Searching: contains, indexOf
     *
     * contains(x) is true if the element is in the list. indexOf(x) is the index of the
     * first match, or -1 if there is none. lastIndexOf(x) is the index of the last match.
     */
    static void searching() {
        List<String> names = new ArrayList<>(List.of("Anna", "Bob", "Anna"));

        names.contains("Bob");      // true
        names.indexOf("Anna");      // 0
        names.lastIndexOf("Anna");  // 2
        names.indexOf("Zed");       // -1: not found
    }

    /**
     * 7. Sorting: Collections.sort, reverse, max, min
     *
     * The Collections class has helpers for lists. They need a changeable list
     * (not List.of): sort and reverse change the list itself.
     */
    static void sorting() {
        List<Integer> numbers = new ArrayList<>(List.of(3, 1, 2));

        Collections.sort(numbers);          // [1, 2, 3]
        Collections.reverse(numbers);       // [3, 2, 1]
        Collections.max(numbers);           // 3
        Collections.min(numbers);           // 1
    }

    /**
     * 8. remove(int) or remove(Object)?
     *
     * A trap with List<Integer>. The list has two methods named remove:
     * remove(int index) and remove(Object value). With a plain number Java picks the index.
     */
    static void removeTrap() {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30));

        list.remove(1);                    // index 1 -> removes 20 -> [10, 30]
        list.remove(Integer.valueOf(10));  // the VALUE 10 -> [30]
    }

    /**
     * 9. IndexOutOfBoundsException
     *
     * A list of size n has indexes 0 .. n-1. Anything else throws an exception.
     * The last element is list.get(list.size() - 1).
     */
    static void indexTrap() {
        List<String> names = new ArrayList<>(List.of("Anna", "Bob", "Eve"));

        names.get(2);                   // "Eve", the last one
        names.get(names.size() - 1);    // "Eve", the same
        // names.get(3);                // IndexOutOfBoundsException: Index 3 out of bounds for length 3
        // new ArrayList<String>().get(0); // the same for an empty list
    }
}
