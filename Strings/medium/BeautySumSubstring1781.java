package Strings.medium;


public class BeautySumSubstring1781 {
    public static void main(String[] args) {
        int sum = beautySum("aaaaa");
        System.out.println("sum is :: "+sum);
    }

    public static int beautySum(String s) {
        int size = s.length();
        int count = 0;

        for(int i=0;i<size-2;i++){
            int[] freqCount = new int[26];
            for(int j=i;j<size;j++){
                freqCount[s.charAt(j)-'a']++;
                if((j-i)>=2){
                    int min = getMin(freqCount);
                    int max = getMax(freqCount);
                    if(min != Integer.MIN_VALUE)
                       count += max - min;
                }
            }
        }
        return count;
    }

    private static int getMax(int[] freqCount) {
        int max = Integer.MIN_VALUE;
        for (int count : freqCount) {
            max = Math.max(count, max);
        }
        return max;
    }

    private static int getMin(int[] freqCount) {
        int min = Integer.MAX_VALUE;
        for (int count : freqCount) {
            if(count != 0) // because default value is 0
                min = Math.min(count, min);
        }
        return min;
    }


}
