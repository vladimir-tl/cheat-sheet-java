package org.tl.warmup;

/**
 * CHEAT SHEET: warm-up patterns
 *
 * Theory: see org.tl.theory.WarmupTheory
 */
public class WarmupCheatSheet {

    public static void main(String[] args) {
        scan();
        twoPointers();
        writePointer();
        digitsAndChars();
        nullGuard();
        overflow();
    }

    /** 1. Scan: one pass and keep an answer */
    static void scan() {
        int[] numbers = {4, 9, 2, 8, 6};
        int evenCount = 0;                     // the answer so far
        for (int x : numbers) {
            if (x % 2 == 0) {
                evenCount++;
            }
        }
        System.out.println(evenCount);         // 4
    }

    /** 2. Two pointers: from both ends to the middle */
    static void twoPointers() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            System.out.println(numbers[left] + numbers[right]);   // 7, 7, 7
            left++;
            right--;
        }
    }

    /** 3. Write pointer: write into the same array */
    static void writePointer() {
        int[] numbers = {3, 8, 5, 6, 1};
        int pos = 0;                           // the place for the next even number
        for (int x : numbers) {
            if (x % 2 == 0) {
                numbers[pos] = x;
                pos++;
            }
        }
        // the first pos cells now hold the even numbers: [8, 6, ...]
        System.out.println(pos);               // 2
    }

    /** 4. Digits and chars: % 10, / 10 and char difference */
    static void digitsAndChars() {
        int n = 4072;
        System.out.println(n % 10);            // 2: the last digit
        System.out.println(n / 10);            // 407: without the last digit
        System.out.println('d' - 'a');         // 3: the position of the letter in the alphabet
    }

    /** 5. Null guard and edge cases */
    static void nullGuard() {
        String name = null;
        String shown = name == null ? "guest" : name;
        System.out.println(shown);                          // guest
        boolean longName = name != null && name.length() > 3;
        System.out.println(longName);                       // false: name.length() is never called
    }

    /** 6. int overflow */
    static void overflow() {
        int max = Integer.MAX_VALUE;           // 2147483647
        System.out.println(max + 1);           // -2147483648: wraps around, no error
        System.out.println((long) max + 1);    // 2147483648
        // Math.addExact(max, 1) would throw ArithmeticException instead of a wrong number
    }
}
