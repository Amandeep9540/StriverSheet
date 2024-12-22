package Arrays.Easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithGivenSum_GFG {
    public static void main(String[] args) {
        int count = lenOfLongestSubarrV2(new int[]{1,2,3,0,0,0,3,1,1,1,1}, 3);
        System.out.println(count);
    }



    /*
    * This solution will work if input is positive and neg both, but we can optimize it further if input have only positive values
    * */
    public static int lenOfLongestSubarr(int[] arr, int k) {
        int maxLen = 0;
        Map<Integer,Integer> preSumMap = new HashMap<>();
        int currentSum = 0;

        for(int i=0;i<arr.length;i++){
            currentSum += arr[i];
            if(currentSum == k ){
                maxLen = i+1;
            }
            if(!preSumMap.isEmpty() && preSumMap.containsKey(currentSum - k)){
                int currentLen = i - preSumMap.get(currentSum - k);
                maxLen = Math.max(currentLen,maxLen);
            }

            if(!preSumMap.containsKey(currentSum)){
                preSumMap.put(currentSum,i);
            }

        }

        return maxLen;
    }


    /*
    * This solution will only work for positive values
    * */
    public static int lenOfLongestSubarrV2(int[] arr, int k){
        int right = 0;
        int left = 0;
        int currentSum = 0;
        int maxLen = 0;

        while(left < arr.length){
            currentSum += arr[left];

            if(currentSum > k){
                while(currentSum > k && right < left){
                    currentSum -= arr[right];
                    right++;
                }
            }

            if(currentSum == k){
                int currentLen = (left - right) +1;
                maxLen = Math.max(currentLen,maxLen);
            }
            left++;
        }
        return maxLen;
    }

}
