package segmentTree.ques.hard;

import java.util.HashMap;
import java.util.Map;

public class LongestBalancedSubArr3721{
    public static void main(String[] args) {
        int len = longestBalanced(new int[]{2,4,5,2,2,7});
        System.out.println("len -- "+len);
    }

    public static int longestBalancedV1(int[] nums) {
        int[] cumulativeSum = new int[nums.length];
        Map<Integer,Integer> seenMap = new HashMap<>();
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int value = nums[i] % 2 == 0 ? 1 : -1;
            int seenIdx = 0;
            if(seenMap.containsKey(nums[i])){
                seenIdx = seenMap.get(nums[i]) + 1;
            }
            //put the - value from the 0 to seenIndex
            for(int j=seenIdx;j<=i;j++)
                cumulativeSum[j] += value;

            //add the value from 0 to i
            for(int j=0;j<=i;j++){
                if(cumulativeSum[j] == 0){
                    ans = Math.max(ans, i -j + 1);
                }
            }
            //check if the zero exists or not
            seenMap.put(nums[i],i);
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }


    static int[] minSt;
    static int[] maxSt;
    static int[] lazySt;
    static int n;

    public static int longestBalanced(int[] nums) {
        n = nums.length;
        minSt = new int[4*n];
        maxSt = new int[4*n];
        lazySt = new int[4*n];

        Map<Integer,Integer> seenMap = new HashMap<>();


        int ans = 0;
        for(int i=0;i<nums.length;i++){
            int value = nums[i] % 2 == 0 ? 1 : -1;
            int seenIdx = 0;
            if(seenMap.containsKey(nums[i])){
                seenIdx = seenMap.get(nums[i]) + 1;
            }

            updateSegmentTree(seenIdx,i,value);

            int leftMostZeroIdx = getLeftZeroIdx(0,i);
            if(leftMostZeroIdx != -1)
                ans = Math.max(ans, i - leftMostZeroIdx + 1);
            //check if the zero exists or not
            seenMap.put(nums[i],i);
        }

        return ans;
    }

    public static void updateSegmentTree(int left, int right, int value){
        updateSegmentTree(left,right, 0 ,0, n-1, value);
    }

    public static void updateSegmentTree(int start, int end, int i , int left, int right, int value){
        propogateValue(i, left, right);
        if(end < left || right < start) return; // invalid range
        if(start <= left && end >= right){ //inside the range
            lazySt[i] += value;
            propogateValue(i, left, right);
            return;
        }

        int mid = left + (right - left)/ 2;
        updateSegmentTree(start,end,2*i+1,left , mid, value);
        updateSegmentTree(start,end,2*i+2,mid+1 , right, value);

        minSt[i] = Math.min(minSt[2*i+1],minSt[2*i+2]);
        maxSt[i] = Math.max(maxSt[2*i+1],maxSt[2*i+2]);
    }

    public static int getLeftZeroIdx(int left, int right){
        return query(0,0,n-1,left,right);
    }

    public static int query(int i,int left, int right, int start, int end){
        propogateValue(i, left, right);
        if(right < start || left > end) return -1;
        if (minSt[i] > 0 || maxSt[i] < 0) return -1;

        if (left == right) return left; // if i am reaching here means the leaf node has a zero

        int mid = left + (right - left)/2;
        int idx = query(2*i +1,left, mid, start, end);
        if(idx != -1) return idx;
        return query(2*i +2,mid+1, right, start, end);
    }

    public static void propogateValue(int i, int left, int right){
        if(lazySt[i] == 0) return;
        minSt[i] += lazySt[i];
        maxSt[i] += lazySt[i];

        if(left != right){ //update child
            lazySt[2*i + 1] += lazySt[i];
            lazySt[2*i + 2] += lazySt[i];
        }
        lazySt[i] = 0;
    }

}
