package chapter2.libs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class File_lib {
    private String name;

    public File_lib(String name) {
            this.name = name;
    }

    /**
     * reading strings line by line to array
     */

    public String[] readToArray() {
        List<String> lines = new ArrayList<String>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(name));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }

            bufferedReader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lines.toArray(new String[lines.size()]);
    }

}

