package Arrays.Easy;

public class SecondLargest_GFG {
    public static void main(String[] args) {
        int secondLargest = getSecondLargest(new int[]{1, 8, 7, 56, 90});
        System.out.println("secondLargest  "+secondLargest);
    }

    public static int getSecondLargest(int[] arr) {
        if(arr.length == 0)
            return -1;
        int largest = -1;
        int secLargest = -1;

        for(int value : arr){
            if(value > largest){
                secLargest = largest;
                largest = value;
            } else if (value > secLargest && value < largest ) {
                secLargest = value;
            }
        }

        return secLargest;
    }
}
