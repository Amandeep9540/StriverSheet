package bitManipulation.otherQues;

public class MaxXorOfTwoNoInArr421 {
    public static void main(String[] args) {
            int[] nums = {3,10,5,25,2,8};
        System.out.println("Max XOR -- "+findMaximumXOR(nums));
    }

    public static int findMaximumXOR(int[] nums) {
        Trie root = buildTrie(nums);
        int maxXOR = 0;
        for(int num : nums){
            int tempXor = 0;
            Trie temp = root;
            for(int i=31;i>=0;i--){
                int iBit = (num >> i) & 1;
                if(iBit > 0){ // iBit is set we try to left
                    if(temp.left != null){
                        tempXor = (tempXor | (1 << i));
                        temp = temp.left;
                    }else{
                        temp = temp.right;
                    }
                }else{ // iBit is unSet we try to right
                    if(temp.right != null){
                        tempXor = (tempXor | (1 << i));
                        temp = temp.right;
                    }else{
                        temp = temp.left;
                    }
                }
            }

            maxXOR = Math.max(tempXor,maxXOR);
        }
        return maxXOR;
    }

    private static Trie buildTrie(int[] nums){
        Trie root = new Trie();
        for(int num : nums){
            Trie temp = root;
            for(int i=31;i>=0;i--){
                int iBit = (num >> i) & 1;
                if(iBit > 0){ // means that bit is set so we go right
                    if(temp.right == null)
                        temp.right = new Trie();
                    temp = temp.right;

                }else{ //bit is not set so we got to left
                    if(temp.left == null)
                        temp.left = new Trie();
                    temp = temp.left;

                }
            }
        }

        return root;
    }
}


class Trie{
    Trie left; // when its 0
    Trie right; // when the bit is 1
}