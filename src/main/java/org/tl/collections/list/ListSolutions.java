package org.tl.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SOLUTIONS for ListTasks.
 */
public class ListSolutions {

    static List<String> task1() {
        return new ArrayList<>();
    }

    static List<String> task2() {
        List<String> names = new ArrayList<>();
        names.add("Anna");
        names.add("Bob");
        names.add("Eve");
        return names;
    }

    static String task3(List<String> list) {
        return list.get(0);
    }

    static String task4(List<String> list) {
        return list.get(list.size() - 1);
    }

    static int task5(List<String> list) {
        return list.size();
    }

    static void task6(List<String> list, String name) {
        list.add(name);
    }

    static void task7(List<String> list, String name) {
        list.set(0, name);
    }

    static void task8(List<String> list) {
        list.remove(0);
    }

    static boolean task9(List<String> list, String name) {
        return list.contains(name);
    }

    static int task10(List<String> list, String name) {
        return list.indexOf(name);
    }

    static boolean task11(List<String> list) {
        return list.isEmpty();
    }

    static void task12(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    static int task13(List<Integer> numbers) {
        return Collections.max(numbers);
    }

    static void task14(List<String> list) {
        list.clear();
    }
}
