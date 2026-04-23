package Strings.matchingAlgos.RabinKrap;

import java.util.HashMap;
import java.util.Map;

public class LongestDuplicateSubstring1044 {


    public static void main(String[] args) {
        System.out.println(" Duplicate substring -- "+longestDupSubstring("baniyani"));
    }
    public static Long BASE = 26L;
    public static Long MOD = 1_000_000_007L;


    public static String longestDupSubstring(String s) {
        int start = 1, high = s.length() - 1;
        int bestIndex = -1, maxLen = 0;
        while (start <= high) {
            int mid = start + (high - start) / 2;
            int index = check(s, mid);
            if (index == -1)
                high = mid - 1;
            else {
                start = mid + 1;
                if (mid > maxLen) {
                    maxLen = mid;
                    bestIndex = index;
                }
            }
        }
        return bestIndex == -1 ? "" : s.substring(bestIndex, bestIndex + maxLen);
    }

    private static int check(String str, int len) {
        Map<Long, Integer> seenHashMap = new HashMap<>();
        Long maxWeight = 1L, hash = 0L;
        for (int i = 0; i < len - 1; i++)
            maxWeight = (maxWeight * BASE) % MOD;

        //calculating the initail hash
        long factor = 1;
        for (int i = 0; i < len; i++) {
            hash = (hash * BASE + (str.charAt(i) - 'a')) % MOD;
        }
        seenHashMap.put(hash, 0);

        for (int i = len; i < str.length(); i++) {

            hash = (hash - ((str.charAt(i - len) - 'a') * maxWeight) % MOD + MOD) % MOD;
            hash = (hash * BASE) % MOD;
            hash = (hash + (str.charAt(i) - 'a')) % MOD;
            if (seenHashMap.containsKey(hash)) {
                int start1 = seenHashMap.get(hash);
                int start2 = i - len + 1;
                for (int j = 0; j < len; j++) {
                    if (str.charAt(start1 + j) != str.charAt(start2 + j))
                        break;
                    if (j == len - 1)
                        return start1;
                }
            } else {
                seenHashMap.put(hash, i - len + 1);
            }

        }

        return -1;
    }
}
