package graph.shortestPath;

import java.util.*;

public class SortedPathInUndirectedGraph_GFG {
    public static void main(String[] args) {
        int[][] edges = {
                {0, 1},
                {0, 3},
                {1, 2},
                {3, 4},
                {4, 5},
                {2, 6},
                {5, 6},
                {6, 7},
                {6, 8},
                {7, 8}
        };

        int V = 9;
        int src = 0;

        int[] path = shortestPath(V,edges,src);
        for(int i=0;i<path.length;i++){
            System.out.print(" "+path[i]);
        }
    }

    public static int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        List<List<Integer>> adjList = getAdjList(edges,V);
        int[] dis = new int[V];
        Arrays.fill(dis,Integer.MAX_VALUE);
        Queue<Pairs> queue = new ArrayDeque<>();
        queue.offer(new Pairs<>(src,0));
        dis[src] = 0;

        while(!queue.isEmpty()){
            Pairs<Integer,Integer> p = queue.poll();
            for(int v : adjList.get(p.value)){
                if(dis[v] > p.dis + 1){ //if(dis[v] == Integer.MAX_VALUE); this also work because the queue store the date is sorted manner because every time we increment that by +1
                    dis[v] = p.dis + 1;
                    queue.offer(new Pairs(v,p.dis+1));
                }
            }
        }

        for(int i =0;i<V;i++){
            if(dis[i] == Integer.MAX_VALUE){
                dis[i] = -1;
            }
        }

        return dis;
    }

    private static List<List<Integer>> getAdjList(int[][] edges, int V){
        List<List<Integer>> adjList = new ArrayList<>(V);
        for(int i=0;i<V;i++)
            adjList.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int a = edges[i][0];
            int b = edges[i][1];
            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }
        return adjList;
    }
}

class Pairs<T,W> {
    T value;
    W dis;

    Pairs(T value, W dis){
        this.value = value;
        this.dis = dis;
    }
}
