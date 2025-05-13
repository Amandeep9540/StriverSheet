package patterns;

public class Pattern14 {
    public static void main(String[] args) {
        pattern14(5);
    }
    public static void pattern14(int a){
        for(int i=1;i<=a;i++){
            char printValue = 'A';
            for(int j=1;j<=i;j++){
                System.out.print(printValue++);
            }
            System.out.println();
        }
    }
}
