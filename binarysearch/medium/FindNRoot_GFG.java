package binarysearch.medium;

public class FindNRoot_GFG {
    public static void main(String[] args) {
        int base = nthRoot(2, 10);
        System.out.println("base is -- "+base);
    }

    public static int nthRoot(int n, int target) {
        if(target == 1 && n == 1) return 1;

        int low = 1;
        int high = target;
        while(high>=low){
            int mid = low + (high - low)/2;
            long currPow =(long) Math.pow(mid,n);
            if(currPow == target) return mid;

            if(currPow > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
