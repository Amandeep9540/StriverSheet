package heap.problems.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFreqEle347 {
    public static void main(String[] args) {
        int[] arr = {1,2,1,2,1,2,3,1,3,2}; int k = 2;
        int[] freqEle = topKFrequent(arr,k);
        for(int ele : freqEle)
            System.out.print(ele+" ");
    }

    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freqMap = getFreqMap(nums);
        List<List<Integer>> freqList = new ArrayList<>();
        for(int i=0;i<=nums.length;i++)
            freqList.add(new ArrayList<>());

        for(Map.Entry<Integer,Integer> mapEntry : freqMap.entrySet()){
            int freq = mapEntry.getValue();
            int val = mapEntry.getKey();
            freqList.get(freq).add(val);
        }

        int[] result = new int[k];
        int index = 0;
        for(int i=nums.length;i>0;i--){
            for(int ele : freqList.get(i)){
                result[index++] = ele;
                if(index == k) return result;
            }
        }
        return result;
    }

    public static Map<Integer,Integer> getFreqMap(int[] nums){
        Map<Integer,Integer> freqMap = new HashMap<>();
        for(int num : nums)
            freqMap.put(num,freqMap.getOrDefault(num,0)+1);

        return freqMap;
    }
}
