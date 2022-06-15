package com.ilya.coding;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an undirected tree consisting of n vertices numbered from 0 to n-1, which has some apples in their vertices.
 * You spend 1 second to walk over one edge of the tree. Return the minimum time in seconds you have to spend to collect
 * all apples in the tree, starting at vertex 0 and coming back to this vertex.
 *
 * The edges of the undirected tree are given in the array edges, where edges[i] = [ai, bi] means that exists an edge connecting
 * the vertices ai and bi. Additionally, there is a boolean array hasApple, where hasApple[i] = true means that vertex i has an apple;
 * otherwise, it does not have any apple.
 *
 * Input: n nodes, edges, List<Boolean> hasApple
 * Output: minimum time in seconds for the edges
 * Examples:
 *  A. Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,true,true,false]
 *     Output: 8
 *  B. Input: n = 7, edges = [[0,1],[0,2],[1,4],[1,5],[2,3],[2,6]], hasApple = [false,false,true,false,false,true,false]
 *     Output: 6
 *  Options: Add the edges to the paths for each node as arrays of adjacent nodes. Create visited boolean array.
 *           Go over the graph in a depth first search (DFS), count total by summing all the adjacent edges for the given node.
 */
public class GraphDFSCollectApples {
    public static int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        // error checking
        if (n < 0 || edges == null || hasApple == null) {
            return -1;
        }

        // populate the adjacent paths for given nodes
        List<List<Integer>> paths = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            paths.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            paths.get(edge[0]).add(edge[1]);
            paths.get(edge[1]).add(edge[0]);
        }
        // init visited nodes - n + 1 of edges
        boolean[] visited = new boolean[n + 1];

        int totalMinTime = minTimeDFS(0, hasApple, paths, visited);
        return (totalMinTime > 0) ? totalMinTime - 2 : 0;
    }

    private static int minTimeDFS(int curNode, List<Boolean> hasApple, List<List<Integer>> paths, boolean[] visited) {
        // mark current as visited
        visited[curNode] = true;
        int totalMinTime = 0;

        // go over the adjacent ndoes and sum up the minTime
        for (int adjNode: paths.get(curNode)) {
            // go to the adjecent node if not visited
            if (!visited[adjNode]) {
                totalMinTime += minTimeDFS(adjNode, hasApple, paths, visited);
            }
        }

        // increment total by 2 if found apple or adjacent nodes had min time
        if (hasApple.get(curNode) || totalMinTime > 0) {
            totalMinTime += 2;
        }

        return totalMinTime;
    }
}
