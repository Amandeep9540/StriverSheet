package Strings.PalindromeBase;

public class LongestPalindromeSubstring5 {
    public static void main(String[] args) {
        System.out.println("Longest palindrome -- "+ longestPalindrome("cbbd"));
    }

    public static String longestPalindrome(String s) {
        int maxLen = 0;
        int start = 0;
        for(int i=0;i<s.length();i++){
            int oddLen = expand(s,i,i);
            int evenLen = expand(s,i,i+1);

            if(maxLen < Math.max(oddLen,evenLen)){
                start = i;
                maxLen = Math.max(oddLen,evenLen);
            }
        }

        int maxStart = start - ((maxLen - 1) / 2);
        int maxEnd = start + (maxLen/2) + 1;
        return s.substring(maxStart,maxEnd);
    }

    public static int expand(String str, int left , int right){
        while(left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)){
            left--;
            right++;
        }

        return (right - left) - 1;
    }
}
