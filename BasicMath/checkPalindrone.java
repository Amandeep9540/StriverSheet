package BasicMath;

public class checkPalindrone {
    public static void main(String[] args) {
        System.out.println("is palindrone 588 "+approach1(588));
    }
    public static boolean approach1(int a){
        int reverse = 0;
        int temp = a;
        while (temp>0){
            int lastDigit = temp % 10;
            reverse = reverse*10 + lastDigit;
            temp = temp/10;
        }
        return a==reverse?true:false;
    }
}
