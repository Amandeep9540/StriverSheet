package recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum39 {
    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        List<List<Integer>> combinationSum = combinationSum(arr, 8);
        for(List<Integer> res : combinationSum){
            System.out.println("list :: > "+res);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
            generateCombinationWithSumK(candidates,target,0,result,new ArrayList<>());
        return result;
    }

    private static void generateCombinationWithSumK(int[] candidates, int target, int i, List<List<Integer>> result, ArrayList<Integer> tempList) {
                //base case
       if(target <= 0 || i >= candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
                // call take element
        tempList.add(candidates[i]);
       generateCombinationWithSumK(candidates,target - candidates[i],i,result,tempList);
                // call not take element and remove that from the tempList
        tempList.removeLast();
       generateCombinationWithSumK(candidates,target,i+1,result,tempList);
    }
}
