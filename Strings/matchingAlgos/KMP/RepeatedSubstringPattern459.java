package Strings.matchingAlgos.KMP;

public class RepeatedSubstringPattern459 {
    public static void main(String[] args) {
        String str = "abac";
        System.out.println("-- "+repeatedSubstringPatternV2(str));
    }


    /**
    * Brute Force -- T.C - O(n²) and S.C -O(n)
    * */
    public static boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        int i = n/2;
        while(i > 0){
            if(n % i == 0){
                int times = n / i;
                StringBuilder sb = new StringBuilder();
                while(times-- > 0){
                    sb.append(s.substring(0,i));
                }
                if(sb.toString().equals(s)) return true;
            }
            i--;
        }
        return false;
    }


    /**
     * This is the optimal one with the LPS array
     * T.C - O(n) S.C -O(n)
     */
    public static boolean repeatedSubstringPatternV2(String s){
        int n = s.length();
        int[] lsp = new int[n];
        int i = 1, len = 0;
        while(i < n){
            if(s.charAt(i) == s.charAt(len)){
                lsp[i++] = ++len;
            }else{
                if(len != 0 )
                    len = lsp[len-1];
                else
                    i++;
            }
        }

        int longestPrefixSuffix = lsp[n-1];
        return longestPrefixSuffix > 0 && n % (n - longestPrefixSuffix)  == 0;
    }
}
