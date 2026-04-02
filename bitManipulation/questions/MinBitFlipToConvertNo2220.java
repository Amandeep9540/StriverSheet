package bitManipulation.questions;

public class MinBitFlipToConvertNo2220 {
    public static void main(String[] args) {
        System.out.println("Bit needs to flip == "+minBitFlips(10,7));
    }

    public static int minBitFlips(int start, int goal) {
        // For this we can use the XOR operator in that if the both bit are set then the result if unset bit ,
        // if one bit is set then result is set bit

        int result = start ^ goal;
        return bitCount(result);
    }

    private static int bitCount(int no){
        int count = 0;
        while(no > 0){
            count += no & 1;
            no = no >> 1;
        }
        return count;
    }
}
