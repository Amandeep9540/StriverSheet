package graph.spanningTree;
import java.util.*;

public class KruskalAlgo_GFG {
    public static void main(String[] args) {
        int[][] edges= {{0, 1, 5}, {1, 2, 3}, {0, 2, 1}};
        System.out.println("min spanning tree cost -- "+kruskalsMST(3,edges));
    }

    static int kruskalsMST(int V, int[][] edges) {
        Arrays.sort(edges, (a,b) -> a[2] - b[2]);
        int[] parent = initizeParent(V);
        int[] rank = new int[V];
        int spanningTreeCost = 0;
        for(int[] ed : edges){
            int u = ed[0];
            int v = ed[1];
            int wt = ed[2];
            if(find(u,parent) == find(v,parent)) continue;
            spanningTreeCost += wt;
            union(u,v,parent,rank);
        }
        return spanningTreeCost;

    }

    /// DSU find, union, initizeParent

    private static int find(int x, int[] parent){
        if(x == parent[x]) return x;
        int x_parent = find(parent[x],parent);
        parent[x] = x_parent;
        return x_parent;
    }

    private static void union(int x,int y,int[] parent,int[] rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);
        if(x_parent == y_parent) return;
        if(rank[x_parent] == rank[y_parent]){
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else{
            parent[y_parent] = x_parent;
        }
    }


    private static int[] initizeParent(int n){
        int[] parent = new int[n];
        for(int i=0;i<parent.length;i++)
            parent[i] = i;
        return parent;
    }
}
