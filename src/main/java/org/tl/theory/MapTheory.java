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
     * A Map stores data in pairs: "key -> value". Let's start with a few examples of such pairs:
     *
     *   "Anna"  -> 3000        employee name -> salary
     *   "apple" -> "яблоко"    word -> translation
     *   "EE"    -> "Estonia"   country code -> country name
     *
     * The key is what you search by: a name, a word, a code. The value is what you want
     * to find for that key: a salary, a translation, a country name. It works like a dictionary:
     * you look up the word "apple" and see its translation right next to it. You don't have
     * to read the whole dictionary from the start, so lookup by key in a Map is fast.
     *
     * Why do you need a Map if there is a List? Say you need to find Anna's salary.
     * In a List you would keep the employees in order and look for Anna with a loop:
     * the first one isn't her, the second one isn't her, and so on to the end. The longer
     * the list, the longer the search. A Map gives you the value right away by its key:
     * salaries.get("Anna"). There can be ten employees or a million, and lookup by key
     * is still fast. The code is shorter too: one line instead of a loop with a check.
     *
     * Two important rules:
     * - Keys never repeat. A Map can't hold a second "Anna" key. If you put a value under a key
     *   that is already there, the old value is replaced with the new one (more in section 2).
     * - Values can repeat. "Anna" and "Bob" can easily have the same salary of 3000.
     *
     * When you create a Map, you write two types in the angle brackets: first the key type,
     * then the value type. Map<String, Integer> means "keys are strings, values are whole numbers".
     * Primitives like int can't go there, you need their wrapper classes: Map<String, Integer>,
     * not Map<String, int> (see PrimitivesAndWrappersTheory).
     *
     * A Map is not a List. It has no indexes 0, 1, 2, and no "first element" either.
     * So map.get(0) won't give you the first pair: the Map looks for the key 0, doesn't find it
     * and returns null.
     *
     * How do you choose between them? Use a Map when the task has something to search by:
     * - Lookup by key: a salary by name, a product by its code, a country by its code.
     * - Counting: how many times each word appears, for example "cat" -> 3.
     * - Grouping: a department -> the list of its employees.
     * - Uniqueness: one login is one user, there won't be a second identical key.
     *
     * Use a List when you don't need a key:
     * - Order and position: you need the first, the second or the last element.
     * - Simple looping: you only go through the values, you don't search among them.
     * - Repeats: identical elements are fine, like in a shopping list.
     *
     * For the curious: technically Map is a separate interface, and it does NOT extend Collection
     * (List and Set do). That is why a Map has no add(x) method, it has put(key, value) instead.
     * You also can't loop over a Map with for-each directly, you use entrySet, keySet
     * or values for that (see section 6).
     *
     * Below is the first example from the list in code: employee names and their salaries.
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
     * To put a pair into a Map, call put(key, value): the key first, then the value.
     * To get a value back, call get(key) with the key. The Map returns whatever is stored
     * under that key.
     *
     * If you call put with a key that is already there, no new pair appears. The Map replaces
     * the old value with the new one, and the size stays the same. There is no error either,
     * so the old value disappears silently.
     *
     * Let's see it in an example: first Anna is 25, then we write 26 for her.
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
     * What happens if you ask for a key that isn't in the Map? There is no error: get simply
     * returns null, which means "nothing".
     *
     * A trap: don't store the result of get straight into an int. The line
     * int age = ages.get("Zed") crashes with NullPointerException. get returned null,
     * and null can't become an int. Store the result in an Integer or use getOrDefault
     * (see PrimitivesAndWrappersTheory).
     *
     * To avoid dealing with null, there is getOrDefault(key, x). It takes two arguments:
     * the key and a fallback value. The rest is simple:
     * - Key is there: the method returns the value from the Map, and the fallback x isn't used.
     * - Key is missing: the method returns x.
     *
     * For example, ages holds only "Anna" -> 26. Then getOrDefault("Anna", 0) returns 26,
     * and getOrDefault("Zed", 0) returns 0.
     *
     * Pick the fallback to fit the task. It is the answer that makes sense when there is no data:
     * 0 for a count or a sum, "" for text, -1 as a "not found" mark. The type of x must match
     * the type of the values. For a Map<String, Integer> 0 works, but the string "none"
     * won't compile.
     *
     * Important: getOrDefault puts nothing into the Map, it only reads. After
     * getOrDefault("Zed", 0) the key "Zed" is still not in the Map, and size() doesn't change.
     * If you need to keep the pair, call put.
     *
     * Most often getOrDefault is used for counting. Say we count how many times each word
     * appears. For each word we take the current count with getOrDefault(word, 0) and put back
     * count + 1. When a word shows up for the first time, it isn't in the Map yet, so the method
     * returns 0. That gives 0 + 1 = 1. Without getOrDefault you would have to check separately
     * whether the word is there, with containsKey or a null check.
     *
     * A detail for the curious: if the key is there but holds null (map.put("Zed", null)),
     * getOrDefault returns null, not x. The fallback is used only when the key is missing
     * completely. In normal tasks nobody puts null into a Map, so this is rare.
     */
    static void missingKey() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Anna", 26);

        // get: no key -> null
        Integer unknown = ages.get("Zed");        // null
        // int crash = ages.get("Zed");           // NullPointerException

        // getOrDefault: key is there -> its value, key is missing -> the fallback
        ages.getOrDefault("Anna", 0);             // 26: the key is there, 0 isn't needed
        ages.getOrDefault("Zed", 0);              // 0: no such key
        ages.size();                              // 1: "Zed" was NOT added to the Map

        // Counting: how many times each word appears
        String[] words = {"cat", "dog", "cat"};
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        // counts: cat -> 2, dog -> 1
    }

    /**
     * 4. Checking a key: containsKey
     *
     * Sometimes you just need to know whether a key is in the Map. That's what containsKey(key)
     * is for: it returns true if the key is there and false if it isn't. It is as fast as get.
     *
     * The similar method containsValue(value) searches the values. It is slow: a Map can only
     * search quickly by key, so here it goes through all the pairs one by one. On a big Map
     * you'll notice that.
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
     * Java has several ready-made kinds of Map. They all have the same methods: put, get,
     * containsKey and the rest. The difference is the order in which they keep the pairs
     * and show them when you print or loop over the Map.
     *
     * The three most common kinds:
     * - HashMap: the order of the pairs is not guaranteed, they can come out in any order.
     *   But it is the fastest one, so use it by default.
     * - LinkedHashMap: remembers the insertion order. The pair you put first comes out first.
     * - TreeMap: sorts the pairs by key. Strings go in alphabetical order, numbers from smallest
     *   to largest.
     *
     * On the left you usually write just Map, and the specific kind goes on the right, after new.
     * That way it's easy to swap HashMap for TreeMap later: you change only one place.
     *
     * There is also a short way to create a Map with data right away: Map.of("Anna", 26, "Bob", 30).
     * But such a Map can't be changed: any put throws UnsupportedOperationException.
     * If you need to add pairs, create a new HashMap<>().
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
     * You can't loop over a Map with for-each directly. Java doesn't know what you want to go
     * through: the keys, the values or the whole pairs. So you choose it first with one of
     * three methods. In all the examples ages = {Anna=26, Bob=30}.
     * - entrySet(): whole pairs. Each pair has getKey() (the key) and getValue() (the value).
     *   > for (Map.Entry<String, Integer> e : ages.entrySet()) {
     *   >     System.out.println(e.getKey() + " -> " + e.getValue());
     *   > }
     *   > // Anna -> 26
     *   > // Bob -> 30
     * - keySet(): only the keys. You can still get the value for a key with get if you need it.
     *   > for (String name : ages.keySet()) {
     *   >     System.out.println(name);
     *   > }
     *   > // Anna
     *   > // Bob
     * - values(): only the values, without keys. Handy, for example, to count a sum.
     *   > int sum = 0;
     *   > for (int age : ages.values()) {
     *   >     sum += age;
     *   > }
     *   > // sum = 56
     *
     * If you need both the key and the value in the loop, use entrySet. The type of each pair
     * is written as Map.Entry<String, Integer>, which means "a Map entry with a String key
     * and an Integer value". It looks long, but you get used to it quickly.
     *
     * The example uses a LinkedHashMap so that the pairs come out in insertion order.
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
     * How does a Map know that a key is "the same"? It compares keys with equals()
     * and hashCode(). First hashCode() quickly tells the Map where to look for the key.
     * Then equals() checks whether it really matches.
     *
     * String, Integer and other standard classes already have these methods done right.
     * That's why strings and numbers are the easiest keys. Just keep in mind that String
     * is case-sensitive: "Anna" and "anna" are two different keys.
     *
     * Your own classes are trickier. If a class has no equals() and hashCode(), Java treats
     * only the very same object as equal. Then two objects with the same data become
     * two different keys. The easiest way to make a key is a record: it creates equals()
     * and hashCode() for you.
     *
     * One more trap: don't change an object while it sits in a Map as a key. Its hashCode()
     * changes, and the Map looks for the key in the wrong place. The pair stays inside,
     * but get can't find it anymore.
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
