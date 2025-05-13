package stacks_queue.monotonicstack;

import java.util.Stack;

public class MaximalRectangles85 {
    public static void main(String[] args) {
        char[][] arr = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };

        int maximalRectangle = maximalRectangle(arr);
        System.out.println("maximalRectangle :: "+maximalRectangle);
    }


    public static int maximalRectangle(char[][] matrix){

        if(matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int largestRectangle = 0;
        for(char[] row:matrix){
            for(int i=0;i<row.length;i++){
                heights[i] = row[i] == '1' ? heights[i]+1 : 0;
            }
            largestRectangle = Math.max(largestRectangle,largestRectangleArea(heights));
        }
        return largestRectangle;
    }


    public static int largestRectangleArea(int[] heights) {
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
