package chapter4.Graph;

public class Search {
    private Graph   graph;
    private int     source;
    private int[]   parent;
    private int     count;

    public Search(Graph graph, int source) {
        this.graph  = graph;
        this.source = source;
        count       = 0;
        parent      = new int [source];
    }

    int find(int v){
        while (v != parent[v]) {
            parent[v] = parent[parent[v]];
            v = parent[v];
        }
        return v;
    }

    boolean marked(int v) {
        return find(v) == find(source);
    }

    int count(){
        return count;
     }



}
