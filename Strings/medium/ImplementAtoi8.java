package Strings.medium;

public class ImplementAtoi8 {
    public static void main(String[] args) {
       int value = myAtoi("34224235");
        System.out.println("value is :: "+value);
    }

    public static int myAtoi(String s) {
        if(s== null || s.length() == 0) return 0;
        s = s.trim();
        if(s== null || s.length() == 0) return 0;

        int result = 0;
        int start = 0;
        boolean isNeg = false;

        if(s.charAt(0) == '-') {
            isNeg = true;
            start++;
        }

        if(s.charAt(0) == '+') {
            start++;
        }

        while(start < s.length()) {

            if (!Character.isDigit(s.charAt(start))) {
                break; // Stop at the first non-digit character
            }

            int digit = Character.getNumericValue(s.charAt(start));
            //check if we add this is can't overflow
            if(result > (Integer.MAX_VALUE-digit)/10){
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + digit;
            start++;
        }
        return isNeg ? -result : result;
    }
}
