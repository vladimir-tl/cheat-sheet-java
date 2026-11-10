package org.tl.warmup;

import java.util.List;

/**
 * PRACTICE TASKS: warm-up with ArrayList (the simplest tasks)
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work and one method that you have to create. The ticket says what the method
 * is called and which parameters it takes. Its template is shown under the ticket (in WarmupListTasks.java
 * it is already there), so you only have to write the body.
 * You need only four operations: size, get, add and reverse.
 *
 * How to read a ticket:
 * - What to do: which method to create, with which parameters, and what it must do.
 * - Input: the values the method receives.
 * - Return: what the method must give back. If it returns nothing (void), it changes the list it received.
 * - Examples: `countTracks(["Intro", "Solo"]) -> 2` means "call the method with this list, and it must return 2".
 * - The notation `["Intro", "Solo"]` is a short way to show a list. In Java code write `new ArrayList<>(List.of("Intro", "Solo"))`.
 * - Run the examples in main to check yourself. A list can be printed directly: `System.out.println(tracks)`.
 *
 * Solutions are in WarmupListSolutions.java; peek only after you've tried.
 */
public class WarmupListTasks {

    public static void main(String[] args) {
        // check your solutions here
    }

    /**
     * Ticket 1. How many tracks are in the playlist?
     * A playlist is stored as a list of track titles. The playlist page must show how many tracks it has.
     *
     * What to do: create a method `countTracks` with one parameter: a list of strings `tracks`. The method must return the number of elements in the list.
     *
     * - Input: tracks, the list of track titles.
     * - Return: the number of tracks. For an empty list, 0.
     *
     * Examples:
     * - countTracks(["Intro", "Solo"]) -> 2
     * - countTracks([]) -> 0 (the playlist is empty)
     *
     * Hint: A list knows how many elements it holds. Look at the method `size()`.
     */
    static int countTracks(List<String> tracks) {
        return 0;
    }

    /**
     * Ticket 2. The first track
     * When a customer presses "Play", the first track of the playlist starts.
     *
     * What to do: create a method `getFirstTrack` with one parameter: a list of strings `tracks`. The method must return the first element of the list. If the list is empty, it must return null.
     *
     * - Input: tracks, the list of track titles.
     * - Return: the first title. For an empty list, null.
     *
     * Examples:
     * - getFirstTrack(["Intro", "Solo"]) -> "Intro"
     * - getFirstTrack([]) -> null (there is no first track)
     *
     * Hint: Positions in a list are counted from 0, and `get(position)` reads an element. Reading from an empty list throws an exception, so check the size first.
     */
    static String getFirstTrack(List<String> tracks) {
        return null;
    }

    /**
     * Ticket 3. The last track
     * The playlist page shows which track will play at the very end.
     *
     * What to do: create a method `getLastTrack` with one parameter: a list of strings `tracks`. The method must return the last element of the list. If the list is empty, it must return null.
     *
     * - Input: tracks, the list of track titles.
     * - Return: the last title. For an empty list, null.
     *
     * Examples:
     * - getLastTrack(["Intro", "Solo"]) -> "Solo"
     * - getLastTrack(["Intro"]) -> "Intro" (the only track is also the last one)
     * - getLastTrack([]) -> null (there is no last track)
     *
     * Hint: Positions start from 0, so in a list of 3 elements the last position is 2. Think how to get this number from the size.
     */
    static String getLastTrack(List<String> tracks) {
        return null;
    }

    /**
     * Ticket 4. Add a track
     * A customer presses "Add to playlist", and the new track goes to the very end.
     *
     * What to do: create a method `addTrack` with two parameters: the first is a list of strings `tracks`, the second is a string `track`. The method must add `track` to the end of the list. It returns nothing, it changes `tracks` itself.
     *
     * - Input: tracks, the list of track titles; track, the title to add.
     * - Return: nothing (void). Change the list tracks itself.
     *
     * Examples:
     * - tracks = ["Intro"], addTrack(tracks, "Solo") -> tracks becomes ["Intro", "Solo"]
     * - tracks = [], addTrack(tracks, "Solo") -> tracks becomes ["Solo"]
     *
     * Hint: The method `add(element)` puts an element at the end of a list.
     */
    static void addTrack(List<String> tracks, String track) {
    }

    /**
     * Ticket 5. Reverse the playlist
     * A customer pressed "Play from the end": the playlist must go in the opposite order.
     *
     * What to do: create a method `reversePlaylist` with one parameter: a list of strings `tracks`. The method must reverse the order of the elements in this same list. It returns nothing, it changes `tracks` itself.
     *
     * - Input: tracks, the list of track titles.
     * - Return: nothing (void). Change the list tracks itself.
     *
     * Examples:
     * - tracks = ["a", "b", "c"], reversePlaylist(tracks) -> tracks becomes ["c", "b", "a"]
     * - tracks = [], reversePlaylist(tracks) -> tracks stays [] (there is nothing to reverse)
     *
     * Hint: The class `Collections` from java.util already has a method that reverses a list. Don't forget the import.
     */
    static void reversePlaylist(List<String> tracks) {
    }
}
