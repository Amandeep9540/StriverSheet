package recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII90 {
    public static void main(String[] args) {
        int[] arr = {1,2,2};
        subsetsWithDup(arr).stream().forEach(System.out::println);
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
            generateSubSet(nums,0,new ArrayList<>(),result);
        return result;
    }

    private static void generateSubSet(int[] nums, int i, List<Integer> tempResult,List<List<Integer>> result) {
        result.add(new ArrayList<>(tempResult));

            for(int j=i;j<nums.length;j++){
                    if(j>i && nums[j] == nums[j-1]) continue;
                tempResult.add(nums[j]);
                generateSubSet(nums,j+1,tempResult,result);
                tempResult.remove(tempResult.size()-1);
            }
    }
}
