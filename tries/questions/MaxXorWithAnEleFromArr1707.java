package tries.questions;
import java.util.*;

public class MaxXorWithAnEleFromArr1707 {
    public static void main(String[] args) {
        MaxXorWithAnEleFromArr1707 ques = new MaxXorWithAnEleFromArr1707();
        int[] maxXors= ques.maximizeXor(new int[]{0,1,2,3,4}, new int[][]{{3,1},{1,3},{5,6}});

        for(int i=0;i<maxXors.length;i++){
            System.out.print(" "+maxXors[i]);
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        int[][] queriesIdxInclued = new int[queries.length][3];
        for(int i=0;i<queries.length;i++){
            queriesIdxInclued[i][0] = queries[i][0];
            queriesIdxInclued[i][1] = queries[i][1];
            queriesIdxInclued[i][2] = i;
        }

        Arrays.sort(queriesIdxInclued,(a,b)-> Integer.compare(a[1],b[1]));
        Arrays.sort(nums);

        int qryIdx = 0;
        TrieNode head = new TrieNode();
        for(int i=0;i<nums.length;i++){
            while(qryIdx < queries.length && nums[i] > queriesIdxInclued[qryIdx][1]){
                result[queriesIdxInclued[qryIdx][2]] = findMaximumXOR(queriesIdxInclued[qryIdx][0],head);
                qryIdx++;
            }
            addToTrie(nums[i],head);
        }

        while(qryIdx < queries.length){
            result[queriesIdxInclued[qryIdx][2]] = findMaximumXOR(queriesIdxInclued[qryIdx][0],head);
            qryIdx++;
        }

        return result;
    }

    public int findMaximumXOR(int num,TrieNode head) {
        return getMaxXor(num,head);
    }

    private int getMaxXor(int num, TrieNode head){
        TrieNode temp = head;
        int xor = 0;
        for(int i=31;i>=0;i--){
            boolean canWeSetBit = false;
            if(checkBitSet(num,i) && temp.right != null){
                canWeSetBit = true;
                temp = temp.right;
            }else if(!checkBitSet(num,i) && temp.left != null){
                canWeSetBit = true;
                temp = temp.left;
            }

            if(canWeSetBit){
                xor = xor | (1 << i);
            }else{
                if(temp.right == null && temp.left == null) return -1;
                temp = temp.right == null ? temp.left : temp.right;
            }
        }

        return xor;
    }

    private void addToTrie(int num,TrieNode head){
        TrieNode temp = head;
        for(int i=31;i>=0;i--){
            if(checkBitSet(num,i)){
                if(temp.left == null) temp.left = new TrieNode();
                temp = temp.left;
            }else{
                if(temp.right == null) temp.right = new TrieNode();
                temp = temp.right;
            }

        }
    }

    private boolean checkBitSet(int num, int pos){
        return ((num >> pos) & 1) != 0;
    }
}
