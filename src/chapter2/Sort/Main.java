package chapter2.Sort;

import chapter2.libs.File_lib;

import java.io.IOException;

import static chapter2.libs.Sort_lib.show;

public class Main {
    static File_lib file;
    static int[] data;

    public static void main(String[] args) {
        file = new File_lib("input");
        data = file.intRead();




    System.out.println("Choose type of sort.\n1-Insert sort\n2-Select sort\n3-Shell sort\n" +
            "4-Merge sort\n5-Quick sort\n6-Heap sort");

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
            case '4':
                System.out.println("Merge sort");
                Merge_sort merge_sort = new Merge_sort(data);
                merge_sort.sort();
                break;
            case '5':
                System.out.println("Quick sort");
                Quick_sort quick_sort = new Quick_sort(data);
                quick_sort.sort();
                break;
            case '6':
                System.out.println("Heap sort");
                Heap_sort heap_sort = new Heap_sort(data);
                heap_sort.sort();
                break;


            default:
                System.out.println("Wrong select");


        }

    }
}
