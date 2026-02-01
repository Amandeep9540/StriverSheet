package graph.disjoint_union_set_dsu;

public class NoOfOperationToConnect1319 {
    public static void main(String[] args) {
        int[][] connections ={{0,1},{0,2},{0,3},{1,2},{1,3}};
        int n = 6;
        System.out.println(" min cable to move -- "+makeConnected(n,connections));
    }

    public static int makeConnected(int n, int[][] connections) {
        if(connections.length < (n-1)) return -1;
        int computerGroup = n;
        int[] parent = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
        int[] rank = new int[n];
        for(int i=0;i<connections.length;i++){
            if(merge(connections[i][0],connections[i][1],parent,rank))
                computerGroup--;
        }
        return Math.max(computerGroup-1,0);
    }

    private static boolean merge(int x,int y,int[] parent,int[] rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);
        if(x_parent == y_parent) return false;
        if(rank[x_parent] == rank[y_parent]){
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }else if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else {
            parent[x_parent] = y_parent;
        }
        return true;
    }

    private static int find(int x, int[] parent){
        if(x == parent[x])  return x;
        int x_parent = find(parent[x],parent);
        parent[x] = x_parent;
        return x_parent;
    }
}
