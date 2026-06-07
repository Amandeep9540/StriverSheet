package tries.questions;

public class CountingWordWithPrefix2185 {
    public static void main(String[] args) {
        System.out.println(" "+prefixCount(new String[]{"pay","attention","practice","attend"},"at"));
    }

    public static int prefixCount(String[] words, String pref) {
        int count = 0;
        for(String word : words){
            if(pref.length() > word.length()) continue;
            if(word.substring(0,pref.length()).equals(pref))
                count++;
        }

        return count;
    }
}
