package patterns;

public class Pattern2 {
    public static void main(String[] args) {
        pattern2(5);
    }
    public static void pattern2(int a){
        for(int i=0;i<a;i++){
            for(int j=0;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
