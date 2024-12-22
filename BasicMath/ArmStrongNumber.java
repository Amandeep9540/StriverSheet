package BasicMath;

public class ArmStrongNumber {
    public static void main(String[] args) {
        System.out.println("is armStrong :: "+isArmStrong(1634));
    }
    public static boolean isArmStrong(int a){
        int temp = a;
        int armStrong = 0;
        while(temp>0){
            int lastDigit = temp%10;
            armStrong += Math.pow(lastDigit,String.valueOf(a).length());
            temp = temp/10;
        }
        return armStrong == a?true:false;
    }
}
