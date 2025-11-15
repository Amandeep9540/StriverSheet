package dp.dpOnSquares;
import java.util.*;

public class MaximalRectangle85 {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println("maximal rectangle -- "+maximalRectangle(matrix));
    }

    public static int maximalRectangle(char[][] matrix) {
        int[] newArr = new int[matrix[0].length];
        int maxLen = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == '0') newArr[j] = 0;
                newArr[j] = newArr[j] + (matrix[i][j] - '0');
            }
            int len = largestRectangleArea(newArr);
            maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }

    public static int largestRectangleArea(int[] heights) {
        int[] nsr = getNextSmallesToRight(heights);
        int[] nsl = getNextSmallesToLeft(heights);
        int maxLen = 0;
        for(int i=0;i<heights.length;i++){
            int len = ((nsr[i] - i - 1) + (i-nsl[i])) * heights[i];
            maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }

    public static int[] getNextSmallesToRight(int[] arr){
        int n = arr.length;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = arr.length-1;
        int[] nsr = new int[arr.length];
        while(i >= 0){
            //validate the stack
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){ stack.pop();}
            nsr[i] = stack.peek() == null ? n : stack.peek();
            stack.push(i--);
        }

        return nsr;
    }

    public static int[] getNextSmallesToLeft(int[] arr){
        int n = -1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        int[] nsr = new int[arr.length];
        while(i < arr.length){
            //validate the stack
            while(!stack.isEmpty() && arr[stack.peek()] >= arr[i]){ stack.pop();}
            nsr[i] = stack.peek() == null ? n : stack.peek();
            stack.push(i++);
        }
        return nsr;
    }
}
