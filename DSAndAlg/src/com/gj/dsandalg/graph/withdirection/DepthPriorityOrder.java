package com.gj.dsandalg.graph.withdirection;

import java.util.Stack;

public class DepthPriorityOrder {
    private boolean[] marked;

    private Stack<Integer> reversePost;

    public DepthPriorityOrder(DirGraph graph) {
        this.marked = new boolean[graph.getV()];
        this.reversePost = new Stack<>();

        for (int i = 0; i < graph.getV(); i++) {
            if (!marked[i]) {
                dfs(graph, i);
            }
        }
    }

    private void dfs(DirGraph graph, int V) {
        marked[V] = true;
        for (Integer w : graph.adj(V)) {
            if (!marked[w]) {
                dfs(graph, w);
            }
        }

        reversePost.push(V);
    }

    public Stack<Integer> getReversePost() {
        return reversePost;
    }
}
