package graph.disjoint_union_set_dsu.weighted_union_find;

import java.util.*;

public class KnowledgeBase {
    public static void main(String[] args) {
        /*
        the knowledgeBase contains knowledgeBase[i][0] - knowledgeBase[i][1] = knowledgeBase[i][2].
        Return the values of quires[i][0] - quires[i][1], if the data is insufficient return -1
        */

        String[][] knowledgeBase = {
                {"a", "b", "3"},   // a - b = 3
                {"b", "c", "13"},  // b - c = 13
                {"d", "e", "7"},   // d - e = 7
                {"c", "d", "5"}    // c - d = 5
        };

        String[][] queries = {
                {"a", "c"}, // a - c = 16
                {"c", "a"}, // c - a = -16

                {"b", "c"}, // b - c = 13
                {"c", "b"}, // c - b = -13

                {"a", "b"}, // a - b = 3
                {"b", "a"}, // b - a = -3

                {"d", "e"}, // d - e = 7
                {"e", "d"}, // e - d = -7

                {"c", "d"}, // c - d = 5
                {"d", "c"}, // d - c = -5

                {"a", "d"}, // a - d = 21
                {"a", "e"}, // a - e = 28

                {"b", "e"}, // b - e = 25
                {"b", "e"}, // b - e = 25

                {"x", "y"}  // -1 (insufficient data)
        };

        int[] result = solve(knowledgeBase,queries);
        for(int i=0;i< queries.length;i++){
            System.out.println("quire "+queries[i][0]+" - "+queries[i][1]+"  = " +result[i]);
        }

    }


    public static int[] solve(String[][] knowledgeBase, String[][] quires) {
        DSU dsu = new DSU();
        for(String[] know : knowledgeBase){
            String x = know[0];
            String y = know[1];
            int val = Integer.valueOf(know[2]);
            dsu.union(x,y,val);
        }

        int[] result = new int[quires.length];

        for(int i=0;i< quires.length;i++){
            String x = quires[i][0];
            String y = quires[i][1];
            Node parent_x = dsu.find(x);
            Node parent_y = dsu.find(y);
            if(parent_x.parent != null && parent_y.parent != null && parent_x.parent.equals(parent_y.parent)){
                result[i] = parent_x.weight - parent_y.weight;
            }else{
                result[i] = -1;
            }
        }

        return result;
    }


    private static class DSU{
        Map<String,String> parent = new HashMap<>();
        Map<String,Integer> weight = new HashMap<>();
        Map<String,Integer> rank = new HashMap<>();

        private void add(String ele){
            parent.putIfAbsent(ele,ele);
            weight.putIfAbsent(ele,0);
            rank.putIfAbsent(ele,0);
        }

        public Node find(String ele){
            if(!parent.containsKey(ele))
                    return new Node(null,0);

            if(!parent.get(ele).equals(ele)){
                        // i will find the parent and add the weight;
                Node parentNode = find(parent.get(ele));
                parent.put(ele,parentNode.parent);
                weight.put(ele,weight.get(ele) + parentNode.weight);
            }

            return new Node(parent.get(ele),weight.get(ele));

        }


        public void union(String x,String y,Integer val){
            add(x);
            add(y); //adding in the maps if not present and adding the default value

            Node parent_x = find(x);
            Node parent_y = find(y);

            if(parent_x.parent.equals(parent_y.parent)){ // both are in same component
                return;
            }

            String xParent = parent_x.parent; int wtx = parent_x.weight;
            String yParent = parent_y.parent; int wty = parent_y.weight;
                //Now i try to merge the components
            if(rank.get(xParent) < (rank.get(yParent))){ ///  x -> y (with weight val), y is parent here
                parent.put(xParent , yParent);
                weight.put(xParent, val + wty - wtx);
            }else if (rank.get(xParent) > (rank.get(yParent))){
                parent.put(yParent , xParent);
                weight.put(yParent, - val - wty + wtx);
            }else {
                parent.put(xParent , yParent);
                weight.put(xParent, val + wty - wtx);
                rank.put(yParent,rank.get(yParent)+1);
            }
        }
    }

    private static class Node{
        String parent;
        Integer weight;

        Node(String parent,Integer weight){
            this.parent = parent;
            this.weight = weight;
        }
    }

}
