package recursion.subsequencesPatterns;

import java.util.HashMap;
import java.util.Map;

public class PerfectSumProblem_GFG {
    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 10, 6, 8};
        int count = perfectSum(arr,10);
        System.out.println(" -- "+count);
    }

    public static int perfectSum(int[] nums, int target) {
        return generateSubsetAndFindSum(nums,0,0,target,0);
    }

    public static int generateSubsetAndFindSum(int[] nums,int i, int currentSum, int desiredSum,int sumCount){
        if (i == nums.length) {
            return currentSum == desiredSum ? 1 : 0;
        }
                //exclude the current ele
         int exlude = generateSubsetAndFindSum(nums,i+1,currentSum,desiredSum,sumCount);
               //include the current ele
        int include = generateSubsetAndFindSum(nums,i+1,currentSum+ nums[i],desiredSum,sumCount);
        return exlude + include;
    }


}
