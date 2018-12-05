package src.Day2;
import src.Filereader;
import java.util.ArrayList;

public class MainTwo {
    public static void main(String [] args) throws Throwable {
        ArrayList<String> data = new ArrayList<>();
        data = Filereader.fileRead("C:/Users/caja-/IdeaProjects/AdventOfCode/Caja/out/production/AdventOfCode/src/Day2/dataTwo.txt");
        System.out.println(data);

        System.out.println(DayTwo.checksum(data));
        System.out.println(DayTwo.rightID(data));
    }
}
