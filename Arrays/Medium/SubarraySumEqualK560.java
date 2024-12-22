package Arrays.Medium;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualK560 {
    public static void main(String[] args) {
        subarraySum(new int[]{1,1,1},2);
    }

    public static int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> prefixSumMap = new HashMap<>();
        prefixSumMap.put(0,1);
        int subArrayPre = 0;
        int prefixSum = 0;

        for(int i=0;i< nums.length;i++){
            prefixSum += nums[i];
            if(prefixSumMap.containsKey(prefixSum-k)){
                subArrayPre += prefixSumMap.get(prefixSum-k);
            }

            prefixSumMap.put(prefixSum,prefixSumMap.getOrDefault(prefixSum,0)+1);
        }
        return subArrayPre;
    }

}

