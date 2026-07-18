package segmentTree.ques.hard;

import java.util.ArrayList;

public class HandlingSumQueries2569 {
    public static void main(String[] args) {

        Solution ques = new Solution();

        int[] nums1 = {1, 0, 1};
        int[] nums2 = {0, 0, 0};

        int[][] queries = {
                {1, 1, 1}, // Flip nums1[1]
                {2, 1, 0}, // nums2 += 1 * countOnes(nums1)
                {3, 0, 0}  // Output sum(nums2)
        };

        long[] ans = ques.handleQuery(nums1, nums2, queries);

        // Print the answer
        for (long x : ans) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
class Solution {
    int n;
    boolean[] lazy;

    public long[] handleQuery(int[] nums1, int[] nums2, int[][] queries) {
        ArrayList<Long> result = new ArrayList<>();
        int[] segmentTree = buildSegmentTree(nums1);
        long nums2Sum = getArraySum(nums2);
        for (int[] query : queries) {
            int queryType = query[0];
            if (queryType == 1) { // flip the bits from l to r in segment tree
                update(query[1], query[2], segmentTree);
            } else if (queryType == 2) { // get the total no of 1 from the segment tree and mulitply noof1Times*query[1] and + nums2Sum
                long pTimesNums1 = (long) segmentTree[0] * (long) query[1];
                nums2Sum += pTimesNums1;
            } else {
                result.add(nums2Sum);
            }
        }
        return result.stream().mapToLong(Long::longValue).toArray();
    }

    //flip the bit
    private void update(int start, int end, int[] segmentTree) {
        update(0, 0, n - 1, start, end, segmentTree);
    }

    private void update(int i,int left,int right, int start, int end, int[] segmentTree){
        propogate(i, left, right, segmentTree);
        if(end < left || start > right) return;

        if(start <= left && right <= end){
            int noOfOnes = (right - left + 1) - segmentTree[i];
            if (left != right) {
                int mid = (left + right) / 2;
                segmentTree[2*i+1] = (mid - left + 1) - segmentTree[2*i+1];
                segmentTree[2*i+2] = (right - mid) - segmentTree[2*i+2];
                lazy[2*i+1] = !lazy[2*i+1];
                lazy[2*i+2] = !lazy[2*i+2];
            }
            segmentTree[i] = noOfOnes;
            return;
        }
        if(left == right ) return;
        int mid = (left + right)/2;
        update(2*i+1,left , mid, start, end, segmentTree);
        update(2*i+2,mid+1 , right, start, end, segmentTree);
        segmentTree[i] = segmentTree[2*i+1] + segmentTree[2*i+2];
    }

    private void propogate(int i, int left, int right, int[] segmentTree) {
        if (!lazy[i])
            return;
        if (left != right) {
            int mid = (left + right) / 2;
            int leftOnes = (mid - left + 1) - segmentTree[2 * i + 1];
            int rightOnes = (right - mid) - segmentTree[2 * i + 2];
            segmentTree[2 * i + 1] = leftOnes;
            segmentTree[2 * i + 2] = rightOnes;
            lazy[2 * i + 1] = !lazy[2 * i + 1];
            lazy[2 * i + 2] = !lazy[2 * i + 2];
            segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
        }
        lazy[i] = false;
    }

    private int[] buildSegmentTree(int[] num) {
        n = num.length;
        int[] segmentTree = new int[4 * n];
        lazy = new boolean[4 * n];
        buildSegmentTree(0, 0, n - 1, segmentTree, num);
        return segmentTree;
    }

    private void buildSegmentTree(int i, int l, int r, int[] st, int[] arr) {
        if (l == r) { // base case
            st[i] = arr[l];
            return;
        }
        int mid = (l + r) / 2;
        buildSegmentTree(2 * i + 1, l, mid, st, arr);
        buildSegmentTree(2 * i + 2, mid + 1, r, st, arr);
        st[i] = st[2 * i + 1] + st[2 * i + 2];
    }

    private long getArraySum(int[] arr) {
        long sum = 0l;
        for (int x : arr)
            sum += x;
        return sum;
    }
}
