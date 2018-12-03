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
}
