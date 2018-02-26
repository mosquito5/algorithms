package chapter4.Graph;

import java.util.Stack;

//przeszukiwanie w glab
public class DeepFisrtPaths {
    private boolean[]   marked;     //czy wywolano juz dfs dla danego wierzcholka
    private int[]       edgeTo;     //ostatni wierzcholek na znanej sciezce do wierzcholka

    private final int source;       //wierzcholek zrodlowy

    public DeepFisrtPaths(Graph graph, int source) {
        this.source = source;
        marked = new boolean[graph.V()];
        edgeTo = new int[graph.V()];
        dfs(graph, source);
    }

    private void dfs(Graph graph, int source) {
        marked[source] = true;
        for(int i : graph.adj(source))
            if (!marked[i]) {
            edgeTo[i] = source;
            dfs(graph, i);
            }
    }

    public boolean hasPathTo(int source) {
        return marked[source];
    }

    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int i = v; i != source; i = edgeTo[i])
            path.push(i);
        return path;

    }
}
