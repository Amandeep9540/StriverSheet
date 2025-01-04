package Strings.easy;

public class RotateString796 {
    public static void main(String[] args) {
        boolean isRotation = rotateString("abcde", "cdeab");
        System.out.println("isRotation :: "+isRotation);
    }

    public static boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;

        s = s+s;

        return s.indexOf(goal) == -1?false:true;
    }
}
