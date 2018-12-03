import Helper.JFileReader;

import java.util.List;

public class Day2 {
    public static void main(String[] args) {
        JFileReader reader = new JFileReader("Day2_1_input.txt");
        List<String> boxes = reader.getLines();

        int zwei = 0;
        int drei = 0;

        for (String s : boxes) {
            if (has(s, 2)) zwei++;
            if (has(s, 3)) drei++;
        }

        System.out.println(zwei * drei);
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
}
