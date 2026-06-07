package tries.questions;

public class LongestCommonPrefix3043 {
    public static void main(String[] args) {
        LongestCommonPrefix3043 ques = new LongestCommonPrefix3043();
        int[] arr1 = {10,100,1};
        int[] arr2 = {10};
        System.out.println("longest common prefix -- "+ques.longestCommonPrefix(arr1,arr2));
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = new TrieNode();
        /**Insert the arr1 to the Trie*/
        for(int x : arr1)
            insertToTrie(x, root);

        /**Now we traverse the arr2 and will find the longest prefix in the trie*/
        int longestPrefix = 0;
        for(int num : arr2){
            longestPrefix = Math.max(longestPrefix, findLongestPrefix(String.valueOf(num),root));
        }

        return longestPrefix;
    }

    private int findLongestPrefix(String str , TrieNode root){
        int prefix = 0 ;
        TrieNode temp = root;
        for(int i=0;i<str.length();i++){
            char c = str.charAt(i);
            if(!temp.contains(c)) return i;
            temp = temp.get(c);
        }
        return str.length();
    }

    private void insertToTrie(int num, TrieNode root){
        insertToTrie(String.valueOf(num),root);
    }

    private void insertToTrie(String word, TrieNode root){
        TrieNode temp = root;

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!temp.contains(c)){
                TrieNode node = new TrieNode();
                temp.add(c,node);
            }

            temp = temp.get(c);
        }
        temp.isEnd = true;
    }


    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[10];
        }

        public boolean contains(char c) {
            return children[c - '0'] != null;
        }

        public void add(char c, TrieNode node) {
            children[c - '0'] = node;
        }

        public TrieNode get(char c) {
            return children[c - '0'];
        }
    }
}
