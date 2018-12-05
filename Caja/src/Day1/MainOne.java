package src.Day1;

import src.Filereader;

import java.util.ArrayList;

public class MainOne {
    public static void main(String [] args) throws Throwable {
        ArrayList<String> data = new ArrayList<>();
        data = Filereader.fileRead("C:/Users/caja-/IdeaProjects/AdventOfCode/Caja/out/production/AdventOfCode/src/Day1/dataOne.txt");

        System.out.println(DayOne.addsub(data));
        System.out.println(DayOne.twice(data));
    }
}
