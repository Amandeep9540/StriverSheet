package Strings.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class IsomorphicString205 {
    public static void main(String[] args) {
        boolean isomorphic = isIsomorphic("baba", "daca");
        System.out.println("isomorphic :: "+isomorphic);
    }

    public static boolean isIsomorphic(String s, String t) {

        Map<Character,Character> sMap = new HashMap<>();
        Set<Character> tSet = new HashSet<>();

        for(int i=0;i<s.length();i++){
            if(sMap.containsKey(s.charAt(i))){
                if(sMap.get(s.charAt(i)) != t.charAt(i))
                    return false;
            }else{
                if(tSet.contains(t.charAt(i)))
                    return false;
                sMap.put(s.charAt(i),t.charAt(i));
            }
            tSet.add(t.charAt(i));
        }

        return true;
    }
}
