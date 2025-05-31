package binarysearch.medium;

public class CapacityToShipInMinDays1011 {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("shipWithinDays --> "+shipWithinDays(arr,5));
    }

    public static int shipWithinDays(int[] weights, int days) {
        long end = 0;
        for(int x:weights){
            end += x;
        }
        long start = 1;
        int minWeightNeeded = Integer.MAX_VALUE;
        while(start <= end){
            int mid = (int) start + (int)(end - start)/2;

            if(canWeCarry(weights,mid,days)){
                minWeightNeeded = Math.min(minWeightNeeded,mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return minWeightNeeded;
    }

    public static boolean canWeCarry(int[] weights,int currentCapacity,int days){
        int carringWeight = 0;
        int daysRequired = 0;
        for(int x : weights){
            if(x > currentCapacity) return false;
            if((carringWeight + x) > currentCapacity){
                carringWeight = 0;
                daysRequired++;
            }
            carringWeight += x;
        }
        if(carringWeight > 0 ) daysRequired++;
        return daysRequired <= days;
    }
}
