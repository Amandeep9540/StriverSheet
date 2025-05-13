package patterns;

public class Pattern20 {
    public static void main(String[] args) {
        pattern20(5);
    }
    public static void pattern20(int a){
        for(int i=1;i<=a;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(a-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=1;i<=a;i++){
            for(int j=0;j<(a-i);j++){
                System.out.print("*");
            }
            for(int j=1;j<=2*(i);j++){
                System.out.print(" ");
            }
            for(int j=0;j<(a-i);j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
