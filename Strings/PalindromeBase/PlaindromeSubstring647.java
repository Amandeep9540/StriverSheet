package Strings.PalindromeBase;

public class PlaindromeSubstring647 {
    public static void main(String[] args) {
        System.out.println("substring count -- "+countSubstringsV2("aaa"));

    }

    /** Bottom Up -D.P. Solution T.C - O(n^2) and S.C -  O(n^2)
    *  The institution is we first calculate the 1 size of palindrome and then 2 .... s.length()
     *  if the L = 1 (i == j) then its a palindrome , if L = 2 (i + 1 == j)then check s.charAt(i) == s.charAt(j)
     *  now if the L(palindrome size is > 2) then check if the s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1]
     *  string s = "abbcbba" i = 0 , j = 6 , (a == a) && isPalindrome[i + 1][j - 1]
    * */
    public static int countSubstrings(String s) {
        int count = 0;
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for(int L=1;L <= s.length();L++) {
            for (int i = 0; i + L - 1 < s.length(); i++) {
                int j = i + L - 1;
                if (i == j) {
                    isPalindrome[i][j] = true;
                } else if (i + 1 == j) {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    isPalindrome[i][j] = s.charAt(i) == s.charAt(j) && isPalindrome[i + 1][j - 1];
                }

                if (isPalindrome[i][j]) count++;

            }
        }
        return count;
    }

    /**
     * Expand From Center Solution T.C - O(n^2) and S.C -  O(1)
     */

    public static int countSubstringsV2(String s) {
        int count = 0;
        for(int i=0;i<s.length();i++){
            count += expand(s,i,i);
            count +=expand(s,i,i+1);
        }

        return count;
    }


    private static int expand(String str, int left, int right) {
        int count = 0;
        while(left >=0 && right < str.length() &&  str.charAt(left) == str.charAt(right)){
            right++; left--;
            count++;
        }
        return count;
    }
}
