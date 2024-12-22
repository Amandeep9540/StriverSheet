package Patterns;

public class Pattern7 {
    public static void main(String[] args) {
        pattern7V2(8);
    }
    public static void pattern7(int a){
        for(int i=1;i<=a;i++){
            for(int j=1;j<=(a-i);j++){
                System.out.print(" ");
            }
            for(int j=1;j<=(2*i-1);j++){
                System.out.print("*");
            }
            for(int j=1;j<=(a-i);j++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static void pattern7V2(int a){
        int lowerLimit = a-1;
        int upperLimit = a+1;
        for(int i=1;i<=a;i++){
            for(int j=1;j<=((2*a)-1);j++){
                if(j>lowerLimit && j<upperLimit){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            lowerLimit--;
            upperLimit++;
        }
    }

}
