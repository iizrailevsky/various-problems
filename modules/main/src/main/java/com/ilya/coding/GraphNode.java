package com.ilya.coding;

import java.util.LinkedList;

public class GraphNode {

    int id;
    boolean visited;
    boolean marked;
    LinkedList<GraphNode> adjacent = new LinkedList<>();
    GraphNode (int id) {
        this.id = id;
    }
}
