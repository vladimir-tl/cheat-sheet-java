package org.tl.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * CHEAT SHEET: warm-up with ArrayList
 *
 * Theory: see org.tl.theory.WarmupListTheory
 */
public class WarmupListCheatSheet {

    public static void main(String[] args) {
        size();
        get();
        add();
        reverse();
        containsAndIndexOf();
        remove();
        setAndAddAt();
        isEmpty();
        forEach();
        removeWhileLooping();
    }

    /** 1. size: how many elements */
    static void size() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        System.out.println(numbers.size());   // 3
    }

    /** 2. get: read an element by its position */
    static void get() {
        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        System.out.println(numbers.get(1));   // 20: positions start from 0
    }

    /** 3. add: put an element at the end */
    static void add() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        System.out.println(numbers);          // [10, 20]
    }

    /** 4. Collections.reverse: reverse the same list */
    static void reverse() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3));
        Collections.reverse(numbers);
        System.out.println(numbers);          // [3, 2, 1]
    }

    /** 5. contains and indexOf: is the element there, and where */
    static void containsAndIndexOf() {
        List<String> names = new ArrayList<>(List.of("Ann", "Bob"));
        System.out.println(names.contains("Bob"));   // true
        System.out.println(names.indexOf("Bob"));    // 1
        System.out.println(names.indexOf("Eve"));    // -1: not in the list
    }

    /** 6. remove: by element or by position */
    static void remove() {
        List<String> names = new ArrayList<>(List.of("Ann", "Bob", "Eve"));
        names.remove("Bob");                         // by element
        names.remove(0);                             // by position
        System.out.println(names);                   // [Eve]

        List<Integer> numbers = new ArrayList<>(List.of(10, 20, 30));
        numbers.remove(1);                           // position 1, not the number 1
        numbers.remove(Integer.valueOf(10));         // the number 10
        System.out.println(numbers);                 // [30]
    }

    /** 7. set and add(position, element) */
    static void setAndAddAt() {
        List<String> names = new ArrayList<>(List.of("Ann", "Bob"));
        names.set(1, "Eve");                         // replace: [Ann, Eve]
        names.add(0, "Max");                         // insert: [Max, Ann, Eve]
        System.out.println(names);
    }

    /** 8. isEmpty */
    static void isEmpty() {
        System.out.println(new ArrayList<String>().isEmpty());  // true
        System.out.println(List.of("Ann").isEmpty());           // false
    }

    /** 9. for-each over a list */
    static void forEach() {
        List<Integer> numbers = new ArrayList<>(List.of(3, 8, 5));
        int sum = 0;
        for (int x : numbers) {
            sum += x;
        }
        System.out.println(sum);                     // 16
    }

    /** 10. Removing while looping: from the end, or removeIf */
    static void removeWhileLooping() {
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4));
        for (int i = numbers.size() - 1; i >= 0; i--) {
            if (numbers.get(i) % 2 == 0) {
                numbers.remove(i);
            }
        }
        System.out.println(numbers);                 // [1, 3]

        List<Integer> other = new ArrayList<>(List.of(1, 2, 3, 4));
        other.removeIf(x -> x % 2 == 0);
        System.out.println(other);                   // [1, 3]
        // for (int x : other) { other.remove(...); }  -> ConcurrentModificationException
    }
}
