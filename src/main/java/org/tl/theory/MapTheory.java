package org.tl.theory;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * THEORY: Map
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Basics
 *   1. What a Map is
 *   2. Put and get
 *   3. Missing key: null and getOrDefault
 *   4. Checking a key: containsKey
 *
 * Kinds of Map
 *   5. HashMap, LinkedHashMap, TreeMap
 *
 * Looping
 *   6. Iterating: entrySet, keySet, values
 *
 * Traps
 *   7. Keys must be unique and comparable by equals/hashCode
 *
 * Practice: see org.tl.collections.map (MapCheatSheet, MapTasks, MapSolutions).
 */
public class MapTheory {

    /**
     * 1. What a Map is
     *
     * A Map stores key -> value pairs, like a dictionary. You find a value by its key.
     * Keys are unique. Values can repeat. Lookup by key is fast.
     *
     * Generics: Map<KeyType, ValueType>. Primitives need wrappers: Map<String, Integer>,
     * not Map<String, int> (see PrimitivesAndWrappersTheory).
     *
     * Map is not a List: there are no indexes and you can't write map.get(0).
     *
     * Technically Map is a separate interface: it does NOT extend Collection (List and Set do).
     * That is why a Map has no add(x) (there is put(key, value)) and you can't loop over it
     * directly (see section 6).
     *
     * A typical example: an employee name and the salary of this employee.
     */
    static void whatIsMap() {
        // Employee name -> salary:
        //   "Anna" -> 3000
        //   "Bob"  -> 2500
        Map<String, Integer> salaries = new HashMap<>();
        salaries.put("Anna", 3000);
        salaries.put("Bob", 2500);
    }

    /**
     * 2. Put and get
     *
     * put(key, value) adds a pair. If the key already exists, its value is OVERWRITTEN.
     * get(key) returns the value.
     */
    static void putAndGet() {
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Anna", 25);   // {Anna=25}
        ages.put("Bob", 30);    // {Anna=25, Bob=30}
        ages.put("Anna", 26);   // same key -> {Anna=26, Bob=30}

        ages.get("Anna");       // 26
        ages.size();            // 2: still two keys
    }

    /**
     * 3. Missing key: null and getOrDefault
     *
     * get returns null when the key is not found. getOrDefault(key, x) returns x instead.
     *
     * A trap: unboxing null. int age = ages.get("Zed") throws NullPointerException,
     * because null cannot become an int (see PrimitivesAndWrappersTheory).
     */
    static void missingKey() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Anna", 26);

        Integer unknown = ages.get("Zed");        // null
        int safe = ages.getOrDefault("Zed", 0);   // 0
        // int crash = ages.get("Zed");           // NullPointerException
    }

    /**
     * 4. Checking a key: containsKey
     *
     * containsKey(key) is true if the key is in the map. containsValue(value) checks values
     * (it is slow: it looks through all of them).
     */
    static void contains() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Anna", 26);

        ages.containsKey("Anna");   // true
        ages.containsKey("Zed");    // false
        ages.containsValue(26);     // true
    }

    /**
     * 5. HashMap, LinkedHashMap, TreeMap
     *
     * All three are used the same way. The difference is the order of the pairs.
     *
     *   HashMap         - no guaranteed order. The default choice, the fastest.
     *   LinkedHashMap   - keeps the insertion order.
     *   TreeMap         - keeps the keys sorted (A to Z, smallest to largest).
     *
     * Map.of(...) creates an immutable map (put throws UnsupportedOperationException).
     */
    static void kinds() {
        Map<String, Integer> hash = new HashMap<>();
        Map<String, Integer> linked = new LinkedHashMap<>();
        Map<String, Integer> tree = new TreeMap<>();

        // After put("Bob", 1), put("Anna", 2), put("Eve", 3):
        //   HashMap:       any order
        //   LinkedHashMap: {Bob=1, Anna=2, Eve=3}
        //   TreeMap:       {Anna=2, Bob=1, Eve=3}
    }

    /**
     * 6. Iterating: entrySet, keySet, values
     *
     * A Map can't be looped over directly. Choose what you need:
     *   entrySet() - key and value together (pairs)
     *   keySet()   - only keys
     *   values()   - only values
     */
    static void iterating() {
        Map<String, Integer> ages = new LinkedHashMap<>();
        ages.put("Anna", 26);
        ages.put("Bob", 30);

        // Pairs: Anna=26, Bob=30
        for (Map.Entry<String, Integer> e : ages.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }

        // Keys: Anna, Bob
        for (String name : ages.keySet()) {
            System.out.println(name);
        }

        // Values: 26, 30
        for (int age : ages.values()) {
            System.out.println(age);
        }
    }

    /**
     * 7. Keys must be unique and comparable by equals/hashCode
     *
     * A Map finds a key using equals() and hashCode(). String and Integer have them
     * done right, so use them as keys. For your own classes you must write both methods,
     * otherwise two "equal" objects become two different keys.
     *
     * Do not change an object after using it as a key: its hashCode changes and
     * the map will not find it anymore.
     */
    static void keysTrap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("Anna", 1);
        map.put("anna", 2);  // different key: String is case-sensitive -> 2 entries
        map.size();          // 2

        // your own key type: a record gives equals and hashCode for free
        record CustomerId(String email) {}
        Map<CustomerId, Integer> bonus = new HashMap<>();
        bonus.put(new CustomerId("ann@mail.ee"), 10);
        bonus.put(new CustomerId("ann@mail.ee"), 20); // the same key by equals() -> value replaced
        bonus.size();        // 1 (with a plain class without equals it would be 2)
    }
}
