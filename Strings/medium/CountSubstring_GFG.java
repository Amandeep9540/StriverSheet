package Strings.medium;

import java.util.HashMap;
import java.util.Map;

public class CountSubstring_GFG {
    public static void main(String[] args) {
        int substr = countSubstr("abaaca",1);
        System.out.println("substring count :: "+substr);
    }

    public static int countSubstr(String s, int k) {
        return countSubstringWithKORLessKDistinct(s, k) - countSubstringWithKORLessKDistinct(s, k - 1);
    }

    public static int countSubstringWithKORLessKDistinct(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;
        int count = 0;

        while(left < str.length()) {
            map.put(str.charAt(left), map.getOrDefault(str.charAt(left), 0) + 1);
            while(map.size() > k ){
                int occurence = map.get(str.charAt(right)) - 1;
                if(occurence == 0){
                    map.remove(str.charAt(right));
                }else{
                    map.put(str.charAt(right), occurence);
                }
                right++;
            }
            count += (left - right) + 1;
            left++;
        }
        return count;
    }
}
