package chapter2.libs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class File_lib {
    private String name;

    public File_lib(String name) {
            this.name = name;
    }

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

