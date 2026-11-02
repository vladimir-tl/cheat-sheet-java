package org.tl.collections.map;

import java.util.HashMap;
import java.util.Map;

/**
 * CHEAT SHEET: Map
 *
 * THEORY
 * A Map stores key -> value pairs, like a dictionary. Keys are unique; putting an
 * existing key overwrites its value. Values can repeat. Lookup by key is fast.
 *
 *   - HashMap: the default choice; no guaranteed order.
 *   - LinkedHashMap: keeps insertion order.
 *   - TreeMap: keeps keys sorted.
 *   - Map.of(...): creates an immutable map.
 *   - Map is not part of the Collection hierarchy, so you can't iterate it directly:
 *     use entrySet() (pairs), keySet() (keys) or values().
 *   - Generics: Map<KeyType, ValueType>; primitives need wrappers (Map<String, Integer>).
 *   - Keys should be immutable and have proper equals()/hashCode() (String and Integer do).
 */
public class MapCheatSheet {

    public static void main(String[] args) {
        putAndGet();
        iterateEntries();
    }

    /** 1. Create, put and get */
    static void putAndGet() {
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Anna", 25);   // add
        ages.put("Bob", 30);
        ages.put("Anna", 26);   // same key -> value is overwritten

        int anna = ages.get("Anna");          // 26
        Integer unknown = ages.get("Zed");    // null: key not found
        int safe = ages.getOrDefault("Zed", 0); // 0: default instead of null

        System.out.println(anna + " " + unknown + " " + safe);
    }

    /** 2. Iterate over key-value pairs */
    static void iterateEntries() {
        Map<String, Integer> map = Map.of("x", 1, "y", 2);
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }
}
