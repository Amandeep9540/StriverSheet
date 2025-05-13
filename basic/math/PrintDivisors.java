package basic.math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintDivisors {
    public static void main(String[] args) {
        approach2(36);
    }
    public static void approach1(int a){
        System.out.print("divisors of a is \n");
        for(int i=1;i<a;i++){
            if(a%i == 0){
                System.out.print(i+" ");
            }
        }
    }

    public static void approach2(int a){
        System.out.print("divisors of a is \n");
        List<Integer> ans = new ArrayList<>();
        for(int i=1;i<=Math.sqrt(a);i++){
            if(a%i == 0){
                ans.add(i);
                if(a/i != i){
                    ans.add(a/i);
                }
            }
        }
        Collections.sort(ans);
        System.out.println(ans);
    }
}
