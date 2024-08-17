package com.gj.dsandalg.graph.nodirection;

import java.util.Stack;

public class DepthPriorityPath {
    /**
     * 索引代表顶点，值表示当前顶点是否已经被遍历
     */
    private boolean[] marked;
    /**
     * 起点
     */
    private int s;

    private int[] edgeTo;

    public DepthPriorityPath(Graph graph, int s) {
        this.marked = new boolean[graph.getV()];
        this.s = s;
        this.edgeTo = new int[graph.getV()];

        dfs(graph, s);
    }

    private void dfs(Graph graph, int v) {
        marked[v] = true;

        for (Integer w : graph.adj(v)) {
            /**
             * 判断当前w顶点有没有被搜索过，如果没有，则调用dfs继续搜索
             */
            if (!marked[w]) {
                dfs(graph, w);

                this.edgeTo[w] = v;
            }
        }
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }

        Stack<Integer> stack = new Stack<>();

        int currentNode = v;
        while (currentNode != s) {
            stack.push(currentNode);

            currentNode = edgeTo[currentNode];
        }

        stack.push(s);

        return stack;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 5);
        graph.addEdge(3, 4);
        graph.addEdge(0, 5);

        DepthPriorityPath search = new DepthPriorityPath(graph, 0);
        Stack<Integer> result = search.pathTo(4);
        System.out.println(result);
    }
}
