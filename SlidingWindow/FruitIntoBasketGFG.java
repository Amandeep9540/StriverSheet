package SlidingWindow;

public class FruitIntoBasketGFG {
    public static void main(String[] args) {
        int[] arr = {1,1,5,6,7,8,9};
        System.out.println("totalFruits :: "+totalFruits(arr));
    }
    public static int totalFruits(int[] arr) {

        int max = 0;
        int windowStart = 0;

        int firstChar = -1;
        int secondChar = -1;

        int firstIndex = 0;
        int secondIndex = 0;

        for(int windowEnd = 0;windowEnd<arr.length;windowEnd++){

            if(firstChar == -1){
                firstChar = arr[windowEnd];
                firstIndex = windowEnd;
            }else if(secondChar == -1 && arr[windowEnd] != firstChar){
                secondChar = arr[windowEnd];
                secondIndex = windowEnd;
            }

            if(arr[windowEnd] == firstChar){
                firstIndex = windowEnd;
            }
            else if(arr[windowEnd] == secondChar){
                secondIndex = windowEnd;
            }else{
                windowStart = Math.min(firstIndex,secondIndex) + 1;
                if(firstIndex<secondIndex){
                    firstIndex = windowEnd;
                    firstChar = arr[windowEnd];
                }else{
                    secondIndex = windowEnd;
                    secondChar = arr[windowEnd];
                }
            }
            max = Math.max(max,(windowEnd-windowStart) + 1);
        }

       return max;
    }
}
