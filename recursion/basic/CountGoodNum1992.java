package recursion.basic;

public class CountGoodNum1992 {
    public static void main(String[] args) {
        System.out.println("countGoodNumbers -- "+countGoodNumbersV2(1924));
    }

    /*Time Complexity :: O(n)*/
    public static int countGoodNumbers(long n) {
        final long MOD = 1000000007;
        long result = 1;
        for(long i=0;i<n;i++){
            if(i%2 == 0){
                result = (result * 5);
            }else{
                result = (result * 4);
            }
            result = result % MOD;
        }
        return (int)result;
    }

    /*Time Complexity :: O(log n)*/
    public static int countGoodNumbersV2(long n){
            /*The game is if the current index is even then there is 5 possible value and in odd there is 4.*/
        long oddIndex = n/2;
        long evenIndex = n/2 + n%2;
        final long MOD = 1000000007;
        long value = ((getPowModule7(4l,oddIndex) % MOD) * (getPowModule7(5l,evenIndex) % MOD)) % MOD;
        System.out.println(value);
        return (int) value;
    }

    private static long getPowModule7(long base,long power) {
        final long MOD = 1000000007;
        if(power <= 0){
            return 1;
        }else if(power % 2 == 0){
            return getPowModule7((base*base)%MOD,power/2) % MOD;
        }else{
            return (base * getPowModule7((base*base)%MOD,(power-1)/2))  % MOD ;
        }
    }
}
