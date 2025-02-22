package Arrays.Medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix54 {

    public static void main(String[] args) {
        int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
        spiralOrder(matrix);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;

        int top = 0;
        int bottom = matrix.length - 1;


        while(right >= left && bottom >= top){

            //printing upper side of square
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            //printing right side of square
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;
            //printing lower side of square
            if(top<=bottom)
            {
                for(int i=right;i>=left;i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            //printing left side of square
            if(left<=right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
    }

}

