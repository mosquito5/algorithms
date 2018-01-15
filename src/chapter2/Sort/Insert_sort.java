package chapter2.Sort;

import static chapter2.libs.Sort_lib.*;

public class Insert_sort {

    private int[] input_data;

    public Insert_sort(int[] input_data) {

        this.input_data = input_data;
    }

    public void sort() {
        for (int i = 1; i < input_data.length; i++) {
            for (int j = i; j > 0 && less(input_data[j],
                    (input_data[j - 1]) ); j--)
                exch(input_data, j, j - 1);

            }
            show(input_data);
    }

}
