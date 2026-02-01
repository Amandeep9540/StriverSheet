package graph.disjoint_union_set_dsu;

import java.util.*;

public class AccountsMerge721 {
    public static void main(String[] args) {
        List<List<String>> accounts = Arrays.asList(
                Arrays.asList("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                Arrays.asList("John", "johnsmith@mail.com", "john00@mail.com"),
                Arrays.asList("Mary", "mary@mail.com"),
                Arrays.asList("John", "johnnybravo@mail.com")
        );
        List<List<String>> mergedAcc = accountsMerge(accounts);
        for(List<String> acc :mergedAcc){
            System.out.println(acc);
        }
    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int[] parent = new int[accounts.size()];
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;
        Map<String, Integer> map = new HashMap<>();
        //STEP 1 :: storing the Data in Map
        for (int i = 0; i < accounts.size(); i++) {
            List<String> acc = accounts.get(i);
            for (int j = 1; j < acc.size(); j++) {
                if (map.containsKey(acc.get(j))) {
                    int prev = map.get(acc.get(j));
                    int p1 = find(i, parent);
                    int p2 = find(prev, parent);
                    parent[p2] = p1;
                } else {
                    map.put(acc.get(j), i);
                }
            }
        }

        // STEP 2 :: store data in List
        Map<Integer, List<String>> mergeAcc = new HashMap<>();
        for (Map.Entry<String, Integer> m : map.entrySet()) {
            int currP = find(m.getValue(), parent);
            List<String> list;
            if (mergeAcc.containsKey(currP)) {
                list = mergeAcc.get(currP);
            } else {
                list = new ArrayList<>();
            }
            list.add(m.getKey());
            mergeAcc.put(currP, list);
        }
        // STEP 3 :: populate the result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> m : mergeAcc.entrySet()) {
            List<String> subRes = new ArrayList<>();
            subRes.add(accounts.get(m.getKey()).get(0));
            List<String> mails = m.getValue();
            Collections.sort(mails);
            subRes.addAll(mails);
            result.add(subRes);
        }
        return result;
    }

    private static int find(int x, int[] parent) {
        if (x == parent[x])
            return x;
        int x_parent = find(parent[x], parent);
        parent[x] = x_parent;
        return x_parent;
    }
}
