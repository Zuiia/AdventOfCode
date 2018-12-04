import Helper.JFileReader;

import java.util.List;

public class Day3 {


    public static void main(String[] args) {
        JFileReader reader = new JFileReader("Day3_input.txt");
        List<String> claims = reader.getLines();

        sortClaims(claims);

    }

    private static void sortClaims(List<String> claims) {
        int[][] fabric = new int[2000][2000];

        for (String claim: claims) {
            int xl = getXLen(claim) + getX(claim);
            int yl = getYLen(claim) + getY(claim);

            for (int x = getX(claim); x < xl; x++ ){
                for (int y = getY(claim); y < yl; y++) {

                    fabric[x][y]++;
                }
            }
        }

        System.out.println(countClaims(fabric));

        System.out.println(findBest(claims, fabric));
    }

    private static int countClaims(int[][] fabric) {
        int count = 0;
        for (int[] row : fabric) {
            for (int i : row) {
                if (i >= 2) count++;
            }
        }
        return count;
    }

    private static int getX(String s) {
        return Integer.parseInt(s.substring(s.indexOf("@"),s.indexOf(",")).substring(2));
    }

    private static int getY(String s) {
        return Integer.parseInt(s.substring(s.indexOf(","),s.indexOf(":")).substring(1));
    }

    private static int getXLen(String s) {
        return Integer.parseInt(s.substring(s.indexOf(":"),s.indexOf("x")).substring(2));
    }

    private static int getYLen(String s) {
        return Integer.parseInt(s.substring(s.indexOf("x")).substring(1));
    }

    private static int findBest(List<String> claims, int[][] fabric) {
        for (String claim: claims) {
            int xl = getXLen(claim) + getX(claim);
            int yl = getYLen(claim) + getY(claim);
            boolean pristine = true;

            for (int x = getX(claim); x < xl; x++ ){
                for (int y = getY(claim); y < yl; y++) {
                    if (fabric[x][y] != 1) pristine = false;
                }
            }

            if (pristine) {
               return Integer.parseInt(claim.substring(1, claim.indexOf("@") - 1));
            }
        }
        return 0;
    }
}
