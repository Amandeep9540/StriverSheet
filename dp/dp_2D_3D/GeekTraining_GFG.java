package dp.dp_2D_3D;

public class GeekTraining_GFG {
    public static void main(String[] args) {
        int[][] trainingPoints = {
                                {1,2,5},
                                {3,1,1},
                                {3,3,3}
        };
        System.out.println("Maximum Point -- "+maximumPoints(trainingPoints));
    }

                 //Memoization
    public static int maximumPointsRecursion(int arr[][]) {
        int[][] dp = new int[arr.length][3];
        int day = arr.length - 1;
        int lastTask = 3;
        return maxPoints(arr,day,lastTask,dp);
    }

    public static int maxPoints(int[][]arr , int day , int lastTask,int[][] dp){
        int max = 0;
        if(lastTask != 3 && dp[day][lastTask] != 0) return dp[day][lastTask];
        if(day == 0){
            for(int i=0;i<3;i++){
                if(i!=lastTask){
                    max = Math.max(max,arr[0][i]);
                }
            }
            dp[day][lastTask] = max;
            return max;
        }

        for(int i=0;i<3;i++){
            if(i!=lastTask){
                max = Math.max(max,arr[day][i]+maxPoints(arr,day-1,i,dp));
            }
        }
        if(lastTask != 3)
            dp[day][lastTask] = max;

        return max;
    }

                 //Tabulation
    public static int maximumPointsTabulation(int arr[][]) {
        int[][] dp = new int[arr.length][3];
        return maxPoints(arr,dp);
    }

    public static int maxPoints(int[][]arr,int[][] dp){
        int day = 0;
        if(day == 0){
            dp[0][0] = Math.max(arr[0][1],arr[0][2]);
            dp[0][1] = Math.max(arr[0][0],arr[0][2]);
            dp[0][2] = Math.max(arr[0][0],arr[0][1]);
            day++;
        }
        int max = 0;
        while(day < arr.length){
            for(int lastTask=0;lastTask<3;lastTask++){
                for(int i=0;i<3;i++){
                    if(i!=lastTask){
                        max = Math.max(max,arr[day][i]+dp[day-1][i]);
                    }
                }
                dp[day][lastTask] = max;
                max=0;
            }
            day++;
        }

        return Math.max(dp[arr.length-1][0],Math.max(dp[arr.length-1][1],dp[arr.length-1][2]));
    }

                //Tabulation + Space Optimization
    public static int maximumPoints(int arr[][]) {
        int[] dp = new int[3];
        return maxPoints(arr,dp);
    }

    public static int maxPoints(int[][]arr,int[] dp){
        int day = 0;
        if(day == 0){
            dp[0] = Math.max(arr[0][1],arr[0][2]);
            dp[1] = Math.max(arr[0][0],arr[0][2]);
            dp[2] = Math.max(arr[0][0],arr[0][1]);
            day++;
        }
        int max = 0;
        while(day < arr.length){
            int[] tempDP = new int[3];
            for(int lastTask=0;lastTask<3;lastTask++){
                for(int i=0;i<3;i++){
                    if(i!=lastTask){
                        max = Math.max(max,arr[day][i]+dp[i]);
                    }
                }
                tempDP[lastTask] = max;
                max=0;
            }
            dp[0] = tempDP[0];
            dp[1] = tempDP[1];
            dp[2] = tempDP[2];
            day++;
        }

        return Math.max(dp[0],Math.max(dp[1],dp[2]));
    }

}
