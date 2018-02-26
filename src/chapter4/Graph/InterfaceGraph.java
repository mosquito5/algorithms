package chapter4.Graph;

public interface InterfaceGraph {
    //InterfaceGraph(int V);                    //Tworzy graf bez krawedzi o V wierzcholkach
    //InterfaceGraph(In in);                    //wczytuje graf z strumienia wejsciowego

    int V();                         //zwraca liczbe wierzcholko
    int E();                        //zwraca liczbe krawedzi

    void addEdge(int v, int w);      //dodaje do grafu prawedz v-w
    Bag<Integer> adj(int v);         //zwraca wierzcholki sasiadujace v
    String toString();               //reprezentacja w postaci lancucha znakow
    boolean hasEdgeTo(int v, int w);
}
