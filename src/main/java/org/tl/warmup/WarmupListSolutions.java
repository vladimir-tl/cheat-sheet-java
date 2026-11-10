package org.tl.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * SOLUTIONS: warm-up with ArrayList. Look only after you've tried the tasks.
 */
public class WarmupListSolutions {

    public static void main(String[] args) {
        List<String> two = new ArrayList<>(List.of("Intro", "Solo"));
        List<String> empty = new ArrayList<>();

        System.out.println(countTracks(two));                         // 2
        System.out.println(countTracks(empty));                       // 0

        System.out.println(getFirstTrack(two));                       // Intro
        System.out.println(getFirstTrack(empty));                     // null

        System.out.println(getLastTrack(two));                        // Solo
        System.out.println(getLastTrack(new ArrayList<>(List.of("Intro")))); // Intro
        System.out.println(getLastTrack(empty));                      // null

        List<String> one = new ArrayList<>(List.of("Intro"));
        addTrack(one, "Solo");
        System.out.println(one);                                      // [Intro, Solo]
        List<String> none = new ArrayList<>();
        addTrack(none, "Solo");
        System.out.println(none);                                     // [Solo]

        List<String> abc = new ArrayList<>(List.of("a", "b", "c"));
        reversePlaylist(abc);
        System.out.println(abc);                                      // [c, b, a]
        reversePlaylist(empty);
        System.out.println(empty);                                    // []
    }

    static int countTracks(List<String> tracks) {
        return tracks.size();
    }

    static String getFirstTrack(List<String> tracks) {
        if (tracks.size() == 0) {
            return null;                      // get(0) on an empty list would throw IndexOutOfBoundsException
        }
        return tracks.get(0);
    }

    static String getLastTrack(List<String> tracks) {
        if (tracks.size() == 0) {
            return null;
        }
        return tracks.get(tracks.size() - 1); // positions start from 0, so the last one is size - 1
    }

    static void addTrack(List<String> tracks, String track) {
        tracks.add(track);
    }

    static void reversePlaylist(List<String> tracks) {
        Collections.reverse(tracks);
    }
}
