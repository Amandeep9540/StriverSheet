package recursion.Hard;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak139 {
    static Boolean[] isWeComputed ;
    public static void main(String[] args) {
        List<String> wordDict = Arrays.asList("cats","dog","sand","and","cat");
        System.out.println("can we form "+wordBreak("catsandog",wordDict));
    }

    /*We use memorization to solve time limit exceed problem*/
    public static boolean wordBreak(String s, List<String> wordDict) {
        isWeComputed = new Boolean[s.length()];
        Set<String> wordDistSet = new HashSet<>(wordDict);
        return canWeFormS(s,0,wordDistSet);
    }

    private static boolean canWeFormS(String s, int i, Set<String> wordDistSet) {
        if(i >=s.length()){
            return true;
        }
        if(isWeComputed[i] != null){
            return isWeComputed[i];
        }
        for(int j = i;j<s.length();j++){
            if(wordDistSet.contains(s.substring(i,j+1)) && canWeFormS(s,j+1,wordDistSet)){
                isWeComputed[i] = true;
                return true;
            }
        }

        return isWeComputed[i] = false;
    }
}
