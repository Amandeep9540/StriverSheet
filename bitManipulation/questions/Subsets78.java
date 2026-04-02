package bitManipulation.questions;

import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> subsets = subsets(nums);
        subsets.stream().forEach(System.out::println);
    }

    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> subsets = new ArrayList<>();

        for(int i=0;i<(1<<nums.length);i++){
            List<Integer> list = new ArrayList<>();

            for(int j =0;j<n;j++){
                if((i & (1 << j)) != 0){ //if bit is not set then add that index value in list
                    list.add(nums[j]);
                }
            }

            subsets.add(new ArrayList<>(list));
        }

        return subsets;
    }
}
