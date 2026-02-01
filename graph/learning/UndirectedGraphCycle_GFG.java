package graph.learning;

import java.util.*;

public class UndirectedGraphCycle_GFG {

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {0, 2}, {1, 2}, {2, 3}};
        int V = 4;
        boolean isCycle = isCycleDFS(V,edges);
        System.out.println("is cycle present in graph -- "+isCycle);
    }

    public static boolean isCycleBFS(int V, int[][] edges) {
        List<List<Integer>> adjList = populateAdjList(edges,V);
        boolean[] isVisited = new boolean[V];

        for(int i=0;i<V;i++){
            if(isVisited[i]) continue;
            if(isCycleBFS(adjList,i,i,isVisited)) return true;
        }

        return false;

    }

    private static boolean isCycleBFS(List<List<Integer>> adjList,int u,int parent,boolean[] isVisited){
        isVisited[u] = true;
        for(int v : adjList.get(u)){
            if(v == parent ) continue;
            if(isVisited[v]) return true;
            if(isCycleBFS(adjList,v,u,isVisited)){
                return true;
            }
        }
        return false;
    }

    public static boolean isCycleDFS(int V, int[][] edges) {
        List<List<Integer>> adjList = populateAdjList(edges,V);
        boolean[] isVisited = new boolean[V];

        for(int i=0;i<V;i++){
            if(isVisited[i]) continue;
            if(isCycleDFS(adjList,i,i,isVisited)) return true;
        }

        return false;

    }

    private static boolean isCycleDFS(List<List<Integer>> adjList,int u,int parent,boolean[] isVisited){
        Queue<List<Integer>> queue = new ArrayDeque<>();
        queue.offer(Arrays.asList(u, parent));
        isVisited[u]=true;
        while(!queue.isEmpty()){
            List<Integer> pair = queue.poll();
            int curr_u = pair.get(0);
            int curr_parent = pair.get(1);
            for(int v : adjList.get(curr_u)){
                if(v == curr_parent) continue;
                if(isVisited[v]) return true;
                isVisited[v] = true;
                queue.offer(Arrays.asList(v, curr_u));
            }
        }
        return false;
    }

    private static List<List<Integer>> populateAdjList(int[][] edges,int V){
        List<List<Integer>> adjList = new ArrayList<>(V);
        for(int i=0;i<V;i++)
            adjList.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }


}
