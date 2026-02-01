package graph.learning;

import java.util.ArrayList;
import java.util.*;

public class GraphDFSTraversal_GFG {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(2, 3, 1)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(0, 4)));
        adj.add(new ArrayList<>(Arrays.asList(0)));
        adj.add(new ArrayList<>(Arrays.asList(2)));

        List<Integer> dfsTravel = dfs(adj);
        System.out.println(dfsTravel);
    }

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        //Map<Integer,Boolean> visitedMap = new HashMap<>();
        boolean[] visitedArr = new boolean[adj.size()];
        ArrayList<Integer> list = new ArrayList<>();
        dfs(adj,0,visitedArr,list);
        return list;
    }

    public static void dfs(ArrayList<ArrayList<Integer>> adj, int u, boolean[] visitedArr, List<Integer> result){
        if(visitedArr[u] == true) return;
        result.add(u);
        visitedArr[u] = true;
        for(int v : adj.get(u)){
            if(visitedArr[v] == false){
                dfs(adj,v,visitedArr,result);
            }
        }
    }
}
