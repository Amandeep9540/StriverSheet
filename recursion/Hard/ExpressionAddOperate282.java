package recursion.Hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperate282 {
    public static void main(String[] args) {
        addOperators("123",7).stream().forEach(System.out::println);
    }

    public static List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        generateAllExpression(num, target, 0, 0, 0, new StringBuilder(), result);
        return result;
    }

    private static void generateAllExpression(String num, int target, int pos, long eval, long prev, StringBuilder path, List<String> result) {
        if (pos == num.length()) {
            if (eval == target) {
                result.add(path.toString());
            }
            return;
        }

        int len = path.length();
        for (int i = pos; i < num.length(); i++) {

            if (i != pos && num.charAt(pos) == '0') break;

            long curr = Long.parseLong(num.substring(pos, i + 1));

            if (pos == 0) {
                path.append(curr);
                generateAllExpression(num, target, i + 1, curr, curr, path, result);
                path.setLength(len);
            } else {
                path.append('+').append(curr);
                generateAllExpression(num, target, i + 1, eval + curr, curr, path, result);
                path.setLength(len);

                path.append('-').append(curr);
                generateAllExpression(num, target, i + 1, eval - curr, -curr, path, result);
                path.setLength(len);

                path.append('*').append(curr);

                generateAllExpression(num, target, i + 1, eval - prev + (prev * curr), prev * curr, path, result);
                path.setLength(len);
            }
        }
    }


}
