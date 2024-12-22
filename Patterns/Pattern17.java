package Patterns;

public class Pattern17 {
    public static void main(String[] args) {
        pattern17(4);
    }
    public static void pattern17(int a){
        for(int i=1;i<=a;i++){
                //print first triangle
                            // print the space
            for(int j=1;j<=(a-i);j++){
                System.out.print(" ");
            }
                            // print the letter
            for(int j=1;j<=i;j++){
                System.out.print((char)(64+j));
            }
                //print second triangle
            for(int j=i;j>1;j--){
                System.out.print((char) (63+j));
            }
            System.out.println();
        }
    }
}
