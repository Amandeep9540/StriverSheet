package SlidingWindow;

public class LongestRepeatingCharacterReplacment424 {
    public static void main(String[] args) {
            //Input - > ABAB,2 || Output -> 4
            //Input - > AABABBA,1 || Output -> 4
        System.out.println("characterReplacement :: "+characterReplacement("AABABBA",1));
    }

    public static int characterReplacementV1(String s,int k){
        int[] count = new int[26];
        int windowStart = 0;
        int max = 0;
        int result = 0;

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            count[s.charAt(windowEnd) - 'A']++;
            max = Math.max(max, count[s.charAt(windowEnd) - 'A']);
            if ((windowEnd - windowStart + 1) - max > k) {
                count[s.charAt(windowStart) - 'A']--;
                windowStart++;
            }

            result = Math.max(result, windowEnd - windowStart + 1);
        }

        return result;
    }
    public static int characterReplacement(String s, int k) {
        int windowStart = 0;
        int maxCount = 0;
        int maxWindow = 0;
        char[] freqArr = new char[26];

        for(int windowEnd = 0;windowEnd<s.length();windowEnd++){
            freqArr[s.charAt(windowEnd)-'A']++;
            maxCount = Math.max(maxCount,freqArr[s.charAt(windowEnd)-'A']);
            if((windowEnd-windowStart)-maxCount >= k){
                freqArr[s.charAt(windowStart)-'A']--;
                windowStart++;
            }
            maxWindow = Math.max(maxWindow,(windowEnd-windowStart)+1);
        }

        return maxWindow;
    }
}
