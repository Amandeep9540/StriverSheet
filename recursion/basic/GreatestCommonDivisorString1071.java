package recursion.basic;

public class GreatestCommonDivisorString1071 {
    public static void main(String[] args) {
//        int gcd = findGCD(10,190);
//        System.out.println(gcd);
        System.out.println(gcdOfStrings("LEET","CODE"));
    }

    public static String gcdOfStrings(String str1, String str2) {
        if(str1.concat(str2).equals(str2+str1)){ // mens str1 and str2 have some common sequence that in present on both string in n and m times.
            int gcd = findGCD(str1.length(),str2.length());
            return str1.substring(0,gcd);
        }else{
            return "";
        }
    }

        /*To find the GCD we are using Euclidean Algorithm, in this we are subtracting a and b until someone become 0 and then other/nonzero is GCD.
        * We are using modulo because at the time of subtracting we will get the modulo.
        * */
    private static int findGCD(int a, int b) {
        if(b == 0){
            return a;
        }
        return findGCD(b,a%b);
    }
}
