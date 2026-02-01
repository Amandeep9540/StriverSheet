package graph.disjoint_union_set_dsu;

import java.util.*;

public class MostStoneRemoveFromSamRowCol947 {
    public static void main(String[] args) {
        int[][] stones = {{0,0},{0,2},{1,1},{2,0},{2,2}};
        System.out.println(" stones -- "+removeStonesDSU(stones));
    }


        /// In this we use the DFS and its Time Complexity -- O(n^2)
    public static int removeStonesDFS(int[][] stones) {
        boolean[] isVisited = new boolean[stones.length];
        int group = 0;
        for (int i = 0; i < stones.length; i++) {
            if (isVisited[i]) continue;
            dfs(i,isVisited, stones);
            group++;
        }

        return stones.length - group;
    }

    private static void dfs(int i,boolean[] isVisited, int[][] stones) {
        isVisited[i] = true;
        int row = stones[i][0];
        int col = stones[i][1];
        for(int j=0;j<stones.length;j++){
            if(isVisited[j]) continue;
            if(stones[j][0] == row || stones[j][1] == col)
                dfs(j,isVisited,stones);
        }
    }


        /// this is the DSU technique Time Complexity -- O(n^2)

   public static int removeStonesDSU(int[][] stones) {
            DSU dsu = new DSU();

            // 1 <= stones.length <= 1000 that's why we are adding the 10001 in the column
            for (int[] stone : stones) {
                dsu.union(stone[0], stone[1] + 10001);
            }

            Set<Integer> components = new HashSet<>();

            for (int[] stone : stones) {
                components.add(dsu.find(stone[0]));
            }

            return stones.length - components.size();
        }
}

class DSU {
    Map<Integer, Integer> parent = new HashMap<>();

    public int find(int x) {
        parent.putIfAbsent(x, x);

        if (x != parent.get(x))
            parent.put(x, find(parent.get(x))); // Path compression

        return parent.get(x);
    }

    public void union(int x, int y) {
        int x_parent = find(x);
        int y_parent = find(y);
        if(x_parent == y_parent) return;
        parent.put(x_parent,y_parent);
    }
}