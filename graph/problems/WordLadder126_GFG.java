package graph.problems;

import java.util.*;

public class WordLadder126_GFG {
    public static void main(String[] args) {
        String startWord = "e";
        String targetWord = "f";
        String[] wordList = {"g","f","g"};
        ArrayList<ArrayList<String>> result = findSequences_GFG(startWord,targetWord,wordList);
        result.stream().forEach(x-> System.out.println(x));
    }

        /*This solution is accepted in GFG*/
    public static ArrayList<ArrayList<String>> findSequences_GFG(String startWord, String targetWord, String[] wordList) {
        Queue<ArrayList<String>> queue = new ArrayDeque<>();
        Set<String> set = new HashSet<>();
        for(String st : wordList){
            set.add(st);
        }
        // if(!set.contains(targetWord)) return new ArrayList<>();
        queue.offer(new ArrayList<>(Arrays.asList(startWord)));

        Set<String> usedOnLevel = new HashSet<>();
        int level = 1;
        int finalLevel = -1;
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        //traversing the queue by follow the BFS approach
        while(!queue.isEmpty()){

            ArrayList<String> list = queue.poll();
            int currentLevel = list.size();
            String lastWord = list.get(list.size()-1);
            char[] chars = lastWord.toCharArray();


            //checking if the finalLevel set if -> yes then we add data in result
            if(finalLevel != -1 && list.size() == finalLevel && lastWord.equals(targetWord)){
                result.add(list);
            }

            if (finalLevel != -1 && list.size() >= finalLevel) {
                continue;
            }

            //removing from the queue if we are one next level
            if(level < list.size()){
                set.removeAll(usedOnLevel);
                usedOnLevel = new HashSet<>();
                level = list.size();
            }
            //updating the last word
            for(int i=0;i<lastWord.length();i++){
                for(char c = 'a';c<='z';c++){
                    if(lastWord.charAt(i) == c) continue;
                    chars[i] = c;
                    String newWord = new String(chars);
                    if(newWord.equals(targetWord)) finalLevel = currentLevel+1;
                    if(set.contains(newWord)){
                        ArrayList<String> newList = new ArrayList<>();
                        newList.addAll(list);
                        newList.add(newWord);
                        usedOnLevel.add(newWord);
                        queue.offer(newList);
                    }
                }
                chars[i] = lastWord.charAt(i);
            }
        }
        return result;
    }


}
