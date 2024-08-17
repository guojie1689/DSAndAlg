package com.gj.dsandalg.graph.nodirection;

public class DepthPrioritySearch {
    /**
     * 索引代表顶点，值表示当前顶点是否已经被遍历
     */
    private boolean[] marked;
    /**
     * 记录有多少个顶点与S顶点相连
     */
    private int count;

    public DepthPrioritySearch(Graph graph, int s) {
        this.marked = new boolean[graph.getV()];
        this.count = 0;

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
            }
        }

        count++;
    }

    public boolean marked(int w) {
        return marked[w];
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        Graph graph = new Graph(13);
        graph.addEdge(0, 5);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 6);
        graph.addEdge(5, 3);
        graph.addEdge(5, 4);
        graph.addEdge(3, 4);
        graph.addEdge(4, 6);
        graph.addEdge(7, 8);
        graph.addEdge(9, 10);
        graph.addEdge(9, 11);
        graph.addEdge(9, 12);
        graph.addEdge(11, 12);

        DepthPrioritySearch search = new DepthPrioritySearch(graph, 0);
        System.out.println("count:" + search.getCount());
        System.out.println("1-->0:" + search.marked(1));
        System.out.println("7-->0:" + search.marked(7));
        System.out.println("11-->0:" + search.marked(11));


    }
}
