package recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses22 {
    public static void main(String[] args) {
        generateParenthesis(3).stream().forEach(System.out::println);
    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] arr = new char[2*n];
        arr[0] = '(';
        generateParenthesis(arr,1,2*n,1,result);
        return result;
    }

    public static void generateParenthesis(char[] arr,int i,int n,int openBcount,List<String> result){
        if(!isValidParenthesis(arr,i,n,openBcount)){
            return;
        }
        if(i == n){
            result.add(new String(arr));
            return;
        }
        arr[i] = '(';
        generateParenthesis(arr,i+1,n,openBcount +1,result);
        arr[i] = ')';
        generateParenthesis(arr,i+1,n,openBcount,result);
    }

    private static boolean isValidParenthesis(char[] arr, int i, int n,int openBCount) {
        int closingBcount = i - openBCount;
        if(openBCount > (n/2) || closingBcount > openBCount){
            return false;
        }
        return true;
    }
}
