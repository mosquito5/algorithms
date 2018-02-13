package chapter3.SequentialSearchST;

import chapter3.BST.Queue;

public class SequentialSearchSt<Key, Value> {
    private int n; //numer par klucz wartosc
    private Node first; //lista linkowana par klucz-wartosc

    //pomoc do list linkowanych
    public class Node {
        private Key key;
        private Value val;
        private Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    /**
     * inicjalizuje pusta tabele symboli
     */
    public SequentialSearchSt() {

    }

    /**
     *Zwraca liczbe par key-value w tej tablicy symboli
     */
    public int size() {
        return n;
    }

    /**
     *Zwraca true jesli symblo tablicy jest pusty
     */
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     *Zwraca true jesli ten symbol zawiera sie w kluczu w tablicy
     */

    public boolean contains(Key key) {
        if(key == null)
            throw new IllegalArgumentException("argument to get() is null");
        return get(key) != null;
    }

    /**
     * Zwraca wartosc polaczona z kluczem w tej tablict
     */
    public Value get(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to get() is null");
        for(Node x = first; x != null; x = x.next) {
            if(key.equals(x.key))
                return x.val;
        }
        return null;
    }

    /**
     *
     */

    public void put(Key key, Value val) {
        if (key == null)
            throw new IllegalArgumentException("first argument to put() is null");
        if (val == null) {
            delete(key);
            return;
        }

        for (Node x = first; x != null; x = x.next) {
            if(key.equals(x.key)) {
                x.val = val;
                return;
            }
        }
        first = new Node(key, val, first);
        n++;
    }

    public void delete(Key key) {
        if (key == null)
            throw new IllegalArgumentException("argument to delete() is null");
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if(x == null)
            return null;
        if(key.equals(x.key)) {
            n--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        for(Node x = first; x != null; x = x.next)
            queue.enqueue(x.key);
        return queue;
    }
}
