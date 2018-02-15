package chapter3.Hash;

import chapter3.BST.Queue;
import chapter3.SequentialSearchST.SequentialSearchSt;

public class SeparateChainingHash<Key, Value> {
    private int n; //liczba par klucz-wartosc
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

    private boolean contains(Key key){
        return (key != null);
    }

    public Value get(Key key) {
        return (Value) st[hash(key)].get(key);
    }

    public void put(Key key, Value val) {
        if(key == null)
            throw new IllegalArgumentException("argument to put() is null");
        st[hash(key)].put(key,val);
        n++;
    }

    public Iterable<Key> keys(){
        Queue<Key> queue = new Queue<Key>();
        for(int i = 0; i < size; i++) {
            for (Key key : st[i].keys())
                queue.enqueue(key);
        }
        return queue;
    }

    public void delete(Key key) {
        if(key == null)
            throw new IllegalArgumentException("argument to delete() is null");
        if(contains(key))
            n--;
        st[hash(key)].delete(key);

    }

}
