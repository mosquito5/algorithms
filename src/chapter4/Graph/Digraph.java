package chapter4.Graph;

public class Digraph implements IntDigraph {
    private final int V;         //liczba wirzcholkow
    private int E;               //liczba krawedzi
    private Bag<Integer> adj[];  //listy sasiedztwa

    public Digraph(int V) {
        this.V  = V;
        this.E  = 0;
        adj     = new Bag[V];
        for(int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Digraph(Digraph g) {
        this.V  = g.V;
        this.E  = g.E;
        adj     = new Bag[g.V];
        for(int v = 0; v < g.V; v++)
            adj[v] = new Bag<Integer>();

    }
    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        adj[v].add(w);
        E++;
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph r = new Digraph(V);
        for(int v = 0; v < V; v++)
            for (int w : adj(v))
                r.addEdge(w, v);
        return r;
    }
    //??
    public boolean hasEdge(int v, int w) {
        for(int i : adj(v))
            for (int j : adj(w))
                if(adj[i] == adj[j])
                    return true;
        return false;
    }
}
