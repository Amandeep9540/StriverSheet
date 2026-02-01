package graph.problems;

import java.util.*;

public class BipartiteGraph_GFG {
    public static void main(String[] args) {
        int V = 4;
        int[][] edges = {{0, 3}, {1, 2}, {3, 2}, {0, 2}};
        boolean isGraphBipartite = isBipartiteDFS(V,edges);
        System.out.println(" isGraphBipartite -- "+isGraphBipartite);
    }
    public static boolean isBipartiteBFS(int V, int[][] edges) {
        List<List<Integer>> adjList = getAdjList(V,edges);
        int[] isVisited = new int[V]; // -1-> unvisited, 1-> red, 0 -> black
        Arrays.fill(isVisited,-1);
        for(int i=0;i<V;i++){
            if(isVisited[i] != -1) continue; // means visited
            if(!canPaintBFS(adjList,i,1,isVisited))
                return false;
        }
        return true;
    }

    private static boolean canPaintBFS(List<List<Integer>> adjList,int u,int color,int[] isVisited){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(u);
        isVisited[u] = color;
        while(!queue.isEmpty()){
            int curr_u = queue.poll();
            for(int v : adjList.get(curr_u)){
                if(isVisited[curr_u] == isVisited[v]) return false;
                if(isVisited[v] != -1) continue;
                isVisited[v] = 1 - isVisited[curr_u]; // next color
                queue.offer(v);
            }
        }
        return true;
    }

    public static boolean isBipartiteDFS(int V, int[][] edges) {
        List<List<Integer>> adjList = getAdjList(V,edges);
        int[] isVisited = new int[V]; // 0-> unvisited, 1-> red, 2 -> black
        for(int i=0;i<V;i++){
            if(isVisited[i] != 0) continue; // means visited
            if(!canPaintDFS(adjList,0,1,isVisited))
                return false;
        }
        return true;
    }

    private static boolean canPaintDFS(List<List<Integer>> adjList,int u,int color,int[] isVisited){
        isVisited[u] = color;
        int nextColor = getPosColor(color);
        for(int v : adjList.get(u)){
            if(isVisited[v] == color) return false;
            if(isVisited[v] != 0) continue;
            if(!canPaintDFS(adjList,v,nextColor,isVisited)){
                return false;
            }
        }
        return true;
    }

    private static int getPosColor(int color){
        if(color == 1)
            return 2;
        else
            return 1;
    }

    private static List<List<Integer>> getAdjList(int V, int[][] edges){
        List<List<Integer>> adjList = new ArrayList<>();
        //Initilize with the empty list
        for(int i=0;i<V;i++)
            adjList.add(new ArrayList<>());
        //Adding the edges in the adj list
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        return adjList;
    }
}
