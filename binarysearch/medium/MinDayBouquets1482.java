package binarysearch.medium;

public class MinDayBouquets1482 {
    public static void main(String[] args) {
        int[] arr = {1,10,3,10,2};
        System.out.println("Min day -- "+minDays(arr,3,1));
    }
    public static int minDays(int[] bloomDay, int m, int k) {
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;
        int minBloomDay = Integer.MAX_VALUE;
        for(int day:bloomDay){
            start = Math.min(start,day);
            end = Math.max(end,day);
        }

        while(start <= end){
            int mid = start + (end - start)/2;

            if(canMakeBoudque(bloomDay,m,k,mid)){
                minBloomDay = Math.min(minBloomDay,mid);
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return minBloomDay == Integer.MAX_VALUE ? -1 : minBloomDay;
    }

    public static boolean canMakeBoudque(int[] bloomDays,int bouquetsNeeded,int adjancentFlowerNeeded,int bloonDay){
        int adjFlowerCount = 0;
        int bouqueCount = 0;
        for(int i=0;i<bloomDays.length;i++){
            if(isFlowerBloomed(bloomDays[i],bloonDay)){
                adjFlowerCount++;
            }else{
                adjFlowerCount = 0;
            }

            if(adjFlowerCount == adjancentFlowerNeeded){
                bouqueCount++;
                adjFlowerCount = 0;
            }
        }

        return bouqueCount >= bouquetsNeeded;
    }

    public static boolean isFlowerBloomed(int currentDay, int bloomDay){
        return currentDay <= bloomDay;
    }
}
