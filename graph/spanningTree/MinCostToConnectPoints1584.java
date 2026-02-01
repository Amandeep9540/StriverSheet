package graph.spanningTree;

import java.util.*;

public class MinCostToConnectPoints1584 {
    public static void main(String[] args) {
        int[][] points = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        System.out.println("cost -- "+minCostConnectPoints(points));
    }

    public static int minCostConnectPoints(int[][] points) {
        return getMinCostUsingPrimAlgo(points);
    }

    private static int  getMinCostUsingPrimAlgo(int[][] points){
        int n = points.length;
        boolean[] inMst = new boolean[n];
        int[] dis = new int[n]; Arrays.fill(dis,Integer.MAX_VALUE);
        dis[0] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b)->a[1] - b[1]); // a - index, b - weight
        queue.offer(new int[]{0,0});
        int totalCost = 0;
        while(!queue.isEmpty()){
            int[] pop = queue.poll();
            int index = pop[0];
            int cost = pop[1];
            if(inMst[index]) continue;
            inMst[index] = true;
            totalCost += cost;
            for(int i=0;i<n;i++){
                if (inMst[i]) continue;
                int manhattenDis = Math.abs(points[i][0] - points[index][0]) + Math.abs(points[i][1] - points[index][1]);
                if(dis[i] > manhattenDis){
                    dis[i] = manhattenDis;
                    queue.offer(new int[]{i,manhattenDis});
                }
            }
        }
        return totalCost;
    }

    private static int getMinCostUsingKruskalAlog(int[][] points){
        int[] parent = initilzeParent(points.length);
        int[] rank = new int[points.length];
        List<int[]> adjList = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            for(int j = i+1;j<points.length;j++){
                int manhattanDis = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                adjList.add(new int[]{i,j,manhattanDis});
            }
        }
        Collections.sort(adjList,(a,b)-> a[2]- b[2]);
        int dis = 0;
        for(int[] edge : adjList){
            int u = edge[0];int v = edge[1];int wt = edge[2];
            if(find(u,parent) == find(v,parent)) continue;
            dis += wt;
            union(u,v,parent,rank);
        }
        return dis;
    }

    private static int[] initilzeParent(int n){
        int[] parent = new int[n];
        for(int i=0;i<parent.length;i++)
            parent[i] = i;
        return parent;
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

    private static int find(int x,int[] parent){
        if(x == parent[x]) return x;
        int x_parent = find(parent[x], parent);
        parent[x] = x_parent;
        return x_parent;
    }
}
