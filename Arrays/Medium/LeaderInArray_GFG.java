package Arrays.Medium;

import java.util.ArrayList;
import java.util.Collections;

public class LeaderInArray_GFG {
    public static void main(String[] args) {
        int[] arr = {16, 17, 4, 3, 5, 2};
        leaders(arr);
    }

    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        int max = arr[arr.length-1];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--){
            if(arr[i] >= max){
                max = arr[i];
                ans.add(max);
            }
        }
        Collections.reverse(ans);
        return ans;
    }
}
