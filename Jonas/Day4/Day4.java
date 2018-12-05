package Day4;

import Helper.JFileReader;

import java.util.*;

public class Day4 {
    public static void main (String[] args) {
        JFileReader reader = new JFileReader("Day4/input.txt");
        List<String> entries = reader.getLines();

        Collections.sort(entries);

        List<GuardListEntry> guardListEntries = new ArrayList<>();

        for (String s : entries) {
            guardListEntries.add(new GuardListEntry(s));
        }

        Map<Integer, Guard> guards = organizeGuards(guardListEntries);

        System.out.println("Part 1: " + methodOne(guards));

        System.out.println("Part 2: " + methodTwo(guards));
    }

    private static Map<Integer, Guard> organizeGuards(List<GuardListEntry> list) {
        Map<Integer, Guard> guardMap = new HashMap<Integer, Guard>();
        int id = 0;

        for (GuardListEntry e : list) {
            if (e.getText().charAt(0) == 'G') {

                String s = e.getText().substring(7);
                id = Integer.parseInt(s.substring(0, s.indexOf(" ")));

                if (guardMap.get(id) == null) guardMap.put(id, new Guard(id));

            } else {

                guardMap.get(id).change(e.getMinute());

            }

        }

        guardMap.get(id).change(60);

        return guardMap;
    }

    private static int methodOne (Map<Integer, Guard> guardMap) {
        int longest = 0;
        int longestId = 0;

        for (Guard g: guardMap.values()) {
            if (g.getTotalSleep() > longest) {
                longest = g.getTotalSleep();
                longestId = g.getID();
            }
        }

        return (longestId * guardMap.get(longestId).getMaxSleep());
    }

    private static int methodTwo (Map<Integer, Guard> guardMap) {
        int frequent = 0;
        int frequentMin = 0;
        int frequentId = 0;

        for (int i = 0; i < 60; i++) {
            for (Guard g: guardMap.values()) {
                if (g.getSleepByMin(i) > frequent) {
                    frequent = g.getSleepByMin(i);
                    frequentMin = i;
                    frequentId = g.getID();
                }
            }
        }

        return (frequentId * frequentMin);
    }
}
