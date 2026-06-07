package tries.learnings;

public class ImplementTriePrefixTree208 {
    public static void main(String[] args) {
        insert("abcd");
        insert("abcdefg");

        System.out.println("is word exists -- "+search("abcd"));
        System.out.println("is word start with -- "+startsWith("abc"));

        delete("abcd");

        System.out.println("is word exists -- "+search("abcd"));
    }

    public static TrieNode head = new TrieNode();
    public static void insert(String word) {
        TrieNode temp = head;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!temp.containsKey(c)){ //
                temp.add(c,new TrieNode()); //
            }
            temp = temp.get(c); //
        }
        temp.isEnd = true;
    }

    public static boolean search(String word) {
        TrieNode temp = head;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!temp.containsKey(c)){
                return false;
            }
            temp = temp.get(c); //
        }
        return temp.isEnd;
    }

    public static boolean startsWith(String word) {
        TrieNode temp = head;
        for(int i=0;i<word.length();i++){
            char c = word.charAt(i);
            if(!temp.containsKey(c)){ //
                return false;
            }
            temp = temp.get(c); //
        }
        return true;
    }

    public static void delete(String word){

    }
}
