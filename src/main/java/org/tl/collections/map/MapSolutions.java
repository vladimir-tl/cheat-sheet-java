package org.tl.collections.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SOLUTIONS for MapTasks.
 */
public class MapSolutions {

    static Map<String, Integer> createCustomers() {
        Map<String, Integer> ages = new HashMap<>();
        ages.put("Anna", 25);
        ages.put("Bob", 30);
        ages.put("Eve", 22);
        return ages;
    }

    static int findAgeByName(Map<String, Integer> customers, String name) {
        return customers.getOrDefault(name, -1);
    }

    static boolean hasCustomer(Map<String, Integer> customers, String name) {
        return customers.containsKey(name);
    }

    static void printCustomers(Map<String, Integer> customers) {
        for (Map.Entry<String, Integer> e : customers.entrySet()) {
            System.out.println(e.getKey() + "=" + e.getValue());
        }
    }

    static int orderTotal(Map<String, Integer> prices) {
        int sum = 0;
        for (int value : prices.values()) {
            sum += value;
        }
        return sum;
    }

    static Map<String, Integer> countGenres(List<String> genres) {
        Map<String, Integer> counts = new HashMap<>();
        for (String genre : genres) {
            counts.put(genre, counts.getOrDefault(genre, 0) + 1);
        }
        return counts;
    }
}
