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

        List<String> three = new ArrayList<>(List.of("Intro", "Solo", "Outro"));
        System.out.println(hasTrack(two, "Solo"));                    // true
        System.out.println(hasTrack(two, "Outro"));                   // false
        System.out.println(hasTrack(empty, "Solo"));                  // false

        System.out.println(findTrackPosition(three, "Solo"));         // 1
        System.out.println(findTrackPosition(two, "Intro"));          // 0
        System.out.println(findTrackPosition(two, "Outro"));          // -1

        List<String> toRemove = new ArrayList<>(three);
        removeTrack(toRemove, "Solo");
        System.out.println(toRemove);                                 // [Intro, Outro]
        List<String> single = new ArrayList<>(List.of("Intro"));
        removeTrack(single, "Outro");
        System.out.println(single);                                   // [Intro]

        List<String> toReplace = new ArrayList<>(three);
        replaceTrack(toReplace, 1, "Solo (Remastered)");
        System.out.println(toReplace);                                // [Intro, Solo (Remastered), Outro]
        replaceTrack(single, 0, "Intro (Live)");
        System.out.println(single);                                   // [Intro (Live)]

        List<String> next = new ArrayList<>(two);
        addTrackToStart(next, "Outro");
        System.out.println(next);                                     // [Outro, Intro, Solo]
        List<String> nextEmpty = new ArrayList<>();
        addTrackToStart(nextEmpty, "Solo");
        System.out.println(nextEmpty);                                // [Solo]

        System.out.println(isPlaylistEmpty(new ArrayList<>()));       // true
        System.out.println(isPlaylistEmpty(List.of("Intro")));        // false

        List<Integer> durations = new ArrayList<>(List.of(200, 45, 300));
        List<Integer> noDurations = new ArrayList<>();
        System.out.println(longestTrack(durations));                  // 300
        System.out.println(longestTrack(List.of(45)));                // 45
        System.out.println(longestTrack(noDurations));                // 0

        System.out.println(countLongTracks(durations));               // 2
        System.out.println(countLongTracks(List.of(180, 60)));        // 0
        System.out.println(countLongTracks(noDurations));             // 0

        List<Integer> mixed = new ArrayList<>(List.of(200, 45, 120, 300));
        System.out.println(shortTracks(mixed));                       // [45, 120]
        System.out.println(mixed);                                    // [200, 45, 120, 300]: unchanged
        System.out.println(shortTracks(List.of(200, 300)));           // []

        List<Integer> withJingles = new ArrayList<>(List.of(200, 30, 45, 300));
        removeJingles(withJingles);
        System.out.println(withJingles);                              // [200, 300]
        List<Integer> noJingles = new ArrayList<>(List.of(200, 300));
        removeJingles(noJingles);
        System.out.println(noJingles);                                // [200, 300]
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

    static boolean hasTrack(List<String> tracks, String track) {
        return tracks.contains(track);
    }

    static int findTrackPosition(List<String> tracks, String track) {
        return tracks.indexOf(track);         // -1 if the track is not in the list
    }

    static void removeTrack(List<String> tracks, String track) {
        tracks.remove(track);                 // remove(Object): removes the first equal element, if there is one
    }

    static void replaceTrack(List<String> tracks, int position, String track) {
        tracks.set(position, track);          // the size stays the same
    }

    static void addTrackToStart(List<String> tracks, String track) {
        tracks.add(0, track);                 // the others move one position to the right
    }

    static boolean isPlaylistEmpty(List<String> tracks) {
        return tracks.isEmpty();
    }

    static int longestTrack(List<Integer> durations) {
        int max = 0;                          // durations are never negative, so 0 also covers the empty list
        for (int d : durations) {
            if (d > max) {
                max = d;
            }
        }
        return max;
    }

    static int countLongTracks(List<Integer> durations) {
        int count = 0;
        for (int d : durations) {
            if (d > 180) {
                count++;
            }
        }
        return count;
    }

    static List<Integer> shortTracks(List<Integer> durations) {
        List<Integer> result = new ArrayList<>();
        for (int d : durations) {
            if (d < 180) {
                result.add(d);
            }
        }
        return result;
    }

    static void removeJingles(List<Integer> durations) {
        // from the end: removing an element does not move the ones we have not checked yet
        for (int i = durations.size() - 1; i >= 0; i--) {
            if (durations.get(i) < 60) {
                durations.remove(i);          // i is an int, so this is remove(position)
            }
        }
        // shorter: durations.removeIf(d -> d < 60);
    }
}
