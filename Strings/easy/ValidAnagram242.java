package Strings.easy;

public class ValidAnagram242 {
    public static void main(String[] args) {
        boolean isAnagram = isAnagram("egg", "gey");
        System.out.println("isAnagram :: "+isAnagram);
    }

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;

        int[] arr = new int[26];

        for(int i=0;i<s.length();i++){
            arr[s.charAt(i)-'a']++;
            arr[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(arr[i] != 0)
                return false;
        }
        return true;
    }
}
