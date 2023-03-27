package dataRegistryPattern.objects;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class SearchRegistry {
    private static AtomicInteger COUNTER = new AtomicInteger(0);

    public static String getSearchText() {
        int index = COUNTER.getAndIncrement();
        return getFilmNameFromFile(index);
    }

    private static String getFilmNameFromFile(int lineNum) {
        try(FileReader fr = new FileReader("src/test/java/dataRegistryPattern/data/filmNames.txt"))
        {
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            int count = 0;
            while (line != null) {
                if (count == lineNum) {
                    return line;
                }
                line = reader.readLine();
                count++;
            }
            return line;
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
            return "";
        }
    }
}
