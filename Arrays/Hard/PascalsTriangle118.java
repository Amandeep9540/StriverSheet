package Arrays.Hard;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle118 {
    public static void main(String[] args) {
        List<List<Integer>> triangle = generate(5);
        for(List<Integer> t : triangle){
            System.out.println(t);
        }
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subResult = new ArrayList<>();
        subResult.add(1);
        result.add(new ArrayList<>(subResult));
        if(numRows == 1) return result;
        subResult.add(1);
        result.add(new ArrayList<>(subResult));
        if(numRows == 2) return result;

        for(int i = 2;i<numRows;i++){
            subResult = new ArrayList<>();
            subResult.add(1);
            for(int j = 1;j<i;j++){
                subResult.add(result.get(i-1).get(j-1) + result.get(i-1).get(j));
            }
            subResult.add(1);
            result.add(new ArrayList<>(subResult));
        }

        return result;
    }
}
