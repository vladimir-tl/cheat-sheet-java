package org.tl.collections.map;

import java.util.HashMap;
import java.util.Map;

/**
 * SOLUTIONS for MapTasks.
 */
public class MapSolutions {

    static Map<String, Integer> task1() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Anna", 25);
        ages.put("Bob", 30);
        ages.put("Eve", 22);
        return ages;
    }

    static int task2(Map<String, Integer> map, String key) {
        return map.getOrDefault(key, -1);
    }

    static boolean task3(Map<String, Integer> map, String key) {
        return map.containsKey(key);
    }

    static void task4(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> e : map.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }

    static int task5(Map<String, Integer> map) {
        int sum = 0;
        for (int value : map.values()) {
            sum += value;
        }
        return sum;
    }

    static Map<Character, Integer> task6(String s) {
        Map<Character, Integer> counts = new HashMap<>();
        for (char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
        }
        return counts;
    }
}
