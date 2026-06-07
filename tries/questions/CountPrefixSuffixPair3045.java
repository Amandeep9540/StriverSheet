package tries.questions;

import java.util.HashMap;
import java.util.Map;

public class CountPrefixSuffixPair3045 {
    public static void main(String[] args) {
        String[] words = {"a","aba","ababa","aa"};
        System.out.println("pair counts -- "+countPrefixSuffixPairs(words));
    }

    public static long countPrefixSuffixPairs(String[] words) {
        /**We traverse the words and insert the word at Trie at same time ,  if while inserting the word we found that is this is present in the Trie and have count > 1 then we add into our ans

         We will insert the word hash the hash will be word[0]*129 + word[n-1], so we will pair the first and last character and insert the hash in the Trie.
         */

        TrieNode root = new TrieNode();
        long ans = 0l;
        for(String word : words ){
            ans += insertWord(word,root);
        }

        return ans;
    }

    private static long insertWord(String word,TrieNode root){
        TrieNode temp = root;
        int n = word.length() - 1;
        long ans = 0l;
        for(int i = 0;i<=n;i++){
            int firstChar = word.charAt(i);
            int secChar = word.charAt(n-i);
            int hash = (firstChar * 128) + secChar;
            if(!temp.contains(hash))
                temp.add(hash,new TrieNode());
            temp = temp.get(hash);
            ans += temp.count;
        }
        temp.count++;
        return ans;
    }

    static class TrieNode{
        Map<Integer, TrieNode> children;
        long count;

        TrieNode(){
            children = new HashMap<>();
            count = 0l;
        }

        boolean contains(int value){
            return children.containsKey(value);
        }

        void add(int value, TrieNode node){
            children.put(value,node);
        }

        TrieNode get(int value){
            return children.getOrDefault(value, null);
        }
    }
}
