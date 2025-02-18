package Stacks_Queue.implementproblem;


import java.util.*;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] window = maxSlidingWindow(arr, k);
        for(int ele:window){
            System.out.print(" "+ele);
        }
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || k ==1)
            return nums;

        if(nums.length == k){
            int[] result = new int[1];
            result[0] = Arrays.stream(nums).max().getAsInt();
            return result;
        }

        int[] result = new int[nums.length - (k-1)];
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0;i< nums.length;i++){
            //remove the element that are not of current window
            while(!deque.isEmpty() && i>=(k-1) && deque.peekFirst() <= (i-k)){
                deque.removeFirst();
            }

            //validate the stack by current element
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[i]){
                deque.removeLast();
            }

            deque.addLast(i);
            if(i>=(k-1)){
                result[i-(k-1)] = nums[deque.peekFirst()];
            }
        }

        return result;
    }
}
