package src.DayOne;

import java.util.ArrayList;

public class DayOne {
    public static int addsub(ArrayList<String> input) {
        int result = 0;
        for (String s : input) {
            if (s.charAt(0) == '+') {
                result += Integer.parseInt(s.substring(1));
            } else {
                result -= Integer.parseInt(s.substring(1));
            }
        }
        return result;
    }

    public static int twice(ArrayList<String> input) {
        int result = 0;
        int bigCount = 0;
        ArrayList<Integer> results = new ArrayList<>();
        do {
            for (String s : input) {
                if (s.charAt(0) == '+') {
                    result += Integer.parseInt(s.substring(1));
                } else {
                    result -= Integer.parseInt(s.substring(1));
                }

                if (results.contains(result)) {
                    System.out.println(bigCount);
                    return result;
                }
                results.add(result);
            }
            bigCount++;
        } while (true);
    }
}
