package org.tl.theory;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * THEORY: Stream API
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Basics
 *   1. What a stream is
 *   2. Creating a stream
 *   3. Lambda: a tiny function
 *
 * Intermediate operations: the stations of the conveyor
 *   4. filter: keep only the matching elements
 *   5. map: transform every element
 *   6. sorted, distinct, limit, skip
 *
 * Terminal operations: the end of the conveyor
 *   7. toList and collect: get a collection back
 *   8. count, sum, average, min, max
 *   9. anyMatch, allMatch, noneMatch, findFirst
 *   10. forEach
 *
 * Grouping
 *   11. groupingBy and counting
 *
 * Traps
 *   12. One use only, no terminal operation, effectively final
 *
 * Practice: see org.tl.streams (StreamCheatSheet, StreamTasks, StreamSolutions).
 */
public class StreamTheory {

    /**
     * 1. What a stream is
     *
     * A stream is a way to process a collection step by step, like a conveyor belt:
     *
     *   source  ->  station  ->  station  ->  ...  ->  result
     *   (list)      filter       map                    (list, number, text...)
     *
     * - The source is a List, Set, array and so on.
     * - Stations (intermediate operations) take elements, filter or change them and pass them on.
     * - The last step (terminal operation) collects the result. Only then the conveyor starts.
     *
     * A stream does NOT change the source list. It gives you a new result.
     * It replaces many for-loops with short, readable code: "from the invoices take the big ones,
     * add up their totals".
     */
    static void whatIsStream() {
        List<Integer> totals = List.of(5, 12, 8, 20, 3);

        // "From the invoice totals take those above 7 and make a list"
        List<Integer> big = totals.stream()    // source
                .filter(t -> t > 7)            // station: keep big ones
                .toList();                     // end: a list [12, 8, 20]

        // The same with a loop (longer):
        // List<Integer> big = new ArrayList<>();
        // for (int t : totals) { if (t > 7) big.add(t); }
    }

    /**
     * 2. Creating a stream
     *
     *   - from a List or Set: list.stream()
     *   - from an array: Arrays.stream(array)
     *   - from values: Stream.of("a", "b", "c")
     *   - a range of numbers: IntStream.range(1, 6) gives 1, 2, 3, 4, 5 (the end is NOT included);
     *     IntStream.rangeClosed(1, 5) gives 1..5 (the end is included)
     *
     * A Map has no stream(): use map.entrySet().stream() or map.values().stream().
     */
    static void creating() {
        List<String> names = List.of("Anna", "Bob", "Eve");
        int[] numbers = {10, 20, 30};

        Stream<String> fromList = names.stream();
        IntStream fromArray = java.util.Arrays.stream(numbers);
        Stream<String> fromValues = Stream.of("a", "b", "c");
        IntStream range = IntStream.range(1, 6);                // 1, 2, 3, 4, 5
    }

    /**
     * 3. Lambda: a tiny function
     *
     * Streams are fed with small functions written as a lambda: parameters -> result.
     *
     *   x -> x * 2            one parameter, returns x * 2
     *   (a, b) -> a + b       two parameters need brackets
     *   x -> { ...; return y; }  a block when one expression is not enough
     *
     * Read the arrow as "goes to": t -> t > 7 is "t goes to (t is greater than 7)".
     * The name of the parameter is up to you.
     *
     * Method reference is a shorter lambda that only calls one method:
     *   String::toUpperCase    is the same as   s -> s.toUpperCase()
     *   String::length         is the same as   s -> s.length()
     *   System.out::println    is the same as   x -> System.out.println(x)
     */
    static void lambdas() {
        List<String> names = List.of("Anna", "Bob", "Eve");

        names.stream().map(s -> s.toUpperCase());      // lambda
        names.stream().map(String::toUpperCase);       // method reference: the same
    }

    /**
     * 4. filter: keep only the matching elements
     *
     * filter takes a condition (a lambda that returns true or false) and lets through only
     * the elements for which it is true. The rest are thrown away.
     */
    static void filtering() {
        List<Integer> totals = List.of(5, 12, 8, 20, 3);
        List<String> names = List.of("Anna", "Bob", "Alex", "Eve");

        List<Integer> big = totals.stream().filter(t -> t > 7).toList();        // [12, 8, 20]
        List<String> onA = names.stream().filter(n -> n.startsWith("A")).toList(); // [Anna, Alex]
    }

    /**
     * 5. map: transform every element
     *
     * map takes a function and applies it to every element. The number of elements stays the same,
     * but the elements (and even their type) can change.
     */
    static void mapping() {
        List<String> names = List.of("Anna", "Bob", "Eve");
        List<Integer> prices = List.of(5, 12, 8);

        List<String> upper = names.stream().map(String::toUpperCase).toList();  // [ANNA, BOB, EVE]
        List<Integer> lengths = names.stream().map(String::length).toList();    // [4, 3, 3]: String -> Integer
        List<Integer> cents = prices.stream().map(p -> p * 100).toList();       // [500, 1200, 800]

        // Stations can be chained: filter first, then map
        List<String> result = names.stream()
                .filter(n -> n.length() > 3)
                .map(String::toUpperCase)
                .toList();                                                      // [ANNA]
    }

    /**
     * 6. sorted, distinct, limit, skip
     *
     *   sorted()                         - ascending order (numbers, strings)
     *   sorted(Comparator.reverseOrder()) - descending order
     *   distinct()                       - drop duplicates
     *   limit(n)                         - take only the first n elements
     *   skip(n)                          - skip the first n elements
     */
    static void sortLimit() {
        List<Integer> totals = List.of(5, 12, 8, 12, 3);

        totals.stream().sorted().toList();                                   // [3, 5, 8, 12, 12]
        totals.stream().sorted(Comparator.reverseOrder()).toList();          // [12, 12, 8, 5, 3]
        totals.stream().distinct().toList();                                 // [5, 12, 8, 3]
        totals.stream().limit(2).toList();                                   // [5, 12]
        totals.stream().skip(3).toList();                                    // [12, 3]

        // "The top 3 biggest totals":
        totals.stream().sorted(Comparator.reverseOrder()).limit(3).toList(); // [12, 12, 8]
    }

    /**
     * 7. toList and collect: get a collection back
     *
     * toList() ends the stream and gives a List. The result can NOT be changed (add throws
     * UnsupportedOperationException). If you need a changeable list, wrap it: new ArrayList<>(...).
     *
     * collect(...) is the general way, with ready collectors from the Collectors class:
     *   Collectors.toList()         - a changeable List
     *   Collectors.toSet()          - a Set (duplicates vanish)
     *   Collectors.joining(", ")    - one String with all elements, with a separator
     *
     * (toList() needs Java 16 or newer.)
     */
    static void collecting() {
        List<String> names = List.of("Anna", "Bob", "Eve");

        List<String> list = names.stream().toList();                          // [Anna, Bob, Eve]
        java.util.Set<String> set = names.stream().collect(Collectors.toSet());
        String text = names.stream().collect(Collectors.joining(", "));       // "Anna, Bob, Eve"
    }

    /**
     * 8. count, sum, average, min, max
     *
     * These operations end the stream and give a single value.
     *   count()                 - how many elements (the result is a long)
     *   mapToInt(...).sum()     - the sum of numbers
     *   mapToInt(...).average() - the average (an OptionalDouble: the list may be empty)
     *   max(...) / min(...)     - the biggest / the smallest (an Optional: the list may be empty)
     *
     * mapToInt(Integer::intValue) turns a Stream<Integer> into an IntStream, which has sum() and average().
     */
    static void numbers() {
        List<Integer> totals = List.of(5, 12, 8, 20, 3);

        long howMany = totals.stream().filter(t -> t > 7).count();                  // 3
        int sum = totals.stream().mapToInt(Integer::intValue).sum();                // 48
        double average = totals.stream().mapToInt(Integer::intValue)
                .average().orElse(0);                                               // 9.6
        int max = totals.stream().max(Integer::compare).orElse(-1);                 // 20
        int min = totals.stream().min(Integer::compare).orElse(-1);                 // 3

        // orElse(x) is the value for an empty list: without it you get an Optional box.
    }

    /**
     * 9. anyMatch, allMatch, noneMatch, findFirst
     *
     * Questions about the elements:
     *   anyMatch(cond)   - is there AT LEAST ONE element that matches? (true/false)
     *   allMatch(cond)   - do ALL elements match? (true for an empty list)
     *   noneMatch(cond)  - does NO element match?
     *   findFirst()      - the first element, as an Optional (the stream may be empty).
     *                      Take the value with orElse(default) or get().
     */
    static void questions() {
        List<Integer> totals = List.of(5, 12, 8, 20, 3);

        boolean hasBig = totals.stream().anyMatch(t -> t > 15);                      // true
        boolean allPositive = totals.stream().allMatch(t -> t > 0);                  // true
        boolean noHuge = totals.stream().noneMatch(t -> t > 100);                    // true

        Optional<Integer> first = totals.stream().filter(t -> t > 10).findFirst();   // Optional[12]
        int firstOrDefault = totals.stream().filter(t -> t > 100).findFirst().orElse(-1); // -1
    }

    /**
     * 10. forEach
     *
     * forEach does something with every element (print it, save it). It returns nothing.
     * Use it for actions, not for collecting results: for results use toList() or collect.
     */
    static void each() {
        List<String> names = List.of("Anna", "Bob", "Eve");

        names.stream().forEach(System.out::println);       // Anna, Bob, Eve
        names.forEach(System.out::println);                // a List has forEach too: the same
    }

    /**
     * 11. groupingBy and counting
     *
     * collect(Collectors.groupingBy(...)) splits elements into groups and returns a Map:
     * the key is the group, the value is a list of its elements.
     * With counting() the value is just the number of elements in the group.
     */
    static void grouping() {
        List<String> countries = List.of("Brazil", "USA", "Brazil", "Canada", "USA", "Brazil");

        // How many customers from each country?
        Map<String, Long> count = countries.stream()
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        // {Brazil=3, USA=2, Canada=1}  (the order of a HashMap is not guaranteed)

        // Group the words by their length:
        List<String> words = List.of("hi", "yo", "hello", "world", "a");
        Map<Integer, List<String>> byLength = words.stream()
                .collect(Collectors.groupingBy(String::length));
        // {1=[a], 2=[hi, yo], 5=[hello, world]}
    }

    /**
     * 12. One use only, no terminal operation, effectively final
     *
     * Three classic traps.
     *
     * 1) A stream can be used ONCE. A second use throws IllegalStateException
     *    ("stream has already been operated upon or closed"). Make a new stream from the list.
     * 2) Without a terminal operation nothing happens. filter and map only describe the
     *    conveyor; it starts when you call toList, count, forEach and so on.
     * 3) A lambda can only read local variables that never change (effectively final).
     *    You can't count with an outside counter++ inside a lambda. Use count() or sum() instead.
     */
    static void traps() {
        List<Integer> totals = List.of(5, 12, 8);

        Stream<Integer> stream = totals.stream();
        stream.count();
        // stream.count();                      // IllegalStateException

        totals.stream().filter(t -> t > 7);     // does nothing: no terminal operation

        // int counter = 0;
        // totals.forEach(t -> counter++);      // does not compile: counter is not effectively final
        long counter = totals.stream().filter(t -> t > 7).count();   // the right way
    }
}
