package bitManipulation.math;

import java.util.ArrayList;
import java.util.List;

public class PrintPrimeFactorOfNumber {
    public static void main(String[] args) {
        int no = 780;
        List<Integer> primeFactors = primeFactors(no);
        System.out.println("Prime Factors == "+primeFactors);
    }

    /**
     * Time Complexity -- O(sqrt(n) * log n)
     * Space Complexity -- O(prime Factors of that no.)
     * */
    private static List<Integer> primeFactors(int no) {
        List<Integer> primeFactors = new ArrayList<>();
        for(int i=2;i<Math.sqrt(no);i++){
                if(no % i == 0){
                    primeFactors.add(i);
                    while(no % i == 0){
                        no = no / i;
                    }
                }
        }
        if(no != 1) primeFactors.add(no);
        return primeFactors;
    }
}
