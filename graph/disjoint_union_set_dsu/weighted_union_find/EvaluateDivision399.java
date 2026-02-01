package graph.disjoint_union_set_dsu.weighted_union_find;

import java.util.*;

public class EvaluateDivision399 {
    public static void main(String[] args) {
        List<List<String>> equations = new ArrayList<>();
        equations.add(Arrays.asList("a", "b"));
        equations.add(Arrays.asList("b", "c"));

        double[] values = {2.0, 3.0};

        List<List<String>> queries = new ArrayList<>();
        queries.add(Arrays.asList("a", "c"));
        queries.add(Arrays.asList("b", "a"));
        queries.add(Arrays.asList("a", "e"));
        queries.add(Arrays.asList("a", "a"));
        queries.add(Arrays.asList("x", "x"));

        double[] result = calcEquation(equations,values,queries);
        for(int i=0;i<result.length;i++){
            System.out.println(queries.get(i).get(0) +" / "+ queries.get(i).get(1) + " -- "+ result[i]);
        }


    }

    public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        DSU dsu = new DSU();
        for(int i=0;i<equations.size();i++){
            String x = equations.get(i).get(0);
            String y = equations.get(i).get(1);
            double val = values[i];
            dsu.union(x,y,val);
        }

        double[] result = new double[queries.size()];

        for(int i=0;i<queries.size();i++){
            String x = queries.get(i).get(0);
            String y = queries.get(i).get(1);

            Node xParent = dsu.find(x);
            Node yParent = dsu.find(y);

            if(xParent.parent != null && yParent.parent != null && xParent.parent.equals(yParent.parent)){
                 result[i] = xParent.weight / yParent.weight;
            }else{
                result[i] = -1.0;
            }
        }
        return result;
    }


    private static class DSU{
        Map<String, String> parent = new HashMap<>();
        Map<String,Double> weight = new HashMap<>();
        Map<String,Integer> rank = new HashMap<>();

        private void add(String ele){
            parent.putIfAbsent(ele,ele);
            weight.putIfAbsent(ele,1.d);
            rank.putIfAbsent(ele,0);
        }

        public Node find(String ele){
            if(!parent.containsKey(ele))
                return new Node(null,0.0);

            if(!parent.get(ele).equals(ele)){
                Node parentNode = find(parent.get(ele));
                parent.put(ele,parentNode.parent);
                weight.put(ele,weight.get(ele) * parentNode.weight);
            }
            return new Node(parent.get(ele),weight.get(ele));
        }

        public void union(String x, String y,Double val){
            add(x);
            add(y);

            Node x_parent = find(x);
            Node y_parent = find(y);

            if(x_parent.parent.equals(y_parent.parent)) return; // both are in same component

            String xP = x_parent.parent; Double wtX = x_parent.weight;
            String yP = y_parent.parent; Double wtY = y_parent.weight;

                // x -> y
            if(rank.get(xP) < rank.get(yP)){
                // xP -> yP
                parent.put(xP, yP);
                weight.put(xP, (val * wtY) / wtX);
            }
            else if(rank.get(xP) > rank.get(yP)){
                // yP -> xP (flipped)
                parent.put(yP, xP);
                weight.put(yP, wtX / (val * wtY));
            }
            else{
                // same rank
                parent.put(xP, yP);
                weight.put(xP, (val * wtY) / wtX);
                rank.put(yP, rank.get(yP) + 1);
            }

        }
    }

    private static class Node{
        String parent;
        Double weight;

        Node(String parent,Double weight){
            this.parent = parent;
            this.weight = weight;
        }
    }
}
