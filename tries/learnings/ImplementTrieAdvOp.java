package tries.learnings;

public class ImplementTrieAdvOp {
    public static void main(String[] args) {
        insert("apple");
        insert("apple");
        insert("apps");

        System.out.println("no. of apple --" +search("apple"));
        System.out.println("start with app --" +startsWith("app"));
        System.out.println("start with apps --" +startsWith("apps"));


        delete("apps");
        System.out.println();


        System.out.println("no. of apple --" +search("apple"));
        System.out.println("start with app --" +startsWith("app"));
        System.out.println("start with apps --" +startsWith("apps"));
    }

    static AdvTrieNode head = new AdvTrieNode();
    public static void insert(String str){
        AdvTrieNode temp = head;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int charIdx = ch - 'a';
            if(!temp.contains(charIdx)){
                temp.add(charIdx,new AdvTrieNode());
            }
            temp = temp.get(charIdx);
            temp.prefixCount++;
        }
        temp.endWithCount++;
    }

    public static int search(String str){
        AdvTrieNode temp = head;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int charIdx = ch - 'a';
            if(!temp.contains(charIdx)){
                return 0;
            }
            temp = temp.get(charIdx);
        }
        return temp.endWithCount;
    }

    public static int startsWith(String str){
        AdvTrieNode temp = head;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int charIdx = ch - 'a';
            if(!temp.contains(charIdx)){
                return 0;
            }

            temp = temp.get(charIdx);
        }
        return temp.prefixCount;
    }

    public static void delete(String str){
        if(search(str) == 0) return;
        AdvTrieNode temp = head;
        for(int i=0;i<str.length();i++){
            char ch = str.charAt(i);
            int charIdx = ch - 'a';
            if(!temp.contains(charIdx)) return;
            temp = temp.get(charIdx);
            temp.prefixCount--;
        }
        temp.endWithCount--;
    }
}
