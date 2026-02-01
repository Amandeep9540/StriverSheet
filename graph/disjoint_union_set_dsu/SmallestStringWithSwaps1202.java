package graph.disjoint_union_set_dsu;

import java.util.*;

public class SmallestStringWithSwaps1202 {
    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        list.add(Arrays.asList(0, 3));
        list.add(Arrays.asList(1, 2));
        list.add(Arrays.asList(0, 2));

        System.out.println("string is -- "+smallestStringWithSwaps("dcab",list));
    }

    public static String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int[] parent = getParentArr(26);
        int[] rank = new int[26];

        for(List<Integer> pair : pairs){
            int a = pair.get(0);
            int b = pair.get(1);
            union(s.charAt(a)-'a' , s.charAt(b)-'a' , parent, rank);
        }

        Map<Integer,PriorityQueue<Character>> map = new LinkedHashMap<>();
        for(List<Integer> pair : pairs){
            int a = pair.get(0);
            int b = pair.get(1);
            int a_parent = find(s.charAt(a)-'a',parent);
            PriorityQueue<Character> charQueue = map.getOrDefault(a_parent,new PriorityQueue<>());

            charQueue.add(s.charAt(a));
            charQueue.add(s.charAt(b));
            map.put(a_parent, charQueue);
        }

        char[] resultArr = new char[s.length()];

        for(int i=0;i<resultArr.length;i++){
            int parentId = find(s.charAt(i) - 'a',parent);
            resultArr[i] = map.get(parentId).poll();
        }

        return new String(resultArr);
    }


    public static  int find(int x,int[] parent){
        if(x == parent[x]) return x;
        int x_parent = find(parent[x],parent);
        parent[x] = x_parent;
        return x_parent;
    }

    public static  boolean union(int x,int y,int[] parent,int[] rank){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);
        if(x_parent == y_parent) return false;

        if(rank[x_parent] == rank[y_parent]){
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }else if(rank[x_parent] < rank[y_parent]){
            parent[x_parent] = y_parent;
        }else{
            parent[y_parent] = x_parent;
        }
        return true;
    }


    private static  int[] getParentArr(int n){
        int[] parent = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
        return parent;
    }
}
