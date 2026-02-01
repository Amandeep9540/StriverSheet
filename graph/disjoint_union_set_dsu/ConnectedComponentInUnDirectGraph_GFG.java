package graph.disjoint_union_set_dsu;

import java.util.*;

public class ConnectedComponentInUnDirectGraph_GFG {
    public static void main(String[] args) {
        int V = 5;
        int[][] edges = {{0, 1}, {2, 1}, {3, 4}};

        ArrayList<ArrayList<Integer>> connectedCom = getComponents(V,edges);
        for(ArrayList<Integer> vertex : connectedCom){
            System.out.println(vertex);
        }
    }

    public static ArrayList<ArrayList<Integer>> getComponents(int V, int[][] edges) {
        // code here
        int[] parent = initilizeParent(V);
        int[] rank = new int[V];

        for(int[] ed : edges){
            int u = ed[0];
            int v = ed[1];
            union(u,v,parent,rank);
        }

        Map<Integer,ArrayList<Integer>> connectedComMap = new HashMap<>();
        for(int i=0;i<V;i++){
            int curr_parent = find(parent[i],parent);
            ArrayList<Integer> list = null;
            if(connectedComMap.containsKey(curr_parent)){
                list = connectedComMap.get(curr_parent);
            }else{
                list = new ArrayList<>();
            }
            list.add(i);
            connectedComMap.put(curr_parent,list);
        }

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer,ArrayList<Integer>> entry : connectedComMap.entrySet()){
            result.add(entry.getValue());
        }
        return result;
    }

    public static int find(int x,int[] parent){
        if(x == parent[x]) return x;
        int x_parent = find(parent[x],parent);
        parent[x] = x_parent;
        return x_parent;
    }

    public static boolean union(int x,int y,int[] parent,int[] rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);
        if(x_parent == y_parent) return false;

        if(rank[x_parent] == rank[y_parent]){
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else{
            parent[y_parent] = x_parent;
        }
        return true;
    }

    public static int[] initilizeParent(int n){
        int[] parent = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
        return parent;
    }
}
