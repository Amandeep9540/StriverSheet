package Strings.slidingWindowHashing;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring76 {
    public static void main(String[] args) {
        String str = minWindow("ABBACBYBAIUB","AAB");
        System.out.println(" -- "+str);
    }

    public static String minWindow(String s, String t) {
        //Base cases
        if(t.length() > s.length()) return "";
        if(t.length() == s.length() && s.equals(t)) return s;
        else if(t.length() == s.length()) return "";


        //Main Code
        Map<Character,Integer> charFreq = getCharFreqMap(t);
        int count = charFreq.size();
        int minLen = Integer.MAX_VALUE, start = 0 , minStart = -1;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!charFreq.containsKey(c))
                continue;
            charFreq.put(c,charFreq.get(c)-1);
            if(charFreq.get(c) == 0)
                count--;

            while(count == 0){
                char prevChar = s.charAt(start);
                if(!charFreq.containsKey(prevChar)){
                    start++;continue;}

                charFreq.put(prevChar,charFreq.get(prevChar)+1);
                if(charFreq.get(prevChar) > 0)
                    count++;

                if( minLen > (i - start) ){
                    minStart = start ;
                    minLen = i-start;
                }
                start++;
            }
        }

        return minStart == -1 ? "" : s.substring(minStart,minStart+minLen+1);
    }

    private static Map<Character,Integer> getCharFreqMap(String str){
        Map<Character,Integer> charFreq  = new HashMap<>();
        for(int i=0;i<str.length();i++){
            charFreq.put(str.charAt(i),charFreq.getOrDefault(str.charAt(i),0)+1);
        }
        return charFreq;
    }
}
