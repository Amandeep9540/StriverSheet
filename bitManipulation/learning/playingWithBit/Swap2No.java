package bitManipulation.learning.playingWithBit;

public class Swap2No {
    /**
     Swap 2 integers without the third variable
     */
    public static void main(String[] args) {

        int a = 9,  b = 7;
        System.out.println("BEFORE SWAP -- a - "+a+" b - "+b);
        a = a ^ b;
        b = a ^ b; // now b = a
        a = a ^ b; // now a = (a ^ b) and b = a , so a ^ b ^ a = b

        System.out.println("AFTER SWAP -- a - "+a+" b - "+b);
    }
}
