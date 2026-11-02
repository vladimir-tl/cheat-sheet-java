package org.tl.theory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * THEORY: Set and HashSet
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Basics
 *   1. What a Set is
 *   2. Creating a set
 *   3. Adding: duplicates are ignored
 *
 * Working with elements
 *   4. Checking and removing: contains, remove, size
 *   5. Removing duplicates from a list
 *   6. Looping over a set
 *
 * Kinds of Set
 *   7. HashSet, LinkedHashSet, TreeSet
 *
 * Traps
 *   8. No index, no order, equals and hashCode
 *
 * Choosing
 *   9. List, Set or Map?
 *
 * Practice: see org.tl.collections.set (SetCheatSheet, SetTasks, SetSolutions).
 */
public class SetTheory {

    /**
     * 1. What a Set is
     *
     * A Set is a collection of UNIQUE elements: the same value can be in it only once.
     * It is good for two things: getting rid of duplicates and quickly checking
     * whether a value is present.
     *
     * Think of a guest list at the door: a name is either on the list or not. Writing the
     * same name twice changes nothing.
     *
     * A Set has no indexes: there is no set.get(0). HashSet is the most common Set.
     */
    static void whatIsSet() {
        // Added: Anna, Bob, Anna, Eve, Bob
        // The set holds: Anna, Bob, Eve   (every name once, in any order)
    }

    /**
     * 2. Creating a set
     *
     *   - Empty, fill it later: new HashSet<>().
     *   - From another collection: new HashSet<>(list). Duplicates disappear on the way.
     *   - Fixed items that can NOT be changed: Set.of(...). It throws an exception if you
     *     give it the same value twice.
     */
    static void creating() {
        // 1. Empty
        Set<String> names = new HashSet<>();                      // {}

        // 2. From a list
        List<String> list = List.of("a", "b", "a");
        Set<String> fromList = new HashSet<>(list);               // {a, b}

        // 3. Fixed, NOT changeable
        Set<String> fixed = Set.of("Mon", "Tue");                 // {Mon, Tue}
        // fixed.add("Wed");                                      // UnsupportedOperationException
        // Set.of("a", "a");                                      // IllegalArgumentException: duplicate element
    }

    /**
     * 3. Adding: duplicates are ignored
     *
     * add(x) puts x into the set and returns a boolean:
     *   true  - the value was new and was added
     *   false - the value was already there, nothing changed
     */
    static void adding() {
        Set<String> names = new HashSet<>();

        names.add("Anna");     // true,  {Anna}
        names.add("Bob");      // true,  {Anna, Bob}
        names.add("Anna");     // false, Anna is already there: still {Anna, Bob}

        System.out.println(names.size());   // 2, not 3
    }

    /**
     * 4. Checking and removing: contains, remove, size
     *
     * contains(x) answers "is x in the set?" and it is FAST, much faster than
     * list.contains on a big collection.
     * remove(x) deletes x (true if it was there). size() is the number of elements.
     * isEmpty() and clear() work like in a List.
     */
    static void checkAndRemove() {
        Set<String> names = new HashSet<>(List.of("Anna", "Bob", "Eve"));

        names.contains("Bob");     // true
        names.contains("Zed");     // false

        names.remove("Bob");       // true,  {Anna, Eve}
        names.remove("Zed");       // false, nothing to remove
        names.size();              // 2

        names.clear();             // {}
        names.isEmpty();           // true
    }

    /**
     * 5. Removing duplicates from a list
     *
     * The classic use of a Set. Put the list into a HashSet: the duplicates vanish.
     * If you need a list again, copy the set back into an ArrayList.
     *
     * To keep the original order of the first appearances use LinkedHashSet (see 7).
     */
    static void removeDuplicates() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3);

        Set<Integer> unique = new HashSet<>(numbers);                    // {1, 2, 3}
        List<Integer> withoutDuplicates = new ArrayList<>(unique);       // [1, 2, 3]

        // How many different values are there?
        System.out.println(unique.size());                               // 3

        // Are there duplicates at all?
        boolean hasDuplicates = numbers.size() != unique.size();         // true
    }

    /**
     * 6. Looping over a set
     *
     * A Set has no indexes, so use for-each (see ForTheory).
     * The order of the elements in a HashSet is not guaranteed.
     */
    static void looping() {
        Set<String> names = new HashSet<>(List.of("Anna", "Bob", "Eve"));

        for (String name : names) {
            System.out.println(name);      // all three, in any order
        }

        // for (int i = 0; i < names.size(); i++) { names.get(i) }  // does not compile: no get(i)
    }

    /**
     * 7. HashSet, LinkedHashSet, TreeSet
     *
     * All three are used the same way. The difference is the order of the elements.
     *
     *   HashSet         - no guaranteed order. The default choice, the fastest.
     *   LinkedHashSet   - keeps the insertion order.
     *   TreeSet         - keeps the elements sorted (A to Z, smallest to largest).
     */
    static void kinds() {
        Set<String> hash = new HashSet<>();
        Set<String> linked = new LinkedHashSet<>();
        Set<String> tree = new TreeSet<>();

        // After add("Bob"), add("Anna"), add("Eve"):
        //   HashSet:       any order
        //   LinkedHashSet: [Bob, Anna, Eve]
        //   TreeSet:       [Anna, Bob, Eve]
    }

    /**
     * 8. No index, no order, equals and hashCode
     *
     * Three things to remember.
     *
     * 1) No index and no order in a HashSet: you can't ask for "the first element".
     * 2) A set decides "is it the same?" with equals() and hashCode(). String and Integer
     *    do it right. For your own classes you must write both methods, otherwise two
     *    "equal" objects both get into the set.
     * 3) Don't change a set while you loop over it with for-each: ConcurrentModificationException.
     *    Use an Iterator or removeIf (see ListTheory).
     */
    static void traps() {
        Set<String> names = new HashSet<>();
        names.add("Anna");
        names.add("anna");           // a different string (case matters) -> both are stored
        names.size();                // 2
    }

    /**
     * 9. List, Set or Map?
     *
     *   List - ordered, access by index, duplicates allowed.
     *          "A queue of people": the order and repeats matter.
     *   Set  - unique elements, fast "is it there?", no index.
     *          "A guest list": only presence matters.
     *   Map  - pairs key -> value, find a value by its key.
     *          "A phone book": name -> number.
     *
     * Technically List and Set belong to the Collection family (they have add, remove,
     * contains, size). Map is a separate interface and does not extend Collection (see MapTheory).
     */
    static void choosing() {
        List<String> queue = new ArrayList<>();   // order and duplicates matter
        Set<String> guests = new HashSet<>();     // only "is this name here?" matters
    }
}
