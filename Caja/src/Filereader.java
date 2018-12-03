package src;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Filereader {
    public static ArrayList<String> fileRead(String verzeichnis) throws FileNotFoundException {
        Scanner inhaltDatei = new Scanner(new FileReader(verzeichnis));
        ArrayList<String> inhalt = new ArrayList<String>();

        while (inhaltDatei.hasNext()) {
            inhalt.add(inhaltDatei.nextLine());
        }

        return inhalt;
    }
}