package Stacks_Queue.monotonicstack;

public class NumberOfGreaterEleToRight_GFG {
    public static void main(String[] args) {
        int[] arr = {3, 4, 2, 7, 5, 8, 10, 6};
        int queries = 2;
        int[] indices = {0, 5};
        for (int countNge : count_NGEs(arr.length, arr, queries, indices)) {
            System.out.print(" "+countNge);
        }


    }

    public static int[] count_NGEs(int N, int arr[], int queries, int indices[]) {
        int[] ansArr = new int[indices.length];

        //outer loop for traverse each ele
        for(int j=0;j< arr.length;j++){
            int ele = arr[j];
            //inner loop to check if its greater than quire
            for(int i=0;i< indices.length;i++){
                if(ele > arr[indices[i]] && indices[i] < j)
                    ansArr[i]++;
            }
        }
        return ansArr;
    }
}
