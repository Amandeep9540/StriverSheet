package Arrays.Easy;

import java.util.ArrayList;

public class FindUnionOfSortedArr_GFG {
    public static void main(String[] args) {
        ArrayList<Integer> union = findUnion(new int[]{1, 2, 3, 4, 5,5,5}, new int[]{1, 2, 3, 6, 7});
        System.out.println(union);
    }

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        ArrayList<Integer> ansList = new ArrayList<>();

        int aLen = 0;
        int bLen = 0;

        while (aLen<a.length && bLen <b.length){
            if(a[aLen] < b[bLen]){
                int size = ansList.size();
                if(size == 0) ansList.add(a[aLen]);
                else if(ansList.get(size-1) != a[aLen]){
                    ansList.add(a[aLen]);
                }
                aLen++;
            }else{
                int size = ansList.size();
                if(size == 0) ansList.add(b[bLen]);
                else if (ansList.get(size-1) != b[bLen]){
                    ansList.add(b[bLen]);
                }
                bLen++;
            }
        }

        while(aLen<a.length){
            int size = ansList.size();
            if(size == 0) ansList.add(a[aLen]);
            else if(ansList.get(size-1) != a[aLen]){
                ansList.add(a[aLen]);
            }
            aLen++;
        }

        while(bLen<b.length){
            int size = ansList.size();
            if(size == 0) ansList.add(b[bLen]);
            else if (ansList.get(size-1) != b[bLen]){
                ansList.add(b[bLen]);
            }
            bLen++;
        }


        return ansList;
    }
}
