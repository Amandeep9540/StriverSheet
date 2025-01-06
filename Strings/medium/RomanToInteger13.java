package Strings.medium;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {
    public static void main(String[] args) {
        String romanNum = "MCMXCIV";
        int romanIntValue = romanToInt(romanNum);
        System.out.println("romanIntValue is :: "+romanIntValue);
    }

    public static int romanToInt(String s) {
        int sum = 0;
        int totalLen = s.length()-1;
        Map<Character,Integer> romanValueMap = getRomanValueMap();

            for(int i=0;i<totalLen;i++){
                if(romanValueMap.get(s.charAt(i+1)) > romanValueMap.get(s.charAt(i)))
                    sum -= romanValueMap.get(s.charAt(i));
                else
                    sum += romanValueMap.get(s.charAt(i));
            }

            sum += romanValueMap.get(s.charAt(s.length()-1));
        return sum;
    }

    public static Map<Character,Integer> getRomanValueMap(){
        Map<Character,Integer> romanValue = new HashMap<>();
        romanValue.put('I',1);
        romanValue.put('V',5);
        romanValue.put('X',10);
        romanValue.put('L',50);
        romanValue.put('C',100);
        romanValue.put('D',500);
        romanValue.put('M',1000);

        return romanValue;
    }
}
