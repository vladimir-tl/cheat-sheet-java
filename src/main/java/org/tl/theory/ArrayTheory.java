package org.tl.theory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * THEORY: arrays
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Basics
 *   1. What an array is
 *   2. Creating an array: with values or empty
 *   3. Default values
 *
 * Working with elements
 *   4. Read and change an element
 *   5. Adding an element: arrays can't grow
 *   6. Printing an array
 *   7. Looping over an array
 *
 * Traps
 *   8. ArrayIndexOutOfBoundsException, copying and comparing
 *
 * Array or List?
 *   9. Array or List? Converting between them
 *
 * Practice: see org.tl.arrays (ArrayCheatSheet, ArrayTasks, ArraySolutions).
 */
public class ArrayTheory {

    /**
     * 1. What an array is
     *
     * An array is a row of numbered cells. All cells hold the same type: only ints,
     * or only Strings, and so on.
     *
     * Think of an egg carton: it has a fixed number of slots, every slot holds one egg,
     * and the slots are numbered. The numbers start from 0, not from 1.
     * Once the carton is made, you can't add a slot: the size never changes.
     */
    static void whatIsArray() {
        // int[] numbers: a row of 3 cells
        //
        //   value:  [10] [20] [30]
        //   index:    0    1    2
        //
        // The first cell has index 0, the last one has index 2 (size minus 1).
    }

    /**
     * 2. Creating an array: with values or empty
     *
     * Two ways, depending on what you know:
     *   - You know the values: write them in braces { }. The size is counted for you.
     *   - You know only the size: new Type[size]. You get that many empty cells.
     *
     * The type is written with square brackets: int[] is "array of int", String[] is "array of String".
     */
    static void creating() {
        // 1. I know the values
        int[] numbers = {10, 20, 30};              // 3 cells: 10, 20, 30
        String[] names = {"Anna", "Bob"};          // 2 cells: Anna, Bob

        // 2. I know only the size: 5 empty cells (for int they are filled with 0)
        int[] empty = new int[5];                  // [0, 0, 0, 0, 0]
        String[] places = new String[3];           // [null, null, null]

        // The size goes into [] after new. It can be a variable:
        int size = 4;
        double[] prices = new double[size];        // [0.0, 0.0, 0.0, 0.0]
    }

    /**
     * 3. Default values
     *
     * A new array is never "really empty": every cell already holds a default value.
     *   int, long, short, byte  -> 0
     *   double, float           -> 0.0
     *   boolean                 -> false
     *   char                    -> the character with code 0 (invisible)
     *   String and any object   -> null (means "nothing here yet")
     *
     * A trap: a String cell holds null, and calling a method on null crashes the program.
     */
    static void defaults() {
        boolean[] flags = new boolean[2];          // [false, false]
        String[] names = new String[2];            // [null, null]

        names[0] = "Anna";                         // [Anna, null]
        // names[1].length();                      // NullPointerException: cell 1 is still null
    }

    /**
     * 4. Read and change an element
     *
     *   - array[index]: on the left side of `=` writes a value, anywhere else it reads one.
     *   - Size: array.length (no parentheses, unlike list.size()).
     *   - Last element: array[array.length - 1].
     */
    static void readAndChange() {
        int[] numbers = {10, 20, 30};

        int first = numbers[0];                    // 10: read
        numbers[1] = 99;                           // write: {10, 99, 30}
        numbers[2] = numbers[2] + 1;               // read, add 1, write back: {10, 99, 31}

        int size = numbers.length;                 // 3
        int last = numbers[numbers.length - 1];    // 31
    }

    /**
     * 5. Adding an element: arrays can't grow
     *
     * You can't add a cell to an array: the egg carton has a fixed number of slots.
     * numbers[3] = 40 on an array of 3 cells crashes.
     *
     * To "add" you make a NEW bigger array and copy the old values into it.
     * Arrays.copyOf(old, newSize) does both steps at once: it makes a bigger array and
     * copies the values. The new cells are empty (0 for int).
     * Then you write the new value into the free cell.
     *
     * If you add often, use a List instead: it grows by itself (see ListTheory).
     */
    static void adding() {
        int[] numbers = {10, 20, 30};

        // Step 1: a copy with one more cell
        numbers = Arrays.copyOf(numbers, numbers.length + 1);   // {10, 20, 30, 0}

        // Step 2: write the new value into the free last cell
        numbers[numbers.length - 1] = 40;                       // {10, 20, 30, 40}

        // The same with a List, no copying:
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30));
        list.add(40);                                           // [10, 20, 30, 40]
    }

    /**
     * 6. Printing an array
     *
     * System.out.println(array) does NOT print the values: it prints the type and an
     * address, something like [I@1b6d3586.
     * Arrays.toString(array) prints the values: [10, 20, 30].
     */
    static void printing() {
        int[] numbers = {10, 20, 30};

        System.out.println(numbers);                    // [I@1b6d3586 (junk)
        System.out.println(Arrays.toString(numbers));   // [10, 20, 30]
    }

    /**
     * 7. Looping over an array
     *
     * To do something with every cell, use a loop (see ForTheory).
     *   - for by index: when you need the position or want to change the cells.
     *   - for-each: when you only read the values.
     */
    static void looping() {
        int[] numbers = {10, 20, 30};

        // By index: print the position and the value
        for (int i = 0; i < numbers.length; i++) {
            System.out.println(i + ": " + numbers[i]);  // 0: 10, 1: 20, 2: 30
        }

        // for-each: only the values
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        System.out.println(sum);                        // 60
    }

    /**
     * 8. ArrayIndexOutOfBoundsException, copying and comparing
     *
     * Three classic surprises.
     *
     * 1) Index out of range. An array of size n has indexes 0 .. n-1. Anything else
     *    crashes with ArrayIndexOutOfBoundsException.
     * 2) int[] b = a does NOT copy. It gives the same array a second name: a and b are
     *    two names of one egg carton, so changing b changes a.
     *    A real copy: Arrays.copyOf(a, a.length).
     * 3) a == b compares whether it is the same array, not the values.
     *    To compare the values use Arrays.equals(a, b).
     */
    static void traps() {
        int[] a = {1, 2, 3};

        // 1) a[3] -> ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3

        // 2) Second name, not a copy
        int[] b = a;
        b[0] = 100;                                    // a is {100, 2, 3} too!

        int[] copy = Arrays.copyOf(a, a.length);       // a real copy
        copy[0] = 5;                                   // a does not change

        // 3) Comparing
        int[] x = {1, 2};
        int[] y = {1, 2};
        System.out.println(x == y);                    // false: two different arrays
        System.out.println(Arrays.equals(x, y));       // true: same values
    }

    /**
     * 9. Array or List? Converting between them
     *
     * Array: fixed size, can hold primitives (int[]), simple.
     * List: grows and shrinks, has many ready methods (add, remove, contains...), holds
     * objects (List<Integer>).
     *
     * Not sure? Take a List. Take an array when the size is fixed and known in advance.
     *
     * Converting:
     *   - array of objects -> List: new ArrayList<>(Arrays.asList(array))
     *   - List -> array of objects: list.toArray(new String[0])
     * Arrays.asList works for String[] and Integer[], but not for int[].
     */
    static void arrayOrList() {
        String[] array = {"a", "b", "c"};

        List<String> list = new ArrayList<>(Arrays.asList(array));  // [a, b, c]
        list.add("d");                                              // [a, b, c, d]

        String[] back = list.toArray(new String[0]);                // {"a", "b", "c", "d"}
    }
}
