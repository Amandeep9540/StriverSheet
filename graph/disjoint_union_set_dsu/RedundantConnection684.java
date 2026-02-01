package graph.disjoint_union_set_dsu;

public class RedundantConnection684 {
    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{2,3}};
        int[] redundantEdge = findRedundantConnection(edges);
        System.out.println(redundantEdge[0]+" -- "+redundantEdge[1]);
    }

    public static int[] findRedundantConnection(int[][] edges) {
        int[] parent = getParentArr(edges.length+1);
        int[] rank = new int[edges.length+1];

        int resultIndex = 0;
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0];
            int v = edges[i][1];
            if(!union(u,v,parent,rank)){
                resultIndex = i;
            }
        }
        return edges[resultIndex];
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

    public static int[] getParentArr(int n){
        int[] parent = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
        return parent;
    }
}
