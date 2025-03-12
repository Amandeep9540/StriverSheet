package recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryString_GFG {
    public static void main(String[] args) {
        List<String> strings = generateBinaryStringsv1(3);
        //strings.forEach(System.out::println);

        List<String> lcresult = validStrings_LC_3211(3);
        lcresult.forEach(System.out::println);
    }

    public static List<String> generateBinaryStringsv1(int n) {
        List<String> result = new ArrayList<>();
        if (n == 0) return result;
        StringBuilder sb = new StringBuilder();
        sb.append('0');
        appendValueAtEndV1(sb, n, result);

        sb = new StringBuilder();
        sb.append('1');

        appendValueAtEndV1(sb, n, result);
        return result;
    }

    private static void appendValueAtEndV1(StringBuilder number, int n, List<String> result) {
        if (number.length() == n) {
            result.add(number.toString());
            return;
        }
        char lastChar = number.charAt(number.length() - 1);
        if (lastChar == '0') {
            number.append('0');
            appendValueAtEndV1(number, n, result);
            number.deleteCharAt(number.length() - 1);
            // Append '1'
            number.append('1');
            appendValueAtEndV1(number, n, result);
            number.deleteCharAt(number.length() - 1);
        } else {
            // Can only append '0'
            number.append('0');
            appendValueAtEndV1(number, n, result);
            number.deleteCharAt(number.length() - 1);
        }
    }

    public static List<String> validStrings_LC_3211(int n) {
        if(n == 0)
            return new ArrayList<>();
        List<String> result = new ArrayList<>();
        generateBinaryStringWAZ(new char[n],0,n,result);
        return result;
    }

    public static void generateBinaryStringWAZ(char[] arr,int i,int n,List<String> result){
        if(i == n){
            result.add(new String(arr));
            return;
        }
            //its first call
            if(i == 0){
                arr[0] = '1';
                generateBinaryStringWAZ(arr,i+1,n,result);
                arr[0] = '0';
                generateBinaryStringWAZ(arr,i+1,n,result);
                return;
            }
            if(arr[i-1] == '1'){
                arr[i] = '1';
                generateBinaryStringWAZ(arr,i+1,n,result);
                arr[i] = '0';
                generateBinaryStringWAZ(arr,i+1,n,result);
            }else{ // means there is 0
                arr[i] = '1';
                generateBinaryStringWAZ(arr,i+1,n,result);
            }
    }
}
