package org.tl.warmup;

import java.util.List;

/**
 * PRACTICE TASKS: warm-up with ArrayList (the simplest tasks)
 *
 * You work in the support team of an online music store. Every ticket below is a small
 * situation from work and one method that you have to create. The ticket says what the method
 * is called and which parameters it takes. Its template is shown under the ticket (in WarmupListTasks.java
 * it is already there), so you only have to write the body.
 * Tickets 1-11 need one list method each: size, get, add, reverse, contains, indexOf, remove, set and isEmpty.
 * Tickets 12-15 walk through a list of track durations with a loop.
 *
 * How to read a ticket:
 * - What to do: which method to create, with which parameters, and what it must do.
 * - Input: the values the method receives.
 * - Return: what the method must give back. If it returns nothing (void), it changes the list it received.
 * - Examples: `countTracks(["Intro", "Solo"]) -> 2` means "call the method with this list, and it must return 2".
 * - The notation `["Intro", "Solo"]` is a short way to show a list. In Java code write `new ArrayList<>(List.of("Intro", "Solo"))`.
 * - Durations are given in seconds: `[200, 45]` is a list of two tracks, 3:20 and 0:45.
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

    /**
     * Ticket 6. Is the track in the playlist?
     * Next to every track in the store there is a button "Add to playlist". If the track is already in the playlist, the button must be grey.
     *
     * What to do: create a method `hasTrack` with two parameters: the first is a list of strings `tracks`, the second is a string `track`. The method must return true if `track` is in the list, and false if it is not.
     *
     * - Input: tracks, the list of track titles; track, the title to look for.
     * - Return: true if the track is in the playlist, otherwise false.
     *
     * Examples:
     * - hasTrack(["Intro", "Solo"], "Solo") -> true
     * - hasTrack(["Intro", "Solo"], "Outro") -> false
     * - hasTrack([], "Solo") -> false (an empty playlist has no tracks)
     *
     * Hint: You don't need a loop. A list has the method `contains(element)`.
     */
    static boolean hasTrack(List<String> tracks, String track) {
        return false;
    }

    /**
     * Ticket 7. Where is the track?
     * A customer asks: "What number is my favourite track in the playlist?". Support needs its position.
     *
     * What to do: create a method `findTrackPosition` with two parameters: the first is a list of strings `tracks`, the second is a string `track`. The method must return the position of `track` in the list. If the track is not there, it must return -1.
     *
     * - Input: tracks, the list of track titles; track, the title to look for.
     * - Return: the position of the track (counted from 0). If the track is not in the list, -1.
     *
     * Examples:
     * - findTrackPosition(["Intro", "Solo", "Outro"], "Solo") -> 1
     * - findTrackPosition(["Intro", "Solo"], "Intro") -> 0 (the first position is 0)
     * - findTrackPosition(["Intro", "Solo"], "Outro") -> -1 (there is no such track)
     *
     * Hint: The method `indexOf(element)` returns the position of an element, and -1 if the element is not in the list.
     */
    static int findTrackPosition(List<String> tracks, String track) {
        return 0;
    }

    /**
     * Ticket 8. Remove a track by its title
     * A customer presses "Remove from playlist" next to a track.
     *
     * What to do: create a method `removeTrack` with two parameters: the first is a list of strings `tracks`, the second is a string `track`. The method must remove `track` from the list. If the track is not there, the list stays as it is. It returns nothing, it changes `tracks` itself.
     *
     * - Input: tracks, the list of track titles; track, the title to remove.
     * - Return: nothing (void). Change the list tracks itself.
     *
     * Examples:
     * - tracks = ["Intro", "Solo", "Outro"], removeTrack(tracks, "Solo") -> tracks becomes ["Intro", "Outro"]
     * - tracks = ["Intro"], removeTrack(tracks, "Outro") -> tracks stays ["Intro"] (there is nothing to remove)
     *
     * Hint: A list has two `remove` methods. `remove(position)` takes a number, `remove(element)` takes the element itself. Here you have the element.
     */
    static void removeTrack(List<String> tracks, String track) {
    }

    /**
     * Ticket 9. Replace a track
     * The label sent a remastered version of a track. It must take the place of the old one, at the same position.
     *
     * What to do: create a method `replaceTrack` with three parameters: a list of strings `tracks`, a number `position` and a string `track`. The method must put `track` at `position` instead of the old title. The size of the list does not change. It returns nothing, it changes `tracks` itself. The position always exists.
     *
     * - Input: tracks, the list of track titles; position, which position to change (from 0); track, the new title.
     * - Return: nothing (void). Change the list tracks itself.
     *
     * Examples:
     * - tracks = ["Intro", "Solo", "Outro"], replaceTrack(tracks, 1, "Solo (Remastered)") -> tracks becomes ["Intro", "Solo (Remastered)", "Outro"]
     * - tracks = ["Intro"], replaceTrack(tracks, 0, "Intro (Live)") -> tracks becomes ["Intro (Live)"]
     *
     * Hint: The method `set(position, element)` writes an element over the old one. Don't confuse it with `add`, which makes the list longer.
     */
    static void replaceTrack(List<String> tracks, int position, String track) {
    }

    /**
     * Ticket 10. Play next
     * A customer presses "Play next": the track must go to the very beginning of the playlist.
     *
     * What to do: create a method `addTrackToStart` with two parameters: the first is a list of strings `tracks`, the second is a string `track`. The method must put `track` at the beginning of the list, all the other tracks move one position to the right. It returns nothing, it changes `tracks` itself.
     *
     * - Input: tracks, the list of track titles; track, the title to add.
     * - Return: nothing (void). Change the list tracks itself.
     *
     * Examples:
     * - tracks = ["Intro", "Solo"], addTrackToStart(tracks, "Outro") -> tracks becomes ["Outro", "Intro", "Solo"]
     * - tracks = [], addTrackToStart(tracks, "Solo") -> tracks becomes ["Solo"]
     *
     * Hint: `add` can take two arguments: `add(position, element)` puts the element at this position.
     */
    static void addTrackToStart(List<String> tracks, String track) {
    }

    /**
     * Ticket 11. Is the playlist empty?
     * Instead of an empty table, an empty playlist shows the text "Add your first track".
     *
     * What to do: create a method `isPlaylistEmpty` with one parameter: a list of strings `tracks`. The method must return true if the list has no elements, and false if it has at least one.
     *
     * - Input: tracks, the list of track titles.
     * - Return: true for an empty list, otherwise false.
     *
     * Examples:
     * - isPlaylistEmpty([]) -> true
     * - isPlaylistEmpty(["Intro"]) -> false
     *
     * Hint: `size() == 0` works, but a list has a method made exactly for this: `isEmpty()`.
     */
    static boolean isPlaylistEmpty(List<String> tracks) {
        return false;
    }

    /**
     * Ticket 12. The longest track
     * A customer wants to know how long the longest track of the playlist is.
     *
     * What to do: create a method `longestTrack` with one parameter: a list of numbers `durations`. The method must return the biggest element of the list. If the list is empty, it must return 0.
     *
     * - Input: durations, the durations of the tracks in seconds.
     * - Return: the biggest duration. For an empty list, 0.
     *
     * Examples:
     * - longestTrack([200, 45, 300]) -> 300
     * - longestTrack([45]) -> 45 (the only track is also the longest one)
     * - longestTrack([]) -> 0 (there are no tracks)
     *
     * Hint: Keep the biggest duration seen so far in a variable. Every element that is bigger replaces it.
     */
    static int longestTrack(List<Integer> durations) {
        return 0;
    }

    /**
     * Ticket 13. How many long tracks?
     * The store marks tracks longer than 3 minutes (more than 180 seconds) with the label "long". Count how many such tracks are in the playlist.
     *
     * What to do: create a method `countLongTracks` with one parameter: a list of numbers `durations`. The method must return how many elements are bigger than 180.
     *
     * - Input: durations, the durations of the tracks in seconds.
     * - Return: how many durations are bigger than 180. For an empty list, 0.
     *
     * Examples:
     * - countLongTracks([200, 45, 300]) -> 2
     * - countLongTracks([180, 60]) -> 0 (exactly 180 seconds is not "longer than 3 minutes")
     * - countLongTracks([]) -> 0
     *
     * Hint: A counter that starts at 0, a loop and one `if` inside it.
     */
    static int countLongTracks(List<Integer> durations) {
        return 0;
    }

    /**
     * Ticket 14. Only short tracks
     * The "Quick break" mode plays only tracks shorter than 3 minutes (less than 180 seconds). The original playlist must not change.
     *
     * What to do: create a method `shortTracks` with one parameter: a list of numbers `durations`. The method must return a new list with only the elements smaller than 180, in the same order. The list `durations` must stay as it was.
     *
     * - Input: durations, the durations of the tracks in seconds.
     * - Return: a new list with the durations smaller than 180. If there are none, an empty list.
     *
     * Examples:
     * - shortTracks([200, 45, 120, 300]) -> [45, 120]
     * - shortTracks([200, 300]) -> [] (there are no short tracks)
     *
     * Hint: Create an empty `new ArrayList<>()` before the loop and `add` the right elements into it. Don't change `durations`.
     */
    static List<Integer> shortTracks(List<Integer> durations) {
        return null;
    }

    /**
     * Ticket 15. Remove the jingles
     * Very short tracks (less than 60 seconds) are jingles and ads. They must be removed from the playlist itself.
     *
     * What to do: create a method `removeJingles` with one parameter: a list of numbers `durations`. The method must remove all elements smaller than 60 from this same list. It returns nothing, it changes `durations` itself.
     *
     * - Input: durations, the durations of the tracks in seconds.
     * - Return: nothing (void). Change the list durations itself.
     *
     * Examples:
     * - durations = [200, 30, 45, 300], removeJingles(durations) -> durations becomes [200, 300]
     * - durations = [200, 300], removeJingles(durations) -> durations stays [200, 300] (there is nothing to remove)
     *
     * Hint: Don't remove inside `for (int d : durations)`: Java throws ConcurrentModificationException. Go by positions from the end to the start and use `remove(position)`, or try the method `removeIf`.
     */
    static void removeJingles(List<Integer> durations) {
    }
}
