package bitManipulation.questions;

public class XorOfARange {
    public static void main(String[] args) {
        System.out.println("XOR of Range -- "+findXOROfRange(4,7));
    }

    public static int findXORToN(int n){
        if(n % 4 == 0) return n;
        if(n % 4 == 1) return 1;
        if(n % 4 == 2) return n+1;
        return 0;
    }

    public static int findXOROfRange(int left, int right){
        return findXORToN(left-1) ^ findXORToN(right);
    }
}
