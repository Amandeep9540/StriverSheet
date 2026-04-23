package Strings.matchingAlgos.KMP;

public class RepeatedStringMatch686 {
    public static void main(String[] args) {
        System.out.println("count -- "+repeatedStringMatch("abcd","cdabcdab"));
    }

    public static int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;


        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // check current
        if (checkPatternExistis(sb.toString(), b))
            return count;

        // check one more append
        sb.append(a);
        if (checkPatternExistis(sb.toString(), b))
            return count + 1;

        return -1;
    }

    //We are using the KMP alog to detect the pattern
    public static boolean checkPatternExistis(String text, String pattern) {
        int[] lps = new int[pattern.length()];
        int m = text.length();
        int n = pattern.length();
        int i = 1, len = 0;
        // filling the LPS
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        //checking the pattern

        i = 0;
        int j = 0;
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            } else {
                if (j != 0)
                    j = lps[j - 1];
                else
                    i++;
            }

            if (j == n)
                return true;
        }
        return false;
    }
}
