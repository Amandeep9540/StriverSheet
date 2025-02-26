package recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllBinaryString_GFG {
    public static void main(String[] args) {
        List<String> strings = generateBinaryStringsv1(3);
        strings.forEach(System.out::println);
    }

    public static List<String> generateBinaryStrings(int n) {
        List<String> result = new ArrayList<>();
        char[] binary = new char[n];
        binary[0] = 0;
        appendValueAtEnd(binary,'0',n,result,1);
        appendValueAtEnd(binary,'1',n,result,1);
        binary[0] = 1;
        appendValueAtEnd(binary,'0',n,result,1);

        return result;
    }

    private static void appendValueAtEnd(char[] number,char addingCharacter, int n,List<String> result,int i) {
        number[i] = addingCharacter;
        if(i == (n-1)){
            result.add(new String(number));
            return;
        }
        if(addingCharacter == '0'){
            appendValueAtEnd(number,'0',n,result,++i);
            appendValueAtEnd(number,'1',n,result,i);
        } else {
            appendValueAtEnd(number,'0',n,result,++i);
        }
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
}
