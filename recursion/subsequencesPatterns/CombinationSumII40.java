package recursion.subsequencesPatterns;

import java.util.*;

public class CombinationSumII40 {
    public static void main(String[] args) {
        int[] arr = {2,5,2,1,2};
        int target = 5;
        combinationSum2(arr,target).stream().forEach(System.out::println);
    }

    /*
    * This is a naive solution :: time complexity O(2^n).
    * */
    public static List<List<Integer>> combinationSum2Naive(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> resultSet = new HashSet<>();
            generateAllUniqueSubsetWithSumK(candidates,0,target,resultSet,new ArrayList<>());
        return new ArrayList<>(resultSet);
    }

    private static void generateAllUniqueSubsetWithSumK(int[] candidates, int i, int target, Set<List<Integer>> result, List<Integer> tempList) {
        if(target <= 0 || i >= candidates.length){
            if(target == 0){
                result.add(new ArrayList<>(tempList));
            }
            return;
        }

                // call for -- take action recursive call
        tempList.add(candidates[i]);
        generateAllUniqueSubsetWithSumK(candidates,i+1,target - candidates[i],result,tempList);
                // call for -- not take action recursive
        tempList.remove(tempList.size() - 1);
        generateAllUniqueSubsetWithSumK(candidates,i+1,target,result,tempList);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
            generateAllUniqueSubsetWithSumKWithSkiping(candidates,0,target,new ArrayList<>(),result);
        return result;
    }

    private static void generateAllUniqueSubsetWithSumKWithSkiping(int[] candidates, int i, int target, ArrayList<Integer> tempList, List<List<Integer>> result) {
        if(target == 0){
            result.add(new ArrayList<>(tempList));
            return;
        }

            for(int j = i;j < candidates.length;j++){
                if(j > i && candidates[j] == candidates[j - 1]){
                    continue;
                }
                if(candidates[i] > target){
                    break;
                }
                tempList.add(candidates[j]);
                generateAllUniqueSubsetWithSumKWithSkiping(candidates,j+1,target-candidates[j],tempList,result);
                tempList.remove(tempList.size() - 1);
            }
    }

}
