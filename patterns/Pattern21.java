package patterns;

public class Pattern21 {
    public static void main(String[] args) {
        pattern21(5);
    }
    public static void pattern21(int a){
        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                if((i==0 || j==0) || (i==(a-1) || j==(a-1))){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}

