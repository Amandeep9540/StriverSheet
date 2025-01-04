package Strings.easy;

public class ReverseWordInString151 {
    public static void main(String[] args) {
        String reverseWord = reverseWords("a");
        System.out.println("reverseWord is :: "+reverseWord);
    }

    public static String reverseWords(String s) {
        int end = s.length()-1;

        StringBuilder result = new StringBuilder();
        while(end>=0){
                //traverse until word string doesn't stand at at character of word
            while(end>0 && s.charAt(end) == ' '){
                end--;
            }

                //breaking the loop if end is reach to 0 and have space (having space meaning no word is left at right)
            if(end == 0 && s.charAt(end) == ' ')
                break;

                //traverse until you doesn't reach start word
            int wordEnd = end;
            while(end>=0 && s.charAt(end) != ' '){
                end--;
            }

                //add the space if result have something
            if(!result.isEmpty()){
                result.append(" ");
            }

                //append that word in result
            result.append(s.substring(end+1,wordEnd+1));

        }

        return result.toString();
    }
}
