package com.gj.dsandalg.graph.weight;

public class Edge implements Comparable<Edge> {

    private final int w;
    private final int v;
    private final double weiget;

    public Edge(int w, int v, double weiget) {
        this.w = w;
        this.v = v;
        this.weiget = weiget;
    }

    @Override
    public int compareTo(Edge o) {
        if (weiget > o.weiget) {
            return 1;
        } else if (weiget < o.weiget) {
            return -1;
        }
        return 0;
    }

    public int getOther(int v) {
        if (this.v == v) {
            return w;
        } else {
            return this.v;
        }
    }

    public int getV() {
        return v;
    }
}
