package Strings.slidingWindowHashing;

import java.util.*;

public class FindAllAnagramInStr438 {
    public static void main(String[] args) {

    }

    /**
     * This solution time complexity is O(n*26), we can reduce the time complexity to O(n) by introducing a variable
     * count to tract the count of element which is required.
     * if (freq[c - 'a'] > 0) { // inside the while loop
     *       count--;
     *  }
     *
     *  if (freq[startChar - 'a'] >= 0) { // when the window size is k
     *                     count++;
     *  }
     */
    public static List<Integer> findAnagrams(String s, String p) {
        int[] freqArr = getFreqArr(p);
        int k = p.length();
        int start = 0, end = -1;
        List<Integer> result = new ArrayList<>();
        while(++end < s.length()){
            char c = s.charAt(end);
            freqArr[c-'a']--;
            if(end - start + 1 == k){
                if(checkFreqArrIsZero(freqArr)){
                    result.add(start);
                }
                freqArr[s.charAt(start)-'a']++;
                start++;
            }
        }

        return result;
    }

    private static boolean checkFreqArrIsZero(int[] arr){
        for(int x : arr){
            if(x > 0 ) return false;
        }
        return true;
    }

    private static int[] getFreqArr(String str){
        int[] arr = new int[26];
        for(char c : str.toCharArray()){
            arr[c - 'a']++;
        }
        return arr;
    }
}
