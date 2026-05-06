package greedyAlgo.easy;

public class ValidParenthesisCheck678 {
    public static void main(String[] args) {
        String str = "(((((()*)(*)*))())())(()())())))((**)))))(()())()";
        System.out.println("is valid -- "+checkValidString(str));
    }



    /*This is the iterative and best solution with T.C - O(n)*/
    public static boolean checkValidString(String s) {
        int min = 0;
        int max = 0;
        for(char c : s.toCharArray()){
            if(c == '('){
                min++;max++;
            }else if(c == ')'){
                min--;max--;
            }else{ // its a *
                min--;
                max++;
            }
            if(min < 0) min =0;
            if(max < 0) return false;
        }
        return min == 0 || max == 0;
    }


    /*This is the DP solution with T.C - O(n²)*/
    public static boolean checkValidStringV2(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        return checkValidStringV2(s,0,0,dp);
    }

    public static boolean checkValidStringV2(String str,int index, int open,Boolean[][] dp){
        if(index == str.length()) return open == 0;
        if(open < 0) return false;

        if(dp[index][open] != null ) return dp[index][open];

        char c = str.charAt(index);
        boolean result;
        if(c == '(')
            result = checkValidStringV2(str, index + 1, open + 1, dp);
        else if(c == ')')
            result = checkValidStringV2(str, index + 1, open - 1, dp);
        else{
            result = checkValidStringV2(str,index+1,open+1,dp) ||
                    checkValidStringV2(str,index+1,open-1,dp) ||
                    checkValidStringV2(str,index+1,open,dp);

        }
        dp[index][open] =  result;
        return dp[index][open];
    }
}
