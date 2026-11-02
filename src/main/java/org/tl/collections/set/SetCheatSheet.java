package org.tl.collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * CHEAT SHEET: Set
 *
 * Theory: see org.tl.theory.SetTheory
 */
public class SetCheatSheet {

    public static void main(String[] args) {
        creating();
        adding();
        checkAndRemove();
        removeDuplicates();
        looping();
        kinds();
    }

    /** 1. Creating a set */
    static void creating() {
        Set<String> empty = new HashSet<>();                          // empty
        Set<String> fromList = new HashSet<>(List.of("a", "b", "a")); // {a, b}: duplicates vanish
        Set<String> fixed = Set.of("Mon", "Tue");                     // NOT changeable
    }

    /** 2. add returns true if the value was new, false if it was already there */
    static void adding() {
        Set<String> names = new HashSet<>();
        System.out.println(names.add("Anna")); // true
        System.out.println(names.add("Bob"));  // true
        System.out.println(names.add("Anna")); // false: already there
        System.out.println(names.size());      // 2
    }

    /** 3. contains is fast; remove, size, isEmpty, clear */
    static void checkAndRemove() {
        Set<String> names = new HashSet<>(List.of("Anna", "Bob", "Eve"));
        System.out.println(names.contains("Bob")); // true
        names.remove("Bob");                       // {Anna, Eve}
        System.out.println(names.size());          // 2
    }

    /** 4. Removing duplicates from a list */
    static void removeDuplicates() {
        List<Integer> numbers = List.of(1, 2, 2, 3, 3, 3);
        Set<Integer> unique = new HashSet<>(numbers);               // {1, 2, 3}
        List<Integer> withoutDuplicates = new ArrayList<>(unique);  // back to a list
        System.out.println(withoutDuplicates);
    }

    /** 5. Looping: only for-each (no indexes) */
    static void looping() {
        Set<String> names = new HashSet<>(List.of("Anna", "Bob", "Eve"));
        for (String name : names) {
            System.out.println(name); // any order
        }
    }

    /** 6. Kinds: HashSet (any order), LinkedHashSet (insertion order), TreeSet (sorted) */
    static void kinds() {
        Set<String> linked = new LinkedHashSet<>(List.of("Bob", "Anna", "Eve"));
        Set<String> tree = new TreeSet<>(List.of("Bob", "Anna", "Eve"));
        System.out.println(linked); // [Bob, Anna, Eve]
        System.out.println(tree);   // [Anna, Bob, Eve]
    }
}
