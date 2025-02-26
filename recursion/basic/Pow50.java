package recursion.basic;

public class Pow50 {
    public static void main(String[] args) {
        System.out.println("the myPow function output is :: "+myPow(2.00000,10));
    }

    public static double myPow(double x, int n) {
        return findPow(x,n);
    }

    public static double findPow(double x, long n) {
        if(n == 0){
            return 1;
        }
        if(n<0){
            return findPow(1/x,-n);
        }
        else if(n%2 == 0){
            return findPow(x*x,n/2);
        }else{
            return x*findPow(x*x,(n-1)/2);
        }
    }
}
