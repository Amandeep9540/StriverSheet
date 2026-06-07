package tries.questions;

import tries.learnings.TrieNode;

public class DistinctSubstring_GFG {
    public static void main(String[] args) {

    }

    public static int countSubs(String s) {
        TrieNode head = new TrieNode();
        int count = 0;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(addToTrie(s,i,j,head)){
                    count++;
                }
            }
        }

        return count;
    }


    private static boolean addToTrie(String str, int start , int end, TrieNode head){
        TrieNode temp = head;
        for(int i=start;i<end;i++){
            char c = str.charAt(i);
            if(!temp.containsKey(c))
                temp.add(c,new TrieNode());
            temp = temp.get(c);
        }
        if(temp.isEnd) return false;
        temp.isEnd = true;
        return true;
    }

    public static int countSubsV2(String s) {

        TrieNode root = new TrieNode();

        int count = 0;

        for(int i = 0; i < s.length(); i++) {

            TrieNode temp = root;

            for(int j = i; j < s.length(); j++) {

                char c = s.charAt(j);

                if(!temp.containsKey(c)) {
                    temp.add(c, new TrieNode());
                    count++;
                }

                temp = temp.get(c);
            }
        }

        return count;
    }
}
