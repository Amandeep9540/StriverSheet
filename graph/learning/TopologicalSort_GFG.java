package graph.learning;

import java.util.*;

public class TopologicalSort_GFG {
    public static void main(String[] args) {
        int[][] edges = {{3, 0}, {1, 0}, {2, 0}};
        int V = 4;
        List<Integer> topoSort = topoSortBFS(V,edges);
        System.out.println(topoSort);
    }

    public static ArrayList<Integer> topoSortDFS(int V, int[][] edges) {
        boolean[] isVisited = new boolean[V];
        Deque<Integer> stack = new ArrayDeque<>();
        List<List<Integer>> adjList = populateAdjList(edges,V);
        for(int i=0;i<V;i++){
            if(isVisited[i]) continue;
            dfs(adjList,i,isVisited,stack);
        }
        return new ArrayList<>(stack);
    }

    public static ArrayList<Integer> topoSortBFS(int V, int[][] edges) {
        List<List<Integer>> adjList = populateAdjList(edges,V);
        int[] indegree = populateIndegree(adjList,V);

        return bfs(adjList,indegree,V);
    }

    private static void dfs(List<List<Integer>> adjList,int u,boolean[] isVisited,Deque<Integer> stack){
        isVisited[u] = true;
        for(int v : adjList.get(u)){
            if(isVisited[v]) continue;
            dfs(adjList,v,isVisited,stack);
        }
        stack.push(u);
    }

    private static ArrayList<Integer> bfs(List<List<Integer>> adjList,int[] indegree,int V){
        Queue<Integer> queue = new ArrayDeque<>();
        ArrayList<Integer> topoSort = new ArrayList<>(V);
        //1.adding who's indgree is zero
        for(int u = 0;u<V;u++){
            if(indegree[u] == 0)
                queue.offer(u);
        }

        //2.getting data from the queue and subtract the indgree of poped vertex edges
        while(!queue.isEmpty()){
            int u = queue.poll();
            topoSort.add(u);

            for(int v : adjList.get(u)){
                indegree[v]--;
                if(indegree[v] == 0)
                    queue.offer(v);
            }
        }

        return topoSort;
    }

    private static List<List<Integer>> populateAdjList(int[][] edges, int V){
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

    private static int[] populateIndegree(List<List<Integer>> adjList, int V){
        int[] indegree = new int[V];
        for(int u =0;u<V;u++){
            for(int v : adjList.get(u)){
                indegree[v]++;
            }
        }
        return indegree;
    }

}
