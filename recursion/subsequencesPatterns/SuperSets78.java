package recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.List;

public class SuperSets78 {
    public static void main(String[] args) {
        subsets(new int[]{1,2,4}).stream().forEach(subset->System.out.println(subset));
    }

    public static List<List<Integer>> subsets(int[] nums) {
         List<List<Integer>> result = new ArrayList<>();
         generateAllSubests(nums,0,new ArrayList<>(),result);
         return result;
    }

    private static void generateAllSubests(int[] nums, int i, List<Integer> subset, List<List<Integer>> result) {
            //base case
        if(i>=nums.length){
            result.add(new ArrayList<>(subset));
            return;
        }

            //taking the ith element
        subset.add(nums[i]);
        generateAllSubests(nums,i+1,subset,result);
            //not taking the ith element
        subset.remove(subset.size() - 1);
        generateAllSubests(nums,i+1,subset,result);
    }
}
