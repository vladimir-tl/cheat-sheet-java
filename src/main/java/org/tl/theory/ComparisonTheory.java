package org.tl.theory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * THEORY: Comparison
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Collections
 *   1. Comparing two lists
 *   3. Comparing two maps
 */
public class ComparisonTheory {

    /**
     * 1. Comparing two lists
     *
     * Two lists are equal if they hold the same elements in the same order.
     *
     * == checks whether it is the same object, equals compares the contents.
     * If the order of the elements changes, equals returns false.
     */
    static void compareLists() {
        List<String> first = new ArrayList<>();
        first.add("Anna");
        first.add("Max");

        List<String> second = new ArrayList<>();
        second.add("Anna");
        second.add("Max");

        System.out.println(first == second);      // false: different objects
        System.out.println(first.equals(second)); // true: same contents

        // If the order changes:
        List<String> third = new ArrayList<>();
        third.add("Max");
        third.add("Anna");

        System.out.println(first.equals(third));  // false
    }

    /**
     * 3. Comparing two maps
     *
     * Two maps are equal if they hold the same key → value pairs. The order of adding does not matter.
     */
    static void compareMaps() {
        Map<String, Integer> first = new HashMap<>();
        first.put("Anna", 25);
        first.put("Max", 30);

        Map<String, Integer> second = new HashMap<>();
        second.put("Max", 30);
        second.put("Anna", 25);

        System.out.println(first == second);      // false: different objects
        System.out.println(first.equals(second)); // true: same pairs
    }
}
