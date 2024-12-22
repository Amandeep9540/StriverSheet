package Patterns;

public class Pattern22 {
    public static void main(String[] args) {
        pattern22(4);
    }
    public static void pattern22(int a){
        for(int i=0;i<2*a-1;i++){
            for(int j=0;j<2*a-1;j++){
                int left = j;
                int top = i;
                int bottom = (2*a-2) -i;
                int right = (2*a-2) -j;
                System.out.print(a-Math.min(Math.min(left,right),Math.min(top,bottom)));
            }
            System.out.println();
        }
    }
}
