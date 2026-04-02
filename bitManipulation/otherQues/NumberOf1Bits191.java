package bitManipulation.otherQues;

public class NumberOf1Bits191 {
    public static void main(String[] args) {
        System.out.println("Set Bits -- "+hammingWeightV2(11));
    }

    public static int hammingWeightV1(int n) {
        int setBits = 0;
        while(n > 0){
            n = n & (n - 1);
            setBits++;
        }

        return setBits;
    }


    public static int hammingWeightV2(int n) {
        int setBits = 0;
        for(int i = 31;i>=0;i--){
            if(((1  << i) & n )!= 0)
                setBits++;
        }

        return setBits;
    }
}
