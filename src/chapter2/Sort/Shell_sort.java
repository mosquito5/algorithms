package chapter2.Sort;

import static chapter2.libs.Sort_lib.*;

public class Shell_sort {
    private Comparable[] input_data;

    Shell_sort(Comparable[] input_data) {
        this.input_data = input_data;

    }
    public void sort() {
        int h = 1;
        while (h < input_data.length / 3)
            h = 3 * h + 1;
        while (h >= 1) {
            for (int i = h; i < input_data.length; i++) {
                for (int j = i; j >= h && less(input_data[j], input_data[j - h]); j -= h)
                    exch(input_data, j, j - h);
            }
            h = h / 3;
        }
    show(input_data);
    }
}
