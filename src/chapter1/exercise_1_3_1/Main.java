package chapter1.exercise_1_3_1;

import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        FixedCapacityStack<String> s = new FixedCapacityStack<String>(2);
        Scanner scanner = new Scanner(System.in);
        String item;

        do {
            item = scanner.nextLine();
            if(item.equals("-") && s.isEmpty())
                System.out.print(s.pop() + " ");
            else if(!item.equals("-") && !item.isEmpty() && s.isFull()) {
                s.push(item);
            }
        }while (!item.isEmpty());

        System.out.println("elementy na stosie: " + s.size());

    }
}
