package bitManipulation.learning.playingWithBit;

public class ToggleIthBit {
    /**
     * Toggle the bit means flip the bit if its 0 then convert it to 1 and if its 1 then 0.
     * For this we can use the XOR ( ^ ) operator. XOR rule - if even no. of 1 then its 0 if odd then 1.
     * We can XOR with 1 << i.
     * */
    public static void main(String[] args) {
        int no = 13, i = 2; // (1101) we will toggle the 2 bit which is set
        no = no ^ (1 << i);
        System.out.println("After toggling the no -- "+no);
    }
}
