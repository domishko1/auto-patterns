package objectPoolPattern.objects;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PooledUser {
    private String login;
    private String password;

    public PooledUser() {
        List<String> data = Arrays.asList(copyAndGetFirstLineFromFile().split(" ", 2));
        this.login = data.get(0);
        this.password = data.get(1);
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    private String copyAndGetFirstLineFromFile() {
        BufferedReader reader = null;
        PrintWriter writer = null;
        String buffLine = "";
        File file = new File("src/test/java/objectPoolPattern/data/data.txt");
        File fileToWrite = new File("src/test/java/objectPoolPattern/data/fileToWrite.txt");

        try {
            reader = new BufferedReader(new FileReader(file));
            writer = new PrintWriter(new FileWriter(fileToWrite));
            int current = 0;
            String line;
            while ((line = reader.readLine()) != null) {
                if (current != 0) {
                    writer.println(line);
                } else {
                    buffLine = line;
                }
                current++;
            }
            writer.close();
            reader.close();
            if (file.delete()) {
                fileToWrite.renameTo(file);
                System.out.println("delete and renamed");
            }
            return buffLine;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
