package tries.questions;

public class LongestCommonSuffixQuery3093 {
    public static void main(String[] args) {
        LongestCommonSuffixQuery3093 ques = new LongestCommonSuffixQuery3093();
        String[] wordsContainer = {"abcd","bcd","xbcd"};
        String[] wordsQuery = {"cd","bcd","xyz"};
        int[] result = ques.stringIndices(wordsContainer,wordsQuery);
        for(int num : result)
            System.out.print(num+" ");
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        /**
         Inserting the words into the trie so the when we traverse the query its easy to find the suffix, and we store the wrods in reverse order for that */
        TrieNode root = new TrieNode();
        for(int i=0;i<wordsContainer.length;i++){
            insertToTrie(wordsContainer,root,i);
        }


        /** We will traverse the query and find the suffix from the trie and the index in present in the trie that tells us the L.C.S index according the question conditions*/
        int[] result = new int[wordsQuery.length];
        for(int i=0;i<wordsQuery.length;i++){
            String query = wordsQuery[i];
            result[i] = findSuffixIndex(root,query);
        }
        return result;
    }

    private int findSuffixIndex(TrieNode root, String word){
        int index = root.index;
        TrieNode temp = root;
        for(int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            if(!temp.contains(c)) return index;
            else{
                temp = temp.get(c);
                index = temp.index;
            }
        }

        return index;
    }

    private void insertToTrie(String[] wordsContainer, TrieNode root,int idx){
        TrieNode temp = root;
        updateNodeIndex(wordsContainer,idx,root);
        String word = wordsContainer[idx];

        for(int i=word.length()-1;i>=0;i--){
            char c = word.charAt(i);
            if(!temp.contains(c)){
                TrieNode node = new TrieNode();
                node.index = idx;
                temp.add(c,node);
            }

            temp = temp.get(c);
            updateNodeIndex(wordsContainer,idx,temp);
        }
    }

    private void updateNodeIndex(String[] wordsContainer, int idx, TrieNode root ){
        if(wordsContainer[root.index].length() > wordsContainer[idx].length())
            root.index = idx;
    }

    class TrieNode{
        TrieNode[] childrens;
        int index;

        public TrieNode(){
            childrens = new TrieNode[26];
        }

        public boolean contains(char c){
            return childrens[c-'a'] != null;
        }

        public void add(char c, TrieNode node){
            childrens[c-'a'] = node;
        }

        public TrieNode get(char c){
            return childrens[c - 'a'];
        }
    }
}
