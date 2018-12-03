package src.DayTwo;

import java.util.ArrayList;

public class DayTwo {
    public static int checksum(ArrayList<String> input) {
        int checksumResult = 0;
        ArrayList<String> twos = new ArrayList<>();
        ArrayList<String> threes = new ArrayList<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";


        for (String s : input) {

            for (int i = 0; i < 26; i++) {
                if (countChar(s, alphabet.charAt(i)) == 2) {
                    twos.add(s);
                    break;
                }
            }

            for (int i = 0; i < 26; i++) {
                if (countChar(s, alphabet.charAt(i)) == 3) {
                    threes.add(s);
                    break;
                }
            }
        }

        checksumResult = twos.size() * threes.size();
        return checksumResult;

    }

    public static int countChar(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == c)
                count++;
        }
        return count;
    }

    public static String rightID(ArrayList<String> input) {
        String sameChars = "";
        ArrayList<String> nearlyTwins = new ArrayList<>();
        for (String first : input) {
            for (String second : input) {
                if (nearlySame(first, second)) {
                    nearlyTwins.add(first);
                    nearlyTwins.add(second);
                }
            }
        }

        // BEWARE This is ugly and hardcoded ( i don't know why every word is doubled in the arry, i guess something with the for-loops but I'm to lazy to check...
        for (int i = 0; i < nearlyTwins.get(1).length(); i++) {
            if ((nearlyTwins.get(1).charAt(i) == nearlyTwins.get(0).charAt(i))) {
                sameChars += nearlyTwins.get(1).charAt(i);
            }
        }
        System.out.println(nearlyTwins);
        return sameChars;
    }

    public static boolean nearlySame (String first, String second) {
        int difference = 0;

        for (int i = 0; i < first.length(); i++) {
            if (!(first.charAt(i) == second.charAt(i))) {
                difference++;
                if (difference > 1) {
                    return false;
                }
            }
        }
        if (difference == 1) {
            return true;
        }
        return false;
    }
}
