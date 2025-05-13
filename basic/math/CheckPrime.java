package basic.math;

public class CheckPrime {
    public static void main(String[] args) {
        System.out.println("is 15 a prime "+checkPrime(15));
    }
    public static boolean checkPrime(int a){
        int count = 0;
        for(int i=1;i*i<=a;i++){
            if(a%i == 0){
                count++;
                if(a/i != i){
                    count++;
                }
            }
        }
        return count == 2? true:false;
    }
}
