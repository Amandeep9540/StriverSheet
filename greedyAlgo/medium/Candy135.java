package greedyAlgo.medium;

public class Candy135 {
    public static void main(String[] args) {
        int[] ratings = {1,2,2};
        System.out.println("count -- "+candy(ratings));
    }

    public static int candy(int[] ratings) {
        int i = 1; int candyCount = 1;
        while(i < ratings.length){

            if(ratings[i] == ratings[i-1]){
                i++; candyCount++; continue;
            }

            int peak = 1;
            while( i < ratings.length && ratings[i] > ratings[i-1]){
                peak++;
                candyCount += peak;
                i++;
            }

            int down = 1;
            while( i < ratings.length && ratings[i] < ratings[i-1]){
                candyCount += down; i++; down++;
            }

            if(peak < down){
                candyCount += (down - peak);
            }
        }

        return candyCount;
    }
}
