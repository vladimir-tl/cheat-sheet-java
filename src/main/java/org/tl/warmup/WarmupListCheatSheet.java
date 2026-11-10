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
}
