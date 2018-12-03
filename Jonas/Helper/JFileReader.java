package Helper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class JFileReader {
    private String text;
    private List<String> lines = new ArrayList<>();

    public JFileReader(String file) {
        text = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Jonas/" + file));
            StringBuilder sb = new StringBuilder();

            String line = reader.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());

                lines.add(line);

                line = reader.readLine();
            }

            text = sb.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getText () {
        return text;
    }

    public List<String> getLines () {
        return lines;
    }
}
