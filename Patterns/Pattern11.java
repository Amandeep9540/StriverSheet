package Patterns;

public class Pattern11 {
    public static void main(String[] args) {
        patten11(5);
    }
    public static void patten11(int a){
        int print;
        for(int i=0;i<a;i++){
            print =i%2==0?1:0;
            for(int j=0;i>=j;j++){
                System.out.print(print+" ");
                print = 1 - print;
            }
            System.out.println();
        }
    }
}
