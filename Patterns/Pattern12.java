package Patterns;

public class Pattern12 {
    public static void main(String[] args) {
        pattern12(5);
    }
    public static void pattern12(int a){
        for(int i=1;i<=a;i++){
            //print forward
            for(int j=1;j<=i;j++){
                System.out.print(j);
            }
            // print space
            for(int j=1;j<=2*(a-i);j++){
                System.out.print(" ");
            }
            //print reverse
            for(int j=i;j>0;j--){
                System.out.print(j);
            }

            System.out.println();
        }
    }
}
