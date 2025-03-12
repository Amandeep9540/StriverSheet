package recursion.subsequencesPatterns;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class BetterString_GFG {
    public static void main(String[] args) {
        String betterString = betterString("Chartt", "deep");
        System.out.println(" :: betterString is :: "+betterString);
    }

    /*
    * This is brute force solution its takes O(2^n) time complexity and O(2^n) space complexity.
    * We can use leetcode question DistinctSubsequence940 to optimize this.
    * */
    public static String betterStringNaive(String str1, String str2) {
        Set<String> str1Set = new HashSet<>();
        Set<String> str2Set = new HashSet<>();

        generateAllSubsequence(str1,0,new char[str1.length()],0,str1Set);
        generateAllSubsequence(str2,0,new char[str2.length()],0,str2Set);

        return str1Set.size() >= str2Set.size() ? str1 : str2;
    }

    public static void generateAllSubsequence(String str, int strInd, char[] charArr, int charInd, Set<String> set){
                //base case
        if(strInd >= str.length())
            return;
                //take action
        charArr[charInd] = str.charAt(strInd);
        set.add(new String(charArr));
        generateAllSubsequence(str,strInd+1,charArr,charInd+1,set);
                //not take action
        charArr[charInd] = '\0';
        set.add(new String(charArr));
        generateAllSubsequence(str,strInd+1,charArr,charInd,set);
    }

    public static String betterString(String str1, String str2) {
        long[] dp1 = new long[str1.length()+1];

        dp1[0] = 1;

        Map<Character,Integer> map= new HashMap<>();
        for(int i = 0;i<str1.length();i++){
            char c = str1.charAt(i);
            dp1[i+1] = (2 * dp1[i]);
            if(map.containsKey(c)){
                dp1[i+1] = (dp1[i+1] - dp1[map.get(c)-1] );
            }
            map.put(c,i+1);
        }


        long[] dp2 = new long[str2.length()+1];
        dp2[0] = 1;

        Map<Character,Integer> map2= new HashMap<>();
        for(int i = 0;i<str2.length();i++){
            char c = str2.charAt(i);
            dp2[i+1] = (2 * dp2[i]);
            if(map2.containsKey(c)){
                dp2[i+1] = (dp2[i+1] - dp2[map2.get(c)-1] );
            }
            map2.put(c,i+1);
        }

        return dp1[dp1.length-1] >= dp2[dp2.length-1] ? str1 : str2;
    }


}
