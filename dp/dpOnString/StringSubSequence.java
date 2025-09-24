package dp.dpOnString;

import java.util.ArrayList;
import java.util.List;

public class StringSubSequence {
    public static void main(String[] args) {
        String st = "abc";
        printAllSubsequenceRecursion(st);
    }

    public static void printAllSubsequencePowerSet(String st){
        int totalSeq = (int)Math.pow(2,st.length());
        List<String> subSequence = new ArrayList<>(totalSeq);
        int stLen = st.length();
                    //running a loop from 0-> totalSeq
        for(int i=0;i<totalSeq;i++){
                    //checking the bit is set or not from 0 -> stLen
            StringBuilder sb = new StringBuilder();
                for(int j =0;j<stLen;j++){
                     if( (i & (1<<j)) != 0){ //means bit is set
                         sb.append(st.charAt(j));
                     }
                }
            subSequence.add(new String(sb));
        }

        subSequence.stream().forEach(System.out::println);
    }

    public static void printAllSubsequenceRecursion(String st){
        List<String> subSeq = new ArrayList<>();
        getSubSeq(st,0,new StringBuilder(),subSeq);
        subSeq.stream().forEach(System.out::println);
    }

    private static void getSubSeq(String st, int index, StringBuilder sb, List<String> subSeq) {
        if(index == st.length()){
            subSeq.add(sb.toString());
            sb = new StringBuilder();
            return;
        }
                //not - picking the element
        getSubSeq(st,index+1,sb,subSeq);
                //picking the element
        sb.append(st.charAt(index));
        getSubSeq(st,index+1,sb,subSeq);
        sb.deleteCharAt(sb.length()-1);
    }


}
