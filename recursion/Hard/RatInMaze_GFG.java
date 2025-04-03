package recursion.Hard;

import java.util.ArrayList;
import java.util.Arrays;

public class RatInMaze_GFG {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> mat = new ArrayList<>();
        mat.add(new ArrayList<>(Arrays.asList(1, 0, 0, 0)));
        mat.add(new ArrayList<>(Arrays.asList(1, 1, 0, 1)));
        mat.add(new ArrayList<>(Arrays.asList(1, 1, 0, 0)));
        mat.add(new ArrayList<>(Arrays.asList(0, 1, 1, 1)));


        findPath(mat).stream().forEach(System.out::println);
    }

    public static ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> ans = new ArrayList<>();
        int n = mat.size();
        if(mat.get(0).get(0) == 1) {
            mat.get(0).set(0, -1);  // mark visited
            generatePath(mat, 0, 0, new StringBuilder(), ans);
            mat.get(0).set(0, 1);
        }
        return ans;
    }

    private static void generatePath(ArrayList<ArrayList<Integer>> mat, int r, int c, StringBuilder path, ArrayList<String> ans) {
        int n = mat.size();

        // Base case: if destination (n-1, n-1) is reached
        if(r == n - 1 && c == n - 1) {
            ans.add(path.toString());
            return;
        }

        // Store current path length for backtracking
        int len = path.length();

        // Move Down: r+1, c
        if(r + 1 < n && mat.get(r + 1).get(c) == 1) {
            mat.get(r + 1).set(c, -1);
            path.append("D");
            generatePath(mat, r + 1, c, path, ans);
            path.setLength(len);
            mat.get(r + 1).set(c, 1);
        }

            //Move Left
        if(c - 1 >= 0 && mat.get(r).get(c - 1) == 1) {
            mat.get(r).set(c - 1, -1);
            path.append("L");
            generatePath(mat, r, c - 1, path, ans);
            path.setLength(len);
            mat.get(r).set(c - 1, 1);
        }

            // Move Right
        if(c + 1 < n && mat.get(r).get(c + 1) == 1) {
            mat.get(r).set(c + 1, -1);
            path.append("R");
            generatePath(mat, r, c + 1, path, ans);
            path.setLength(len);
            mat.get(r).set(c + 1, 1);
        }

            // Move Up
        if(r - 1 >= 0 && mat.get(r - 1).get(c) == 1) {
            mat.get(r - 1).set(c, -1);
            path.append("U");
            generatePath(mat, r - 1, c, path, ans);
            path.setLength(len);
            mat.get(r - 1).set(c, 1);
        }
    }
}
