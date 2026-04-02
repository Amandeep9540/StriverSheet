package bitManipulation.otherQues;

public class MinFlipToMakeOREqualsC1318 {
    public static void main(String[] args) {
        int a = 2, b = 6, c = 5;
        System.out.println("-min flips-"+minFlipsV2(a,b,c));
    }

    public static int minFlips(int a, int b, int c) {
        int flip = 0;
        while(a != 0 || b != 0 || c!= 0){
            if((c & 1) != 0){ // if c 0-th bit is set
                if((a & 1) == 0 && (b & 1) == 0 ){
                    flip++;
                }
            }else{ //if the c 0-th bit is not set
                if((a & 1) != 0)
                    flip++;
                if((b & 1) != 0)
                    flip++;
            }

            a = a >> 1; b = b >> 1; c = c >> 1;
        }
        return flip;
    }

    public static int minFlipsV2(int a, int b, int c) {
        int xor = (a | b) ^ c;
        int extra = (a & b) & xor;

        return Integer.bitCount(xor) + Integer.bitCount(extra);
    }
}
