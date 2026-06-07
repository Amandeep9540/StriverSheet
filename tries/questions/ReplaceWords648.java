package tries.questions;

import java.util.List;

public class ReplaceWords648 {
    public static void main(String[] args) {
        ReplaceWords648 ques = new ReplaceWords648();
        String[] dictionary = {"cat","bat","rat"};
        String sentence = "the cattle was rattled by the battery";
        System.out.println(" sentence is  -- "+ques.replaceWords(List.of(dictionary),sentence));
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        /**Insert the dictionary words to the trie , so we can check when traversing the sentence efficently */
        for(String word : dictionary)
            insertToTrie(word,root);

        String[] sentenceArr = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word : sentenceArr){
            result.append(getDictionaryWord(word,root));
            result.append(" ");
        }

        result.setLength(result.length() - 1); // Removing the extra space , causing because of we are appending the space after every word

        return result.toString();
    }

    private String getDictionaryWord(String word,TrieNode root){
        if(!root.contains(word.charAt(0))) return word;
        TrieNode temp = root;

        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!temp.contains(c)) return word;
            temp = temp.get(c);
            if(temp.isEnd) return temp.word;
        }

        return word;
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
        temp.word = word;
    }


    class TrieNode {
        TrieNode[] childrens;
        boolean isEnd;
        String word;

        public TrieNode() {
            childrens = new TrieNode[26];
        }

        public boolean contains(char c) {
            return childrens[c - 'a'] != null;
        }

        public void add(char c, TrieNode node) {
            childrens[c - 'a'] = node;
        }

        public TrieNode get(char c) {
            return childrens[c - 'a'];
        }
    }
}
