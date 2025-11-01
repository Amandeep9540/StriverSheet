package dp.dpOnLIS;
import java.util.*;

public class LongestStringChain1048 {
    public static void main(String[] args) {
        String[] words = { "xb", "xbc","cxbc", "pcxbc", "pcxbcf"};
        int len = longestStrChainBest(words);
        System.out.println("-- "+len);
    }

    /*TC-O(n logn) + O(n^2 + l) */
    public static int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int[] lis = new int[words.length];
            java.util.Arrays.fill(lis,1);
        for(int i=0;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(isChain(words[j],words[i])){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
        }
        int max = 0;
        for(int x:lis){
            max = Math.max(x,max);
        }
        return max;
    }

        //str1 is previous , str2 is current
    public static boolean isChain(String str1, String str2){
        if(str1.length() + 1 != str2.length()) return false;
        int unmatch = 0;
        int i=0;
        int j=0;
        while(i < str1.length() && j < str2.length()){
            if(str1.charAt(i) == str2.charAt(j)){
                i++;j++;
            }else{
                unmatch++;j++;
            }
            if(unmatch >= 2) return false;
        }
        return unmatch < 2;
    }

    /*TC-O(n logn) + O(n^2) */
    public static int longestStrChainBest(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        int max = 0;
        Map<String, Integer> map = new HashMap<>();
        for(String word : words){
            int best = 1;
            for(int i=0;i<word.length();i++){
                String prev = word.substring(0, i) + word.substring(i + 1);
                best = Math.max(best,map.getOrDefault(prev,0)+1);
            }
            max = Math.max(best,max);
            map.put(word,best);
        }
        return max;
    }
}
