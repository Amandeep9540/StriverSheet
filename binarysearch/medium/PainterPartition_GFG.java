package binarysearch.medium;

public class PainterPartition_GFG {
    public static void main(String[] args) {
        int[] arr = {5, 10, 30, 20, 15};
        System.out.println("min time-- > "+minTime(arr,3));
    }

    public static int minTime(int[] arr, int k) {
        int high = 0;
        int low = Integer.MIN_VALUE;
        for(int ele:arr){
            low = Math.max(low,ele);
            high += ele;
        }
        if(k == 1) return high;
        if(k == arr.length) return low;
        int ans = -1;
        while(high >= low){
            int mid = (low + high)/2;
            if(canPainterDoneWork(arr,k,mid)){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }

    public static boolean canPainterDoneWork(int[] boards,int painters,int unit){
        int currentPainterRequired = 1;
        int currentWork = 0;
        for(int i=0;i<boards.length;i++){
            if((currentWork + boards[i]) > unit){
                currentWork = boards[i];
                currentPainterRequired++;
            }else{
                currentWork += boards[i];
            }
        }
        return currentPainterRequired <= painters;
    }
}
