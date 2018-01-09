package chapter2.Sort;

import static chapter2.libs.Sort_lib.*;

public class Merge_sort {
    private Comparable[] input_data;
    private Comparable[] input_data_copy;
    private int lo;
    private int hi;

    Merge_sort(Comparable[] input_data) {

        this.input_data = input_data;
        this.input_data_copy = new Comparable[input_data.length];
        lo = 0;
        hi = input_data.length - 1;

    }

    public void sort() {
        sort(lo, hi);
        show(input_data);
    }

    public void sort(int lo, int hi) {
        if(hi <= lo)
            return;

        int mid = lo + (hi - lo) / 2;

        sort(lo, mid); //sorting left side
        sort(mid + 1, hi); // sorting right side
        merge(lo, mid,  hi);
    }

    private void merge(int lo, int mid, int hi) {

        for(int k = lo; k <= hi; k++)
            input_data_copy[k] = input_data[k];

        int j = mid + 1;


        for(int k = lo; k <= hi; k++)
            if (lo > mid)
                input_data[k] = input_data_copy[j++];
            else if (j > hi)
                input_data[k] = input_data_copy[lo++];
            else if (less(Integer.parseInt(String.valueOf(input_data_copy[j])),
                    Integer.parseInt(String.valueOf(input_data_copy[lo]))))
                input_data[k] = input_data_copy[j++];
            else
                input_data[k] = input_data_copy[lo++];

    }

}
