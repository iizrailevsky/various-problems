package com.ilya.coding;

import java.util.HashMap;
import java.util.Map;

public class Graph {
    private Map<Integer, GraphNode> nodeLookup = new HashMap<>();

    public GraphNode getNode (int id) {
        return this.nodeLookup.get(id);
    }
    public void putIfAbsent(int id, GraphNode graphNode) { this.nodeLookup.putIfAbsent(id, graphNode); }

    public void addEdge(int source, int destination) {
        GraphNode s = getNode(source);
        GraphNode d = getNode(destination);
        s.adjacent.add(d);
        d.adjacent.add(s);
    }
}
