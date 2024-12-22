package Patterns;

public class Pattern13 {
    public static void main(String[] args) {
        pattern13(5);
    }
    public static void pattern13(int a){
        int print = 1;
        for(int i=1;i<=a;i++){
            for(int j=1;j<=i;j++){
                System.out.print(print+++" ");
            }
            System.out.println();
        }
    }
}
