package org.tl.types;

/**
 * CHEAT SHEET: primitives and wrapper classes
 *
 * Theory: see org.tl.theory.PrimitivesAndWrappersTheory
 */
public class PrimitivesAndWrappersCheatSheet {

    public static void main(String[] args) {
        autoboxing();
        nullPitfall();
        comparison();
        parsingAndConversion();
        usefulMethods();
        pitfalls();
    }

    /** 1. Autoboxing and unboxing: Java converts automatically */
    static void autoboxing() {
        Integer boxed = 5;      // autoboxing: int -> Integer
        int primitive = boxed;  // unboxing:   Integer -> int
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

    /** 6. Common mistakes */
    static void pitfalls() {
        // integer division: 5 / 2 == 2, use 5 / 2.0 or (double) 5 / 2 for 2.5
        // int overflow: Integer.MAX_VALUE + 1 becomes a negative number; use long
        // double precision: 0.1 + 0.2 != 0.3; use BigDecimal for money
        // comparing wrappers with == instead of equals()
        // unboxing a null wrapper -> NullPointerException
    }
}
