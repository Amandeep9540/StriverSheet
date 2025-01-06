package Strings.medium;

public class MaximumNestingDepth1614 {
    public static void main(String[] args) {
        int maxDepth = maxDepth("()(())((()()))");
        System.out.println("maxDepth is :: "+maxDepth);
    }

    public static int maxDepth(String s) {
        int maxCount = 0;
        int current = 0;

        for(char c :s.toCharArray()){
            if(c == '(')
                current++;
            else if(c == ')')
                current--;

            maxCount = Math.max(current,maxCount);
        }

        return maxCount;
    }
}
