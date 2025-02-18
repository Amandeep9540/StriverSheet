package Stacks_Queue.monotonicstack;

public class TrappingRainWater42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        int trappedWater = trapV2(height);
        System.out.println("trapped water :: " +trappedWater);
    }

    /*
     * TC :: O(2n)
     * SC :: O(n)
     * */
    public static int trap(int[] height) {
        int storedWater = 0;
        int[] maxLeft = new int[height.length];

        //put the last
        maxLeft[height.length-1] = height[height.length-1];
        for(int i= height.length-2;i>=0;i--){
            maxLeft[i] = Math.max(maxLeft[i+1],height[i]);
        }
        int maxRight = 0;

        for(int i=0;i< height.length;i++){
            maxRight = Math.max(maxRight,height[i]);
            if((maxRight > height[i]) &&( height[i] < maxLeft[i]))
                storedWater += Math.min(maxRight,maxLeft[i]) - height[i] ;
        }

        return storedWater;
    }

    /*
     * TC :: O(n)
     * SC :: O(1)
     * */
    public static int trapV2(int[] height){
        int storedWater = 0;

        int maxRight = 0;
        int maxLeft = 0;

        int r = 0;
        int l = height.length-1;

        while(r<l){
            if(height[r] <= height[l]){
                if(maxRight > height[r]){
                    storedWater += maxRight - height[r];
                }else{
                    maxRight = height[r];
                }
                r++;
            }else{
                if(maxLeft > height[l]){
                    storedWater += maxLeft - height[l];
                }else{
                    maxLeft = height[l];
                }
                l--;
            }
        }
        return storedWater;
    }
}
