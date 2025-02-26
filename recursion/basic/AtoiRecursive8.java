package recursion.basic;

public class AtoiRecursive8 {
    public static void main(String[] args) {
        String num = "-83";
        System.out.println("myAtoi output is :: "+myAtoi(num));
    }

    public static int myAtoi(String s) {
        return getNum(s,0,false,false,0);
    }

    public static int getNum(String s, int i,boolean isNeg,boolean isStarted, int num){

        if(i>=s.length())
            return isNeg? -num : num;

        if(s.charAt(i) == ' ' && !isStarted){
            return getNum(s,i+1,isNeg,false,num);
        } else if ((s.charAt(i) == '-' || s.charAt(i) == '+') && !isStarted) {
            return getNum(s,i+1,true,true,num);
        } else if (Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            if (num > (Integer.MAX_VALUE - digit) / 10)
                return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;

            num = num * 10 + digit;
            return getNum(s,i+1,isNeg,true,num);
        }else{
            return isNeg? -num : num;
        }
    }
}
