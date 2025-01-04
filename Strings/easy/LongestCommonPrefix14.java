package Strings.easy;

import java.util.Arrays;

public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        String commonPrefix = longestCommonPrefix(new String[]{"flower", "flu", "flight"});
        System.out.println("commonPrefix is :: "+commonPrefix);
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 1)
            return strs[0];

        Arrays.sort(strs);

        int start = 0;

        while(start < strs[0].length()){
            if(strs[0].charAt(start) != strs[strs.length-1].charAt(start))
                break;
            start++;
        }

        return strs[0].substring(0,start);
    }
}
