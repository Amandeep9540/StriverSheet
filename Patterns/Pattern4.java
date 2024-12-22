package Patterns;

public class Pattern4 {
    public static void main(String[] args) {
        pattern4(5);
    }
    public static void pattern4(int a){
        for(int i=1;i<=a;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}
