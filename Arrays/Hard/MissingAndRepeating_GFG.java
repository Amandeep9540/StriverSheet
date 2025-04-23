package Arrays.Hard;

import java.util.ArrayList;

public class MissingAndRepeating_GFG {
    public static void main(String[] args) {
        int[] arr = {4, 3, 6, 2, 1, 1};
        findTwoElement(arr).stream().forEach(System.out::println);
    }


    /*
    *
    *
    * */
    public static ArrayList<Integer> findTwoElement(int arr[]) {
        int n = arr.length;
        long arrSum = 0;
        long arrSqSum = 0;

        for(int x:arr){
            arrSum += (long) x;
            arrSqSum += (long) x * (long)x;
        }

        long nSum =(long) n*(n+1)/2;
        long nSqSum =(long) n*(n+1)*(2*n +1)/6;

        long eq1 = nSum - arrSum;
        long eq2 = nSqSum - arrSqSum;
        eq2 = eq2/eq1;

        long repeating = (eq1+eq2) / 2;
        long missing = repeating - eq1;


        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) missing);
        result.add((int) repeating);
        return result;
    }
}
