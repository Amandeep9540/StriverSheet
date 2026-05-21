package heap.problems.hard;

import java.util.PriorityQueue;

public class MinCostOfRopes_GFG {
    public static void main(String[] args) {
        int[] arr = {4, 3, 2, 6};
        System.out.println("cost -- "+minCost(arr));
    }

    public static int minCost(int[] arr) {
        if(arr.length == 1) return 0;
        PriorityQueue<Integer> pQueue = new PriorityQueue<>();
        for(int ele : arr)
            pQueue.offer(ele);

        int cost = 0;
        while(!pQueue.isEmpty()){
            int first = pQueue.poll();
            int sec = pQueue.poll();

            cost += first+sec;

            pQueue.offer(first+sec);
            if(pQueue.size() == 1) return cost;
        }

        return -1;
    }

}
