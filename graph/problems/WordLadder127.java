package graph.problems;

import java.util.*;

public class WordLadder127 {
    public static void main(String[] args) {
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        String beginWord = "hit";
        String endWord = "cog";
        System.out.println("min transformation -- "+ ladderLength(beginWord,endWord,wordList));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for(String s : wordList)
            set.add(s);
        if(!set.contains(endWord)) return 0;
        Queue<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(beginWord,1));
        while(!queue.isEmpty()){
            Pair p = queue.poll();
            String word = p.word;
            int dis = p.dis;
            char[] chars = word.toCharArray();
            for(int i=0;i<word.length();i++){
                for(char c = 'a'; c <= 'z'; c++){
                    chars[i] = c;
                    String newWord = new String(chars);
                    if(endWord.equals(newWord)) return dis + 1;
                    if(set.contains(newWord)){
                        queue.offer(new Pair(newWord,dis+1));
                        set.remove(newWord);
                    }
                }
                chars[i] = word.charAt(i);
            }
        }

        return 0;
    }
}

class Pair {

    String word;
    int dis;

    public Pair(String word,int dis) {
        this.word = word;
        this.dis = dis;
    }

}


