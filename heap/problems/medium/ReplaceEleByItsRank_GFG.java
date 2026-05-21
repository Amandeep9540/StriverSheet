package heap.problems.medium;

import java.util.PriorityQueue;

public class ReplaceEleByItsRank_GFG {
    public static void main(String[] args) {
        int[] arr = {20, 15, 26, 2, 98, 6,2};
        int[] rank = replaceWithRank(arr,arr.length);
        for(int x : rank) System.out.print(x +" ");
    }

    static int[] replaceWithRank(int arr[], int N) {
        PriorityQueue<Integer[]> pQueue = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        for(int i=0;i<arr.length;i++){
            pQueue.offer(new Integer[]{arr[i],i});
        }
        int rank = 1;
        while(!pQueue.isEmpty()){
            Integer[] data = pQueue.poll();
            while(pQueue.peek() != null && pQueue.peek()[0].equals(data[0])){
                Integer[] data2= pQueue.poll();
                arr[data2[1]] = rank;
            }
            arr[data[1]] = rank;
            rank++;
        }
        return arr;
    }
}
