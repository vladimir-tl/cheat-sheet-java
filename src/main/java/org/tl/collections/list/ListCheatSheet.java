package org.tl.collections.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * CHEAT SHEET: List
 */
public class ListCheatSheet {

    public static void main(String[] args) {
        iterateWithFor();
        iterateWithForEach();
        removeWhileIterating();
    }

    /** 1. for loop by index (collections use size(), not length) */
    static void iterateWithFor() {
        List<String> list = List.of("a", "b", "c");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ":" + list.get(i));
        }
    }

    /** 2. for-each: when you don't need the index */
    static void iterateWithForEach() {
        List<String> list = List.of("a", "b", "c");
        for (String s : list) {
            System.out.println(s);
        }
    }

    /** 3. Removing while iterating */
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
}
