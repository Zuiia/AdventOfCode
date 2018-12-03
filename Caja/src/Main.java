package src;

import src.DayOne.DayOne;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Throwable {
        ArrayList<String> data = new ArrayList<>();
        data = Filereader.fileRead("C:/Users/caja-/IdeaProjects/AdventOfCode/Caja/out/production/AdventOfCode/src/DayOne/dataOne.txt");
        System.out.println(data);

        System.out.println(DayOne.addsub(data));
        System.out.println(DayOne.twice(data));
    }
}

