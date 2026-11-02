package org.tl.types;

import java.util.ArrayList;
import java.util.List;

/**
 * CHEAT SHEET: primitives and wrapper classes
 *
 * THEORY
 * Java has two kinds of types:
 *   - Primitives: store the value itself. Fast, never null, no methods.
 *   - Wrappers (classes): an object that holds a primitive value. Can be null,
 *     have useful methods, and are required by generics.
 *
 *   Primitive | Wrapper   | Size    | Default | Notes
 *   ----------|-----------|---------|---------|-----------------------------
 *   byte      | Byte      | 8 bit   | 0       | -128 .. 127
 *   short     | Short     | 16 bit  | 0       |
 *   int       | Integer   | 32 bit  | 0       | the default integer type
 *   long      | Long      | 64 bit  | 0L      | literal needs L: 10000000000L
 *   float     | Float     | 32 bit  | 0.0f    | literal needs f: 1.5f
 *   double    | Double    | 64 bit  | 0.0     | the default decimal type
 *   char      | Character | 16 bit  | 0 (nul) | single character in ''
 *   boolean   | Boolean   | n/a     | false   | true / false
 *
 * Wrapper default value (field or array element) is null, not 0.
 * String is NOT a primitive; it is a class.
 *
 * When to use which:
 *   - Primitive by default (counters, math, flags).
 *   - Wrapper when you need null ("no value"), or inside generics: List<Integer>, Map<String, Long>.
 *     Generics cannot hold primitives: List<int> does not compile.
 */
public class PrimitivesAndWrappersCheatSheet {

    public static void main(String[] args) {
        autoboxing();
        nullPitfall();
        comparison();
        parsingAndConversion();
        usefulMethods();
        collectionsPitfall();
        pitfalls();
    }

    /** 1. Autoboxing and unboxing: Java converts automatically */
    static void autoboxing() {
        Integer boxed = 5;      // autoboxing: int -> Integer
        int primitive = boxed;  // unboxing:   Integer -> int

        List<Integer> list = new ArrayList<>();
        list.add(10);           // int is boxed to Integer automatically
        int first = list.get(0); // and unboxed back
    }

    /** 2. Unboxing null throws NullPointerException */
    static void nullPitfall() {
        Integer value = null;
        // int x = value; // NullPointerException!

        // Safe: check first
        int x = (value != null) ? value : 0;
    }

    /** 3. Comparison: == vs equals() */
    static void comparison() {
        // Primitives: == compares values
        int a = 1000, b = 1000;
        System.out.println(a == b);          // true

        // Wrappers: == compares references (objects), NOT values
        Integer c = 1000, d = 1000;
        System.out.println(c == d);          // false (!) different objects
        System.out.println(c.equals(d));     // true: always use equals() for wrappers

        // Small values -128..127 are cached, so == "works" by accident
        Integer e = 100, f = 100;
        System.out.println(e == f);          // true, but don't rely on it
    }

    /** 4. Parsing and converting */
    static void parsingAndConversion() {
        int fromString = Integer.parseInt("42");        // String -> int
        double decimal = Double.parseDouble("3.14");    // String -> double
        String text = String.valueOf(42);               // int -> String
        Integer boxed = Integer.valueOf(42);            // int -> Integer

        // Widening (smaller -> bigger) is automatic
        long big = 5;           // int -> long
        double dbl = 5;         // int -> double

        // Narrowing (bigger -> smaller) needs a cast and may lose data
        int truncated = (int) 3.99;   // 3, decimals are cut, not rounded
        byte overflow = (byte) 200;   // -56, overflowed
    }

    /** 5. Useful wrapper methods and constants */
    static void usefulMethods() {
        System.out.println(Integer.MAX_VALUE);          // 2147483647
        System.out.println(Integer.MIN_VALUE);          // -2147483648
        System.out.println(Integer.compare(3, 5));      // negative: 3 < 5
        System.out.println(Integer.sum(2, 3));          // 5
        System.out.println(Character.isDigit('7'));     // true
        System.out.println(Character.isLetter('a'));    // true
        System.out.println(Character.toUpperCase('a')); // 'A'
    }

    /** 6. Removing from List<Integer>: index or value? */
    static void collectionsPitfall() {
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30));

        list.remove(1);                      // int -> removes by INDEX -> [10, 30]
        list.remove(Integer.valueOf(10));    // object -> removes by VALUE -> [30]
    }

    /** 7. Common mistakes */
    static void pitfalls() {
        // integer division: 5 / 2 == 2, use 5 / 2.0 or (double) 5 / 2 for 2.5
        // int overflow: Integer.MAX_VALUE + 1 becomes a negative number; use long
        // double precision: 0.1 + 0.2 != 0.3; use BigDecimal for money
        // comparing wrappers with == instead of equals()
        // unboxing a null wrapper -> NullPointerException
    }
}
