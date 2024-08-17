package com.gj.dsandalg.graph.weight;

import java.util.ArrayDeque;

public class EdgeWeightGraph {
    private int V;
    private int E;
    private ArrayDeque<Edge>[] adj;

    public EdgeWeightGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new ArrayDeque[V];

        for (int i = 0; i < this.adj.length; i++) {
            adj[i] = new ArrayDeque<Edge>(20);
        }
    }

    public int getV() {
        return V;
    }

    public int getE() {
        return E;
    }

    public void addEdge(Edge edge) {
        int v = edge.getV();
        int w = edge.getOther(v);

        adj[v].add(edge);
        adj[w].add(edge);
        E++;
    }

    public ArrayDeque<Edge> adj(int v) {
        return adj[v];
    }

    public ArrayDeque<Edge> edges() {
        ArrayDeque<Edge> allEdges = new ArrayDeque();
        for (int v = 0; v < V; v++) {
            ArrayDeque<Edge> arrayDeque = adj[v];

            for (Edge edge : arrayDeque) {
                if (edge.getOther(v) < v) {
                    allEdges.add(edge);
                }
            }
        }

        return allEdges;

    }

}
