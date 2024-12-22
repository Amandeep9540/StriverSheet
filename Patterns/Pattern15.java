package Patterns;

public class Pattern15 {
    public static void main(String[] args) {
        pattern15(5);
    }
    public static void pattern15(int a){
        for(int i=1;i<=a;i++){
            char printValue = 'A';
            for(int j=a;j>=i;j--){
                System.out.print(printValue++);
            }
            System.out.println();
        }
    }
}
