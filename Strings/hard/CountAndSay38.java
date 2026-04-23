package Strings.hard;

public class CountAndSay38 {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(n +"-th sequence is -- "+countAndSay(n));
    }

    public static String countAndSay(int n) {
        if(n == 1) return "1";

        String prev = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int i=1 , times = 1 ;
        char ch = prev.charAt(0);
        while(i < prev.length()){
            if(ch == prev.charAt(i))
                times++;
            else{
                sb.append(times);
                sb.append(ch);
                times = 1;
                ch = prev.charAt(i);
            }
            i++;
        }
        sb.append(times);
        sb.append(ch);
        return sb.toString();
    }
}
