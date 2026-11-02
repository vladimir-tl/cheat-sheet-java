package org.tl.theory;

import java.util.ArrayList;
import java.util.Arrays;
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
  2. Creating a list: four ways
 *   3. List<String> names = new ArrayList<>(): what is on the left and on the right
 *   4. Immutable list: List.of
 *
 * Working with elements
 *   5. Add, get, size, isEmpty
 *   6. Change and remove: set, remove, clear
 *   7. Searching: contains, indexOf
 *   8. Sorting: Collections.sort, reverse, max, min
 *
 * Traps
 *   9. remove(int) or remove(Object)?
 *   10. IndexOutOfBoundsException
 *
 * Summary
 *   11. All basic methods in one table
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
     * 2. Creating a list: four ways
     *
     * Think of a list as a paper shopping list: you can write new lines and cross lines out.
     * There are four ways to get one:
     *   - Empty, fill it later: new ArrayList<>(). Like a new empty notebook.
     *   - With starting items, and you can change it later: new ArrayList<>(List.of(...)).
     *     List.of(...) only provides the starting items; ArrayList copies them into a list you can change.
     *   - With items that can NOT be changed: List.of(...). Fine for data that never changes.
     *   - From an array: new ArrayList<>(Arrays.asList(array)).
     *
     * Which one? You will add or remove items later: the first, second or fourth way.
     * The data is fixed: List.of.
     */
    static void creating() {
        // 1. Empty
        List<String> empty = new ArrayList<>();                          // []

        // 2. With items, changeable
        List<String> fruits = new ArrayList<>(List.of("apple", "pear")); // [apple, pear]
        fruits.add("plum");                                              // [apple, pear, plum]

        // 3. With items, NOT changeable
        List<String> days = List.of("Mon", "Tue");                       // [Mon, Tue]
        // days.add("Wed");                                              // UnsupportedOperationException

        // 4. From an array
        String[] array = {"a", "b", "c"};
        List<String> fromArray = new ArrayList<>(Arrays.asList(array));  // [a, b, c]
    }

    /**
     * 3. List<String> names = new ArrayList<>(): what is on the left and on the right
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
     * 4. Immutable list: List.of
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
     * 5. Add, get, size, isEmpty
     *
     * A list grows by itself: just call add. No size to choose, no copying.
     *   - add(x): put x at the END of the list.
     *   - add(index, x): put x at that place; everything after it moves one step to the right.
     *   - addAll(other): add all the elements of another list to the end.
     * get(index) returns the element at the index. size() is the number of elements.
     * isEmpty() is true when there is nothing in the list.
     */
    static void basics() {
        List<String> names = new ArrayList<>();

        names.add("Anna");     // [Anna]
        names.add("Bob");      // [Anna, Bob]
        names.add(0, "Eve");   // [Eve, Anna, Bob]: Eve is in front, the others moved right
        names.addAll(List.of("Tom", "Kate")); // [Eve, Anna, Bob, Tom, Kate]

        names.get(0);          // "Eve"
        names.size();          // 5
        names.isEmpty();       // false
    }

    /**
     * 6. Change and remove: set, remove, clear
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
     * 7. Searching: contains, indexOf
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
     * 8. Sorting: Collections.sort, reverse, max, min
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
     * 9. remove(int) or remove(Object)?
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
     * 10. IndexOutOfBoundsException
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

    /**
     * 11. All basic methods in one table
     *
     *   Method              | What it does
     *   --------------------|----------------------------------------
     *   add(value)          | Add an element (to the end)
     *   get(index)          | Get an element
     *   set(index, value)   | Replace an element
     *   remove(index)       | Remove by index
     *   remove(value)       | Remove by value
     *   size()              | Get the number of elements
     *   contains(value)     | Check that the element is in the list
     *   isEmpty()           | Check that the list is empty
     *   clear()             | Remove all elements
     *   indexOf(value)      | Find the index of an element (-1 if not found)
     *
     * With List<Integer> remember the trap from section 9: remove(1) is an INDEX.
     */
    static void allMethods() {
        List<String> names = new ArrayList<>();

        names.add("Anna");          // [Anna]
        names.add("Bob");           // [Anna, Bob]
        names.add("Eve");           // [Anna, Bob, Eve]

        names.get(0);               // "Anna"
        names.set(1, "Alex");       // [Anna, Alex, Eve]
        names.remove(0);            // by index: [Alex, Eve]
        names.remove("Eve");        // by value: [Alex]

        names.size();               // 1
        names.contains("Alex");     // true
        names.isEmpty();            // false
        names.indexOf("Alex");      // 0
        names.indexOf("Zed");       // -1: not found

        names.clear();              // []
    }
}
