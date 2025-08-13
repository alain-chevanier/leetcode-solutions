package solutions;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

/**
 * LeetCode problem:
 * 2101. Detonate the Maximum Bombs
 * https://leetcode.com/problems/detonate-the-maximum-bombs/description/
 */
public class DetonateMaximumBombsSolution {
    public int maximumDetonation(int[][] bombs) {
        // Solution:
        // 1. Transform the bombs into a directed graph.
        //    Note: there is an edge from bomb A to bomb B if A can detonate B
        // 2. For each vertex in the graph, find all vertices reachable from it using BFS.
        //    Note: we only need to apply BFS onces for each each connected component in the graph.
        // 3. Find the maximum size of all connected components in the graph.
        var graph = buildAdjacenciesList(bombs);
        return findSizeOfBiggestConnectedComponent(graph);
    }

    private int findSizeOfBiggestConnectedComponent(
       Map<Integer, Set<Integer>> graph) {
        int max = 0;
        var visitedVertices = new HashSet<Integer>();
        for (int vertex : graph.keySet()) {
            if (visitedVertices.size() == graph.size()) {
                break;
            }
            if (visitedVertices.contains(vertex)) {
                continue;
            }
            var connectedComponent = bfs(vertex, graph);
            max = Math.max(max, connectedComponent.size());
            visitedVertices.addAll(connectedComponent);
        }
        return max;
    }

    Map<Integer, Set<Integer>>
    buildAdjacenciesList(int[][] bombs) {
        var adjacencyLists = new HashMap<Integer, Set<Integer>>();
        for (var cur = 0; cur < bombs.length; cur++) {
            adjacencyLists.put(cur, new HashSet<Integer>());
            for (int other = 0; other < bombs.length; other++) {
                if (cur != other
                        && inBlastRadius(bombs[cur], bombs[other])) {
                    adjacencyLists.get(cur).add(other);
                }
            }
        }
        return adjacencyLists;
    }

    boolean inBlastRadius(int[] bombA, int[] bombB) {
        long xDiff = Math.abs(bombA[0] - bombB[0]);
        long yDiff = Math.abs(bombA[1] - bombB[1]);
        long R = bombA[2];
        return (xDiff * xDiff + yDiff * yDiff) <= R * R;
    }

    Set<Integer> bfs(int vertex, Map<Integer, Set<Integer>> graph) {
        var queue = new LinkedList<Integer>();
        var visitedVertices = new HashSet<Integer>();

        queue.add(vertex);
        visitedVertices.add(vertex);

        while (queue.size() > 0) {
            int cur = queue.remove();
            for (int neighbor : graph.get(cur)) {
                if (!visitedVertices.contains(neighbor)) {
                    queue.add(neighbor);
                    visitedVertices.add(neighbor);
                }
            }
        }

        return visitedVertices;
    }
}
