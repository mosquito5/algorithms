package chapter1.exercise_1_3_1;

public class FixedCapacityStack<Item> {
    private Item[] a;
    private int N, cap;

    public FixedCapacityStack(int cap) {
        a = (Item[]) new Object[cap];
        this.cap = cap;
    }


    public boolean isEmpty() {
        return N == 0;
    }

    public boolean isFull() {
        return N == cap;
    }

    public int size() {
        return N;
    }

    public void push(Item item){
        a[N++] = item;
    }

    public Item pop() {
        return a[--N];
    }
}


