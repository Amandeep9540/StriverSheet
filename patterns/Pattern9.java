package patterns;

public class Pattern9 {
    public static void main(String[] args) {
        pattern9V2(5);
    }
    public static void pattern9(int a){
        int lowerLimit = a-1;
        int upperLimit = a+1;
        for(int i=1;i<=2*a;i++){
            for(int j=1;j<=((2*a)-1);j++){
                if(j>lowerLimit && j<upperLimit){
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
            if(i>a){
            lowerLimit++;
            upperLimit--;
            }
            else if(i==a){
                lowerLimit=0;
                upperLimit = 2*a;
            }
            else{
                lowerLimit--;
                upperLimit++;
            }
        }
    }

    public static void pattern9V2(int a){
        Pattern7.pattern7(a);
        Pattern8.pattern8(a);
    }
}
