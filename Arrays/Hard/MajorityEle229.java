package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class MajorityEle229 {
    public static void main(String[] args) {
        int[] arr = {1,2};
        majorityElement(arr).stream().forEach(System.out::println);

    }

    public static List<Integer> majorityElement(int[] nums) {
        int count1 = 0; int count2 = 0;
        int var1 = Integer.MIN_VALUE; int var2 = Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();

        for(int num : nums){
            if(count1 == 0 && num != var2){
                var1 = num;
                count1++;
            }else if(count2 == 0 && num != var1){
                var2 = num;
                count2++;
            }else if(num == var1){
                count1++;
            }else if(num == var2){
                count2++;
            }else{
                count1--; count2--;
            }
        }

        //checking manually is our var1 var2 has more than n/3 occurcence.
        int requiredCount = nums.length / 3;

        count1 = 0;count2 = 0;
        for(int num : nums){
            if(num == var1){
                count1++;
            }else if(num == var2){
                count2++;
            }
        }

        if(count1 > requiredCount) result.add(var1);
        if(count2 > requiredCount) result.add(var2);

        return result;
    }
}
