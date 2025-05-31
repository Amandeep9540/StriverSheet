package binarysearch.medium;

public class FindSquareRoot {
    public static void main(String[] args) {
        int sqrt = mySqrt(55);
        System.out.println(sqrt);
    }

    public static int mySqrt(int x) {
        if(x == 0) return 0;
        if(x <= 3) return 1;

        int start = 1;
        int end = x/2;
        int ans = -1;

        while(start <= end){
            int mid = start + (end - start)/2;
            long product = (long)mid*(long)mid;
            if(product == x) return mid;

            if(product > x){
                end = mid - 1;
            }else{
                ans = mid;
                start = mid + 1;
            }
        }
        return ans;
    }
}
