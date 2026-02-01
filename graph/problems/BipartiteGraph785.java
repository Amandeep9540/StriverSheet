package graph.problems;
import java.util.*;

public class BipartiteGraph785 {
    public static void main(String[] args) {
        int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
        System.out.println(" is graph bipartite -- "+isBipartite(graph));
    }

    public static boolean isBipartite(int[][] graph) {
        int[] isVisited = new int[graph.length];
        Arrays.fill(isVisited,-1); // -1 -> not visited, 0 - > red, 1 -> black
        for(int u=0;u<graph.length;u++){
            if(isVisited[u] != -1) continue; // means visited
            if(!dfs(u,1,graph,isVisited)) return false;
        }

        return true;
    }

    public static boolean dfs(int u,int color, int[][] graph,int[] isVisited){
        isVisited[u] = color;
        for(int v : graph[u]){
            if(isVisited[u] == isVisited[v]) return false;
            if(isVisited[v] != -1) continue; // visited h
            if(!dfs(v,1-color,graph,isVisited)) return false;
        }
        return true;
    }
}
