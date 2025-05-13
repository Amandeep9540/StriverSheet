package patterns;

public class Pattern10 {
    public static void main(String[] args) {
        pattern10V2(5);
    }
    public static void pattern10(int a){
        for(int i=1;i<=a;i++){
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
        a--;
        for(int i=1;i<=a;i++){
            for(int j=a;j>=i;j--){
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void pattern10V2(int a){
        for(int i=1;i<2*a;i++){
            int stars = i;
            if(i>a){
                stars = 2*a -i;
            }
            for(int j=1;j<=stars;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
