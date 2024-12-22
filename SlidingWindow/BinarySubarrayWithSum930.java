package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarrayWithSum930 {
    public static void main(String[] args) {
        int[] arr = {1,0,1,0,1};
        System.out.println("numSubarraysWithSumV2  :: "+numSubarraysWithSumV2(arr,2));
    }
    /*
    * TC :: O(n)
    * SC :: O(n)
    * */
    public static int numSubarraysWithSumV1(int[] nums, int goal) {
        int res = 0;
        int ps = 0;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            ps += nums[i];
            res += map.getOrDefault(ps-goal,0);
            map.put(ps,map.getOrDefault(ps,0)+1);
        }
        return res;
    }

    public static int numSubarraysWithSumV2(int[] nums, int goal) {
        int windowStart = 0;
        int countZero = 0;
        int result = 0;
        int windowSum = 0;

        for(int windowEnd = 0; windowEnd<nums.length;windowEnd++){
            windowSum += nums[windowEnd];

                while(windowStart<windowEnd && (nums[windowStart] == 0 || windowSum > goal)){
                    if(nums[windowStart] == 0)
                        countZero++;
                    else
                        countZero = 0;

                    windowSum -= nums[windowStart];
                    windowStart++;
                }

            if(windowSum == goal)
                result += 1 + countZero;
        }

        return result;
    }
}
