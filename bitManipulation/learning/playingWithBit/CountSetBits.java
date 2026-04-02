package bitManipulation.learning.playingWithBit;

public class CountSetBits {
    public static void main(String[] args) {
        countSetBitsForPositiveOnly(40);

        countSetBits(-103);
    }

    /**
     * Count the set bits for positive number only
     * */
    public static void countSetBitsForPositiveOnly(int no){
        int temp = no;
        int setBitCount = 0;
        while(temp > 0){
            setBitCount += temp & 1; // if the last bit is set then 1 otherwise 0. Faster then check odd or even using module op.
            temp = temp >> 1; // Right shift by 1 means, we remove the right bit or we divided the no. by 2.
        }

        System.out.println("Count (manual) -- "+setBitCount);
        System.out.println("Count (built-in) --" +Integer.bitCount(no));
    }

    /**
     * Count the set bits
     * */
    public static void countSetBits(int no){
        int temp = no;
        int setBitCount = 0;

        while(temp != 0){
            setBitCount += (temp & 1);
            temp = temp >>> 1; // this is Unsigned Right Shift , it's shifts bits to the right and fills left side with 0.
        }

        System.out.println("Count (manual) -- " + setBitCount);
        System.out.println("Count (Built-in Function) -- " + Integer.bitCount(no));
    }
}
