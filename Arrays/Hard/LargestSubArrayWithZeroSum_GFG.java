package Arrays.Hard;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWithZeroSum_GFG {
    public static void main(String[] args) {
        int[] arr = {15,-2,2,-8,1,7,10,23};
        System.out.println("--> "+maxLen(arr));
    }

    public static int maxLen(int arr[]) {
        int currentSum = 0;
        int maxLen = 0;
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0;i<arr.length;i++){
            currentSum += arr[i];
            if(currentSum == 0){
                maxLen = i+1;
            }else if(map.containsKey(currentSum)){
                int currLen = i - map.get(currentSum);
                maxLen = Math.max(currLen,maxLen);
            }else{
                map.put(currentSum,i);
            }
        }
        return maxLen;
    }
}
