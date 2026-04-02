package bitManipulation.questions;

public class DivideTwoIntegers29 {

    public static void main(String[] args) {
        int dividend = 10 , divisor = 3;
        System.out.println("quotient == "+divide(dividend,divisor));
    }

    public static int divide(int dividend, int divisor) {
        if (dividend == divisor)
            return 1;

        // Edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;

        boolean isPos = (dividend >= 0) == (divisor >= 0);

        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        long ans = 0;

        while (dvd >= dvs) {
            int count = 0;
            while (dvd >= (dvs << (count + 1))) { // dvs << (count + 1)) = dvs * Math.pow(2,count+1)
                count++;
            }
            ans += (1L << count); // (1L << count) = 1 * Math.pow(2,count)
            dvd -= (dvs << count); // (dvs << count) = dvs * Math.pow(2,count)
        }

        return isPos ? (int) ans : (int) -ans;
    }

}
