package dp.dpOnPartitions;
import java.util.*;

public class BooleanParenthesization_GFG {
    public static void main(String[] args) {
        System.out.println("Number of ways it become true -- "+countWaysTabu("T|T&F^T"));
    }

//-------------------------------------------------Memoization-------------------------------------
    static int countWaysMemo(String s) {
        int[][][] dp = new int[s.length()][s.length()][2];
        for(int i=0;i<dp.length;i++)
            for(int j=0;j<dp[i].length;j++)
                Arrays.fill(dp[i][j],-1);
        return solve(s,0,s.length()-1,1,dp);
    }

    private static int solve(String str, int i, int j, int isTrue,int[][][] dp) {
        // Base case
        if (i > j) return 0;

        if (i == j) {
            if (isTrue == 1 && str.charAt(i) == 'T') return 1;
            else if (isTrue == 0 && str.charAt(i) == 'F') return 1;
            else return 0;
        }

        if(dp[i][j][isTrue] != -1) return dp[i][j][isTrue];
        int ways = 0;

        for (int k = i + 1; k < j; k += 2) {
            int exp1T = solve(str, i, k - 1, 1,dp);
            int exp1F = solve(str, i, k - 1, 0,dp);

            int exp2T = solve(str, k + 1, j, 1,dp);
            int exp2F = solve(str, k + 1, j, 0,dp);

            char op = str.charAt(k);

            if (op == '&') {
                if (isTrue == 1) {
                    ways += exp1T * exp2T;
                } else {
                    ways += exp1F * exp2T + exp1T * exp2F + exp1F * exp2F;
                }
            } else if (op == '|') {
                if (isTrue == 1) {
                    ways += exp1T * exp2T + exp1F * exp2T + exp1T * exp2F;
                } else {
                    ways += exp1F * exp2F;
                }
            } else if (op == '^') {
                if (isTrue == 1) {
                    ways += exp1T * exp2F + exp1F * exp2T;
                } else {
                    ways += exp1T * exp2T + exp1F * exp2F;
                }
            }
        }
        dp[i][j][isTrue] = ways;
        return ways;
    }
//--------------------------------------------Tabulazation--------------------------------------------------
    public static int countWaysTabu(String str) {
        int[][][] dp = new int[str.length()][str.length()][2];
        for (int i = str.length() - 1; i >= 0; i--) {
            for (int j = 0; j < str.length(); j++) {
                if (i > j)
                    continue;
                if (i == j) {
                    dp[i][j][1] = str.charAt(i) == 'T' ? 1 : 0;
                    dp[i][j][0] = str.charAt(i) == 'F' ? 1 : 0;
                    continue;
                }

                for (int isTrue = 0; isTrue <= 1; isTrue++) {
                    int ways = 0;
                    for (int k = i + 1; k < j; k += 2) {
                        int exp1T = dp[i][k - 1][1];
                        int exp1F = dp[i][k - 1][0];

                        int exp2T = dp[k + 1][j][1];
                        int exp2F = dp[k + 1][j][0];

                        char op = str.charAt(k);

                        if (op == '&') {
                            if (isTrue == 1) {
                                ways += exp1T * exp2T;
                            } else {
                                ways += exp1F * exp2T + exp1T * exp2F + exp1F * exp2F;
                            }
                        } else if (op == '|') {
                            if (isTrue == 1) {
                                ways += exp1T * exp2T + exp1F * exp2T + exp1T * exp2F;
                            } else {
                                ways += exp1F * exp2F;
                            }
                        } else if (op == '^') {
                            if (isTrue == 1) {
                                ways += exp1T * exp2F + exp1F * exp2T;
                            } else {
                                ways += exp1T * exp2T + exp1F * exp2F;
                            }
                        }
                    }
                    dp[i][j][isTrue] = ways;
                }

            }
        }
        return dp[0][str.length() - 1][1];
    }
}
