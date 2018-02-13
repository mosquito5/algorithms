package chapter3.Hash;

import chapter3.SequentialSearchST.SequentialSearchSt;

public class SeparateChainingHash<Key, Value> {
    private int N; //liczba par klucz-wartosc
    private int size; //Rozmiar tablicy z haszowaniem
    private SequentialSearchSt<Key, Value>[] st;

    public SeparateChainingHash(){
        this(997);
    }

    public SeparateChainingHash(int size) {
        this.size = size;
        st = (SequentialSearchSt<Key, Value>[]) new SequentialSearchSt[size];
        for (int i = 0; i < size; i++)
            st[i] = new SequentialSearchSt();
    }
    private int hash(Key key) {
        return (key.hashCode() & 0x7FFFFFFF % size);
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        st[hash(key)].put(key,val);
    }

    public Iterable<Key> keys(){
        return null;
    }

}
