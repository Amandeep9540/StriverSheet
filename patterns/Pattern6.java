package patterns;

public class Pattern6 {
    public static void main(String[] args) {
        pattern6(5);
    }
    public static void pattern6(int a){
        for(int i=0;i<a;i++){
            for(int j=a;j>i;j--){
                System.out.print((j-i)+" ");
            }
            System.out.println();
        }
    }
}
