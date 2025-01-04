package Strings.easy;

public class LargestOddNumber1903 {
    public static void main(String[] args) {
        String oddNum = largestOddNumber("1");
        System.out.println("Largest Odd Number is :: "+oddNum);
    }

    public static String largestOddNumber(String num) {

                //traverse from the back and check if this character is odd then return
        for(int i = num.length()-1;i>=0;i--){
            if((num.charAt(i) - '0') % 2 != 0 )
                return num.substring(0,i+1);
        }

        return "";
    }
}
