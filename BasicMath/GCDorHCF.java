package BasicMath;

public class GCDorHCF {
    public static void main(String[] args) {
        System.out.println("GCD or HCF "+approach3(18,20));
    }
    public static int approach1(int a,int b){
        for(int i= Math.min(a,b);i>=1;i--){
            if(a%i==0 && b%i==0){
                return i;
            }
        }
        return -1;
    }

    //        Euclidean Algorithm
    // GCD(a,b) = GCD(b-a,b) where b>a
    public static int approach2(int a,int b){
        while(a>0 && b>0){
            if(a>b) a = a-b;
            else b = b-a;
        }
        if(a == 0) return  b;
        else return a;
    }

    // in euclidean algorithm consider the example of 50 and 5 then we see there is multiple steps performing to
    // subtract the data, instead of subtracting we can use module operator.

    // GCD(a,b) = GCD(b%a,b)
    public static int approach3(int a,int b){
        while(a>0 && b>0){
            if(a>b) a = a%b;
            else b = b%a;
        }
        if(a == 0) return  b;
        else return a;
    }
}
