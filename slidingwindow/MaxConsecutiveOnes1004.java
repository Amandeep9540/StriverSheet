package slidingwindow;

import java.util.Arrays;

public class MaxConsecutiveOnes1004 {
    public static void main(String[] args) {
        int[] arr = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        System.out.println("longestOnes :: "+longestOnes(arr,2));
    }

    /*
    * Time -- O(N*M)
    * */
    public static int longestOnesV2(int[] nums, int k) {
        int windowStart = 0;
        int[] zeroInArr = new int[k];
        int max = 0;
        int zeroInx = 0;

        for(int windowEnd = 0;windowEnd < nums.length;windowEnd++){
            if(nums[windowEnd] == 0 ){
                if(k!=0) {
                    if (zeroInx == k) {
                        windowStart = zeroInArr[0] +1 ;
                        zeroInx--;
                        zeroInArr[0] = windowEnd;
                        Arrays.sort(zeroInArr);
                    }
                    zeroInArr[zeroInx] = windowEnd;
                    zeroInx++;
                }else{
                    windowStart = windowEnd +1 ;
                }
            }
            max = Math.max(max, windowEnd - windowStart + 1);
        }
        return max;
    }


    public static int longestOnes(int[] nums, int k) {
        int windowStart = 0;
        int zeroCount = 0;
        int max = 0;

        for(int windowEnd = 0;windowEnd<nums.length;windowEnd++){
            if(nums[windowEnd] == 0){
                zeroCount++;
            }
            if(zeroCount > k){
                if(nums[windowStart] == 0){
                    zeroCount--;
                }
                windowStart++;
            }
            if(zeroCount<=k)
                max = Math.max(max,windowEnd-windowStart +1);
        }

        return max;
    }
}
