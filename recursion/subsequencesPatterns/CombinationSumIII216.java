package recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {
    public static void main(String[] args) {
        combinationSum3(3,9).stream().forEach(System.out::println);
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();
            generateSubsets(arr,k,0,n,new ArrayList<>(),result);
        return result;
    }

    public static void generateSubsets(int[] arr,int subsetLen, int i,int requiredSum,List<Integer> tempResult,List<List<Integer>> result){
        if(requiredSum <= 0 || i >= arr.length || tempResult.size() >= subsetLen){
            if(requiredSum == 0 && tempResult.size() == subsetLen)
                result.add(new ArrayList<>(tempResult));
            return;
        }

        generateSubsets(arr,subsetLen,i+1,requiredSum,tempResult,result);

            requiredSum -= arr[i];
            tempResult.add(arr[i]);
        generateSubsets(arr,subsetLen,i+1,requiredSum,tempResult,result);
            tempResult.remove(tempResult.size() -1);

    }
}
