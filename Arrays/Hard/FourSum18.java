package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class FourSum18 {
    public static void main(String[] args) {
        int[] arr = {1,0,-1,0,-2,2};
        fourSum(arr,0).stream().forEach(System.out::println);
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list ;
        java.util.Arrays.sort(nums);
        int i = 0;

        while(i < nums.length - 3){
            int j = i+1;
            while(j < nums.length -2){
                int k = j+1;
                int l = nums.length-1;
                while(l>k){
                    long sum =(long) nums[i] + nums[j] + nums[k] + nums[l];
                    if(sum > target)
                        l = previousUniqueIndex(l,nums);
                    else if (sum < target)
                        k = nextUniqueIndex(k,nums);
                    else{
                        list = java.util.Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        result.add(new ArrayList<>(list));
                        l = previousUniqueIndex(l,nums);
                        k = nextUniqueIndex(k,nums);
                    }
                }
                j =  nextUniqueIndex(j,nums);
            }
            i =  nextUniqueIndex(i,nums);
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
