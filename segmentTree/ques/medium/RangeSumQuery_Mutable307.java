package segmentTree.ques.medium;

public class RangeSumQuery_Mutable307 {
    public static void main(String[] args) {
        int[] query = new int[]{1, 3, 5};
        NumArray ques = new NumArray(query);
        System.out.println("sum range - "+ques.sumRange(0,2));
        ques.update(1,2);
        System.out.println("sum range - "+ques.sumRange(0,2));
    }

    static class NumArray{
        int[] segmentTreeArr ;
        int n ;
        public NumArray(int[] nums) {
            n = nums.length;
            segmentTreeArr = new int[4*n];
            buildSegmentTree(0,0,n-1,nums,segmentTreeArr);
        }

        public void update(int index, int val) {
            update(index,val,0,0,n-1,segmentTreeArr);
        }

        public int sumRange(int left, int right) {
            return query(left, right, 0, 0, n-1,segmentTreeArr);
        }

        public void update(int index, int val, int i, int l ,int r, int[] segmentTreeArr){
            if(l == r){
                segmentTreeArr[i] = val;
                return;
            }
            int mid = l + (r-l)/2;
            if(index <= mid){
                update(index,val,2*i+1,l,mid,segmentTreeArr);
            }else{
                update(index,val,2*i+2,mid+1,r,segmentTreeArr);
            }
            segmentTreeArr[i] = segmentTreeArr[2*i+1] + segmentTreeArr[2*i+2];
        }

        public int query(int start, int end, int i, int l, int r, int[] segmentTreeArr){
            if(start > r || end < l) return 0; // out of bound case
            if(start <= l && r <= end) return segmentTreeArr[i];

            int mid = l + (r-l)/2;
            return query(start,end, 2*i+1, l, mid , segmentTreeArr) + query(start,end, 2*i+2, mid + 1, r , segmentTreeArr);
        }

        public void buildSegmentTree(int i, int l , int r , int[] arr, int[] segmentTreeArr){
            if(l == r){
                segmentTreeArr[i] = arr[l];
                return;
            }
            int mid = l + (r-l)/2;
            buildSegmentTree(2*i + 1, l , mid , arr, segmentTreeArr);
            buildSegmentTree(2*i + 2, mid+1 , r , arr, segmentTreeArr);

            segmentTreeArr[i] = segmentTreeArr[2*i + 1] + segmentTreeArr[2*i + 2];
        }
    }
}
