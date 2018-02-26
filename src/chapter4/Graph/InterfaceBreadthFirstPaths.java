package chapter4.Graph;

public interface InterfaceBreadthFirstPaths {
    //void bfs(Graph graph, int source) throws InterruptedException;
    boolean hasPathTo(int source);
    Iterable<Integer> pathTo(int v);
    int distTo(int v);


}
