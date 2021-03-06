package src.Day3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DayThree {


    /**
     * converts all the strings from one StringArrayList into Claims
     *
     * @param allClaimsString all Strings
     * @return all Claims
     */
    public static ArrayList<Claim> getAllClaim(ArrayList<String> allClaimsString) {
        ArrayList<Claim> allClaimsClaims = new ArrayList<>();
        for (int i = 0; i < allClaimsString.size(); i++) {
            allClaimsClaims.add(splice(allClaimsString.get(i)));
        }
        return allClaimsClaims;
    }

    /**
     * creates an array of the fabric piece with all used inches marked
     * @param allClaims all the Claims
     * @return multidimensional arry
     */
    public static int[][] doubleUsedFabric(ArrayList<Claim> allClaims) {
        int[][] fabricPiece = new int[1000][1000];

        for (int i = 0; i < allClaims.size(); i++) {
            int top = allClaims.get(i).top;
            int left = allClaims.get(i).left;
            int width = allClaims.get(i).width;
            int height = allClaims.get(i).height;

            for (int horizontal = left; horizontal < width + left; horizontal++) {
                for (int vertikal = top; vertikal < top + height; vertikal++) {
                    fabricPiece[vertikal][horizontal]++;
                }
            }
        }

        return fabricPiece;
    }

    /**
     * counts the doubleused fabric inches
     * @param fabricPiece Array of the used fabric
     * @return returns count of used pieces
     */
    public static int countUsedFabric(int[][] fabricPiece) {

        int count = 0;

        for (int i = 0; i < fabricPiece.length; i++) {
            for (int j = 0; j < fabricPiece.length; j++) {
                if (fabricPiece[j][i] > 1) {
                    count++;
                }
            }
        }

        return count;
    }

    /**
     * finds the One Claim without Problems
     * @param allClaims all the Claims
     * @param fabricPiece the fabricPiece with claimed Spaces
     * @return returns ArrayList with only one Claim in it
     */
    public static ArrayList<Claim> findBest(ArrayList<Claim> allClaims, int[][] fabricPiece) {

        ArrayList<Claim> theBest = new ArrayList<>();
        theBest = (ArrayList<Claim>)allClaims.clone();


        for (int i = 0; i < allClaims.size(); i++) {
            int top = allClaims.get(i).top;
            int left = allClaims.get(i).left;
            int width = allClaims.get(i).width;
            int height = allClaims.get(i).height;

            for (int horizontal = left; horizontal < width + left; horizontal++) {
                for (int vertikal = top; vertikal < top + height; vertikal++) {
                    if (fabricPiece[vertikal][horizontal] > 1) {
                        Claim removeClaim = allClaims.get(i);
                        if (theBest.indexOf(removeClaim) != -1) {
                            theBest.remove(theBest.get(theBest.indexOf(removeClaim)));
                        }
                    };
                }
            }
        }

        return theBest;

    }


    /**
     * splices One String in all individual parameters
     *
     * @param s big String
     * @return all parameters inside one Claim Object
     */
    public static Claim splice(String s) {
        int id = spliceID(s);
        int left = spliceleft(s);
        int top = splicetop(s);
        int width = splicewidth(s);
        int height = spliceheight(s);

        return new Claim(id, left, top, width, height);

    }

    /**
     * gets the ID from input
     * @param s String of Claim
     * @return ID
     */
    public static int spliceID(String s) {
        String segments[] = s.split("#");
        String first = segments[1];
        String segments2[] = first.split(" @");
        return Integer.parseInt(segments2[0]);
    }

    /**
     * gets the space from left
     *
     * @param s big string
     * @return left-parameter
     */
    public static int spliceleft(String s) {
        String segments[] = s.split("@ ");
        String first = segments[1];
        String segments2[] = first.split(",");
        return Integer.parseInt(segments2[0]);
    }

    /**
     * gets the space from top
     *
     * @param s big string
     * @return top-parameter
     */
    public static int splicetop(String s) {
        String segments[] = s.split(",");
        String first = segments[1];
        String segments2[] = first.split(":");
        return Integer.parseInt(segments2[0]);
    }

    /**
     * gets the width of the claim
     *
     * @param s big string
     * @return width
     */
    public static int splicewidth(String s) {
        String segments[] = s.split(": ");
        String first = segments[1];
        String segments2[] = first.split("x");
        return Integer.parseInt(segments2[0]);
    }

    /**
     * gets the height of the claim
     *
     * @param s big string
     * @return height
     */
    public static int spliceheight(String s) {
        String segments[] = s.split("x");
        return Integer.parseInt(segments[1]);
    }
}
