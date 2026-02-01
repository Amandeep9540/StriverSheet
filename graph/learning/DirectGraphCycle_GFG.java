package graph.learning;

import java.util.*;


public class DirectGraphCycle_GFG {
    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {2, 0}, {2, 3}};
        int V = 4;
        boolean isCycle = isCyclicBFS(V,edges);
        System.out.println("is cycle present == "+isCycle);
    }
    public static boolean isCyclicDFS(int V, int[][] edges) {
        List<List<Integer>> adjList = populateAdjList(edges,V);
        boolean[] isVisited = new boolean[V];
        boolean[] inRecurssion = new boolean[V];

        for(int i=0;i<V;i++){
            if(isVisited[i]) continue;
            if(isCycleDFS(adjList,i,isVisited,inRecurssion)) return true;
        }

        return false;

    }

    private static boolean isCycleDFS(List<List<Integer>> adjList,int u,boolean[] isVisited,boolean[] inRecurssion){
        isVisited[u] = true;
        inRecurssion[u] = true;
        for(int v : adjList.get(u)){
            if(isVisited[v] && inRecurssion[v]) return true;
            if(isCycleDFS(adjList,v,isVisited,inRecurssion)){
                return true;
            }
        }
        inRecurssion[u] = false;
        return false;
    }

    public static boolean isCyclicBFS(int V, int[][] edges) {
        List<List<Integer>> adjList = populateAdjList(edges,V);
        int[] indegree = populateIndegree(adjList,V);
        return isCycleBFS(adjList,indegree,V);
    }

    private static boolean isCycleBFS(List<List<Integer>> adjList,int[] indegree,int V){
        Queue<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i] == 0)
                queue.offer(i);
        }
        int count = 0;
        while(!queue.isEmpty()){
            int u = queue.poll();
            count++;
            for(int v : adjList.get(u)){
                indegree[v]--;
                if(indegree[v] == 0)
                    queue.offer(v);
            }
        }
        return !(count == V);
    }

    private static List<List<Integer>> populateAdjList(int[][] edges,int V){
        List<List<Integer>> adjList = new ArrayList<>(V);
        for(int i=0;i<V;i++)
            adjList.add(new ArrayList<>());

        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
        }
        return adjList;
    }

    private static int[] populateIndegree(List<List<Integer>> adjList,int V){
        int[] indegree = new int[V];
        for(int u =0;u<V;u++){
            for(int v : adjList.get(u)){
                indegree[v]++;
            }
        }
        return indegree;
    }

}
