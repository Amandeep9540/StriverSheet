package bitManipulation.otherQues;

public class BitwiseAndOfRange201 {
    public static void main(String[] args) {
        int left = 4;
        int right = 5;
        System.out.println("and value is -- "+rangeBitwiseAnd(left,right));
    }

    public static int rangeBitwiseAnd(int left, int right) {
        while(right > left){
            right = right & (right - 1);
        }
        return right;
    }
}
