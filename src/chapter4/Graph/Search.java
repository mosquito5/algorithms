package chapter4.Graph;

import chapter1.exercise_1_3_12.Stack;
import chapter3.BST.Queue;

public class Search {
    private Graph       graph;
    private int         source;
    private boolean[]   marked;
    private int[]       distTo;
    private int[]       edgeTo;

    public Search(Graph graph, int source) {
        this.graph  = graph;
        this.source = source;
        marked      = new boolean[graph.V()];
        distTo      = new int[graph.V()]; //liczba krawedzi najkrotszych sciezek s-v
        edgeTo      = new int[graph.V()];
        BreadFirstPaths(graph, source);
        check(graph, source);

//        count       = 0;
//        parent      = new int [source];
    }
    private void BreadFirstPaths(Graph graph, int source) {
        Queue<Integer> queue = new Queue<Integer>();
        for(int v = 0; v < graph.V(); v++)
            distTo[v] = Integer.MAX_VALUE;
        distTo[source] = 0;
        marked[source] = true;
        queue.enqueue(source);

        while (!queue.isEmpty()) {
            int v = queue.dequeue();
            for (int w : graph.adj(v)) {
                if(!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    queue.enqueue(w);
                }
            }
        }
    }
    //sprawdza optymalne warunki dla pojedynczego zrodla
    private boolean check(Graph graph, int source) {
        //sprawdza czy dystans source = 0
        if (distTo[source] != 0) {
            System.out.println("distance of source " + source + "to itself = " + distTo[source] );
            return false;
        }

        //sprawdza czy dla kazdej krawedzi v-w dist[w] <= dist[v] + 1
        //zapewnia v osiagniecie z source
        for(int v = 0; v < graph.V(); v++) {
            for(int w : graph.adj(v)) {
                if ((hasPathTo(v) != hasPathTo(w))) {
                    System.out.println("edge " + v + "-" + w);
                    System.out.println("distTo["  + v + "] = " + hasPathTo(v));
                    System.out.println("distTo["  + w + "] = " + hasPathTo(w));
                    return false;
                }
                if(hasPathTo(v) && (distTo[w] > distTo[v] + 1)) {
                    System.out.println("edge " + v + "-" + w);
                    System.out.println("distTo["  + v + "] = " + distTo[v]);
                    System.out.println("distTo["  + w + "] = " + distTo[v]);
                    return false;
                }

            }
        }
        //sprawdza czy v = edgeTo[w] spelnia distTo[w] = distTo[v] + 1
        //zapewnia v is osiagalny od source

        for(int w = 0; w < graph.V(); w++) {
            if(!hasPathTo(w) || w == source)
                continue; // przerywa dzialanie tej petlia nie calej metody
            int v = edgeTo[w];
            if(distTo[w] != distTo[v] + 1) {
                System.out.println("shortest path edge  " + v + "-" + w);
                System.out.println("distTo["  + v + "] = " + distTo[v]);
                System.out.println("distTo["  + w + "] = " + distTo[v]);
                return false;
            }

        }
        return true;

    }

//    int find(int v){
//        while (v != parent[v]) {
//            parent[v] = parent[parent[v]];
//            v = parent[v];
//        }
//        return v;
//    }

//    boolean marked(int v) {
//        return find(v) == find(source);
//    }
    boolean hasPathTo(int v) {
        return marked[v];
    }

    public int distTo(int v) {
        return distTo[v];
    }

    Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v))
            return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for(x = v; distTo[x] !=0; x = edgeTo[x])
            path.push(x);
        return path;
    }

//    int count(){
//        return count;
//     }



}
