package graph.shortestPath;

public class SmallestConnectedCity1334 {
    public static void main(String[] args) {
        int[][] edges = {{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}};
        int n = 5;
        int distanceThreshold = 2;
        int city = findTheCity(n,edges,distanceThreshold);
        System.out.println("that city is -- "+city);
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] dis = new int[n][n];
            //STEP 1:: populate the dis arr
        for(int i=0;i<n;i++){
            dis[i][i] = 0;
        }
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0]; int v = edges[i][1]; int wt = edges[i][2];
            if(dis[u][v] == 0) dis[u][v] = edges[i][2];
            else dis[u][v] = Math.min(dis[u][v],edges[i][2]);
            if(dis[v][u] == 0) dis[v][u] = edges[i][2];
            else dis[v][u] = Math.min(dis[v][u],edges[i][2]);
        }

        //STEP 2 :: fill the dis arr using the floyd warshall algo
        for(int viz = 0;viz < n ;viz++){
            //source -> viz -> destination
            for(int src =0;src<n;src++){
                for(int des =0;des<n;des++){
                    if(src == des) continue;
                    if(dis[src][viz] == 0 || dis[viz][des] == 0) continue; // there is no edge
                    if(dis[src][des] == 0)
                        dis[src][des] = dis[src][viz] + dis[viz][des];
                    else
                        dis[src][des] = Math.min(dis[src][des],dis[src][viz] + dis[viz][des]);
                }
            }
        }

        //STEP 3 :: check the city with min connected city
        int city = n-1; int connectedCity = Integer.MAX_VALUE;
        int currConnectedCity = 0;

        for(int currCity = n-1;currCity >= 0;currCity--){
            for(int i=0;i<n;i++){
                if(dis[currCity][i] != 0 && dis[currCity][i] <= distanceThreshold){
                    currConnectedCity++;
                }
            }
            //check
            if(connectedCity > currConnectedCity){
                connectedCity = currConnectedCity;
                city = currCity;
            }
            currConnectedCity = 0;
        }

        return city;
    }

}
