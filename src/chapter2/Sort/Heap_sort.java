package chapter2.Sort;

import static chapter2.libs.Sort_lib.*;

public class Heap_sort {
    private int[] data;
    private int dataLength;

    public  Heap_sort(int[] data) {
        this.data = data;
        dataLength = data.length;
    }

    public void sort() {
        for(int i = dataLength / 2; i >= 1; i--)
            sink(data, i, dataLength);
        while (dataLength > 1) {
            exch(data, 0, --dataLength);
            sink(data, 1, dataLength);
        }
        show(data);
    }
}
