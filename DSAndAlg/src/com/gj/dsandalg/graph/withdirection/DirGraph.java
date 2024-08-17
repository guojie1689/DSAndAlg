package com.gj.dsandalg.graph.withdirection;

import java.util.LinkedList;

public class DirGraph {
    /**
     * 顶点数量
     */
    private int V;
    /**
     * 边的数量
     */
    private int E;

    private LinkedList<Integer>[] adj;

    public DirGraph(int v) {
        V = v;
        E = 0;
        adj = new LinkedList[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public int getE() {
        return E;
    }

    public int getV() {
        return V;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);

        E++;
    }

    public LinkedList<Integer> adj(int w) {
        return adj[w];
    }

    private DirGraph reverse() {
        DirGraph newDirGraph = new DirGraph(V);

        for (int v = 0; v < V; v++) {
            LinkedList<Integer> linkedList = adj[v];
            for (int i1 = 0; i1 < linkedList.size(); i1++) {
                newDirGraph.addEdge(linkedList.get(i1), v);
            }
        }

        return newDirGraph;
    }

    public static void main(String[] args) {

    }
}
