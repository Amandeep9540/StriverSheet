package patterns;

public class Pattern5 {
    public static void main(String[] args) {
        pattern5(5);
    }
    public static void pattern5(int a){
        for(int i=0;i<a;i++){
            for(int j=a;j>i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
