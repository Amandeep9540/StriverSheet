package graph.disjoint_union_set_dsu;

import java.util.*;

public class SatisfiabilityEquation990 {
    public static void main(String[] args) {
        String[] equations = {"a==b","b!=a"};
        System.out.println("whole equation is -- "+equationsPossible(equations));
    }

    public static boolean equationsPossible(String[] equations) {
        int[] parent = new int[26];
        for(int i=0;i<parent.length;i++)
            parent[i] = i;
        int[] rank = new int[26];
        List<String> notEqualEquation = new ArrayList<>();
        //STEP 1 :: I will traverse the equation of == and do the merge function and if the ele != i will store in the list.
        for(String eq : equations){
            if(eq.charAt(1) == '!')
                notEqualEquation.add(eq);
            else
                merge(eq.charAt(0)-'a',eq.charAt(3)-'a',parent,rank);
        }

        for(String eq : notEqualEquation){
            if(find(eq.charAt(0)-'a',parent) == find(eq.charAt(3)-'a',parent))
                return false;
        }

        return true;
    }

    private static void merge(int x,int y,int[] parent,int[] rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);
        if(x_parent == y_parent) return;
        if(rank[x_parent] == rank[y_parent]){
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }else if(rank[x_parent] > rank[y_parent]){
            parent[y_parent] = x_parent;
        }else{
            parent[x_parent] = y_parent;
        }
    }

    private static int find(int x,int[] parent){
        if(x == parent[x])
            return x;
        int x_parent = find(parent[x],parent);
        parent[x] = x_parent;
        return x_parent;
    }
}
