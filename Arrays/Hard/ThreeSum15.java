package Arrays.Hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum15 {
    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        threeSum(arr).stream().forEach(System.out::println);
    }

    public static List<List<Integer>> threeSumNaive(int[] nums) {
        List<List<Integer>> tripletSums = new ArrayList<>();
        Set<List<Integer>> recordedTriplets = new HashSet<>();

        java.util.Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            // Anchor first number
            // Two-pointer method on two-sum, just remember to add anchored number

            int l = i + 1;
            int r = nums.length - 1;

            while (l < r) {
                int currSum = nums[i] + nums[l] + nums[r];
                if (currSum == 0) {
                    List<Integer> testTriplet = java.util.Arrays.asList(nums[i], nums[l], nums[r]);
                    if (!recordedTriplets.contains(testTriplet)) {
                        tripletSums.add(testTriplet);
                        recordedTriplets.add(testTriplet);
                    }

                    l++;
                } else if (currSum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        return tripletSums;
    }


    /*Best Approach :: TC --> O(n)logn + O(n2)*/
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list ;
        java.util.Arrays.sort(nums);
        int i = 0;
        while(i < nums.length - 2){
            int j = i+1;
            int k = nums.length - 1;
            while(k>j){
                int currentSum = nums[i] + nums[j] + nums[k];
                if(currentSum > 0)
                    k = previousUniqueIndex(k,nums);
                else if(currentSum < 0)
                    j = nextUniqueIndex(j,nums);
                else{
                    list = java.util.Arrays.asList(nums[i],nums[j],nums[k]);
                    result.add(new ArrayList<>(list));
                    k = previousUniqueIndex(k,nums);
                    j = nextUniqueIndex(j,nums);
                }
            }
            i = nextUniqueIndex(i,nums);
        }
        return result;
    }

    public static int nextUniqueIndex(int index,int[] arr){
        int currentEle = arr[index];
        while(index < arr.length - 1){
            index = index + 1;
            if(arr[index] != currentEle)
                return index;
        }
        return arr.length;
    }

    public static int previousUniqueIndex(int index,int[] arr){
        int currentEle = arr[index];
        while(index > 0){
            index = index - 1;
            if(arr[index] != currentEle)
                return index;
        }
        return -1;
    }
}
