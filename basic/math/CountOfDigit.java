package basic.math;

public class CountOfDigit {
    public static void main(String[] args) {
        approach2(55445);
    }
    public static void approach1(int a){
        int count = 0;
        while(a>0){
            count++;
            a = a / 10;
        }
        System.out.println("Digit count is :: "+count);
    }
    public static void approach2(int a){
        System.out.println("Digit count is :: "+(int)(Math.log10(a)+1));
    }
}
