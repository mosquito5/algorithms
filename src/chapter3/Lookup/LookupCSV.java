package chapter3.Lookup;

import Libs.File_lib;
import Libs.Input;

import java.util.Scanner;

public class LookupCSV {
    File_lib file_lib;
    Scanner scanner;
    int keyFiled;
    int valFiled;
    ST<String, String> st = new ST<String, String>();


    public LookupCSV(String FileName, int keyFiled, int valFiled) {
        file_lib        = new File_lib(FileName);
        scanner         = file_lib.getScanner();
        this.keyFiled   = keyFiled;
        this.valFiled   = valFiled;
        look();
    }

    private void look() {
        while (scanner.hasNextLine()) {
            String line         = scanner.nextLine();
            String[] tokens     = line.split(".");
            String key          = tokens[keyFiled];
            String val          = tokens[valFiled];
        }
    }

    public void show() {
        while (!Input.isEmpty()) {
            String query = Input.readString();
            if(st.contains(query))
                System.out.println(st.get(query));

        }
    }
}
