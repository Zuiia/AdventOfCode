package Day5;

import Helper.JFileReader;

public class Day5 {
    public static void main (String[] args) {
        JFileReader reader = new JFileReader("Day5/input.txt");
        String polymers = reader.getText();

        System.out.println("Part 1: " + destroy(polymers.replaceAll("\\s+","")));
    }

    private static int destroy (String polymers) {
        StringBuilder polyBomb = new StringBuilder(polymers);

        boolean complete = false;

        while (!complete) {
            complete = true;

            for (int i = 0; i < polyBomb.length() - 1;) {
                if (react(polyBomb.toString(), i)) {
                    polyBomb.delete(i,i+2);
                    complete = false;
                } else {
                    i++;
                }
            }

        }

        System.out.println(polyBomb.toString());
        return polyBomb.length();
    }

    private static boolean react (String polys, int pos) {
        char c1 = polys.charAt(pos);
        char c2 = polys.charAt(pos + 1);

        if (Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
            return (Character.isLowerCase(c1) && Character.isUpperCase(c2)) || (Character.isLowerCase(c2) && Character.isUpperCase(c1));
        }

        return false;
    }
}
