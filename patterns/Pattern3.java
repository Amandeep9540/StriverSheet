package patterns;

public class Pattern3 {
    public static void main(String[] args) {
        pattern3(5);
    }

    public static void pattern3(int a){
        for(int i=1;i<=a;i++){
            for(int j=1;j<=i;j++){
                System.out.print(j+" ");
            }
            System.out.println();
        }
    }
}
