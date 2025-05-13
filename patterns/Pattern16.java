package patterns;

public class Pattern16 {
    public static void main(String[] args) {
        pattern16(5);
    }
    public static void pattern16(int a){
        char printValue = 'A';
        for(int i=1;i<=a;i++){
            for(int j=1;j<=i;j++){
                System.out.print(printValue);
            }
            printValue++;
            System.out.println();
        }
    }
}
