package chapter2.Sort;

import static chapter2.libs.Sort_lib.*;

public class Select_sort {
    private Comparable[] input_data;

    Select_sort(Comparable[] input_data) {
        this.input_data = input_data;
    }
    public void sort() {

            //Sortowanie w porzadku rosnacym
            for (int i = 0; i < input_data.length; i++) {
                //indeks minmalnego elementu
                int min = i;
                for (int j = i + 1; j < input_data.length; j++) {
                    if (less(Integer.parseInt(String.valueOf(input_data[j])) ,
                            Integer.parseInt(String.valueOf(input_data[min]))))
                        min = j;
                    exch(input_data, i, min);
                }
            }

        show(input_data);
    }
}
