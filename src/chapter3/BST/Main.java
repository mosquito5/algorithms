package chapter3.BST;


import java.util.Scanner;

public class Main {
    public static void main (String[] args) {

        BST<String, Integer> bst = new BST<String, Integer>();

        Read(bst);

        try {
            for (String s : bst.keys())
                System.out.println(s + " " + bst.get(s));
        }
        catch (NullPointerException none) {
                System.out.println("EMPTY DATA");
        }


    }

    public static void Read(BST bst) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (true) {
            String tmp = scanner.nextLine();
            if(tmp.equals(""))
                break;

            bst.put(tmp, count);

            count++;
        }
        scanner.close();


    }
}
