package bitManipulation.learning.playingWithBit;

public class ClearIthBit {
    /**
     * Clear the i-th bit means update the i-th position with 0.
     * For this, we can do the and ( & ) operation with a no. who's all bit are set except i-th bit
     * For that no. we can do not (~) operation with (1 << i)
     */
    public static void main(String[] args) {
        int no = 19, i = 1; // 19 = 10011 -after the clear 1th bit - 10001
        no = no & ~( (1 << i));
        System.out.println("After setting "+i+"- bit no -- "+no);
    }
}
