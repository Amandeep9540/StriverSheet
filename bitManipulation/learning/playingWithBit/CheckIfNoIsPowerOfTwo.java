package bitManipulation.learning.playingWithBit;

public class CheckIfNoIsPowerOfTwo {
    /**
     * In this we need to check if the given number is the power of 2 or not .
     * If a number is power of 2 then it have only one set bit, then try to remove the last set bit
     * After that if the output is 0 then the no. is a power of 2 otherwise not.
     * */
    public static void main(String[] args) {
        int n = 16;
        boolean is2Power = (n & (n - 1)) == 0;
        System.out.println("Is "+n+" is power of 2 -- "+is2Power);
    }
}
