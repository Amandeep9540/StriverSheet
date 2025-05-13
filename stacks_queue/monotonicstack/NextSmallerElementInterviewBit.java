package stacks_queue.monotonicstack;

import java.util.Stack;

public class NextSmallerElementInterviewBit {
    public static void main(String[] args) {
        int[] arr = {2,5,2,4,9,1};
        for (int i : prevSmaller(arr)) {
            System.out.print(" "+i);
        }

    }
    public static int[] prevSmaller(int[] nums) {
        int[] ansArr = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for(int num : nums){
            //validate the stack
            while(!stack.isEmpty() && stack.peek() > num){
                stack.pop();
            }
            //populate data in ansArr
            ansArr[i++] = stack.isEmpty() ? -1 : stack.peek();
            //add the element in stack
            stack.add(num);
        }
        return ansArr;
    }
}
