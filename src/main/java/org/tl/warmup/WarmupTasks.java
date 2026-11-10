package org.tl.warmup;

/**
 * PRACTICE TASKS: warm-up (the first LeetCode-style problems)
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work and one method that you have to create. The ticket says what the method
 * is called and which parameters it takes. Its template is shown under the ticket (in WarmupTasks.java
 * it is already there), so you only have to write the body.
 * The tasks use only arrays, loops, primitives and null. They go from easy to a bit harder.
 *
 * How to read a ticket:
 * - What to do: which method to create, with which parameters, and what it must do.
 * - Input: the values the method receives.
 * - Return: what the method must give back. If it returns nothing (void), it changes the array it received.
 * - Examples: `findBestSeller([3, 17, 9]) -> 17` means "call the method with this array, and it must return 17".
 * - The notation `[3, 17, 9]` is a short way to show an array. In Java code write `new int[]{3, 17, 9}`.
 * - Run the examples in main to check yourself. To print an array, use `Arrays.toString(arr)`.
 *
 * Solutions are in WarmupSolutions.java; peek only after you've tried.
 */
public class WarmupTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. Is the track in the playlist?
     * A playlist is stored as an array of numbers: each number is the id of one track.
     * A customer asks: "Is this track in my playlist?"
     *
     * What to do: create a method `containsTrack` with two parameters: the first is an array of numbers `ids`, the second is a number `target`. The method must check whether `target` is in the array `ids` and return true or false.
     *
     * - Input: ids, the array of track ids; target, the track id to look for.
     * - Return: true if target is in the array, otherwise false. For an empty array, also false.
     *
     * Examples:
     * - containsTrack([5, 8, 12], 8) -> true (8 is in the array)
     * - containsTrack([5, 8, 12], 7) -> false (there is no 7)
     * - containsTrack([], 7) -> false (the playlist is empty)
     *
     * Hint: Look at the elements one by one. As soon as you find target, the answer is known and you can return it.
     */
    static boolean containsTrack(int[] ids, int target) {
        return false;
    }

    /**
     * Ticket 2. Best seller
     * Each number in the array shows how many copies of one album were sold today.
     * The manager wants to know the best result of the day.
     *
     * What to do: create a method `findBestSeller` with one parameter: an array of numbers `sales`. The method must find the biggest number in the array and return it.
     *
     * - Input: sales, the array of sold copies (every number is 0 or more).
     * - Return: the biggest number. If the array is empty, there is nothing to compare, so return -1.
     *
     * Examples:
     * - findBestSeller([3, 17, 9]) -> 17
     * - findBestSeller([4]) -> 4 (the only number is the biggest)
     * - findBestSeller([]) -> -1 (the array is empty)
     *
     * Hint: Remember the biggest number you have seen so far and compare every next element with it.
     */
    static int findBestSeller(int[] sales) {
        return 0;
    }

    /**
     * Ticket 3. Swap two tracks
     * A customer drags one track onto the place of another, and these two tracks change places.
     * All other tracks stay where they were.
     *
     * What to do: create a method `swapTracks` with three parameters: the first is an array of numbers `arr`, the second is a number `i`, the third is a number `j`. The numbers `i` and `j` are positions (indexes) in the array, counted from 0. The method must swap the elements at these two positions. It returns nothing, it changes `arr` itself.
     *
     * - Input: arr, the playlist; i and j, two indexes. Both always exist in the array.
     * - Return: nothing (void). Change the array arr itself.
     *
     * Examples:
     * - arr = [1, 2, 3, 4], swapTracks(arr, 0, 3) -> arr becomes [4, 2, 3, 1] (the first and the last changed places)
     * - arr = [1, 2, 3], swapTracks(arr, 1, 1) -> arr stays [1, 2, 3] (i and j are the same position)
     *
     * Hint: If you write the value of arr[j] into arr[i] right away, the old value of arr[i] is lost. Save it first in an extra variable.
     */
    static void swapTracks(int[] arr, int i, int j) {
    }

    /**
     * Ticket 4. Play it backwards
     * A customer pressed "Play from the end": the playlist must go in the opposite order.
     *
     * What to do: create a method `reversePlaylist` with one parameter: an array of numbers `arr`. The method must reverse the array: the last element becomes the first, the second to last becomes the second, and so on. Change this same array, do not create a second one. The method returns nothing.
     *
     * - Input: arr, the playlist.
     * - Return: nothing (void). Change the array arr itself.
     *
     * Examples:
     * - arr = [1, 2, 3, 4, 5], reversePlaylist(arr) -> arr becomes [5, 4, 3, 2, 1]
     * - arr = [7, 8], reversePlaylist(arr) -> arr becomes [8, 7]
     * - arr = [], reversePlaylist(arr) -> arr stays [] (there is nothing to reverse)
     *
     * Hint: Swap the first element with the last one, the second with the second to last, and stop when you reach the middle.
     */
    static void reversePlaylist(int[] arr) {
    }

    /**
     * Ticket 5. Are the prices in order?
     * The store page must show prices from the cheapest to the most expensive.
     * Before publishing the list, somebody has to check it.
     *
     * What to do: create a method `arePricesInOrder` with one parameter: an array of numbers `prices`. The method must check that every price is not smaller than the price right before it and return true or false. Two equal prices in a row are fine.
     *
     * - Input: prices, the array of prices.
     * - Return: true if the prices are in order, otherwise false. For an empty array or one price, return true.
     *
     * Examples:
     * - arePricesInOrder([1, 3, 3, 8]) -> true (every price is not smaller than the one before it)
     * - arePricesInOrder([1, 5, 4]) -> false (4 comes after 5)
     * - arePricesInOrder([]) -> true (no prices, so nothing is out of order)
     *
     * Hint: Compare neighbours: an element and the one right before it. Start from the second element, because the first has nothing before it. One wrong pair is enough for the answer.
     */
    static boolean arePricesInOrder(int[] prices) {
        return false;
    }

    /**
     * Ticket 6. Zeros to the end
     * Each number is the count of downloads in one day; 0 means there were no downloads.
     * The report must show the days with downloads first and the empty days at the end.
     *
     * What to do: create a method `moveZerosToEnd` with one parameter: an array of numbers `arr`. The method must move all zeros to the end of the array, and the other numbers must keep their order. Change this same array, do not create a second one. The method returns nothing.
     *
     * - Input: arr, the downloads per day.
     * - Return: nothing (void). Change the array arr itself.
     *
     * Examples:
     * - arr = [0, 4, 0, 7, 9], moveZerosToEnd(arr) -> arr becomes [4, 7, 9, 0, 0] (4, 7, 9 are still in the same order)
     * - arr = [1, 2], moveZerosToEnd(arr) -> arr stays [1, 2] (there are no zeros)
     *
     * Hint: Keep an extra index: the place where the next non-zero number must go. When all non-zero numbers are in place, think about what must be in the remaining cells.
     */
    static void moveZerosToEnd(int[] arr) {
    }

    /**
     * Ticket 7. Running total
     * Each number is the revenue of one day.
     * The report must show how much the store has earned in total by the end of every day.
     *
     * What to do: create a method `runningTotal` with one parameter: an array of numbers `arr`. The method must create and return a new array in which every element is the sum of all numbers of `arr` from the beginning up to this position, including this position.
     *
     * - Input: arr, the revenue per day.
     * - Return: a new array of the same length. Do not change arr. For an empty array, return an empty array.
     *
     * Examples:
     * - runningTotal([1, 2, 3, 4]) -> [1, 3, 6, 10] (1, then 1+2, then 1+2+3, then 1+2+3+4)
     * - runningTotal([5, -2, 4]) -> [5, 3, 7] (5, then 5-2, then 5-2+4)
     * - runningTotal([]) -> []
     *
     * Hint: You don't have to count the sum again for every position. Keep the sum so far and add one number on each step.
     */
    static int[] runningTotal(int[] arr) {
        return null;
    }

    /**
     * Ticket 8. Two albums for the gift card
     * A customer has a gift card and wants to spend all of it on exactly two different albums.
     *
     * What to do: create a method `findAlbumsForGiftCard` with two parameters: the first is an array of numbers `prices`, the second is a number `amount`. The method must find two different positions in the array whose prices add up exactly to `amount` and return these positions (indexes, not the prices) as an array.
     *
     * - Input: prices, the album prices; amount, the money on the gift card.
     * - Return: an array of two indexes, the smaller one first. If there is no such pair, return an empty array. If there are several pairs, return any of them.
     *
     * Examples:
     * - findAlbumsForGiftCard([2, 7, 11, 15], 9) -> [0, 1] (the prices at indexes 0 and 1 are 2 and 7, and 2 + 7 = 9)
     * - findAlbumsForGiftCard([3, 2, 4], 6) -> [1, 2] (2 + 4 = 6; the album with price 3 can't be taken twice)
     * - findAlbumsForGiftCard([1, 2], 10) -> [] (no two prices give 10)
     *
     * Hint: Try every pair of albums. That takes one loop inside another. The index of the second album must always be bigger than the index of the first.
     */
    static int[] findAlbumsForGiftCard(int[] prices, int amount) {
        return null;
    }

    /**
     * Ticket 9. The lost ticket number
     * Concert tickets have the numbers 0, 1, 2, ... up to some number n, one ticket per number.
     * One ticket is lost. The array holds the numbers of all the other tickets, in any order.
     *
     * What to do: create a method `findLostTicket` with one parameter: an array of numbers `arr`. The method must find the number of the lost ticket and return it.
     *
     * - Input: arr, the numbers of the remaining tickets, without repeats. The biggest possible number n equals arr.length.
     * - Return: the number from 0 to n that is not in the array.
     *
     * Examples:
     * - findLostTicket([3, 0, 1]) -> 2 (n is 3, so the tickets were 0, 1, 2, 3, and 2 is missing)
     * - findLostTicket([0, 1]) -> 2 (n is 2, so the tickets were 0, 1, 2, and 2 is missing)
     * - findLostTicket([1]) -> 0 (n is 1, so the tickets were 0, 1, and 0 is missing)
     *
     * Hint: You can work out what the sum of all numbers from 0 to n should be. Compare it with the real sum of the array.
     */
    static int findLostTicket(int[] arr) {
        return 0;
    }

    /**
     * Ticket 10. Music quiz labels
     * The quiz page shows the numbers from 1 to n, but some numbers are replaced with words.
     *
     * What to do: create a method `buildQuizLabels` with one parameter: a number `n`. The method must build and return one string with a label for every number from 1 to `n`. The label of a number is:
     * - "FizzBuzz" if the number is divisible by both 3 and 5;
     * - "Fizz" if it is divisible only by 3;
     * - "Buzz" if it is divisible only by 5;
     * - the number itself in all other cases.
     *
     * "Divisible" means there is no remainder after division.
     *
     * - Input: n, how many numbers to show (n is 0 or more).
     * - Return: one String with all labels separated by a comma and a space. For n = 0, return an empty string "".
     *
     * Examples:
     * - buildQuizLabels(5) -> "1, 2, Fizz, 4, Buzz"
     * - buildQuizLabels(15) -> "1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz"
     * - buildQuizLabels(0) -> ""
     *
     * Hint: The order of checks matters: 15 is also divisible by 3, so decide which check must go first. The comma goes only between labels, not after the last one.
     */
    static String buildQuizLabels(int n) {
        return null;
    }

    /**
     * Ticket 11. Special offer code
     * A promo code works only if it is a prime number. A prime number is bigger than 1
     * and can be divided without a remainder only by 1 and by itself: 2, 3, 5, 7, 11, ...
     *
     * What to do: create a method `isPrime` with one parameter: a number `n`. The method must check whether `n` is prime and return true or false.
     *
     * - Input: n, the promo code.
     * - Return: true if n is prime, otherwise false.
     *
     * Examples:
     * - isPrime(7) -> true (7 is divided only by 1 and 7)
     * - isPrime(12) -> false (12 is also divided by 2, 3, 4 and 6)
     * - isPrime(1) -> false (a prime number must be bigger than 1)
     * - isPrime(2) -> true (the smallest prime number)
     *
     * Hint: Try to divide n by 2, 3, 4, and so on. If any of them divides n without a remainder, n is not prime. Numbers smaller than 2 are never prime, so handle them first.
     */
    static boolean isPrime(int n) {
        return false;
    }

    /**
     * Ticket 12. Mirror album title
     * Some titles read the same from left to right and from right to left, like "level".
     * Such a word is called a palindrome, and the store wants to mark these albums.
     *
     * What to do: create a method `isPalindrome` with one parameter: a string `s`. The method must check whether `s` is a palindrome and return true or false. Capital and small letters are different, so "Level" is not a palindrome.
     *
     * - Input: s, the title. It can be null, which means there is no title at all.
     * - Return: true if s is a palindrome, otherwise false. An empty string and a string of one letter are palindromes. For null, return false.
     *
     * Examples:
     * - isPalindrome("level") -> true
     * - isPalindrome("abca") -> false (the second letter is b, the second to last is c)
     * - isPalindrome("Level") -> false (L and l are different)
     * - isPalindrome("") -> true
     * - isPalindrome(null) -> false
     *
     * Hint: First deal with null. Then compare the first letter with the last, the second with the second to last, and so on up to the middle. `s.charAt(i)` gives the letter at position i.
     */
    static boolean isPalindrome(String s) {
        return false;
    }

    /**
     * Ticket 13. Vinyl box sets
     * Vinyl box sets are made only with 1, 2, 4, 8, 16, ... records: every size is twice the size
     * before it. Such numbers are called powers of two. A customer asks for a box of n records.
     *
     * What to do: create a method `isPowerOfTwo` with one parameter: a number `n`. The method must check whether `n` is one of these sizes and return true or false.
     *
     * - Input: n, the requested size. It can also be 0 or negative.
     * - Return: true if n is a power of two (1, 2, 4, 8, ...), otherwise false.
     *
     * Examples:
     * - isPowerOfTwo(16) -> true
     * - isPowerOfTwo(12) -> false (the sizes jump from 8 to 16)
     * - isPowerOfTwo(1) -> true (the smallest size)
     * - isPowerOfTwo(0) -> false
     * - isPowerOfTwo(-8) -> false (a negative size does not exist)
     *
     * Hint: Divide n by 2 while it is even. What is left of a power of two in the end? Handle 0 and negative numbers first.
     */
    static boolean isPowerOfTwo(int n) {
        return false;
    }

    /**
     * Ticket 14. Total bonus points
     * Bonus points come from another system. The array has the type Integer[] and not int[],
     * because an Integer can be null: it means the system does not know the points of this customer.
     * Sometimes the whole array is null: the system has sent nothing.
     *
     * What to do: create a method `sumBonusPoints` with one parameter: an array `bonuses` of type `Integer[]`. The method must add up all the known points, skip every null and return the sum.
     *
     * - Input: bonuses, the array of points; it can be null and can contain null elements.
     * - Return: the sum of all numbers in the array. If the array is null, return 0.
     *
     * Examples:
     * - sumBonusPoints([10, null, 5]) -> 15 (10 + 5, null is skipped)
     * - sumBonusPoints([null, null]) -> 0 (no known points)
     * - sumBonusPoints(null) -> 0 (there is no array at all)
     *
     * Hint: There are two possible null values here: the array and each element. Using a null Integer in arithmetic throws NullPointerException.
     */
    static int sumBonusPoints(Integer[] bonuses) {
        return 0;
    }

    /**
     * Ticket 15. Is there a comment?
     * Customers can add a comment to an order. If they leave the field empty, the site
     * can send null, an empty string, or a string of spaces. None of these is a real comment.
     *
     * What to do: create a method `hasCommentText` with one parameter: a string `s`. The method must check that the comment has real text (it is not null and has at least one character that is not a space) and return true or false.
     *
     * - Input: s, the comment. It can be null.
     * - Return: true if there is real text, otherwise false.
     *
     * Examples:
     * - hasCommentText("great album") -> true
     * - hasCommentText("   ") -> false (only spaces)
     * - hasCommentText("") -> false (an empty string)
     * - hasCommentText(null) -> false (no comment at all)
     *
     * Hint: Check for null first, because calling any method on null throws NullPointerException. `trim()` removes the spaces at the start and the end of a string.
     */
    static boolean hasCommentText(String s) {
        return false;
    }

    /**
     * Ticket 16. Digit from a character
     * A serial number is read one character at a time. The character '7' and the number 7 are
     * different things: inside Java the character '7' is stored as the code 55.
     *
     * What to do: create a method `digitFromChar` with one parameter: a character `c` of type `char`. The method must turn a digit character into the number it shows and return this number. If the character is not a digit, it must return -1.
     *
     * - Input: c, one character.
     * - Return: a number from 0 to 9 if c is one of the characters '0' to '9', otherwise -1.
     *
     * Examples:
     * - digitFromChar('7') -> 7
     * - digitFromChar('0') -> 0
     * - digitFromChar('a') -> -1 (a is not a digit)
     *
     * Hint: The digit characters have codes that go one after another: '0' is 48, '1' is 49, '2' is 50. You can subtract one char from another.
     */
    static int digitFromChar(char c) {
        return 0;
    }

    /**
     * Ticket 17. Total price without overflow
     * The total of an order is price * quantity. An int can hold numbers up to about 2.1 billion.
     * If the result is bigger, Java does not report an error: you just get a wrong number. This is called overflow.
     *
     * What to do: create a method `totalPrice` with two parameters: the first is a number `price`, the second is a number `quantity`, both of type `int`. The method must multiply them and return the exact result as a `long`, even if it does not fit in an `int`.
     *
     * - Input: price and quantity, two numbers of type int.
     * - Return: the exact result of the multiplication as a long.
     *
     * Examples:
     * - totalPrice(3, 4) -> 12
     * - totalPrice(2000000000, 3) -> 6000000000 (too big for an int)
     *
     * Hint: `price * quantity` is calculated in int and may overflow before it reaches the long. Make the calculation happen in long.
     */
    static long totalPrice(int price, int quantity) {
        return 0;
    }
}
