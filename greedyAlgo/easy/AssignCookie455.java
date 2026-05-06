package greedyAlgo.easy;
import java.util.*;

public class AssignCookie455 {
    public static void main(String[] args) {
        int[] greedyFactor = {1,2,3};
        int[] cookieSize = {1,1};
        System.out.println("--"+findContentChildren(greedyFactor,cookieSize));
    }

    public static int findContentChildren(int[] g, int[] s) { // g is gready factor of child, s is cookie size
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int i = 0;
        int j = 0;
        while(i < g.length && j < s.length){
            if(s[j] >= g[i]){
                count++; i++;j++;
            }else{
                j++;
            }
        }
        return count;
    }
}
