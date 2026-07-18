package segmentTree.ques.hard;

public class FindBuildingWhereTwoMeet2940 {
    public static void main(String[] args) {
        int[] heights = {9, 5, 6, 100};
        int[][] queries = {{0,1}};
        int[] result = leftmostBuildingQueriesV2(heights,queries);
        System.out.println(" - "+result[0]);
    }

        //Time Limit Exceeded    (945 / 953 testcases passed)
    public static int[] leftmostBuildingQueriesV1(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] st = constructST(heights,n);
        int[] result = new int[queries.length];
        int i = 0;
        for(int[] query : queries){
            int minIdx = Math.min(query[0],query[1]);
            int maxIdx = Math.max(query[0],query[1]);

            if(minIdx == maxIdx) result[i] = minIdx;
            else if(heights[maxIdx] > heights[minIdx]) result[i] = maxIdx;
            else{
                for(int j=maxIdx;j<n;j++){
                    if(heights[j] > Math.max(heights[maxIdx],heights[minIdx])){
                        result[i] = j;
                        break;
                    }
                    if(j == n-1) result[i] = -1;
                }
            }
            i++;
        }
        return result;
    }

    public static int[] leftmostBuildingQueriesV2(int[] heights, int[][] queries) {
        int n = heights.length;
        int[] st = constructST(heights,n);
        int[] result = new int[queries.length];
        int i = 0;
        for(int[] query : queries){
            int minIdx = Math.min(query[0],query[1]);
            int maxIdx = Math.max(query[0],query[1]);

            if(minIdx == maxIdx) result[i] = minIdx;
            else if(heights[maxIdx] > heights[minIdx]) result[i] = maxIdx;
            else{
                //now we need to do binary search here and get from l = maxIdx +1 to r = n -1
                int left = maxIdx + 1;
                int right = n - 1;
                int ansIdx = Integer.MAX_VALUE;
                while(right >= left){
                    int mid = left + (right - left) / 2;
                    int currMaxIdx = RMIQ(heights,st,left,mid);
                    if(currMaxIdx != -1 && heights[currMaxIdx] > Math.max(heights[minIdx],heights[maxIdx])){
                        ansIdx = Math.min(ansIdx,currMaxIdx);
                        right = mid - 1;
                    }else{
                        left = mid + 1;
                    }
                }
                if(ansIdx == Integer.MAX_VALUE){
                    result[i] = -1;
                }else{
                    result[i] = ansIdx;
                }
            }
            i++;
        }
        return result;
    }

    private static int[] constructST(int[] arr, int n){
        int[] st = new int[4*n];
        buildSegmentTree(0,0,n-1,arr,st);
        return st;
    }

    private static void buildSegmentTree(int i,int left, int right, int[] arr, int[] st){
        if(left == right ){
            st[i] = left; return;
        }
        int mid = left + (right - left) / 2;
        buildSegmentTree(2*i+1,left, mid, arr,st);
        buildSegmentTree(2*i+2,mid+1, right, arr,st);
        int leftIndex = st[2*i+1]; int rightIndex = st[2*i+2];
        st[i] = (arr[leftIndex] >= arr[rightIndex]) ? leftIndex : rightIndex;
    }

    private static int RMIQ(int[] arr,int[] st, int start, int end){
        return query(0,0,arr.length-1,arr,st, start , end);
    }

    private static int query(int i, int left ,int right,int[] arr, int[] st, int start, int end){
        //invalid left and right
        if (right < start || left > end) return -1;
        //inside the start and end
        if(start <= left && end >= right) return st[i];
        //divide the prob
        int mid = left + (right - left )/ 2;
        int leftRes = query(2*i+1,left,mid,arr,st,start,end);
        int rightRes = query(2*i+2,mid+1,right,arr,st,start,end);
        if(leftRes == -1 ) return rightRes;
        if(rightRes == -1) return leftRes;
        return arr[leftRes] >= arr[rightRes] ? leftRes : rightRes;
    }
}
