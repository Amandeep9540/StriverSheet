package recursion.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PalindronePartitioning131 {
    public static void main(String[] args) {
        partition("abc").stream().forEach(list-> System.out.println(list));
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s.length() <=1){
            result.add(Arrays.asList(s));
            return result;
        }
            generateAllPalindronePartition(s.toCharArray(),0,new ArrayList<>(),result);
        return result;
    }

    private static void generateAllPalindronePartition(char[] arr, int ci, ArrayList<String> tempResult, List<List<String>> result) {
        if(ci == arr.length){
            result.add(new ArrayList<>(tempResult));
            return;
        }
        for(int i = ci; i < arr.length; i++){
            if(isPalindrone(arr, ci, i)){
                tempResult.add(new String(arr, ci, i - ci + 1));
                generateAllPalindronePartition(arr, i + 1, tempResult, result);
                tempResult.remove(tempResult.size() - 1);
            }
        }
    }

    public static boolean isPalindrone(char[] arr, int start, int end){
        while(start < end){
            if(arr[start] != arr[end]){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
