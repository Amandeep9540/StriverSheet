package graph.shortestPath;

import java.util.*;

public class NetworkDelayTime743 {
    public static void main(String[] args) {
        int[][] times ={{2,1,1},{2,3,1},{3,4,1}};
        System.out.println("Min time taken  -- "+ networkDelayTime(times,4,2));
    }

    public static int networkDelayTime(int[][] times, int n, int k) {
        int[] dis = new int[n+1]; Arrays.fill(dis,Integer.MAX_VALUE);
        List<List<int[]>> adjList = getAdjList(times,n); // 0 -> v (target vertext ) , 1 -> weight/ time
        dis[k] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[1]-b[1]);
        queue.offer(new int[]{k,0});
        while(!queue.isEmpty()){
            int[] polledArr = queue.poll();
            int currWt = polledArr[1];
            for(int[] arr : adjList.get(polledArr[0])){
                if(dis[arr[0]] > currWt + arr[1]){
                    dis[arr[0]] = currWt + arr[1];
                    queue.offer(new int[]{arr[0],dis[arr[0]]});
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=1;i<dis.length;i++){
            max = Math.max(max,dis[i]);
        }

        return max == Integer.MAX_VALUE ? -1 : max;
    }

    public static List<List<int[]>> getAdjList(int[][] times, int n){
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++)
            adjList.add(new ArrayList<>());
        for(int i=0;i<times.length;i++){
            int u = times[i][0]; int v = times[i][1]; int wt = times[i][2];
            adjList.get(u).add(new int[]{v,wt});
        }
        return adjList;
    }
}
