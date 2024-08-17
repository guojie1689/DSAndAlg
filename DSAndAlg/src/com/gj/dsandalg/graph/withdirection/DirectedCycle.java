package com.gj.dsandalg.graph.withdirection;

import com.gj.dsandalg.graph.nodirection.Graph;

public class DirectedCycle {
    /**
     * 索引代表顶点，值表示当前顶点是否已经被搜索
     */
    private boolean[] marked;
    /**
     * 记录图中是否有环
     */
    private boolean hasCycle;
    /**
     * 索引代表顶点，使用栈的思想，代表当前顶点有没有已经处于正在搜索的有向路径上
     */
    private boolean[] onStack;

    public DirectedCycle(DirGraph graph) {
        this.marked = new boolean[graph.getV()];
        this.hasCycle = false;
        this.onStack = new boolean[graph.getV()];

        //找到图中每一个顶点，用每一个顶点做为入口，调用dfs进行搜索
        for (int v = 0; v < graph.getV(); v++) {
            if (!marked[v]) {
                dfs(graph, v);
            }
        }
    }

    /**
     * 深度搜索检测是否有环
     *
     * @param graph
     * @param v
     */
    private void dfs(DirGraph graph, int v) {
        marked[v] = true;
        onStack[v] = true;

        for (Integer w : graph.adj(v)) {
            if (!marked[w]) {
                dfs(graph, w);
            }

            //当前顶点w是否已经在栈中，如果已经在，当前正在搜索的状态，现在又要搜索一次，证明有环
            if (onStack[w]) {
                hasCycle = true;
            }
        }

        onStack[v] = false;
    }

    /**
     * 当前图中是否有环，如果没有环，就可以进行拓朴排序
     *
     * @return
     */
    public boolean hasCycle() {
        return hasCycle;
    }
}
