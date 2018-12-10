package Day2;

import Helper.JFileReader;

import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        JFileReader reader = new JFileReader("Day2/input.txt");
        List<String> boxes = reader.getLines();

        int zwei = 0;
        int drei = 0;

        for (String s : boxes) {
            if (has(s, 2)) zwei++;
            if (has(s, 3)) drei++;
        }

        System.out.println(zwei * drei);

        System.out.println(findPrototype(boxes));
    }

    private static boolean has(String s, int i) {

        while (s.length() > 0) {
            if (occurances(s) == i) return true;
            s = s.replaceAll(String.valueOf(s.charAt(0)), "");
        }

        return false;
    }

    private static int occurances(String s) {
        char c = s.charAt(0);
        int occ = 1;
        for (int x = 1; x < s.length(); x++) {
            if (s.charAt(x) == c) occ++;
        }
        return occ;
    }

    private static String findPrototype(List<String> boxes) {
        int i = 0;
        while (true) {
            List<String> neu = cull(i, boxes);

            for (int x = 0; x <= neu.size()-1; x++) {
                if (neu.subList(x+1, neu.size()).contains(neu.get(x))) return neu.get(x);
            }

            i++;
        }
    }

    private static List<String> cull(int i, List<String> boxes) {
        List<String> test = new ArrayList<>();
        for (String s: boxes) {
            StringBuilder builder = new StringBuilder(s);
            builder.deleteCharAt(i);
            test.add(builder.toString());
        }
        return test;
    }
}
