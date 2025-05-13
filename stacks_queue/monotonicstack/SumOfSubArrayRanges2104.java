package stacks_queue.monotonicstack;

import java.util.Stack;

public class SumOfSubArrayRanges2104 {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        long sum = subArrayRanges(arr);
        System.out.println(sum);
    }


    public static long subArrayRanges(int[] nums) {
        return findGreaterSum(nums) - findSmallerSum(nums);
    }

    private static long findSmallerSum(int[] arr) {
        long sum = 0;
        int[] nsl = new int[arr.length];
        int[] nsr = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        //filling the next smaller to left
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            nsl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(i);
        }
        stack.clear();
        //filling the next smaller to right
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            nsr[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.add(i);
        }

        for(int i=0;i<arr.length;i++){
            sum += ((long)((nsr[i] - i) * (i - nsl[i])) * arr[i]) - arr[i];
        }

        return sum;
    }

    public static long findGreaterSum(int[] arr){
        long sum = 0;
        int[] ngl = new int[arr.length];
        int[] ngr = new int[arr.length];

        Stack<Integer> stack = new Stack<>();

        //filling next greater to left
        for(int i=0;i<arr.length;i++){
            while(!stack.isEmpty() &&  arr[stack.peek()] < arr[i]){
                stack.pop();
            }
            ngl[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.add(i);
        }
        stack.clear();
        //filling next greater to right
        for(int i=arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] <= arr[i]){
                stack.pop();
            }
            ngr[i] = stack.isEmpty() ? arr.length : stack.peek();
            stack.add(i);
        }

        for(int i=0;i<arr.length;i++){
            sum += ((long)((ngr[i] - i) * (i - ngl[i])) * arr[i]) - arr[i];
        }

        return sum;
    }
}
