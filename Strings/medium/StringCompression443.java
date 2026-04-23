package Strings.medium;

public class StringCompression443 {
    public static void main(String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'};
        int len = compress(chars);
        for(int i=0;i<len;i++){
            System.out.print(chars[i]);
        }
    }

    public static int compress(char[] chars) {
        int i = 0;
        int printingIndex = 0;
        while(i < chars.length){
            char c = chars[i];
            int count = countOccurence(chars,i);
            printingIndex = updateCount(chars,c,count,printingIndex);
            i += count;
        }
        return printingIndex;
    }

    public static int updateCount(char[] chars, char c, int count, int printingIndex){
        chars[printingIndex++] = c;
        if(count == 1) return printingIndex;
        String countStr = String.valueOf(count);
        for(int i=0;i<countStr.length();i++){
            chars[printingIndex++] = countStr.charAt(i);
        }
        return printingIndex;
    }
    public static int countOccurence(char[] chars , int i){
        int count = 1;
        while(i + 1 < chars.length && chars[i] == chars[i+1]){
            i++; count++;
        }
        return count;
    }
}
