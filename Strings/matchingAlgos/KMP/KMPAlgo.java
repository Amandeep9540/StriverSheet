package Strings.matchingAlgos.KMP;

import java.util.ArrayList;

public class KMPAlgo {
    public static void main(String[] args) {
        String pattern = "aaba";
        String text = "aabaacaadaabaaba";
        ArrayList<Integer> result = search(pattern,text);
        result.stream().forEach(System.out::println);
    }

    public  static ArrayList<Integer> search(String pat, String txt) {
        int i = 0; // representing txt index
        int j = 0; // representing pattern index
        int[] lps = computeLPS(pat);
        ArrayList<Integer> result = new ArrayList<>();
        while(i < txt.length()){
            if(pat.charAt(j) == txt.charAt(i)){
                i++;j++;
            }else{
                if(j != 0)
                    j = lps[j-1];
                else
                    i++;
            }

            //checking that pattern found in the txt or not
            if(j == pat.length()){
                result.add(i-pat.length() );
                j = lps[j-1];
            }


        }

        return result;
    }

    private static int[] computeLPS(String pattern){
        int[] lps = new int[pattern.length()];
        int i = 1, len = 0;

        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }else{
                if(len != 0){
                    len = lps[len - 1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }
}
