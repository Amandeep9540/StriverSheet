package graph.otherAlgos;

import java.util.*;

public class ValidArrangementPairs2097 {
    public static void main(String[] args) {
        int[][] pairs = {{5,1},{4,5},{11,9},{9,4}};
        int[][] arrangedPairs = validArrangement(pairs);
        for(int[] pair : arrangedPairs){
            System.out.println(pair[0] + " "+pair[1]);
        }
    }

    public static int[][] validArrangement(int[][] pairs) {
        Map<Integer, List<Integer>> adjMap = getAdjList(pairs);
        Map<Integer, Integer> indgreeMap = new HashMap<>();
        Map<Integer, Integer> outDegreeMap = new HashMap<>();

        //populating the indegree and outDegree
        for (Map.Entry<Integer, List<Integer>> entry : adjMap.entrySet()) {
            int u = entry.getKey();
            List<Integer> adjEdges = entry.getValue();
            outDegreeMap.put(u, adjEdges.size());
            for (int v : adjEdges) {
                indgreeMap.put(v, indgreeMap.getOrDefault(v, 0) + 1);
            }

        }

        int startNode = pairs[0][0]; // default

        for (int[] pair : pairs) {
            int u = pair[0];
            int out = outDegreeMap.getOrDefault(u, 0);
            int in = indgreeMap.getOrDefault(u, 0);

            if (out == in + 1) {
                startNode = u;
                break;
            }
        }

        Deque<Integer> stack = new ArrayDeque<>();
        // Map<Integer,Boolean> isVisited = new HashMap<>();
        dfs(startNode, adjMap, stack);

        int i = 0;
        int prev = -1;
        while (!stack.isEmpty()) {
            int top = stack.pop();
            if (prev == -1) {
                prev = top;
                continue;
            }
            pairs[i][0] = prev;
            pairs[i][1] = top;
            prev = top;
            i++;
        }

        return pairs;
    }

    private static void dfs(int node, Map<Integer, List<Integer>> adjMap, Deque<Integer> stack) {
        List<Integer> edges = adjMap.getOrDefault(node, new ArrayList<>());

        while (!edges.isEmpty()) {
            int v = edges.remove(edges.size() - 1);
            dfs(v, adjMap, stack);
        }
        stack.push(node);
    }

    private static Map<Integer, List<Integer>> getAdjList(int[][] pairs) {
        Map<Integer, List<Integer>> adjMap = new HashMap<>();
        for (int[] pair : pairs) {
            int u = pair[0];
            int v = pair[1];

            List<Integer> adj = null;
            if (adjMap.containsKey(u)) {
                adj = adjMap.get(u);
            } else {
                adj = new ArrayList<>();
            }

            adj.add(v);
            adjMap.put(u, adj);
        }
        return adjMap;
    }
}
