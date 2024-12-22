package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class SubarrayWithKdistinct992 {
    public static void main(String[] args) {
      int[] arr = {1,2,1,2,3};
      int k = 2;
      int subArrayCount = subarraysWithKDistinct(arr,k);
        System.out.println("SubArray count is :: "+subArrayCount);
    }
    /*
    * This is approach 1 type in this
    *  Time Complexity is :: O(4n) -- 0(2n) + O(2n)
    *  Space Complexity is :: O(n)
    * */
    public static int subarraysWithKDistinctV1(int[] arr,int k){
        return  subarraysWithKDistinctSubFunc(arr,k) - subarraysWithKDistinctSubFunc(arr,k-1);
    }
    public static int subarraysWithKDistinctSubFunc(int[] nums, int k) {
        int windowStart = 0;
        int count = 0;
        Map<Integer,Integer> mapFrequency= new HashMap<>();

        for(int windowEnd = 0;windowEnd< nums.length;windowEnd++){
            mapFrequency.put(nums[windowEnd], mapFrequency.getOrDefault(nums[windowEnd],0)+1);

                while(mapFrequency.size()>k){
                    mapFrequency.put(nums[windowStart],mapFrequency.get(nums[windowStart])-1);
                    if(mapFrequency.get(nums[windowStart]) == 0){
                        mapFrequency.remove(nums[windowStart]);
                    }
                    windowStart++;
                }
            count += (windowEnd - windowStart) + 1;
        }

        return count;
    }


    public static int subarraysWithKDistinct(int[] nums,int k){
        int count =0;
        int windowStart =0; // minimumWindow
        int maximumWindow = 0;
        Map<Integer,Integer> freqMap = new HashMap<>();

        for(int windowEnd =0; windowEnd < nums.length;windowEnd++){
            freqMap.put(nums[windowEnd],freqMap.getOrDefault(nums[windowEnd],0)+1);
                    //reduce the window
            while(freqMap.size()>k){
                freqMap.put(nums[windowStart],freqMap.get(nums[windowStart]) -1);
                if(freqMap.get(nums[windowStart]) == 0){
                    freqMap.remove(nums[windowStart]);
                }
                windowStart++;
                maximumWindow = windowStart;
            }
                    // reduce the frequency
            while(freqMap.get(nums[windowStart]) > 1){
                freqMap.put(nums[windowStart],freqMap.get(nums[windowStart]) -1);
                windowStart++;
            }

            if(freqMap.size() == k){
                count += (windowStart - maximumWindow) +1;
            }
        }

        return count;
    }
}
