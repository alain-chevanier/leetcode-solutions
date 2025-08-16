package solutions;

import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

/**
 * 2101. Detonate the Maximum Bombs
 * https://leetcode.com/problems/detonate-the-maximum-bombs/description/
 */
public class DetonateMaximumBombs {
    public int maximumDetonation(int[][] bombs) {
        // Solution:
        // 1. Transform the bombs into a directed graph.
        //    Note: there is an edge from bomb A to bomb B if A can detonate B
        // 2. For each vertex in the graph, find all vertices reachable from it using BFS.
        //    Note: We need to discover longest BFS traversal that contains each vertex.
        // 3. Find the maximum size among all traversals we discovered in the previous step.
        var graph = buildAdjacenciesList(bombs);
        return findSizeOfBiggestConnectedComponent(graph);
    }

    Map<Integer, Set<Integer>> buildAdjacenciesList(int[][] bombs) {
        var adjacencyLists = new HashMap<Integer, Set<Integer>>();
        for (int cur = 0; cur < bombs.length; cur++) {
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

    private int findSizeOfBiggestConnectedComponent(
       Map<Integer, Set<Integer>> graph) {
        int max = 0;
        var visitedVertices = new HashSet<Integer>();
        for (int vertex : graph.keySet()) {
            // already discovered all connected components?
            if (visitedVertices.size() == graph.size()) {
                break;
            }
            // the current vertex belongs to a connected
            // component we already analyzed?
            if (visitedVertices.contains(vertex)) {
                continue;
            }
            var connectedComponent = bfs(vertex, graph);
            max = Math.max(max, connectedComponent.size());
            visitedVertices.addAll(connectedComponent);
        }
        return max;
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

class DetonateMaximumBombs2 {
    public int maximumDetonation(int[][] bombs) {
        var dist = buildGraph(bombs);
        floydWharshall(dist);
        return findMaxBiggestDAG(dist);
    }

    Integer[][] buildGraph(int[][] bombs) {
        var dist = new Integer[bombs.length][bombs.length];
        for (int cur = 0; cur < bombs.length; cur++) {
            for (int other = 0; other < bombs.length; other++) {
                if (cur == other) {
                    dist[cur][other] = 0;
                } else {
                    dist[cur][other] = isReachable(bombs, cur, other) ? 1 : null;
                }

            }
        }
        return dist;
    }

    boolean isReachable(int[][] bombs, int source, int target) {
        long xDist = Math.abs(bombs[source][0] - bombs[target][0]);
        long yDist = Math.abs(bombs[source][1] - bombs[target][1]);
        long blastRadius = bombs[source][2];
        return xDist*xDist + yDist*yDist <= blastRadius * blastRadius;
    }

    void floydWharshall(Integer[][] dist) {
        int vertices = dist.length;
        for (int k = 0; k < vertices; k++) {
            for (int source = 0; source < vertices; source++) {
                for (int destination = 0; destination < vertices; destination++) {
                    if (dist[source][k] != null
                        && dist[k][destination] != null
                        && (dist[source][destination] == null ||
                            (dist[source][destination] >
                             dist[source][k] + dist[k][destination]))) {
                        dist[source][destination] =
                             dist[source][k] + dist[k][destination];
                    }
                }
            }
        }
    }

    int findMaxBiggestDAG(Integer[][] dist) {
        int max = 0;
        for (int vertex = 0; vertex < dist.length; vertex++) {
            int reachableVertices = 0;
            for (Integer distance : dist[vertex]) {
                reachableVertices += distance != null ? 1 : 0;
            }
            max = Math.max(max, reachableVertices);
        }
        return max;
    }
}
