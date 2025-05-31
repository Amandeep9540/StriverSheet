package binarysearch.medium;

public class AggressiveCow_GFG {
    public static void main(String[] args) {
        int[] stalls = {1,2,4,8,9};
        System.out.println("min distance b/w cows -- "+aggressiveCows(stalls,3));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        java.util.Arrays.sort(stalls);
        int start = 1;
        int end = stalls[stalls.length - 1];
        int minDis = -1;
        while(end >= start){
            int mid = (start + end)/2;
            if(canPlaceCow(stalls,mid,k)){
                minDis = Math.max(mid,minDis);
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return minDis;
    }

    public static boolean canPlaceCow(int[] stalls,int disRequired,int cowRequired){
        int placedCows = 0;
        int currentDis = 0;
        for(int i=1;i<stalls.length;i++){
            currentDis += stalls[i] - stalls[i-1];
            if(currentDis >= disRequired){
                currentDis = 0;
                placedCows++;
            }
            if(placedCows >= (cowRequired-1)) return true; // because first cow is placed at first place
        }
        return false;
    }
}
