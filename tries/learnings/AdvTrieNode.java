package tries.learnings;

public class AdvTrieNode {
    AdvTrieNode[] nodes;
    int prefixCount;
    int endWithCount;

    public AdvTrieNode() {
        nodes = new AdvTrieNode[26];
    }

    public AdvTrieNode( int prefixCount, int endWithCount) {
        nodes = new AdvTrieNode[26];
        this.prefixCount = prefixCount;
        this.endWithCount = endWithCount;
    }

    public boolean contains(int charIdx) {
        return nodes[charIdx] != null;
    }

    public void add(int charIdx, AdvTrieNode advTrieNode) {
        nodes[charIdx] = advTrieNode;
    }

    public AdvTrieNode get(int charIdx) {
        return nodes[charIdx];
    }
}
