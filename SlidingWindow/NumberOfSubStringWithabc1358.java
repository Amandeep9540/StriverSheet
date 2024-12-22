package SlidingWindow;

public class NumberOfSubStringWithabc1358 {
    public static void main(String[] args) {
        System.out.println("Number of substring present is :: "+numberOfSubstrings("ababbbc")); // 3
    }
    public static int numberOfSubstringsV2(String s) {
        int windowStart = 0;
        int aCount =0;
        int bCount =0;
        int cCount =0;
        int subStringCount =0;

        for(int windowEnd =0;windowEnd<s.length();windowEnd++){

            if(s.charAt(windowEnd) == 'a')
                aCount++;
            else if(s.charAt(windowEnd) == 'b')
                bCount++;
            else
                cCount++;
            if(aCount>0 && bCount > 0 && cCount >0) {
                while((windowEnd>windowStart) && (aCount>0&&bCount>0&&cCount>0)){
                    if(s.charAt(windowStart) == 'a')
                        aCount--;
                    else if(s.charAt(windowStart) == 'b')
                        bCount--;
                    else
                        cCount--;

                    subStringCount += (s.length()-windowEnd);
                    windowStart++;
                }
            }
        }
        return subStringCount;
    }

    public static int numberOfSubstrings(String s){
        int aIndex = -1;
        int bIndex = -1;
        int cIndex = -1;
        int ans =0;

        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == 'a')
                aIndex = i;
            else if(s.charAt(i) == 'b')
                bIndex = i;
            else
                cIndex = i;

            if(aIndex > -1 && bIndex > -1 && cIndex > -1){
                int min = Math.min(aIndex,Math.min(bIndex,cIndex));
                ans += (min+1);
            }
        }
        return ans;
    }
}
