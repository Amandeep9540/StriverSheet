package heap.problems.hard;

import java.util.PriorityQueue;

public class KLargestInStream703 {
    public static void main(String[] args) {
        int[] arr = {};

    }

    static int k = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void KthLargest(int k, int[] nums) {
        KLargestInStream703.k = k;
        for(int num : nums)
            pq.offer(num);

        while(k < pq.size())
            pq.poll();
    }

    public static int add(int val) {
        pq.offer(val);
        if(k < pq.size()) pq.poll();
        return pq.peek();
    }
}
