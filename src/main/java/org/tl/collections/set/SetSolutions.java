package org.tl.collections.set;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * SOLUTIONS for SetTasks.
 */
public class SetSolutions {

    static Set<String> task1() {
        return new HashSet<>();
    }

    static Set<String> task2() {
        Set<String> names = new HashSet<>();
        names.add("Anna");
        names.add("Bob");
        names.add("Eve");
        return names;
    }

    static boolean task3(Set<String> set, String name) {
        return set.add(name);
    }

    static boolean task4(Set<String> set, String name) {
        return set.contains(name);
    }

    static int task5(Set<String> set) {
        return set.size();
    }

    static void task6(Set<String> set, String name) {
        set.remove(name);
    }

    static Set<Integer> task7(List<Integer> numbers) {
        return new HashSet<>(numbers);
    }

    static int task8(List<Integer> numbers) {
        return new HashSet<>(numbers).size();
    }

    static boolean task9(List<Integer> numbers) {
        return numbers.size() != new HashSet<>(numbers).size();
    }

    static int task10(String text) {
        Set<Character> unique = new HashSet<>();
        for (char c : text.toCharArray()) {
            unique.add(c);
        }
        return unique.size();
    }
}
