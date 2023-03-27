package dataProviderPattern.objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class FileUtil {

    public static List<String> getRandomLoginDataFromFile() {
        List<String> data = null;
        try (FileReader fr = new FileReader("src/test/java/dataProviderPattern/data/data.txt")) {
            BufferedReader reader = new BufferedReader(fr);
            Random random = new Random();

            String line = reader.readLine();
            int count = 1;

            int lineCount = Integer.parseInt(line);
            int lineNumToReturn = random.nextInt(lineCount) + 1;

            while (line != null && lineCount <= count) {
                line = reader.readLine();

                if (lineNumToReturn == count) {
                    data = Arrays.asList(line.split(" ", 2));
                    return data;
                }
                count++;
            }
            return data;
        } catch (IOException ex) {
            return null;
        }
    }
}
