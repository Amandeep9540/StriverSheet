package recursion.basic;

public class ClimbingStairs70 {
    public static void main(String[] args) {
        System.out.println("To reach 41 stair the ways :: "+climbStairsV3(41));
    }

    /*Time complexity of this code is O(2^n)*/
    public static int climbStairs(int n) {
        if(n == 1 || n == 2 || n== 3){
            return n;
        }
        return climbStairs(n-1) + climbStairs(n-2);
    }


    /*
    * Time Complexity :: O(n)
    * Space Complexity :: O(n)
    * */
    public static int climbStairsV2(int n) {
            if(n <= 3){
                return n;
            }
        int[] staris = new int[n+1];

            //put some base value in stairs
        staris[1] = 1;
        staris[2] = 2;
        staris[3] = 3;

        for(int i=4;i<=n;i++){
           staris[i] = staris[i-1] + staris[i-2];
        }
        return staris[n];
    }

    /*
     * We can do it better, instead of taking the whole array we can do this by taking previous two stairs value in a variable and change when we reach to new stair
     * Time Complexity :: O(n)
     * Space Complexity :: O(1)
     * */
    public static int climbStairsV3(int n) {
            if(n <= 3){
                return n;
            }
        //put some base value in stairs
        int fstPreviousStair = 3;
        int secPreviousStair = 2;
        int currentStair = 0;

        for(int i=4;i<=n;i++){
            currentStair = fstPreviousStair + secPreviousStair;
                //reassign the value as we climb
            secPreviousStair = fstPreviousStair;
            fstPreviousStair = currentStair;
        }
        return currentStair;
    }
}

