package dp.dpOnString;

public class DeleteOpForTwoString583 {
    public static void main(String[] args) {
        String st1 = "sea";
        String st2 = "eat";
        System.out.println("min op -- "+minDistance(st1,st2));
    }

    public static int minDistance(String word1, String word2) {
        int n = longestCommonSubsequence(word1,word2);
        int removeOp = word1.length() - n;
        int addOp = word2.length() - n;
        return addOp + removeOp;
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        int[] prevDp = new int[text2.length()+1];
        int[] currDp = new int[text2.length()+1];
        for(int row = 1;row<=text1.length();row++){
            for(int col = 1;col<prevDp.length;col++){
                //if the char is matching
                if(text1.charAt(row-1) == text2.charAt(col-1)){
                    currDp[col] =  1 + prevDp[col-1];
                }else{ // char is not matching
                    currDp[col] = Math.max(currDp[col-1],prevDp[col]);
                }
            }
            prevDp = currDp.clone();
        }
        return prevDp[text2.length()];
    }
}

