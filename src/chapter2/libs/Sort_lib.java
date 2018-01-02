package chapter2.libs;

public class Sort_lib {
    public static boolean less(int a, int b) {
        return Integer.compare(a ,b) > 0;
    }

    public static void exch(Comparable[] input, int i, int j) {
        Comparable temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void show(Comparable[] input) {
        for(int i = 0; i < input.length; i++) {
            System.out.println(input[i]);
        }
    }
    public static boolean isSorted(Comparable[] input_data) {
        for(int i = 1; i < input_data.length; i++)
            if(less(Integer.parseInt(String.valueOf(input_data[i])),
                Integer.parseInt(String.valueOf(input_data[i - 1]))))
                return true;
        return false;
    }
}
