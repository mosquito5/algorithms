package chapter2.Sort;

import static chapter2.libs.Sort_lib.*;

public class Select_sort {
    public static void sort(Comparable a[]) {
        //Sortowanie w porzadku rosnacym
        for(int i = 0; i < a.length; i++) {
            //indeks minmalnego elementu
            int min = i;
            for(int j = i + 1; j < a.length; j++) {
                if(less(a[j], a[min]))
                    min = j;
                exch(a, i, min);
            }
        }
    }
}
