package recursion.subsequencesPatterns;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationPhoneNumber17 {
    public static void main(String[] args) {
        letterCombinations("23").stream().forEach(System.out::println);
    }
        /*Try to use char array instead of string in map*/
    public static List<String> letterCombinations(String digits) {
        if(digits.length() == 0 ) return new ArrayList<>();
        Map<Character,String> digitMap = new HashMap<>();
        digitMap.put('2',"abc");
        digitMap.put('3',"def");
        digitMap.put('4',"ghi");
        digitMap.put('5',"jkl");
        digitMap.put('6',"mno");
        digitMap.put('7',"pqrs");
        digitMap.put('8',"tuv");
        digitMap.put('9',"wxyz");

        List<String> result = new ArrayList<>();
        generateComninations(digits,0,new StringBuilder(),digitMap,result);
        return result;
    }

    private static void generateComninations(String digits, int i, StringBuilder temp, Map<Character, String> digitMap,List<String> result) {
        if(i >= digits.length()){
            result.add(new String(temp));
            return;
        }

        String currentTypedChar = digitMap.get(digits.charAt(i));

            for(Character ch : currentTypedChar.toCharArray()){
                 temp.append(ch);
                 generateComninations(digits,i+1,temp,digitMap,result);
                 temp.deleteCharAt(temp.length()-1);
            }
    }


}
