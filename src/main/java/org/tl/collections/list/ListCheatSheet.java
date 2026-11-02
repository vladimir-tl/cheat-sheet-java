package org.tl.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * CHEAT SHEET: List
 *
 * Theory: see org.tl.theory.ListTheory
 */
public class ListCheatSheet {

    public static void main(String[] args) {
        creating();
        basicOperations();
        searching();
        sorting();
        iterateWithFor();
        iterateWithForEach();
        removeWhileIterating();
        removeByIndexOrValue();
    }

    /** 0. Creating a list: four ways */
    static void creating() {
        List<String> empty = new ArrayList<>();                          // empty, fill it later
        List<String> fruits = new ArrayList<>(List.of("apple", "pear")); // with items, changeable
        List<String> days = List.of("Mon", "Tue");                       // with items, NOT changeable
        String[] array = {"a", "b", "c"};
        List<String> fromArray = new ArrayList<>(Arrays.asList(array));  // from an array
    }

    /** 1. Basic operations (no loops needed) */
    static void basicOperations() {
        // Why List on the left and ArrayList on the right: see ListTheory, section 3
        List<String> names = new ArrayList<>(); // empty list

        names.add("Anna");          // add to the end -> [Anna]
        names.add("Bob");           // -> [Anna, Bob]
        names.add(0, "Eve");        // insert at index 0 -> [Eve, Anna, Bob]
        names.addAll(List.of("Tom", "Kate")); // add many at the end -> [Eve, Anna, Bob, Tom, Kate]

        String first = names.get(0);    // "Eve" (index starts at 0)
        int size = names.size();        // 5
        boolean empty = names.isEmpty(); // false

        names.set(1, "Alex");       // replace element at index 1 -> [Eve, Alex, Bob, Tom, Kate]
        names.remove(0);            // remove by index -> [Alex, Bob, Tom, Kate]
        names.remove("Bob");        // remove by value -> [Alex, Tom, Kate]

        names.clear();              // remove everything -> []

        // names.get(5) on a list of size 3 -> IndexOutOfBoundsException (valid: 0..size-1)
    }

    /** 2. Searching (no loops needed) */
    static void searching() {
        List<String> names = new ArrayList<>(List.of("Anna", "Bob", "Anna"));

        boolean has = names.contains("Bob");      // true
        int firstIndex = names.indexOf("Anna");   // 0
        int lastIndex = names.lastIndexOf("Anna"); // 2
        int missing = names.indexOf("Zed");       // -1: not found
    }

    /** 3. Sorting and reversing (no loops needed) */
    static void sorting() {
        List<Integer> numbers = new ArrayList<>(List.of(3, 1, 2));

        Collections.sort(numbers);      // [1, 2, 3]
        Collections.reverse(numbers);   // [3, 2, 1]
        int max = Collections.max(numbers); // 3
        int min = Collections.min(numbers); // 1

        // List.of(...) is immutable: sort/add/remove on it throws UnsupportedOperationException
    }

    /** 4. for loop by index (collections use size(), not length) */
    static void iterateWithFor() {
        List<String> list = List.of("a", "b", "c");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ":" + list.get(i));
        }
    }

    /** 5. for-each: when you don't need the index */
    static void iterateWithForEach() {
        List<String> list = List.of("a", "b", "c");
        for (String s : list) {
            System.out.println(s);
        }
    }

    /** 6. Removing while iterating */
    static void removeWhileIterating() {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4));

        // list.remove(...) inside for-each -> ConcurrentModificationException

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) it.remove();
        }

        // or simply:
        list.removeIf(x -> x > 2);
    }

    /** 7. List<Integer>.remove(): by index or by value? */
    static void removeByIndexOrValue() {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30));

        list.remove(1);                    // int -> removes by INDEX -> [10, 30]
        list.remove(Integer.valueOf(10));  // object -> removes by VALUE -> [30]
    }
}
