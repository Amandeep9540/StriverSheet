package bitManipulation.otherQues;

public class CountingBits338 {
    public static void main(String[] args) {
        int[] bitsCount = countBits(5);
        for(int i=0;i<bitsCount.length;i++){
            System.out.println("Set bits in "+i+ " -- "+bitsCount[i]);
        }
    }

    public static int[] countBits(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;

        for(int i=1;i<=n;i++){
            if((i & 1) == 0) arr[i] = arr[i/2]; // even check (if the first bit is not set then its even)
            else arr[i] = arr[i/2] + 1;
        }

        return arr;
    }
}
