package chapter4.Graph;

import sun.misc.Queue;

import java.util.Stack;

public class BreadthFirstPaths implements InterfaceBreadthFirstPaths {
    private boolean[]   marked;         //czy wywolano juz dfs dla danego wierzcholka
    private int[]       edgeTo;         //ostatni wierzcholek na znanej sciezce do wierzcholka
    private int[]       distTo;         //liczba krawedzi miedzy zrodlem a danym wierzcholkiem

    private final int source;       //wierzcholek zrodlowy

    public BreadthFirstPaths(Graph graph, int source) {
        this.source = source;
        marked      = new boolean[graph.V()];
        edgeTo      = new int[graph.V()];
        distTo      = new int[graph.V()];
        try {
            bfs(graph, source);
        } catch (InterruptedException none) {
            System.out.println("BFS METHOD ERROR");
        }
    }

    private void bfs(Graph graph, int source) throws InterruptedException {
        Queue<Integer> queue = new Queue<Integer>();
        for(int v = 0; v < graph.V(); v++)
            distTo[v] = Integer.MAX_VALUE;

        distTo[source] = 0;
        marked[source] = true;

        queue.enqueue(source);
        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int i : graph.adj(v))
                if (!marked[i]) {
                    edgeTo[i] = v;      //zapisujemy najkrotsza krawedz na najkrotszej sciezce
                    distTo[i] = distTo[v] + 1;
                    marked[i] = true;   //oznaczamy wirzcholek
                    queue.enqueue(i);   // dodajemy wirzcholek do kolejki
                }
        }


    }
    @Override
    public boolean hasPathTo(int source) {
        return marked[source];
    }
    @Override
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int i = v; i != source; i = edgeTo[i])
            path.push(i);
        return path;

    }

    @Override
    public int distTo(int v) {
        return distTo[v];
    }
}
