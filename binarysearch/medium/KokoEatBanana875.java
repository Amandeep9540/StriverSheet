package binarysearch.medium;

public class KokoEatBanana875 {
    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        System.out.println("min speed -- "+minEatingSpeed(arr,8));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int high = getMax(piles);
        int low = 1;
        int lowestSpeed = Integer.MAX_VALUE;
        while(high >= low){
            int mid = low + (high - low)/2;
            if(canKukuEatBanan(piles,mid,h)){
                lowestSpeed = Math.min(lowestSpeed,mid);
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return lowestSpeed;
    }

    public static boolean canKukuEatBanan(int[] plies,int currentSpeed,int totalHours){
        long timeTaking  = 0;
        for(int pile : plies){
            timeTaking += pile/currentSpeed;
            if(pile % currentSpeed != 0) timeTaking++;
        }
        return totalHours >= timeTaking;
    }

    public static int getMax(int[] piles){
        int currentMax = Integer.MIN_VALUE;
        for(int x : piles){
            currentMax = Math.max(x,currentMax);
        }
        return currentMax;
    }
}
