package org.tl.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * CHEAT SHEET: Stream API
 *
 * Theory: see org.tl.theory.StreamTheory
 */
public class StreamCheatSheet {

    public static void main(String[] args) {
        filter();
        map();
        sortLimit();
        collecting();
        numbers();
        questions();
        grouping();
    }

    static final List<Integer> TOTALS = List.of(5, 12, 8, 20, 3);
    static final List<String> NAMES = List.of("Anna", "Bob", "Alex", "Eve");

    /** 1. filter: keep matching elements */
    static void filter() {
        System.out.println(TOTALS.stream().filter(t -> t > 7).toList());               // [12, 8, 20]
        System.out.println(NAMES.stream().filter(n -> n.startsWith("A")).toList());    // [Anna, Alex]
    }

    /** 2. map: transform every element */
    static void map() {
        System.out.println(NAMES.stream().map(String::toUpperCase).toList());   // [ANNA, BOB, ALEX, EVE]
        System.out.println(NAMES.stream().map(String::length).toList());        // [4, 3, 4, 3]
    }

    /** 3. sorted, distinct, limit, skip */
    static void sortLimit() {
        System.out.println(TOTALS.stream().sorted().toList());                                   // [3, 5, 8, 12, 20]
        System.out.println(TOTALS.stream().sorted(Comparator.reverseOrder()).limit(3).toList()); // top 3: [20, 12, 8]
        System.out.println(List.of(1, 1, 2).stream().distinct().toList());                       // [1, 2]
        System.out.println(TOTALS.stream().skip(3).toList());                                    // [20, 3]
    }

    /** 4. Collecting the result */
    static void collecting() {
        System.out.println(NAMES.stream().toList());
        System.out.println(NAMES.stream().collect(Collectors.toSet()));
        System.out.println(NAMES.stream().collect(Collectors.joining(", "))); // Anna, Bob, Alex, Eve
    }

    /** 5. count, sum, average, min, max */
    static void numbers() {
        System.out.println(TOTALS.stream().filter(t -> t > 7).count());              // 3
        System.out.println(TOTALS.stream().mapToInt(Integer::intValue).sum());       // 48
        System.out.println(TOTALS.stream().mapToInt(Integer::intValue).average().orElse(0)); // 9.6
        System.out.println(TOTALS.stream().max(Integer::compare).orElse(-1));        // 20
        System.out.println(IntStream.rangeClosed(1, 5).sum());                       // 15
    }

    /** 6. anyMatch, allMatch, noneMatch, findFirst */
    static void questions() {
        System.out.println(TOTALS.stream().anyMatch(t -> t > 15));                       // true
        System.out.println(TOTALS.stream().allMatch(t -> t > 0));                        // true
        System.out.println(TOTALS.stream().noneMatch(t -> t > 100));                     // true
        System.out.println(TOTALS.stream().filter(t -> t > 10).findFirst().orElse(-1));  // 12
    }

    /** 7. groupingBy and counting */
    static void grouping() {
        List<String> countries = List.of("Brazil", "USA", "Brazil", "Canada", "USA", "Brazil");
        Map<String, Long> count = countries.stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println(count); // {Brazil=3, USA=2, Canada=1} (any order)
    }
}
