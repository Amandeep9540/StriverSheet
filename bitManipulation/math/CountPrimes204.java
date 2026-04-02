package bitManipulation.math;

public class CountPrimes204 {
    public static void main(String[] args) {
        int n = 10;
        System.out.println("Prime Count -- "+countPrimes(10));
    }

    public static int countPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for(int i=2;i<Math.sqrt(n);i++){
            if(!isPrime[i]){ // means its false means it's prime
                for(int j=i+i;j<n;j+=i){
                    isPrime[j] = true;
                }
            }
        }

        int count =0;
        for(int i=2;i<n;i++){
            if(!isPrime[i])
                count++;
        }

        return count;
    }
}
