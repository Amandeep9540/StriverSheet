package bitManipulation.learning.playingWithBit;

public class RemoveTheLastSetBit {
    /**
     * Q - Remove the last (rightmost) set bit from a number.
     * A - We can do this by performing an AND (&) operation with (n - 1).
     * For example:
     * n = 84  (01010100)
     * n - 1 = 83 (01010011)
     * If we observe, the rightmost set bit in n becomes unset in (n - 1),
     * and all the bits after it are flipped.
     *
     *   01010100
     * & 01010011
     *   01010000  -> This is the desired result.
     */
    public static void main(String[] args) {
        int n = 40;
        n = n & (n - 1);
        System.out.println("After removing rightmost bit then no. is = "+n);
    }
}
