package dp.dpOnLIS;

import java.util.*;

public class LargestDivisibleSubset368 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,8};
        List<Integer > list = largestDivisibleSubset(arr);
        list.stream().forEach(System.out::println);
    }
    public static List<Integer> largestDivisibleSubset(int[] arr) {
        Arrays.sort(arr);

        List<Integer> list = new ArrayList<>();
        int[] lis = new int[arr.length];
        Arrays.fill(lis,1);

        int[] hash = new int[arr.length];
        for(int i=0;i<arr.length;i++)
            hash[i] = i;

        //Marking the Increasing Seq
        int maxInd;
        for(int i=1;i<arr.length;i++){
            maxInd = -1;
            for(int j=0;j<i;j++){
                if(arr[i] % arr[j] == 0){
                    if(maxInd == -1){maxInd = j; continue;};
                    if(lis[j] > lis[maxInd]){
                        maxInd = j;
                    }
                }
            }
            if(maxInd != -1){
                lis[i] = lis[i] + lis[maxInd];
                hash[i] = maxInd;
            }
        }

        //getting the increasing seq
        maxInd = 0;
        for(int i=0;i<arr.length;i++){
            if(lis[maxInd] < lis[i]){
                maxInd = i;
            }
        }

        int i = maxInd;
        while(i != hash[i]){
            list.add(arr[i]);
            i = hash[i];
        }
        list.add(arr[i]);
        return list;
    }
}
