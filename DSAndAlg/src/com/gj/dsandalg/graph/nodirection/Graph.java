package com.gj.dsandalg.graph.nodirection;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Graph {
    /**
     * 顶点数量
     */
    private int V;
    /**
     * 边的数量
     */
    private int E;

    private LinkedList<Integer>[] adj;

    public Graph(int v) {
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
        adj[w].add(v);

        E++;
    }

    public LinkedList<Integer> adj(int w) {
        return adj[w];
    }
}
