package chapter2.Sort;

import chapter2.libs.File_lib;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    static File_lib file;
    static Comparable<String>[] data;

    public static void main(String[] args) {

    /*Shell_sort shell_sort;
    Insert_sort insert_sort;
    Select_sort select_sort;*/

    Scanner scanner = new Scanner(System.in);

    byte select;

    /*System.out.print("Type file name with extensions: ");
    if(scanner.hasNext()) {*/
        file = new File_lib("input");
        data = file.readToArray();

    //}

    System.out.println("Choose type of sort.\n1-Insert sort\n2-Select sort\n3-Shell sort");

        try {
            sort_algs((char) System.in.read());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    static void sort_algs(char select) {
        switch (select) {
            case '1':
                System.out.println("Insert sort");
                Insert_sort insert_sort = new Insert_sort(data);
                insert_sort.sort();
                break;
            case '2':
                System.out.println("Select sort");
                Select_sort select_sort = new Select_sort(data);
                select_sort.sort();
                break;
            case '3':
                System.out.println("Shell sort");
                Shell_sort shell_sort = new Shell_sort(data);
                shell_sort.sort();
                break;

            default:
                System.out.println("Wrong select");
        }

    }
}
