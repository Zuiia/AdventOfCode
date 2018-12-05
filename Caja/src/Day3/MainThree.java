package src.Day3;
import src.Filereader;
import java.util.ArrayList;

public class MainThree {
    public static void main (String[] args) throws Throwable /* von Jonsch so gelernt*/ {
        ArrayList<String> data = new ArrayList<>();
        data = Filereader.fileRead("C:/Users/caja-/IdeaProjects/AdventOfCode/Caja/out/production/AdventOfCode/src/Day3/dataThree.txt");

        ArrayList<Claim> allClaims = DayThree.getAllClaim(data);
        int ergebnis = DayThree.doubleUsedFabric(allClaims);
        System.out.println(ergebnis);
    }
}
