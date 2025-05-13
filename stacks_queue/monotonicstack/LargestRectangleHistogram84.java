package stacks_queue.monotonicstack;

import java.util.Stack;

public class LargestRectangleHistogram84 {
    public static void main(String[] args) {

    }

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();

        int[] nsl = new int[heights.length];
        for(int i=0;i<heights.length;i++){
            //validate stack
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            nsl[i] = stack.isEmpty() ? -1: stack.peek();
            stack.add(i);
        }
        stack = new Stack<>();
        int[] nsr = new int[heights.length];
        for(int i=heights.length-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            nsr[i] = stack.isEmpty() ? heights.length: stack.peek();
            stack.add(i);
        }

        int largestHeight = 0;
        for(int i=0;i<heights.length;i++){
            int currentHistogramHeight ;
            currentHistogramHeight = ((i - nsl[i] -1) + (nsr[i] - i)) * heights[i];
            largestHeight = Math.max(largestHeight,currentHistogramHeight);
        }

        return largestHeight;
    }
}
