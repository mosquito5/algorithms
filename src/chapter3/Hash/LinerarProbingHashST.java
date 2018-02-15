package chapter3.Hash;

import chapter3.BST.Queue;

public class LinerarProbingHashST<Key, Value> {
    private int N;          //liczba par klucz-wartosc w tablicy.
    private int size = 16;  // Rozmoar tablicy z probkowaniem liniowym.
    private Key[] keys;     // klucze
    private Value[] vals;   //wartosci

    public LinerarProbingHashST() {
        keys = (Key[]) new Object[size];
        vals = (Value[]) new Object[size];
    }

    public LinerarProbingHashST(int cap) {
        size = cap;
        keys = (Key[]) new Object[size];
        vals = (Value[]) new Object[size];
    }

    private int hash(Key key) {
        return(key.hashCode() & 0x7FFFFFFF % size);
    }

    private void resize(int cap) {
        LinerarProbingHashST<Key, Value> t;
        t = new LinerarProbingHashST<Key, Value>(cap);
        for (int i = 0; i < size; i++)
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        size = t.size;

    }

    public void put(Key key, Value value) {
        if(N >= size/2)
            resize(2*size); //podwajanie size
        int i;
        for (i = hash(key); keys[i] != null; i = (i + 1) % size)
            if(keys.equals(key)) {
            vals[i] = value;
            return;
        }
        keys[i] = key;
        vals[i] = value;
        N++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % size)
            if(keys[i].equals(key))
                return vals[i];
        return null;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for(int i = 0; i < size; i++)
            if(keys[i] != null)
                queue.enqueue(keys[i]);

        return queue;
    }
}
