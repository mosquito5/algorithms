package chapter2.libs;

public class Sort_lib {
    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void exch(Comparable [] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    public static void show(Comparable[] a) {
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
    public static boolean isSorted(Comparable[] input_data) {
        for(int i = 1; i < input_data.length; i++)
            if(less(input_data[i], input_data[i - 1]))
                return true;
        return false;
    }
}
