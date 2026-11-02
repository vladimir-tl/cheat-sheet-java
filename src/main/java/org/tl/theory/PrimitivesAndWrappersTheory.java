package org.tl.theory;

/**
 * THEORY: primitives and wrapper classes
 *
 * Short sample snippets. Copy any of them into a main method and run it.
 *
 * Contents
 *
 * Basics
 *   1. Two kinds of types: primitives and wrappers
 *   2. The eight primitives and their wrappers
 *   3. When to use which
 *
 * Converting
 *   4. Autoboxing and unboxing
 *   5. Parsing: String to number and back
 *   6. Casting: widening and narrowing
 *
 * Traps
 *   7. Unboxing null: NullPointerException
 *   8. Comparing wrappers: == or equals?
 *   9. Integer division, overflow, double precision
 *
 * Practice: see org.tl.types (PrimitivesAndWrappersCheatSheet).
 */
public class PrimitivesAndWrappersTheory {

    /**
     * 1. Two kinds of types: primitives and wrappers
     *
     * Primitive: stores the value itself. Fast, never null, has no methods. Written in
     * lower case: int, double, boolean.
     *
     * Wrapper: a class (an object) that holds a primitive. Can be null, has useful
     * methods, and is required by generics. Written with a capital letter: Integer, Double, Boolean.
     *
     * String is NOT a primitive; it is a class.
     */
    static void twoKinds() {
        int a = 5;          // primitive: just the number 5
        Integer b = 5;      // wrapper: an object holding 5
        Integer c = null;   // possible only for a wrapper
    }

    /**
     * 2. The eight primitives and their wrappers
     *
     *   Primitive | Wrapper   | Size   | Default | Notes
     *   ----------|-----------|--------|---------|---------------------------------
     *   byte      | Byte      | 8 bit  | 0       | -128 .. 127
     *   short     | Short     | 16 bit | 0       |
     *   int       | Integer   | 32 bit | 0       | the default integer type
     *   long      | Long      | 64 bit | 0L      | literal needs L: 10000000000L
     *   float     | Float     | 32 bit | 0.0f    | literal needs f: 1.5f
     *   double    | Double    | 64 bit | 0.0     | the default decimal type
     *   char      | Character | 16 bit | 0 (nul) | one character in single quotes: 'a'
     *   boolean   | Boolean   | n/a    | false   | true or false
     *
     * The default is what a field or an array element gets if you set nothing.
     * For every wrapper the default is null, not 0.
     */
    static void table() {
        long big = 10000000000L;  // without L: "integer number too large"
        float f = 1.5f;           // without f: 1.5 is a double and does not fit into float
        char letter = 'a';        // single quotes for char, double quotes for String
    }

    /**
     * 3. When to use which
     *
     *   - Primitive by default: counters, math, flags.
     *   - Wrapper when you need null ("no value"), or inside generics:
     *     Map<String, Long>. Generics cannot hold primitives: Map<String, long> does not compile.
     */
    static void whenToUse() {
        int count = 0;                    // a counter: primitive
        Integer maybeAge = null;          // age may be unknown: wrapper
    }

    /**
     * 4. Autoboxing and unboxing
     *
     * Java converts between a primitive and its wrapper automatically.
     *   boxing:   int -> Integer
     *   unboxing: Integer -> int
     */
    static void autoboxing() {
        Integer boxed = 5;       // boxing
        int primitive = boxed;   // unboxing
    }

    /**
     * 5. Parsing: String to number and back
     *
     * Integer.parseInt("42") turns text into an int. String.valueOf(42) turns a number
     * into text. Text that is not a number throws NumberFormatException.
     */
    static void parsing() {
        int a = Integer.parseInt("42");             // 42
        double d = Double.parseDouble("3.14");      // 3.14
        String text = String.valueOf(42);           // "42"
        Integer boxed = Integer.valueOf(42);        // 42 as an Integer

        // Integer.parseInt("abc");   // NumberFormatException: For input string: "abc"
        // Integer.parseInt("");      // NumberFormatException
    }

    /**
     * 6. Casting: widening and narrowing
     *
     * Widening (smaller -> bigger type) is automatic and safe: int -> long -> double.
     * Narrowing (bigger -> smaller) needs a cast in brackets and may lose data.
     */
    static void casting() {
        long big = 5;                   // int -> long, automatic
        double dbl = 5;                 // int -> double, automatic: 5.0

        int truncated = (int) 3.99;     // 3: the decimals are CUT, not rounded
        byte overflow = (byte) 200;     // -56: 200 does not fit into byte (max 127)
        int rounded = (int) Math.round(3.99); // 4: use Math.round to round
    }

    /**
     * 7. Unboxing null: NullPointerException
     *
     * A wrapper may be null, a primitive may not. If you unbox a null wrapper,
     * the program crashes.
     */
    static void nullTrap() {
        Integer value = null;
        // int x = value;   // NullPointerException

        int safe = (value != null) ? value : 0;   // check first -> 0
    }

    /**
     * 8. Comparing wrappers: == or equals?
     *
     * For primitives == compares values. For wrappers == compares REFERENCES (are these the
     * same object?), not values. Always use equals() for wrappers.
     *
     * Integer caches the values -128 .. 127, so == "works" for small numbers by accident
     * and fails for big ones. Do not rely on it.
     */
    static void equalsTrap() {
        int a = 1000, b = 1000;
        System.out.println(a == b);             // true: primitives

        Integer c = 1000, d = 1000;
        System.out.println(c == d);             // false (!) two different objects
        System.out.println(c.equals(d));        // true: compares values

        Integer e = 100, f = 100;
        System.out.println(e == f);             // true, only because 100 is cached
    }

    /**
     * 9. Integer division, overflow, double precision
     *
     * Three classic surprises with numbers.
     */
    static void numberTraps() {
        // Integer division: int / int is an int, the decimals are cut
        System.out.println(5 / 2);              // 2, not 2.5
        System.out.println(5 / 2.0);            // 2.5: one operand is a double
        System.out.println(5 % 2);              // 1: the remainder

        // Overflow: int has no room for a bigger number and wraps around
        System.out.println(Integer.MAX_VALUE);      // 2147483647
        System.out.println(Integer.MAX_VALUE + 1);  // -2147483648 (!)
        System.out.println(Integer.MAX_VALUE + 1L); // 2147483648: use long

        // Precision: double stores decimals approximately
        System.out.println(0.1 + 0.2);              // 0.30000000000000004
        System.out.println(0.1 + 0.2 == 0.3);       // false
        // For money use BigDecimal or whole cents in a long.
    }
}
