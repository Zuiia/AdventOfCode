import Helper.JFileReader;

import java.util.ArrayList;
import java.util.List;

public class Day1_1 {
    public static void main (String args[]) {
        JFileReader reader = new JFileReader("Day1_1_input.txt");
        List<String> frequencys =  reader.getLines();

        int x = 0;

        for (String s : frequencys) {
            if (s.charAt(0) == '+') {
                x += step(s);
            } else {
                x -= step(s);
            }
        }
        System.out.println(x);

        System.out.println(firstRepeat(frequencys));
    }

    private static int firstRepeat(List<String> freq) {
        List<Integer> visited = new ArrayList<>();
        int x = 0;
        int count = 0;

        while (true) {
            System.out.println(count++);
            for (String s : freq) {
                //calculate next frequency
                if (s.charAt(0) == '+') {
                    x += step(s);
                } else {
                    x -= step(s);
                }
                //check if the frequency was visited before
                for (int y : visited) {
                    if (y == x) {
                        return x;
                    }
                }
                //add frequency to the visited frequencies
                visited.add(x);
            }
        }
    }

    private static int step (String s) {
        return Integer.parseInt(s.substring(1));
    }
}
