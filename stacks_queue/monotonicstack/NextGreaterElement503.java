package stacks_queue.monotonicstack;

import java.util.Stack;

public class NextGreaterElement503 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,3};
        for (int i : nextGreaterElements(arr)) {
            System.out.print(" "+i);
        }

    }

    public static int[] nextGreaterElements(int[] nums) {

        Stack<Integer> stack = new Stack<>();
        int[] resArr = new int[nums.length];

        for(int i=nums.length-1;i>=0;i--){
            while(!stack.isEmpty() && (stack.peek() < nums[i])){
                stack.pop();
            }
            stack.push(nums[i]);
        }

        for(int i=nums.length-1;i>=0;i--){
            int currentValue = nums[i];
            //validating
            while(!stack.isEmpty() && (stack.peek() <= currentValue)){
                stack.pop();
            }

            resArr[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(nums[i]);
        }

        return resArr;
    }
}
