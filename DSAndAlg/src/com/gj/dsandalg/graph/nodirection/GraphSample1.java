package com.gj.dsandalg.graph.nodirection;

public class GraphSample1 {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Graph graph = new Graph(20);

        graph.addEdge(0, 1);
        graph.addEdge(6, 9);
        graph.addEdge(3, 8);
        graph.addEdge(5, 11);
        graph.addEdge(2, 12);
        graph.addEdge(6, 10);
        graph.addEdge(4, 8);

        BroadPrioritySearch broadPrioritySearch = new BroadPrioritySearch(graph, 9);

        System.out.println("9->10:" + broadPrioritySearch.marked(10));
        System.out.println("9->8:" + broadPrioritySearch.marked(8));
    }
}
