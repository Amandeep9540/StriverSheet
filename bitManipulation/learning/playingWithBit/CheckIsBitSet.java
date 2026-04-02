package bitManipulation.learning.playingWithBit;

public class CheckIsBitSet {
    /**
     * Check if i'th bit is set or not
     *  -- check with right and left shift operator
     * */
    public static void main(String[] args) {
        int no = 19; // 19 = 10011
        boolean isSetUsingRight = checkBitIsSetWithRightShift(no,2);
        boolean isSetUsingLeft = checkBitIsSetWithLeftShift(no,2);
        System.out.println("According to Right Shift bit is set "+ isSetUsingRight);
        System.out.println("According to Left Shift bit is set "+ isSetUsingLeft);
    }

    /**
     The main idea to check whether the i-th bit is set or not is to perform an AND (&) operation with a number. If the output is zero, then the bit is not set; otherwise, it is set.

     We get that number by left shifting 1 by k positions (1 << k).

     In the case of right shift, we right shift the number k times and then perform an AND (&) operation with 1.
     * */

    private static boolean checkBitIsSetWithLeftShift(int no, int k) {
        int thatNo = 1;
        thatNo = thatNo << k;
        return (no & thatNo) != 0;
    }

    private static boolean checkBitIsSetWithRightShift(int no, int k) {
        no = no >> k;
        return (no & 1) != 0;
    }
}
