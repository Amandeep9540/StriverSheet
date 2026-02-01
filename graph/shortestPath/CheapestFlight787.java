package graph.shortestPath;

import java.util.*;

public class CheapestFlight787 {
    public static void main(String[] args) {
        int[][] flights = {
                {0, 1, 1},
                {0, 2, 5},
                {1, 2, 1},
                {2, 3, 1}
        };
        System.out.println("min cost -- "+findCheapestPrice(4,flights,0,3,1));;
    }


            ////S.C : O(V+E)
    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dis = new int[n];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[src] = 0;
        List<List<FlightData>> adjList = getAdjList(n,flights);
        Queue<int[]> queue = new ArrayDeque<>(); // 0-> node, 1-> cost
        queue.offer(new int[]{src,0});
        int level = 0;
        while(!queue.isEmpty() && level <= k){
            int queueSize = queue.size();
            for(int i=0;i<queueSize;i++){
                int[] polledArr = queue.poll();
                int node = polledArr[0]; int cost = polledArr[1];
                for(FlightData fd : adjList.get(node)){
                    if(dis[fd.station] > cost + fd.cost){
                        dis[fd.station] = cost + fd.cost;
                        queue.offer(new int[]{fd.station,dis[fd.station]});
                    }
                }
            }
            level++;
        }
        if(dis[dst] == Integer.MAX_VALUE) return -1;
        return dis[dst];
    }



    private static List<List<FlightData>> getAdjList(int n, int[][] flights){
        List<List<FlightData>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }

        for(int i=0;i<flights.length;i++){
            int u = flights[i][0];
            int v = flights[i][1];
            int cost = flights[i][2];
            adjList.get(u).add(new FlightData(v,cost));
        }

        return adjList;
    }
}

class FlightData{
    int station;
    int cost;
    int changeFlight;
    FlightData(int station,int cost){
        this.station = station;
        this.cost = cost;
    }
    FlightData(int station,int cost,int changeFlight){
        this.station = station;
        this.cost = cost;
        this.changeFlight = changeFlight;
    }
}
