package com.gj.dsandalg.graph.withdirection;

import java.util.Stack;

/**
 * 拓朴排序
 */
public class Topological {
    private Stack<Integer> order;

    public Topological(DirGraph graph) {
        DirectedCycle directedCycle = new DirectedCycle(graph);
        if (!directedCycle.hasCycle()) {
            DepthPriorityOrder depthPriorityOrder = new DepthPriorityOrder(graph);
            order = depthPriorityOrder.getReversePost();
        }
    }

    private boolean isCycle() {
        return order == null;
    }

    public Stack<Integer> getOrder() {
        return order;
    }

    public static void main(String[] args) {
        DirGraph dirGraph = new DirGraph(6);
        dirGraph.addEdge(0, 2);
        dirGraph.addEdge(0, 3);
        dirGraph.addEdge(2, 4);
        dirGraph.addEdge(3, 4);
        dirGraph.addEdge(4, 5);
        dirGraph.addEdge(1, 3);

        Topological topological = new Topological(dirGraph);
        Stack<Integer> order = topological.getOrder();
        while (!order.isEmpty()) {
            System.out.print(order.pop() + "->");
        }
    }
}
