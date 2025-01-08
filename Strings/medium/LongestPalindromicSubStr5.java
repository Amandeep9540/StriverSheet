package Strings.medium;

public class LongestPalindromicSubStr5 {
    public static void main(String[] args) {
        String longPalindrome = longestPalindrome("babad");
        System.out.println("longest Palindrome is :: "+longPalindrome);
    }

    public static String longestPalindrome(String s) {

        if(s.length() <= 1) return s;

        String palindrome = "";
        int len = s.length() - 1; // skipping last character

        for(int i = 0; i < len; i++) {
            int end = s.length() - 1;

            if(i!=0 && (end - i) <= palindrome.length())
                break;


            while(end > i){
                if(checkPalindrome(s,i,end)){
                    if(((end - i) + 1) > palindrome.length())
                        palindrome = s.substring(i,end+1);
                    break;
                }
                end--;
            }
        }
        return palindrome.length() == 0 ?String.valueOf(s.charAt(0)):palindrome;
    }

    public static boolean checkPalindrome(String s,int start,int end) {
        while (start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
