package chapter3.Hash;

public class LinerarProbingHaszST<Key, Value> {
    private int N;          //liczba par klucz-wartosc w tablicy.
    private int size = 16;  // Rozmoar tablicy z probkowaniem liniowym.
    private Key[] keys;     // klucze
    private Value[] vals;   //wartosci

    public LinerarProbingHaszST() {
        keys = (Key[]) new Object[size];
        vals = (Value[]) new Object[size];
    }

    public LinerarProbingHaszST(int cap) {
        size = cap;
        keys = (Key[]) new Object[size];
        vals = (Value[]) new Object[size];
    }

    private int hash(Key key) {
        return(key.hashCode() & 0x7FFFFFFF % size);
    }

    private void resize(int cap) {
        LinerarProbingHaszST<Key, Value> t;
        t = new LinerarProbingHaszST<Key, Value>(cap);
        for (int i = 0; i < size; i++)
            if (keys[i] != null)
                t.put(keys[i], vals[i]);
        keys = t.keys;
        vals = t.vals;
        size = t.size;

    }

    private void put(Key key, Value value) {
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
        size++;
    }

    public Value get(Key key) {
        for (int i = hash(key); keys[i] != null; i = (i + 1) % size)
            if(keys[i].equals(key))
                return vals[i];
        return null;
    }
}
