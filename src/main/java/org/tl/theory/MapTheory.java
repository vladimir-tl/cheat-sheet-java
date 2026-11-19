package org.tl.theory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
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
 *   4. Checking a key and a value: containsKey and containsValue
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
     * What a Map can do, in short. The details for each method are in the sections below.
     * - put(key, value): put a pair. If the key is already there, replaces the value (section 2).
     * - get(key): get the value by key. If the key is missing, returns null (sections 2 and 3).
     * - getOrDefault(key, x): the value by key, or the fallback x if the key is missing (section 3).
     * - containsKey(key): whether there is such a key, true or false (section 4).
     * - containsValue(value): whether there is such a value. It is slow (section 4).
     * - remove(key): remove the pair by key. Returns the removed value, or null if there was no key.
     * - size(): how many pairs are in the Map. isEmpty() tells whether it is empty.
     * - keySet(), values(), entrySet(): all the keys, all the values and all the pairs, for example
     *   for a loop (section 6).
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
     * 4. Checking a key and a value: containsKey and containsValue
     *
     * Sometimes you just need to know whether a key is in the Map. That's what containsKey(key)
     * is for: it returns true if the key is there and false if it isn't. It is as fast as get.
     *
     * The similar method containsValue(value) searches the values: is anyone 26 years old?
     * The answer is the same, true or false. But it works much slower. Let's see why.
     *
     * Picture a cloakroom in a theatre. You hand in your coat and get ticket number 42. The ticket
     * is the key, the coat is the value. When you bring the ticket back, the attendant goes
     * straight to hook 42, there's nothing to search for. That's how get and containsKey work.
     *
     * Now you ask: "Do you have a blue coat here?" There's no ticket, so the attendant has to walk
     * past every hook and look at every coat. That's how containsValue works.
     *
     * A Map works the same way. From the key, a HashMap calculates right away where the pair is
     * stored: that's what the key's hashCode is for (more in section 7). Values have no such
     * "address". So containsValue takes the first pair and compares its value, then the second,
     * the third and so on, until it finds a match or runs out of pairs.
     *
     * How much you notice it depends on the size of the Map:
     * - 10 pairs: containsValue makes at most 10 comparisons. You won't feel the difference.
     * - A million pairs: containsKey still looks in one or two places, while containsValue may make
     *   a million comparisons.
     * - containsValue in a loop: a thousand checks on a Map with a million pairs is up to
     *   a billion comparisons. That's where the program will slow down noticeably.
     *
     * So a rare check on a small Map is a perfectly normal job for containsValue, no need
     * to be afraid of it.
     *
     * And if you need to search by value often, make the value a key in a second Map.
     * For example, you often look up a customer by phone number. Create a Map<String, String>
     * phoneToName: phone -> name. Then a lookup by phone becomes fast too, with containsKey
     * or get. The price: you have to update both Maps together. Added a customer to one,
     * add them to the other as well.
     */
    static void contains() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Anna", 26);

        ages.containsKey("Anna");   // true
        ages.containsKey("Zed");    // false
        ages.containsValue(26);     // true

        // Searching by value often? Make it a key in a second Map
        Map<String, String> phoneToName = new HashMap<>();
        phoneToName.put("+372 5555 1234", "Anna");
        phoneToName.get("+372 5555 1234");           // "Anna"
    }

    /**
     * 5. HashMap, LinkedHashMap, TreeMap
     *
     * Java has several ready-made kinds of Map. They all have the same methods: put, get,
     * containsKey and the rest. The difference is the order in which they keep the pairs
     * and show them when you print or loop over the Map.
     *
     * To see the difference, let's put the same pairs into each Map in the same order:
     * put("Bob", 1), then put("Anna", 2), then put("Eve", 3). And print the result.
     * - HashMap: the order of the pairs is not guaranteed. It depends on how HashMap arranges
     *   the keys inside, and it can change when you add new pairs. So don't write code that
     *   relies on this order. On the other hand, HashMap is the fastest, and in most tasks
     *   the order doesn't matter. Use it by default.
     *   > System.out.println(hash);     // {Bob=1, Eve=3, Anna=2}, but the order may be different
     * - LinkedHashMap: remembers the insertion order. The pair you put first comes out first.
     *   If you put a new value under a key that is already there, the pair stays in its place.
     *   Use it when the order matters: items in a shopping cart, steps in an action history.
     *   > System.out.println(linked);   // {Bob=1, Anna=2, Eve=3}
     * - TreeMap: sorts the pairs by key. Strings go in alphabetical order, numbers from smallest
     *   to largest. Use it when you need a sorted result: a dictionary in alphabetical order,
     *   a schedule by hour. It is a bit slower than HashMap. Keep in mind that strings are
     *   compared case-sensitively: capital letters go before lowercase ones, so "Bob" ends up
     *   before "anna".
     *   > System.out.println(tree);     // {Anna=2, Bob=1, Eve=3}
     *
     * If in doubt, use HashMap. The other two are needed only when the order matters.
     *
     * On the left you usually write just Map, and the specific kind goes on the right, after new:
     * Map<String, Integer> ages = new TreeMap<>(). That way it's easy to swap TreeMap for HashMap
     * later: you change only one place, and the rest of the code stays the same.
     *
     * There is also a short way to create a Map with data right away:
     * Map.of("EE", "Estonia", "LV", "Latvia"). The arguments go in pairs: key, value, key, value.
     * Such a Map has three limits:
     * - Can't be changed: put throws UnsupportedOperationException.
     * - Keys don't repeat: Map.of("Anna", 1, "Anna", 2) throws IllegalArgumentException.
     * - No guaranteed order, just like HashMap.
     *
     * Map.of is handy for data that doesn't change, for example country codes. If you need to add
     * pairs, make a changeable copy: new HashMap<>(Map.of(...)).
     */
    static void kinds() {
        Map<String, Integer> hash = new HashMap<>();
        Map<String, Integer> linked = new HashMap<>();
        Map<String, Integer> tree = new TreeMap<>();

        // The same pairs in the same order: Bob, Anna, Eve
        hash.put("Bob", 1);
        hash.put("Anna", 2);
        hash.put("Eve", 3);
        linked.put("Bob", 1);
        linked.put("Anna", 2);
        linked.put("Eve", 3);
        tree.put("Bob", 1);
        tree.put("Anna", 2);
        tree.put("Eve", 3);

        System.out.println(hash);     // {Bob=1, Eve=3, Anna=2}: no guaranteed order
        System.out.println(linked);   // {Bob=1, Anna=2, Eve=3}: insertion order
        System.out.println(tree);     // {Anna=2, Bob=1, Eve=3}: alphabetical order

        // TreeMap with number keys: from smallest to largest
        Map<Integer, String> schedule = new TreeMap<>();
        schedule.put(18, "Dinner");
        schedule.put(8, "Breakfast");
        schedule.put(13, "Lunch");
        System.out.println(schedule); // {8=Breakfast, 13=Lunch, 18=Dinner}

        // Map.of: data right away, but can't be changed
        Map<String, String> countries = Map.of("EE", "Estonia", "LV", "Latvia");
        // countries.put("LT", "Lithuania");    // UnsupportedOperationException

        Map<String, String> editable = new HashMap<>(countries);  // a changeable copy
        editable.put("LT", "Lithuania");                          // this works
    }

    /**
     * 6. Iterating: entrySet, keySet, values
     *
     * You can't loop over a Map with for-each directly. Java doesn't know what you want to go
     * through: the keys, the values or the whole pairs. So you choose it first with one of
     * three methods. In all the examples ages is a plain HashMap:
     * first put("Anna", 26), then put("Bob", 30).
     * - entrySet(): whole pairs. Each pair has getKey() (the key) and getValue() (the value).
     *   > for (Map.Entry<String, Integer> e : ages.entrySet()) {
     *   >     System.out.println(e.getKey() + " -> " + e.getValue());
     *   > }
     *   > // Bob -> 30
     *   > // Anna -> 26
     * - keySet(): only the keys. You can still get the value for a key with get if you need it.
     *   > for (String name : ages.keySet()) {
     *   >     System.out.println(name);
     *   > }
     *   > // Bob
     *   > // Anna
     * - values(): only the values, without keys. Handy, for example, to count a sum.
     *   > int sum = 0;
     *   > for (int age : ages.values()) {
     *   >     sum += age;
     *   > }
     *   > // sum = 56
     *
     * Let's look at the keySet loop more closely. Read it like this: "for every name from the set
     * of names, run the code in the curly braces". The loop takes the next name by itself and puts
     * it into the variable name. The type String to the left of the colon is the key type of our Map.
     *
     * If you also need the age for every name, get it with get:
     * - get(name) inside the loop: returns the value for the current key. Here get never returns
     *   null: we go through keys that are in the Map. So you can safely store the result in an int.
     *   > for (String name : ages.keySet()) {
     *   >     int age = ages.get(name);
     *   >     System.out.println(name + " -> " + age);
     *   > }
     *   > // Bob -> 30
     *   > // Anna -> 26
     *
     * This works, but for every name the Map looks up the value again. entrySet is handier:
     * it gives you the key and the value at once.
     *
     * You can call keySet() and values() without a loop too. They return collections that you can
     * print, store in a variable or pass on:
     * - keySet(): returns a `Set<String>`, the set of keys. It is a Set (see SetTheory) because
     *   keys in a Map don't repeat.
     *   > System.out.println(ages.keySet());           // [Bob, Anna]
     *   > Set<String> names = ages.keySet();
     *   > System.out.println(names.size());            // 2
     *   > System.out.println(names.contains("Bob"));   // true
     * - values(): returns a `Collection<Integer>`, all the values. This one is not a Set: if Anna
     *   and Bob happen to be the same age, that age shows up here twice.
     *   > System.out.println(ages.values());           // [30, 26]
     *
     * Notice the brackets: the Map itself prints in curly braces, {Bob=30, Anna=26},
     * while keySet and values print in square brackets, like a regular list.
     *
     * Two things to keep in mind:
     * - A copy: if you need a separate list of keys, make a copy with new ArrayList<>(...).
     *   You can do anything with the copy, and the Map won't change.
     *   > List<String> nameList = new ArrayList<>(ages.keySet());   // [Bob, Anna]
     *   > nameList.remove("Bob");                                    // ages hasn't changed
     * - A trap: keySet() is not a copy but a "window" into the same Map. Remove a key from names,
     *   and the pair disappears from ages too.
     *   > names.remove("Bob");
     *   > System.out.println(ages);                    // {Anna=26}
     *
     * Now a closer look at values(). It gives you only the values, and the keys stay hidden.
     * So values() is the right choice when it doesn't matter whose value it is: to count a sum,
     * find the maximum, or check whether a value appears at all.
     *
     * In the loop, the variable type is the value type of the Map. Our values are Integer, so you
     * can write int age or Integer age: Java turns an Integer into an int by itself.
     *
     * What you can do with values():
     * - Sum and average: loop over the values and add them up.
     *   > int sum = 0;
     *   > for (int age : ages.values()) {
     *   >     sum += age;
     *   > }
     *   > System.out.println(sum);                     // 56
     *   > System.out.println(sum / ages.size());       // 28
     * - Maximum and minimum: Collections.max and Collections.min find them without a loop.
     *   > System.out.println(Collections.max(ages.values()));   // 30
     * - Whether a value is there: contains works just like containsValue from section 4,
     *   and it is just as slow, going through all the values.
     *   > System.out.println(ages.values().contains(30));       // true
     * - Without repeats: values() keeps repeats. If you need only distinct values,
     *   put them into a HashSet (see SetTheory).
     *   > ages.put("Eve", 26);
     *   > System.out.println(ages.values());                    // [30, 26, 26]
     *   > System.out.println(new HashSet<>(ages.values()));     // [26, 30]
     *
     * What values() can't do:
     * - Add a value: ages.values().add(40) throws UnsupportedOperationException.
     *   A Map can't store a value without a key, so add pairs with put.
     * - Tell you the key: from the value 26 you can't tell whose age it is. If you need
     *   the key too, use entrySet.
     *
     * If you need both the key and the value in the loop, use entrySet. Let's see what it gives you.
     *
     * Map.Entry is one pair from a Map: a key and a value together, like one row in a table.
     * A Map is made of such pairs, and entrySet() hands them out one by one.
     *
     * Why is the name written with a dot? Entry is declared inside Map, so its full name
     * is Map.Entry. It's like "flat 5 in house 12": without the house number you can't tell
     * which flat is meant.
     *
     * The angle brackets hold the same types as the Map itself. `Map.Entry<String, Integer>`
     * is a pair with a String key and an Integer value. So for a `Map<String, Integer>` always
     * use `Map.Entry<String, Integer>`. It looks long, but you get used to it quickly.
     *
     * What a pair can do:
     * - getKey() and getValue(): return the key and the value. You already saw them
     *   in the loop above.
     * - setValue(x): replaces the value right inside the Map. Handy when you need to change
     *   all the values at once. For example, every customer just had a birthday:
     *   > for (Map.Entry<String, Integer> e : ages.entrySet()) {
     *   >     e.setValue(e.getValue() + 1);
     *   > }
     *   > System.out.println(ages);   // {Bob=31, Anna=27}
     *
     * You can't change a pair's key: there is no setKey method. If you need a different key,
     * remove the old pair with remove and put a new one with put.
     *
     * You can also create a pair without a Map:
     * - Map.entry(key, value): creates a standalone pair. It can't be changed: setValue throws
     *   UnsupportedOperationException. It comes in handy, for example, for `Map.ofEntries(...)`:
     *   the same as Map.of, but built from ready pairs.
     *   > Map.Entry<String, Integer> pair = Map.entry("Eve", 22);
     *   > System.out.println(pair.getKey() + " " + pair.getValue());   // Eve 22
     *   > System.out.println(pair);                                    // Eve=22
     *
     * If you don't want to write the long type, use var: `for (var e : ages.entrySet())`.
     * Java figures out by itself that e is a `Map.Entry<String, Integer>`. But while you're
     * learning, it's better to write the full type: that way you see right away what the
     * variable holds.
     *
     * Notice the order: Bob came out before Anna, even though he was added second.
     * That's normal for a HashMap, the order of its pairs is not guaranteed (see section 5).
     * If you need insertion order, use a LinkedHashMap, and for sorting, a TreeMap.
     */
    static void iterating() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Anna", 26);
        ages.put("Bob", 30);

        // Pairs: Bob=30, Anna=26 (a HashMap doesn't guarantee the order)
        for (Map.Entry<String, Integer> e : ages.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }

        // Keys: Bob, Anna
        for (String name : ages.keySet()) {
            System.out.println(name);
        }

        // Values: 30, 26
        for (int age : ages.values()) {
            System.out.println(age);
        }

        // Name and age with get: Bob -> 30, Anna -> 26
        for (String name : ages.keySet()) {
            int age = ages.get(name);
            System.out.println(name + " -> " + age);
        }

        // keySet and values can be printed as a whole
        System.out.println(ages.keySet());   // [Bob, Anna]
        System.out.println(ages.values());   // [30, 26]

        // setValue changes the value right inside the Map
        for (Map.Entry<String, Integer> e : ages.entrySet()) {
            e.setValue(e.getValue() + 1);
        }
        System.out.println(ages);   // {Bob=31, Anna=27}

        // A standalone pair without a Map, it can't be changed
        Map.Entry<String, Integer> pair = Map.entry("Eve", 22);
        System.out.println(pair.getKey() + " " + pair.getValue());   // Eve 22
    }

    /**
     * 7. Keys must be unique and comparable by equals/hashCode
     *
     * How does a Map know that a key is "the same"? It compares keys with two methods that every
     * object in Java has:
     * - hashCode(): turns the key into a number. From this number a HashMap knows right away
     *   where to look for the pair. Like the cloakroom ticket from section 4.
     * - equals(): checks whether the key it found really matches yours. Different keys sometimes
     *   get the same number, so this check can't be skipped.
     *
     * If two keys are equal by equals(), for the Map they are one and the same key. The second put
     * doesn't add a new pair, it replaces the value of the old one.
     *
     * String, Integer and other standard classes already have these methods done right: strings
     * are equal if they have the same characters, numbers are equal if their values are equal.
     * That's why strings and numbers are the easiest keys. But strings have their own catches:
     * - Case and spaces: "Anna", "anna" and "Anna " (with a space at the end) are three different
     *   keys. For equals they are different strings.
     *   > map.put("Anna", 1);
     *   > map.put("anna", 2);
     *   > map.put("Anna ", 3);
     *   > System.out.println(map.size());   // 3
     * - How to avoid it: bring the key to one form before you put it into the Map.
     *   trim() removes spaces at the edges, toLowerCase() makes all letters lowercase.
     *   > names.put(" Anna ".trim().toLowerCase(), 1);
     *   > names.put("ANNA".trim().toLowerCase(), 2);
     *   > System.out.println(names);        // {anna=2}
     *
     * Your own classes are trickier. If you haven't written equals() and hashCode() in a class,
     * Java compares objects by the rule "is this the very same object in memory?". Every new
     * creates a new object, so two customers with the same email become two different keys:
     * - A plain class: the second put added a new pair, and get with a new object found nothing.
     *   > class Customer {
     *   >     String email;
     *   >     Customer(String email) { this.email = email; }
     *   > }
     *   > bonus.put(new Customer("ann@mail.ee"), 10);
     *   > bonus.put(new Customer("ann@mail.ee"), 20);
     *   > System.out.println(bonus.size());                            // 2
     *   > System.out.println(bonus.get(new Customer("ann@mail.ee")));  // null
     * - record: the easiest way to make your own key. It creates equals() and hashCode() from
     *   all its fields by itself, so the same data gives the same key.
     *   > record CustomerId(String email) {}
     *   > ids.put(new CustomerId("ann@mail.ee"), 10);
     *   > ids.put(new CustomerId("ann@mail.ee"), 20);
     *   > System.out.println(ids.size());                              // 1
     *   > System.out.println(ids.get(new CustomerId("ann@mail.ee")));  // 20
     *
     * If you write equals() yourself, always write hashCode() too. With equals() alone, a HashMap
     * almost always looks for the key in the wrong place and never even gets to the equals check.
     * Then equal objects become different keys again. In IntelliJ IDEA you can generate both
     * methods at once: the menu "Code → Generate", item "equals() and hashCode()".
     *
     * And the last trap: don't change an object while it sits in a Map as a key. Its hashCode()
     * changes, and the Map looks for the pair in the wrong place. The pair stays inside, but get
     * can't find it anymore. Let's see it with a list as the key: a list is compared by its
     * contents, so its hashCode depends on the elements.
     * - The key changed after put: the pair is there and size() sees it, but get and containsKey don't.
     *   > List<String> key = new ArrayList<>(List.of("rock"));
     *   > playlists.put(key, 1);
     *   > key.add("jazz");                               // changing a key that is already in the Map
     *   > System.out.println(playlists.get(key));        // null
     *   > System.out.println(playlists.containsKey(key)); // false
     *   > System.out.println(playlists.size());          // 1
     *
     * So for keys use things that can't be changed: String, Integer or a record.
     */
    static void keysTrap() {
        // Strings: case and spaces matter
        Map<String, Integer> map = new HashMap<>();
        map.put("Anna", 1);
        map.put("anna", 2);
        map.put("Anna ", 3);
        System.out.println(map.size());   // 3: three different keys

        // Bring the key to one form before put
        Map<String, Integer> names = new HashMap<>();
        names.put(" Anna ".trim().toLowerCase(), 1);
        names.put("ANNA".trim().toLowerCase(), 2);
        System.out.println(names);        // {anna=2}

        // A plain class without equals and hashCode: the same data, but different keys
        class Customer {
            String email;
            Customer(String email) { this.email = email; }
        }
        Map<Customer, Integer> bonus = new HashMap<>();
        bonus.put(new Customer("ann@mail.ee"), 10);
        bonus.put(new Customer("ann@mail.ee"), 20);
        System.out.println(bonus.size());                            // 2
        System.out.println(bonus.get(new Customer("ann@mail.ee")));  // null

        // A record gives equals and hashCode by itself: the same data is one key
        record CustomerId(String email) {}
        Map<CustomerId, Integer> ids = new HashMap<>();
        ids.put(new CustomerId("ann@mail.ee"), 10);
        ids.put(new CustomerId("ann@mail.ee"), 20);
        System.out.println(ids.size());                              // 1
        System.out.println(ids.get(new CustomerId("ann@mail.ee")));  // 20

        // The key changed after put: get can't find it anymore
        Map<List<String>, Integer> playlists = new HashMap<>();
        List<String> key = new ArrayList<>(List.of("rock"));
        playlists.put(key, 1);
        key.add("jazz");
        System.out.println(playlists.get(key));   // null
        System.out.println(playlists.size());     // 1
    }
}
