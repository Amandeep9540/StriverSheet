package Strings;

public class RemoveOutnerParenthess1021 {
    public static void main(String[] args) {
        String ans = removeOuterParentheses("(()())(())(()(()))");
        System.out.println("answer of output is :: "+ans);
    }

    public static String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int settledOpeningBracket = 0;

        for(Character c:s.toCharArray()){
            if(c == '(')
                settledOpeningBracket++;

            if(c == '(' && settledOpeningBracket > 1)
                sb.append(c);
            else if(c == ')') {
                if (settledOpeningBracket > 1)
                    sb.append(c);
                settledOpeningBracket--;
            }
        }

        return sb.toString();
    }
}
