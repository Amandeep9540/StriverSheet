package graph.otherAlgos;

import java.util.*;

public class ArticulationInGraph {
    public static void main(String[] args) {

    }
    private static int time = 1;
    public static ArrayList<Integer> articulationPoints(int V,
                                                        ArrayList<ArrayList<Integer>> adj) {
        boolean[] isVisited = new boolean[V];
        int[] low = new int[V];
        int[] tin = new int[V];
        Set<Integer> articulationPoints = new HashSet<>();
        time = 1;

        for(int u=0;u<V;u++){
            if(isVisited[u]) continue;
            dfs(u,-1,isVisited,low,tin,articulationPoints,adj);
        }

        if(articulationPoints.size() == 0)
            return new ArrayList<>(Arrays.asList(-1));

        ArrayList<Integer> result = new ArrayList<>(articulationPoints);
        Collections.sort(result);
        return result;
    }

    private static void dfs(int u, int parent, boolean[] isVisited, int[] low, int[] tin, Set<Integer> articulationPoints,ArrayList<ArrayList<Integer>> adj){
        isVisited[u] = true;
        low[u] = tin[u] = time;
        time++;
        int countChild = 0;
        for(int v : adj.get(u)){
            if(v == parent) continue;
            if(isVisited[v]){
                low[u] = Math.min(low[u],tin[v]);
            }else{
                countChild++;
                dfs(v,u,isVisited,low,tin,articulationPoints,adj);
                low[u] = Math.min(low[u],low[v]);
                if(tin[u] <= low[v] && parent != -1)
                    articulationPoints.add(u);
            }
        }
        if(parent == -1 && countChild > 1){
            articulationPoints.add(u);
        }
    }


}
