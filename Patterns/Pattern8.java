package Patterns;

public class Pattern8 {
    public static void main(String[] args) {
        pattern8(5);
    }
    public static void pattern8(int a){
        int lowerLimit = 0;
        int upperLimit = 2*a;
        for(int i=1;i<=a;i++){
            for(int j=1;j<=((2*a)-1);j++){
                if(j>lowerLimit && j<upperLimit){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            lowerLimit++;
            upperLimit--;
        }
    }
}
