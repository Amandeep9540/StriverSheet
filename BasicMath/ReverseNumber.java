package BasicMath;

public class ReverseNumber {
    public static void main(String[] args) {
        System.out.println("reverse number is :: "+approcach1(653453759));
    }
    public static int approcach1(int a){


        int sign = 1;
        if(a<0){
            sign = -1;
            a = -a;
        }

        int reverse = 0;
        int temp = a;
        while (temp>0){
            int lastDigit = temp % 10;
            reverse = reverse*10 + lastDigit;
            temp = temp/10;
        }
        return sign*reverse;
    }
}
