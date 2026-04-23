package Strings.matchingAlgos.KMP;

public class LongestHappyPrefix1392 {
    public static void main(String[] args) {
        String str = "ababab";
        System.out.println(" -- "+longestPrefix(str));
    }

    public static String longestPrefix(String s) {
        int[] lps = new int[s.length()];
        int i = 1, len = 0;

        while(i < s.length()){

            if(s.charAt(i) == s.charAt(len)){
                len++;
                lps[i++] = len;
            }else{
                if(len != 0)
                    len = lps[len-1];
                else
                    i++;
            }

        }
        if(lps[lps.length - 1] == 0) return "";
        return s.substring(lps.length - lps[lps.length - 1]);
    }

}
