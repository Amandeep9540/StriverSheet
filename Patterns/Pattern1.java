package Patterns;

public class Pattern1 {
    public static void main(String[] args) {
        Patten1(4);
    }
    public static void Patten1(int a){
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
