package tries.questions;

import tries.learnings.TrieNode;

public class LongestValidWordWithAllPrefixes_GFG {
    public static void main(String[] args) {
        String[] words = {"p", "pr", "pro", "probl", "problem", "pros", "process", "processor"};
        System.out.println("word is -- "+longestValidWord(words));
    }

    public static String longestValidWord(String[] words) {
        TrieNode head = populateWords(words);
        String result = "";
        for(String word : words){
            if(containsAllPrefix(word,head)){
                if(word.length() > result.length() ||
                        (word.length() ==  result.length() && result.compareTo(word) > 0)
                )
                    result = word;

            }
        }

        return result;
    }

    private static boolean containsAllPrefix(String word,TrieNode head){
        TrieNode temp = head;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!temp.containsKey(c)) return false;
            temp = temp.get(c);
            if(!temp.isEnd) return false;
        }
        return true;
    }

    private static TrieNode populateWords(String[] words){
        TrieNode head = new TrieNode();
        for(String word : words)
            insertWord(word,head);

        return head;
    }

    private static void insertWord(String word,TrieNode head){
        TrieNode temp = head;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!temp.containsKey(c))
                temp.add(c,new TrieNode());

            temp = temp.get(c);
        }

        temp.isEnd = true;
    }
}
