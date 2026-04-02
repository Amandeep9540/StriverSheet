package bitManipulation.learning.conversion;

public class DecimalConversion {
    public static void main(String[] args) {
        int decimal = 7;
        String binary = decimalToBinary(decimal);
        System.out.println("Binary of "+decimal+ " is "+ binary);
        int decimalByFun = binaryToDecimal(binary);
        System.out.println("Decimal of "+binary+ " is "+decimalByFun);

    }

        /**
            This method is only for 8 bits integer values so the MIN_VALUE = -128  and MAX_VALUE = 127.
            If the input is exceeding this value method will throw RuntimeException
        */
    private static String decimalToBinary(int decimal) throws RuntimeException{
            if(!isUnder8Bits(decimal))
                    throw new RuntimeException("THIS METHOD SUPPORT ONLY 8 BITS");
        if(decimal == -128) return "10000000";
        if(decimal >= 0) return decimalToBinaryPositive(decimal).toString();
        StringBuilder posBinary = decimalToBinaryPositive(Math.abs(decimal)); // if the input is -128 its break here
            //computer store the 2's complement in the case of neg number so, we are adding the padding in case
            //STEP 1 : flip all the bits
        for(int i=0;i<posBinary.length();i++){
            if(posBinary.charAt(i) == '1')
                posBinary.setCharAt(i,'0');
            else
                posBinary.setCharAt(i,'1');
        }
            //STEP 2 : add one to it ( in simple from the left we need to flip one bit from 0 to 1 , if there is not bit as 0 no issue its overflow case)
        int i = 7;
        while(i >= 0){
            if(posBinary.charAt(i) == '0'){
                posBinary.setCharAt(i,'1');
                break;
            }
            i--;
        }

        return posBinary.toString();
    }


    /*This is only valid for the positive decimal or value , in the case of negative we store 2's complement in the memory*/
    public static StringBuilder decimalToBinaryPositive(int decimal){
        if(decimal == 0) return new StringBuilder("00000000");

        StringBuilder binarySB = new StringBuilder();
        int tempDecimal = decimal;
        while(tempDecimal > 0){
            binarySB.append(tempDecimal % 2);
            tempDecimal = tempDecimal / 2;
        }
            //adding the padding
        while(binarySB.length() < 8){
            binarySB.append(0);
        }

        binarySB.reverse();
        return binarySB;
    }

    public static int binaryToDecimal(String binary){
        int decimal = 0;
        for(int i=binary.length()-1;i>0;i--){
            int power = binary.length() - i - 1;
            decimal += Math.pow(2,power) * (binary.charAt(i) - '0');
        }
        //Last bit is used for the sign purpose and it's shows the -negative power
        if(binary.charAt(0) == '1'){
            decimal -= Math.pow(2,binary.length()  - 1);
        }
        return decimal;
    }

    public static boolean isUnder8Bits(int decimal){
        return decimal >= -128 && decimal <= 127;
    }
}
