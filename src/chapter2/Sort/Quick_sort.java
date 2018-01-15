package chapter2.Sort;

import static chapter2.libs.Sort_lib.*;


public class Quick_sort {

    private static int[] data;


    public Quick_sort(int[] data) {
        this.data = data;
    }

    public static void sort() {
        shuffle(data);
        sort(data, 0, data.length - 1);
        show(data);

    }

    private static void sort(int[] input, int low, int high) {
            if (high <= low)
                return;
            int j = partition(input, low, high); // podzial na lewa i prawa strone

            sort(input, low, j - 1);       // sortowanie lewej strony input[low ..j - 1]
            sort(input, j + 1, high);       // sortowanie prawej strony input[j + 1..hi]
    }

    private static int partition(int[] input, int low, int high) {
        int i = low;
        int j = high + 1;
        int v = input[low];

        while (true) {
            while (less(input[++i], v))
                if (i == high)
                    break;

            while (less(v , input[--j]))
                if(j == low)
                    break;

            if( i >= j)
                break;

            exch(input, i, j);
        }
        exch(input, low, j);
        return j;
    }
}

