package bitManipulation.learning.playingWithBit;

public class SetIthBit {

    /**
     * Set the i-th bit means update the i-th position and put 1 there.
     * For this , we can do the OR (|) operation with 1 << i.
     * */

    public static void main(String[] args) {
        int no = 19, i = 2; // 19 = 10011 -after the set 2th bit - 10111
        no = no | (1 << i);
        System.out.println("After setting "+i+"- bit no -- "+no);
    }


}
