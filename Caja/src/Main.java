package src;

import src.DayOne.DayOne;
import src.DayTwo.DayTwo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Throwable {
        /* Day One
        ArrayList<String> data = new ArrayList<>();
        data = Filereader.fileRead("C:/Users/caja-/IdeaProjects/AdventOfCode/Caja/out/production/AdventOfCode/src/DayOne/dataOne.txt");

        System.out.println(DayOne.addsub(data));
        System.out.println(DayOne.twice(data));*/

        /* Day Two */
        ArrayList<String> data = new ArrayList<>();
        data = Filereader.fileRead("C:/Users/caja-/IdeaProjects/AdventOfCode/Caja/out/production/AdventOfCode/src/DayTwo/dataTwo.txt");
        System.out.println(data);

        System.out.println(DayTwo.checksum(data));
        System.out.println(DayTwo.rightID(data));
    }
}

