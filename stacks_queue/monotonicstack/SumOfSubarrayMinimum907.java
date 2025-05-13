package stacks_queue.monotonicstack;

import java.util.Stack;

public class SumOfSubarrayMinimum907 {
    public static void main(String[] args) {
        int[] arr = {11,81,94,43,3};
        int sum = sumSubarrayMins(arr);
        System.out.println("Sum is :: "+sum);
    }

    public static int sumSubarrayMins(int[] arr) {
        int minSum =0;
        int moduloValue = 1_000_000_007;

        int[] nsl = getNSL(arr);
        int[] nsr = getNSR(arr);

        for(int i=0;i<arr.length;i++){
                //here we count the no. of subarray where current element is smallest
            long count = (i - nsl[i])*(nsr[i] - i);
            long currentSum = count*arr[i];
            minSum = (int) ((currentSum + minSum) % moduloValue);
        }

        return minSum;
    }

    public static int[] getNSL(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<arr.length;i++){
            //validate the stack
            while(!stack.isEmpty() && arr[stack.peek()] > arr[i]){
                stack.pop();
            }
            //push the ans
            ans[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }
        return ans;
    }


    public static int[] getNSR(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = arr.length-1;i>=0;i--){
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }
            //push the ans
            ans[i] = stack.isEmpty() ? arr.length : stack.peek();

            stack.push(i);
        }
        return ans;
    }
}
