package Strings.matchingAlgos.RabinKrap;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgo {
    private static Long MOD_I = 1_000_000_007L;
    private static Long MOD_II = 1_000_000_033L;

    private static Long BASE_I = 26L;
    private static Long BASE_II = 27L;


    public static void main(String[] args) {
        String text = "abcabc";
        String pattern = "abc";
        matchPattern(text,pattern).forEach(System.out::println);
    }

    public static List<Integer> matchPattern(String text, String pattern){
                if(text.length() < pattern.length()) return new ArrayList<>();
        List<Integer> resultIndex = new ArrayList<>();
        long patternHashI = findHash(pattern,BASE_I,MOD_I,pattern.length()-1);
        long patternHashII = findHash(pattern,BASE_II,MOD_II,pattern.length()-1);

        int m = pattern.length();

        Long MAX_WEIGHT_I = 1L;
        Long MAX_WEIGHT_II = 1L;
        for(int i=0;i< pattern.length()-1;i++) {
            MAX_WEIGHT_I = (MAX_WEIGHT_I * BASE_I) % MOD_I;
            MAX_WEIGHT_II = (MAX_WEIGHT_II * BASE_II) % MOD_II;
        }

        Long textHashI = 0L;
        Long textHashII = 0L;

        for(int i=0; i<=text.length()- m;i++){
            if(i==0){
                textHashI = findHash(text,BASE_I,MOD_I,pattern.length()-1);
                textHashII = findHash(text,BASE_II,MOD_II,pattern.length()-1);
            }else{
                char prevChar = text.charAt(i-1);
                char newChar = text.charAt(i+m-1);
                textHashI = (textHashI - (((prevChar - 'a') * MAX_WEIGHT_I)) % MOD_I);
                textHashI = (textHashI * BASE_I) % MOD_I;
                textHashI = ((textHashI + (newChar - 'a'))) % MOD_I;
                    if (textHashI < 0) textHashI += MOD_I;
                textHashII = (textHashII - (((prevChar - 'a') * MAX_WEIGHT_II)) % MOD_II);
                textHashII = (textHashII * BASE_II) % MOD_II;
                textHashII = ((textHashII + (newChar - 'a'))) % MOD_II;
                    if (textHashII < 0) textHashII += MOD_II;
            }

            if(textHashI == patternHashI && textHashII == patternHashII){
                for(int j=0;j<m;j++){
                    if(pattern.charAt(j) != text.charAt(j+i)){
                        System.out.println("Invalid hit");
                       break;
                    }
                    if(j == pattern.length()-1){
                        resultIndex.add(i);
                    }
                }

            }
        }


        return resultIndex;
    }

    private static long findHash(String pattern,Long base, Long mod,int n) {
        long hash = 0 , factor = 1;
        for (int i = n; i >= 0 ; i--) {
            hash = (hash + (pattern.charAt(i) - 'a') * factor) % mod;
            factor = (factor * base) % mod;

        }
        return hash;
    }


}
