package bitManipulation.otherQues;
import java.util.Arrays;

public class SortIntegerBySetBits1356 {
    public static void main(String[] args) {
        int[] arr = {0,1,2,3,4,5,6,7,8};
        int[] sortedArr = sortByBits(arr);
        Arrays.stream(sortedArr).forEach(System.out::println);
    }

    public static int[] sortByBits(int[] arr) {
        Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);

        Arrays.sort(boxed,(x,y)->{
            int xSetBits = findSetBits(x);
            int ySetBits = findSetBits(y);

            if(xSetBits == ySetBits) return Integer.compare(x,y);
            return Integer.compare(xSetBits,ySetBits);
        });

        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxed[i];
        }
        return arr;
    }


    public static int findSetBits(int x){
        int setBits = 0;
        while(x != 0){
            setBits += x & 1;
            x = x >> 1;
        }
        return setBits;
    }
}
