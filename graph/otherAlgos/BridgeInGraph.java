package graph.otherAlgos;

import java.util.*;

public class BridgeInGraph {
    public static void main(String[] args) {
        List<List<Integer>> edges = List.of(
                List.of(0, 1),
                List.of(1, 2),
                List.of(2, 0),
                List.of(1, 3)
        );

        criticalConnections(4,edges).stream().forEach(x-> System.out.println(x));

    }

    /// This is the tarjan's Algo and the T.C. O(V+E) and S.C O(3n) + O(V+E)
    private static int time = 1;
    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adjList = getAdjList(n,connections);
        boolean[] isVisited = new boolean[n];
        int[] tin = new int[n]; Arrays.fill(tin,-1);
        int[] low = new int[n]; Arrays.fill(low,-1);
        List<List<Integer>> bridges = new ArrayList<>();
        for(int u=0;u<n;u++){
            if(tin[u] != -1) continue;
            dfs(u,-1,adjList,isVisited,tin,low,bridges);
        }
        return bridges;
    }

    private static void dfs(int u, int parent, List<List<Integer>> adjList, boolean[] isVisited,int[] tin,int[] low,List<List<Integer>> bridges){
        isVisited[u] = true;
        tin[u] = low[u] = time;
        time++;
        for(int v : adjList.get(u)){
            if(v == parent) continue;
            if(isVisited[v]){
                low[u] = Math.min(low[u],low[v]);
            }else{
                dfs(v,u,adjList,isVisited,tin,low,bridges);
                low[u] = Math.min(low[u],low[v]);
                if(low[v] > tin[u]){
                    bridges.add(Arrays.asList(u,v));
                }
            }
        }
    }

    private static List<List<Integer>> getAdjList(int n, List<List<Integer>> connections){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<>());

        for(List<Integer> edge : connections){
            int u = edge.get(0);
            int v = edge.get(1);
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }
}
