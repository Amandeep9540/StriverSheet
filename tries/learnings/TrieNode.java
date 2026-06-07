package tries.learnings;

public class TrieNode {
    public TrieNode[] nodes;
    public boolean isEnd;

    public TrieNode(){
        nodes = null;
    }

    public boolean containsKey(char c){
        if(nodes == null)
            nodes = new TrieNode[27];
        return nodes[c-'a'] != null;
    }

    public TrieNode get(char c){
        return nodes[c-'a'];
    }

    public void add(char c, TrieNode node){
        nodes[c-'a'] = node;
    }
}
