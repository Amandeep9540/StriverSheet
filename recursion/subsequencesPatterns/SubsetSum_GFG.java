package recursion.subsequencesPatterns;

import java.util.ArrayList;

public class SubsetSum_GFG {
    public static void main(String[] args) {
        int[] arr = {1,2,4};
        subsetSums(arr).stream().forEach((num)->System.out.print(num+" "));

    }

    public static ArrayList<Integer> subsetSums(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
            getSumOfAllSubsets(arr,0,0,ans);
        return ans;
    }

    private static void getSumOfAllSubsets(int[] arr, int i, int sum,ArrayList<Integer> resutlArr) {
        if(i>= arr.length){
            resutlArr.add(sum);
            return;
        }
                //take call
        sum += arr[i];
            getSumOfAllSubsets(arr,i+1,sum,resutlArr);
            // not take call
        sum -= arr[i];
            getSumOfAllSubsets(arr,i+1,sum,resutlArr);
    }


}
