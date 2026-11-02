package org.tl.streams;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * SOLUTIONS for StreamTasks.
 */
public class StreamSolutions {

    static List<Integer> task1(List<Integer> totals) {
        return totals.stream().filter(t -> t > 100).toList();
    }

    static List<Integer> task2(List<Integer> prices) {
        return prices.stream().map(p -> p * 100).toList();
    }

    static List<String> task3(List<String> names) {
        return names.stream().map(String::toUpperCase).toList();
    }

    static long task4(List<Integer> priorities) {
        return priorities.stream().filter(p -> p == 1).count();
    }

    static int task5(List<Integer> totals) {
        return totals.stream().mapToInt(Integer::intValue).sum();
    }

    static double task6(List<Integer> ratings) {
        return ratings.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    static int task7(List<Integer> totals) {
        return totals.stream().max(Integer::compare).orElse(-1);
    }

    static List<Integer> task8(List<Integer> totals) {
        return totals.stream().sorted(Comparator.reverseOrder()).limit(3).toList();
    }

    static List<String> task9(List<String> countries) {
        return countries.stream().distinct().toList();
    }

    static boolean task10(List<Integer> movements) {
        return movements.stream().anyMatch(m -> m < 0);
    }

    static boolean task11(List<Integer> amounts) {
        return amounts.stream().allMatch(a -> a > 0);
    }

    static String task12(List<String> titles) {
        return titles.stream().filter(t -> t.length() > 10).findFirst().orElse("none");
    }

    static String task13(List<String> names) {
        return names.stream().collect(Collectors.joining(", "));
    }

    static Map<String, Long> task14(List<String> countries) {
        return countries.stream().collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }
}
