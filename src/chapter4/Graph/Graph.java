package chapter4.Graph;

import Libs.File_lib;

import java.util.Scanner;

public class Graph implements InterfaceGraph {
    private final int V;         //liczba wirzcholkow
    private int E;               //liczba krawedzi
    private Bag<Integer> adj[];  //listy sasiedztwa
    //private List<Integer> adj;  //listy sasiedztwa

    public Graph(int V) {
        this.V  = V;
        this.E  = 0;
        //adj     = new ArrayList<Integer>();
        adj     = new Bag[V];
        for(int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Graph(Graph g) {
        V       = g.V;
        int E   = g.E;
        adj     = new Bag[g.V];
        for(int v = 0; v < g.V; v++)
            adj[v] = new Bag<Integer>();
    }

    public Graph(Scanner scanner) {
        V       = scanner.nextInt();
        int E   = scanner.nextInt();
        //adj     = new ArrayList<Integer>();
        adj     = new Bag[V];
        for(int v = 0; v < V; v++)
            adj[v] = new Bag<Integer>();
        for(int i = 0; i < E; i++) {
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            addEdge(v, w);
        }
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
        E++;
        adj[v].add(w);
        adj[w].add(v);

    }

    @Override
    public Bag<Integer> adj(int v) {
        return adj[v];
    }

    @Override
    public boolean hasEdgeTo(int v, int w) {
        for(int i : adj(v))
            for (int j : adj(w))
                if(adj[i] == adj[j])
                    return true;
        return false;
    }
//
//    public void test(int v, int w) {
//        for(int i : adj(v))
//            for (int j : adj(w))
//                if(adj[i] == adj[j])
//                    return true;
//        return false;
//    }


    public static void main(String[] args) {
        File_lib file = new File_lib("./data/tinyG.txt");
        Graph g = new Graph(file.getScanner());
        System.out.println(g.hasEdgeTo(5,4));
//        Scanner scanner = new Scanner(System.in);
//        int source = scanner.nextInt();
//
//        Testsearch(g, source);
//
//        TestBreadthFirstPaths(g, source);
//
//        TestDeepFisrtPaths(g, source);
//
//        scanner.close();


    }

    static void TestDeepFisrtPaths(Graph g, int source) {
        //Scanner keyboard    = new Scanner(System.in);
        //int source          = keyboard.nextInt();
        DeepFisrtPaths dfp  = new DeepFisrtPaths(g, source);

        for(int v = 0; v < g.V(); v++) {
            if(dfp.hasPathTo(v)) {
                System.out.println("soruce: " + source + " " + "number of edges " + v);
                for (int x : dfp.pathTo(v)) {
                    if(x == source)
                        System.out.println(x);
                    else
                        System.out.println("-" + x);
                }
                System.out.println();
            }
            else
                System.out.println(source + " to " + v + " not connected");
        }
        //keyboard.close();
    }

    static void TestBreadthFirstPaths(Graph g, int source) {
        //Scanner keyboard = new Scanner(System.in);
        //int source = keyboard.nextInt();
        BreadthFirstPaths bfs = new BreadthFirstPaths(g, source);

        for(int v = 0; v < g.V(); v++) {
            if(bfs.hasPathTo(v)) {
                System.out.println("soruce: " + source + " " + "number of edges " + v);
                for (int x : bfs.pathTo(v)) {
                    if(x == source)
                        System.out.println(x);
                    else
                        System.out.println("-" + x);
                }
                System.out.println();
            }
            else
                System.out.println(source + " to " + v + " not connected");
        }
    //keyboard.close();
    }

    static void Testsearch(Graph g, int source) {
        //Scanner keyboard = new Scanner(System.in);
        //int source = keyboard.nextInt();
        Search search = new Search(g, source);

        for(int v = 0; v < g.V(); v++) {
            if(search.hasPathTo(v)) {
                System.out.println(source + " " +  v + " " + search.distTo(v));
                for (int x : search.pathTo(v)) {
                    if(x == source)
                        System.out.println(x);
                    else
                        System.out.println("-" + x);
                }
                System.out.println();
            }
            else
                System.out.println(source + " to " + v + " not connected");
        }
        //keyboard.close();
    }

}
