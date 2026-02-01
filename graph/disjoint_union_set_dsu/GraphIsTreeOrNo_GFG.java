package graph.disjoint_union_set_dsu;

import java.util.*;

public class GraphIsTreeOrNo_GFG {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>(Arrays.asList(0, 1)));
        adj.add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.add(new ArrayList<>(Arrays.asList(2, 0)));

        System.out.println("is this graph - tree " + isTree(4,3,adj));
    }

    public static boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) {
        // edge is greater then the vertex/nodes
        if(m >= n) return false;
        int[] parent = initilizeParent(n);
        int[] rank = new int[n];

        for(ArrayList<Integer> ed : edges){
            int u = ed.get(0);
            int v = ed.get(1);
            if(!union(u,v,parent,rank)){
                return false;
            }
        }

        int ownParent = 0;
        for(int i=0;i<n;i++)
        {
            if(i == parent[i]) ownParent++;
        }

        return ownParent <= 1;
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
