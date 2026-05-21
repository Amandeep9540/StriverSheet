package heap.problems.medium;

import java.util.*;

public class HandOfStraights846 {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;

        System.out.println(" -- "+isNStraightHand(hand,groupSize));
    }

    public static boolean isNStraightHand(int[] hand, int groupSize) {
            if(hand.length % groupSize != 0) return false;
        Arrays.sort(hand);
        LinkedHashMap<Integer,Integer> freqMap = new LinkedHashMap<>();
        for(int i=0;i<hand.length;i++)
            freqMap.put(hand[i],freqMap.getOrDefault(hand[i],0)+1);

        while(!freqMap.isEmpty()){
            int firstValue =freqMap.firstEntry().getKey();
            for(int i=1;i<groupSize;i++){
                if(freqMap.containsKey(firstValue + i)){
                    updateFreq(firstValue+i,freqMap.get(firstValue + i) - 1 , freqMap);
                }else{
                    return false;
                }
            }
            updateFreq(firstValue,freqMap.get(firstValue) - 1 , freqMap);
        }

        return true;
    }

    private static void updateFreq(int key,int freq, LinkedHashMap<Integer,Integer> freqMap){
        if(freq > 0)
            freqMap.put(key, freq);
        else
            freqMap.remove(key);
    }
}
