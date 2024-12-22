package SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring76 {
    public static void main(String[] args) {
        System.out.println("ans is :: "+minWindow("abc","cba"));
    }

    public static String minWindow(String s, String t){
        if(t.length() > s.length())
            return "";
        int countReq = t.length();
        int startIn = -1;
        int minWindowLen = Integer.MAX_VALUE;
        int windowStart = 0;
        Map<Character,Integer> map = new HashMap<>();

                //fill the frequency
        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }

        for(int windowEnd =0;windowEnd<s.length();windowEnd++){
            if(map.containsKey(s.charAt(windowEnd))){
                if(map.get(s.charAt(windowEnd)) > 0)
                    countReq--;
                map.put(s.charAt(windowEnd),map.get(s.charAt(windowEnd))-1);
                        while(countReq<=0){
                            if((windowEnd-windowStart +1 )<minWindowLen){
                                startIn = windowStart;
                                minWindowLen = (windowEnd-windowStart)+1;
                            }
                            map.put(s.charAt(windowStart),map.get(s.charAt(windowStart))+1);
                            if(map.get(s.charAt(windowStart)) > 0)
                                countReq++;
                            windowStart++;
                        }
            }else{
                map.put(s.charAt(windowEnd),-1);
            }
        }

        return minWindowLen == Integer.MAX_VALUE ? "" :s.substring(startIn,startIn+minWindowLen);
    }
    public static String minWindowNotValid(String s, String t) {

        /*
        * 1. Track min, max in map
        * 2. Answer Min, map update by diff
        * */
        if(t.length() == 1)
            return s.indexOf(t) == -1 ? "" : t;

        Map<Character,Integer> goalMap = new HashMap<>();
        for(int i=0;i<t.length();i++){
            goalMap.put(t.charAt(i),-1);
        }

        StringBuilder sb = new StringBuilder();
        int mapMin = Integer.MAX_VALUE;
        int mapMax = Integer.MIN_VALUE;
        int ansMin = -1;
        int ansMax = -1;

        for(int i=0;i<s.length();i++){

            if(!goalMap.containsKey(s.charAt(i)))
                continue;
            goalMap.put(s.charAt(i),i);
            mapMin = findMinInMap(goalMap);
            mapMax = findMaxInMap(goalMap);
            if(mapMin != -1){
                if(ansMax == -1 )
                {
                    ansMin = mapMin;
                    ansMax = mapMax;
                }
                if((mapMax - mapMin) < (ansMax - ansMin)){
                    ansMin = mapMin;
                    ansMax = mapMax;
                }
            }
        }
        if(ansMin != -1){
            for(int i = ansMin;i<=ansMax;i++){
                sb.append(s.charAt(i));
            }
        }else{
            return "";
        }

        return sb.toString();
    }

    public static int findMinInMap(Map<Character,Integer> map){
        int min = Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> en :map.entrySet()){
            min = Math.min(en.getValue(),min);
        }
        return min;
    }
    public static int findMaxInMap(Map<Character,Integer> map){
        int max = Integer.MIN_VALUE;
        for(Map.Entry<Character,Integer> en :map.entrySet()){
            max = Math.max(en.getValue(),max);
        }
        return max;
    }
}
