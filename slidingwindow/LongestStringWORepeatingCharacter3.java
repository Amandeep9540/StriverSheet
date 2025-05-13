package slidingwindow;

import java.util.HashMap;

public class LongestStringWORepeatingCharacter3 {
    public static void main(String[] args) {
        System.out.println("lengthOfLongestSubstring( ) "+lengthOfLongestSubstring("tmmzuxt"));
    }
    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> characterIndex= new HashMap<>();

        int windowStart = 0;
        int max = 0;

        for(int windowEnd = 0; windowEnd < s.length(); windowEnd++){
            if(!characterIndex.containsKey(s.charAt(windowEnd)) ){
                max = Math.max(max,windowEnd-windowStart +1);
                characterIndex.put(s.charAt(windowEnd),windowEnd);
            }else{
                if(characterIndex.get(s.charAt(windowEnd)) < windowStart){
                    max = Math.max(max,windowEnd-windowStart +1);
                }else {
                    windowStart = characterIndex.get(s.charAt(windowEnd)) + 1;
                }
                characterIndex.put(s.charAt(windowEnd), windowEnd);
            }
        }
        return max;
    }
}
