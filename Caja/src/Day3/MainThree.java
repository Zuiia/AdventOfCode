package src.Day3;
import Helper.JFileReader;
import src.Filereader;
import java.util.ArrayList;
import java.util.List;

public class MainThree {
    public static void main (String[] args) throws Throwable /* von Jonsch so gelernt*/ {
        ArrayList<String> data = new ArrayList<>();
        data = Filereader.fileRead("C:/Users/caja-/IdeaProjects/AdventOfCode/Caja/out/production/AdventOfCode/src/Day3/dataThree.txt");

        ArrayList<Claim> allClaims = DayThree.getAllClaim(data);
        int[][] fabricPiece = DayThree.doubleUsedFabric(allClaims);
        int result = DayThree.countUsedFabric(fabricPiece);
        ArrayList<Claim> theBestClaim = DayThree.findBest(allClaims, fabricPiece);
        System.out.println(theBestClaim.get(0).id);
    }
}
