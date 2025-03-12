package recursion.subsequencesPatterns;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequence940 {
    public static void main(String[] args) {
        int subseqCount = distinctSubseqII("ajxjagdwzxxehvwbxhenrxtoydfobqrlugeuklytwonkrilsthwokzobvtraitboxlsazxstwnjnwnouzuzsskwteuapmmyexvdj");
        System.out.println(subseqCount);
    }

    public static int distinctSubseqII(String s) {
        long[] dp = new long[s.length()+1];
        final int mod = 1000000007;
        dp[0] = 1;

        Map<Character,Integer> map= new HashMap<>();
        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            dp[i+1] = (2 * dp[i]) % mod;
            if(map.containsKey(c)){
                dp[i+1] = (dp[i+1] - dp[map.get(c)-1] + mod) % mod;
            }
            map.put(c,i+1);
        }
        return (int)((dp[dp.length-1] -1 + mod) % mod);
    }


}
