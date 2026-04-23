package Strings.slidingWindowHashing;

import java.util.HashSet;
import java.util.Set;

public class LongSubStringWithoutRepeatedChars3 {
    public static void main(String[] args) {
        System.out.println("Len -- "+lengthOfLongestSubstring("abcabcbb"));

    }

    public static int lengthOfLongestSubstring(String s) {
        Set<Character> seenChars = new HashSet<>();
        int start = 0 , end = 0;
        int maxLen = 0;
        while(end < s.length()){
            if(seenChars.contains(s.charAt(end))){
                // srink the window until we got the s.charAt(start) = s.charAt(end)
                while(s.charAt(start) != s.charAt(end)){
                    seenChars.remove(s.charAt(start++));
                }
                start++;
            }else{
                seenChars.add(s.charAt(end));
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}
