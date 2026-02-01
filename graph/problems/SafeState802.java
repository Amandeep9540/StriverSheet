package graph.problems;

import java.util.ArrayList;
import java.util.List;

public class SafeState802 {
    public static void main(String[] args) {
        int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
        eventualSafeNodes(graph).stream().forEach(System.out::println);
    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] inRecurssion = new boolean[n];
        boolean[] isVisited = new boolean[n];
        for(int i=0;i<n;i++){
            if(isVisited[i]) continue;
            dfs(i,graph,isVisited,inRecurssion);
        }
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!inRecurssion[i])
                result.add(i);
        }

        return result;
    }

    private static boolean dfs(int u ,int[][] graph, boolean[] isVisited, boolean[] inRecurssion ){
        isVisited[u] = true;
        inRecurssion[u] = true;
        for(int v : graph[u]){
            if(!isVisited[v] && dfs(v,graph,isVisited,inRecurssion)) return true;
            else if(inRecurssion[v]) return false; // means cycle

        }
        inRecurssion[u] = false;
        return false;
    }
}
