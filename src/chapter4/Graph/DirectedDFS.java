package chapter4.Graph;

//sprawdza czy istanieje sciezka skierowana z s do docelowego wierzcholka v

public class DirectedDFS {
    private boolean[] marked;

    public DirectedDFS(Digraph g, int s) {
        marked = new boolean[g.V()];
        dfs(g, s);
    }

    public DirectedDFS(Digraph g, Iterable<Integer> sources) {
        marked = new boolean[g.V()];
        for (int s : sources)
            if (!marked[s])
                dfs(g, s);
    }

    private void dfs(Digraph g, int s) {
        marked[s] = true;
        for(int w : g.adj(s))
            if(!marked[w])
                dfs(g, w);
    }

}
