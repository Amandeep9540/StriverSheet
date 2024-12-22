package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem1 {
    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{3,2,4}, 6);
        if(ints != null) {
            System.out.println(ints[0]);
            System.out.println(ints[1]);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> arrMap = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int reqSum = target-nums[i];
                if(arrMap.containsKey(reqSum)){
                    return new int[]{i,arrMap.get(reqSum)};
                }
            arrMap.put(nums[i],i);
        }

        return null;
    }
}
