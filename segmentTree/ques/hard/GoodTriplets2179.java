package segmentTree.ques.hard;

import java.util.Map;
import java.util.HashMap;

public class GoodTriplets2179 {
    static int n ;
    public static void main(String[] args) {
        int[] nums1 = {2,0,1,3};
        int[] nums2 = {0,1,2,3};
        System.out.println("count -- "+goodTriplets(nums1,nums2));
    }

    public static long goodTriplets(int[] nums1, int[] nums2) {
        n = nums1.length;
        Map<Integer,Integer> nums2Map = getMapFromArr(nums2);
        int[] st = new int[4*n];

        long result = 0l;
        markVisited(nums2Map.get(nums1[0]),st);
        for(int y=1;y<n;y++){
            int pos = nums2Map.get(nums1[y]);

            int leftCommonCount = getLeftCommonEleNo(pos,nums2Map,st);
            int leftNotCommon = y - leftCommonCount;

            int elementAfterY = n - pos - 1;
            int rightCommonCount = elementAfterY - leftNotCommon;

            result += (long) leftCommonCount * rightCommonCount;
            markVisited(nums2Map.get(nums1[y]),st);

        }
        return result;
    }

    private static Map<Integer,Integer> getMapFromArr(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        return map;
    }

    private static int getLeftCommonEleNo(int y , Map<Integer,Integer> nums2Map, int[] st){
        return query(0,0,n-1,0,y-1,st);
    }

    private static int query(int idx, int left, int right, int start, int end, int[] st){
        if(left > end || right < start){  // invalid case
            return 0;
        }
        if(left >= start && right <= end){ //inside the range
            return st[idx];
        }
        int mid = left + (right - left) / 2;
        return query(2*idx+1, left, mid, start, end, st) + query(2*idx+2, mid+1, right, start, end, st);
    }

    private static void markVisited(int idx, int[] st){
        updateSegmentTree(0, 0, n-1,idx, st);
    }

    private static void updateSegmentTree(int i, int left , int right, int idx, int[] st){
        if(left == right){ // invalid case
            st[i]++; return;
        }
        int mid = left + (right - left) / 2;
        if(mid >= idx){
            updateSegmentTree(2*i+1,left,mid, idx,st);
        }else{
            updateSegmentTree(2*i+2,mid+1,right, idx,st);
        }
        st[i] = st[2*i+1] + st[2*i+2];
    }
}
