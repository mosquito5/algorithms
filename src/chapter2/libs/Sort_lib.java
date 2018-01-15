package chapter2.libs;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Sort_lib {
    public static boolean less(int a, int b) {
        return Integer.compare(a, b) > 0;
    }

    public static void exch(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

//    public static void show(Comparable[] input) {
//        for (int i = 0; i < input.length; i++)
//            System.out.println(input[i]);
//
//    }

    public static void show(int[] input) {
        for (int i = 0; i < input.length; i++)
            System.out.println(input[i]);

    }

    public static boolean isSorted(Comparable[] input_data) {
        for (int i = 1; i < input_data.length; i++)
            if (less(Integer.parseInt(String.valueOf(input_data[i])),
                    Integer.parseInt(String.valueOf(input_data[i - 1]))))
                return true;
        return false;
    }

    public static void shuffle(int[] input) {
        Random random = ThreadLocalRandom.current();
        int index;

        for (int i = input.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);

            //swap
            int a = input[index];
            input[index] = input[i];
            input[i] = a;
        }

    }
}
