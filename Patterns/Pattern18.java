package Patterns;

public class Pattern18 {
    public static void main(String[] args) {
        pattern18(5);
    }
    public static void pattern18(int a){
        for(int i=0;i<a;i++){
                char value = (char) (64 +(a-i));
            for(int j=0;j<=i;j++){
                System.out.print(value++);
            }
            System.out.println();
        }
    }
}
