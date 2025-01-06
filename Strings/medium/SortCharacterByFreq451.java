package Strings.medium;

import java.util.*;

public class SortCharacterByFreq451 {
    public static void main(String[] args) {
        String shortedString = frequencySort("tree");
        System.out.println("shortedString is :: "+shortedString);
    }

    public static String frequencySort(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);

        Map<Character,Integer> frequencyMap = new LinkedHashMap<>();

        for (char c : charArray) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c,0) + 1);
        }

        List<Map.Entry<Character, Integer>> sortedMapList = new ArrayList<>(frequencyMap.entrySet());
        sortedMapList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        StringBuilder result = new StringBuilder();

        for (Map.Entry<Character, Integer> entry : sortedMapList) {
            int value = entry.getValue();
            while(value > 0) {
                result.append(entry.getKey());
                value--;
            }
        }

        return result.toString();
    }
}
