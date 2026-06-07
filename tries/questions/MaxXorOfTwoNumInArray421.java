package tries.questions;

public class MaxXorOfTwoNumInArray421 {
    public static void main(String[] args) {
        MaxXorOfTwoNumInArray421 ques = new MaxXorOfTwoNumInArray421();
        int maxXor = ques.findMaximumXOR(new int[]{3,10,5,25,2,8});
        System.out.println("maxXor -- "+maxXor);
    }

    public int findMaximumXOR(int[] nums) {
        // In these type of question we generally do bit by bit, means we pick a element(i-th bit = 0) and then we try to put the next number (i-th bit = 1) by using this we get large number and we do this from the end to start of bits(32 bit).


        //How we can get the number how's i-th bit is set or not , for this we store all the number bits in the TRIE.
        TrieNode head = getTrieNode(nums);


        //Now, we iterate every element in the num and try to get the maximun xor.
        int maxXOR = -1;
        for(int num : nums){
            maxXOR = Math.max(getMaxXor(num,head),maxXOR);
        }

        return maxXOR;
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
                temp = temp.right == null ? temp.left : temp.right;
            }
        }

        return xor;
    }

    private TrieNode getTrieNode(int[] nums){
        TrieNode head = new TrieNode();
        for(int num : nums)
            getTrieNode(num,head);
        return head;
    }

    private void getTrieNode(int num,TrieNode head){
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

class TrieNode{
    TrieNode right;  // if the bit is 0
    TrieNode left;   //in case of 1

}