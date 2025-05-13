package patterns;

public class Pattern19 {
    public static void main(String[] args) {
        pattern19(5);
    }
    public static void pattern19(int a){
        for(int i=1;i<=a;i++){
                    //print first right half of upper side
            for(int j=0;j<=(a-i);j++){
                System.out.print("*");
            }
                    //print space of right half side
            for(int j=0;j<2*(i-1);j++){
                System.out.print(" ");
            }
                    //print space of left half upper side
            for(int j=0;j<=(a-i);j++){
                System.out.print("*");
            }
            System.out.println();
        }

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
    }
}
