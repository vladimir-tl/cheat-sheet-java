package org.tl.warmup;

import java.util.Arrays;

/**
 * SOLUTIONS: warm-up. Look only after you've tried the tasks.
 */
public class WarmupSolutions {

    public static void main(String[] args) {
        System.out.println(containsTrack(new int[]{5, 8, 12}, 8));           // true
        System.out.println(findBestSeller(new int[]{3, 17, 9}));              // 17
        int[] a = {1, 2, 3, 4};
        swapTracks(a, 0, 3);
        System.out.println(Arrays.toString(a));                      // [4, 2, 3, 1]
        int[] b = {1, 2, 3, 4, 5};
        reversePlaylist(b);
        System.out.println(Arrays.toString(b));                      // [5, 4, 3, 2, 1]
        System.out.println(arePricesInOrder(new int[]{1, 3, 3, 8}));            // true
        int[] c = {0, 4, 0, 7, 9};
        moveZerosToEnd(c);
        System.out.println(Arrays.toString(c));                      // [4, 7, 9, 0, 0]
        System.out.println(Arrays.toString(runningTotal(new int[]{1, 2, 3, 4}))); // [1, 3, 6, 10]
        System.out.println(Arrays.toString(findAlbumsForGiftCard(new int[]{2, 7, 11, 15}, 9))); // [0, 1]
        System.out.println(findLostTicket(new int[]{3, 0, 1}));               // 2
        System.out.println(isPrime(7));                               // true
        System.out.println(isPalindrome("level"));                         // true
        System.out.println(isPowerOfTwo(16));                              // true
        System.out.println(sumBonusPoints(new Integer[]{10, null, 5}));      // 15
        System.out.println(hasCommentText("   "));                           // false
        System.out.println(digitFromChar('7'));                             // 7
        System.out.println(totalPrice(2000000000, 3));                   // 6000000000
    }

    static boolean containsTrack(int[] ids, int target) {
        for (int id : ids) {
            if (id == target) {
                return true;
            }
        }
        return false;
    }

    static int findBestSeller(int[] sales) {
        if (sales.length == 0) {
            return -1;
        }
        int max = sales[0];
        for (int i = 1; i < sales.length; i++) {
            if (sales[i] > max) {
                max = sales[i];
            }
        }
        return max;
    }

    static void swapTracks(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void reversePlaylist(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    static boolean arePricesInOrder(int[] prices) {
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                return false;
            }
        }
        return true;
    }

    static void moveZerosToEnd(int[] arr) {
        int pos = 0;                          // where the next non-zero number goes
        for (int x : arr) {
            if (x != 0) {
                arr[pos++] = x;
            }
        }
        while (pos < arr.length) {
            arr[pos++] = 0;
        }
    }

    static int[] runningTotal(int[] arr) {
        int[] result = new int[arr.length];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            result[i] = sum;
        }
        return result;
    }

    static int[] findAlbumsForGiftCard(int[] prices, int amount) {
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] + prices[j] == amount) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    static int findLostTicket(int[] arr) {
        int n = 0;                            // the biggest number in the array
        int actual = 0;
        for (int x : arr) {
            if (x > n) {
                n = x;
            }
            actual += x;
        }
        int expected = n * (n + 1) / 2;       // sum of 0..n
        return expected - actual;
    }

    static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int d = 2; d * d <= n; d++) {    // a divisor above sqrt(n) has a partner below it
            if (n % d == 0) {
                return false;
            }
        }
        return true;
    }

    static boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    static int sumBonusPoints(Integer[] bonuses) {
        if (bonuses == null) {
            return 0;
        }
        int sum = 0;
        for (Integer b : bonuses) {
            if (b != null) {                  // unboxing null would throw NullPointerException
                sum += b;
            }
        }
        return sum;
    }

    static boolean hasCommentText(String s) {
        return s != null && !s.trim().isEmpty();   // && stops at once if s is null
    }

    static int digitFromChar(char c) {
        if (c >= '0' && c <= '9') {
            return c - '0';                   // '7' is the number 55, '0' is 48: the difference is the digit
        }
        return -1;
    }

    static long totalPrice(int price, int quantity) {
        return (long) price * quantity;       // (long) price * quantity: convert first, then multiply
    }
}
