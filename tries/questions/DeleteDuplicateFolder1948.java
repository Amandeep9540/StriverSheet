package tries.questions;

import java.util.*;

public class DeleteDuplicateFolder1948 {
    public static void main(String[] args) {

    }

    Map<String, Integer> subFolderCount = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        /** Store the paths in the trie */
        TrieNode root = initializePath(paths);

        removeDuplicatePaths(root);

        return constructPath(root);
    }

    /**This function will store the path realted data in the trie */
    public TrieNode initializePath(List<List<String>> paths) {
        TrieNode root = new TrieNode();
        TrieNode temp = root;
        for (List<String> path : paths) {
            temp = root;
            for (String str : path) {
                if (!temp.contains(str)) {
                    temp.add(str, new TrieNode());
                }
                temp = temp.get(str);
            }
        }
        computeSubFoldersForNodes(root);
        return root;
    }

    /** This functin will compute the sub-folder for every node and also its sort the subfolder and store the subfolder count in the map */
    private String computeSubFoldersForNodes(TrieNode root) {

        Map<String, String> subFolderMap = new HashMap<>();

        for (Map.Entry<String, TrieNode> entry : root.childMap.entrySet()) {

            String currFolder = entry.getKey();

            String subFolderName = computeSubFoldersForNodes(entry.getValue());

            subFolderMap.put(currFolder, subFolderName);
        }

        List<String> folders = new ArrayList<>(subFolderMap.keySet());

        Collections.sort(folders);

        StringBuilder currSubFolder = new StringBuilder();

        for (String folder : folders) {
            currSubFolder.append("(");
            currSubFolder.append(folder);
            currSubFolder.append(subFolderMap.get(folder));
            currSubFolder.append(")");
        }

        String subFolder = currSubFolder.toString();

        root.subFolder = subFolder;

        if (!subFolder.isEmpty()) {
            subFolderCount.put(
                    subFolder,
                    subFolderCount.getOrDefault(subFolder, 0) + 1);
        }

        return subFolder;
    }

    /**This function will remove the edge to the child node if the subfolder count is > 2 */
    private void removeDuplicatePaths(TrieNode root) {
        for (TrieNode child : root.childMap.values()) {

            if (!child.subFolder.isEmpty() &&
                    subFolderCount.get(child.subFolder) > 1) {

                child.deleted = true;
            }

            removeDuplicatePaths(child);
        }
    }

    /** This function will construct the path based the trie node edges */
    /** This function will construct the paths based on the trie node edges */
    private List<List<String>> constructPath(TrieNode root) {
        List<List<String>> result = new ArrayList<>();
        dfs(root, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TrieNode node, List<String> currPath, List<List<String>> result) {

        for (Map.Entry<String, TrieNode> entry : node.childMap.entrySet()) {
            String folder = entry.getKey();
            TrieNode child = entry.getValue();
            if (child.deleted)
                continue;
            currPath.add(folder);

            // Every folder node represents a valid path
            result.add(new ArrayList<>(currPath));

            dfs(child, currPath, result);

            currPath.remove(currPath.size() - 1);
        }
    }

    class TrieNode {
        String nodeName;
        String subFolder;
        boolean deleted;
        Map<String, TrieNode> childMap;

        /**Constructor */
        public TrieNode() {
            childMap = new HashMap<>();
        }

        public TrieNode get(String value) {
            return childMap.getOrDefault(value, null);
        }

        public void add(String value, TrieNode node) {
            childMap.put(value, node);
        }

        public boolean contains(String value) {
            return childMap.containsKey(value);
        }
    }
}
