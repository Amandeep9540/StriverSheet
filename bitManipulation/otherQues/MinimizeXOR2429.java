package bitManipulation.otherQues;

public class MinimizeXOR2429 {
    public static void main(String[] args) {
        System.out.println("That no is -- "+minimizeXor(20,7));
    }

    public static int minimizeXor(int num1, int num2) {
        int num1SetBits = setBitsCount(num1);
        int num2SetBits = setBitsCount(num2);
        if(num1SetBits == num2SetBits) return num1;
        int XOR = 0;
        // if the num1SetBits >  num2SetBits, then we need to remove the set bits from the left
        if(num1SetBits < num2SetBits){
            int bitsNeedToAdd = num2SetBits - num1SetBits;
            int i = 0;
            while(i < 32){
                if((num1 & (1 << i)) == 0){
                    XOR = (XOR |  (1 << i));
                    bitsNeedToAdd--;
                    if(bitsNeedToAdd == 0) break;
                }
                i++;
            }
        }
        // if the num1SetBits < num2SetBits,  then we need to add the set bits from the starting if there unsert bit in nums1

        if(num1SetBits > num2SetBits){
            int bitsNeedToAdd = num1SetBits - num2SetBits;
            int i = 0;
            while(i < 32){
                if((num1 & (1 << i)) != 0){
                    XOR = (XOR |  (1 << i));
                    bitsNeedToAdd--;
                    if(bitsNeedToAdd == 0) break;
                }
                i++;
            }
        }


        return XOR ^ num1;
    }

    public static int setBitsCount(int num){
        int setBits = 0;
        while(num > 0){
            num = (num & (num - 1));
            setBits++;
        }
        return setBits;
    }
}
