package com.ilya.coding;

import java.io.*;
import java.util.*;

public class GraphBFS {

    private static final int DEFAULT_LENGTH = 6;

    private Map<Integer, GraphNode> nodeLookup = new HashMap<>();

    private static class GraphNode {
        private int id;
        LinkedList<GraphNode> adjacent = new LinkedList<>();
        private GraphNode (int id) {
            this.id = id;
        }
    }

    private GraphNode getNode (int id) {
        return this.nodeLookup.get(id);
    }

    public void addEdge(int source, int destination) {
        GraphNode s = getNode(source);
        GraphNode d = getNode(destination);
        s.adjacent.add(d);
        d.adjacent.add(s);
    }

    /**
     * Returns all the distance between source and other reachable node if found,
     * -1 otherwise
     * @param source
     * @return distances if found, -1 otherwise
     */
    public Map<Integer, Integer> getAllDistnancesBFS(int source) {
        return getAllDistnancesBFS(getNode(source));
    }

    /**
     * Returns all the distance between source and other reachable node if found,
     * -1 otherwise
     * @param source
     * @return distances if found, -1 otherwise
     */
    public Map<Integer, Integer> getAllDistnancesBFS(GraphNode source) {
        // error checking
        if (source == null) {
            return null;
        }

        // init variables
        LinkedList<GraphNode> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Integer> distances = new HashMap<>();

        // start with source with no (0) distance
        distances.putIfAbsent(source.id, 0);
        q.add(source);
        // go over nodes in BFS and try to find the destination
        while (!q.isEmpty()) {
            GraphNode node = q.remove();
            // visited this node already? skip
            if (visited.contains(node.id)) {
                continue;
            }
            visited.add(node.id);
            // add adjacent nodes to the q
            for (GraphNode child : node.adjacent) {
                // update child's distance to source
                // to be parent's distance to source + distance b/n child and parent
                distances.putIfAbsent(child.id, distances.get(node.id) + DEFAULT_LENGTH);
                q.add(child);
            }
        }

        return distances;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        // create graph queries
        for (int qi = 0; qi < q; qi++) {
            String[] nm = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = Integer.parseInt(nm[0]);
            int m = Integer.parseInt(nm[1]);

            GraphBFS graph = new GraphBFS();
            // create nodes
            for (int ni = 1; ni <= n; ni++) {
                graph.nodeLookup.putIfAbsent(ni, new GraphNode(ni));
            }
            // create edges
            for (int mi = 1; mi <= m; mi++) {
                String[] uv = scanner.nextLine().split(" ");
                //scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                int u = Integer.parseInt(uv[0]);
                int v = Integer.parseInt(uv[1]);
                graph.addEdge(u, v);
            }
            // get starting node
            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            Map<Integer, Integer> distances = graph.getAllDistnancesBFS(s);
            StringJoiner sj = new StringJoiner(" ");
            // print distances from start to all other nodes
            for (int i = 1; i <= n; i++) {
                if (i != s) {
                    sj.add(Integer.toString((distances.containsKey(i) ? distances.get(i) : -1)));
                }
            }
            System.out.println(sj);
        }

        scanner.close();
    }
}
