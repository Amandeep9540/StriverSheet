package recursion.basic;

public class TowerOfHanoi_GFG {
    public static void main(String[] args) {
        int minCount  = towerOfHanoi(3, 55, 77, 99);
        System.out.println("minCount :: "+minCount);
    }
        //It's working correct but giving time limit exceed error.
    public static int towerOfHanoi(int n, int from, int to, int aux) {
        if(n == 1){
            System.out.println("move disk "+n+ " from rod "+ from +" to rod "+to);
            return 1;
        }
        int count = towerOfHanoi(n-1,from,aux,to);

        System.out.println("move disk "+n+ " from rod "+ from +" to rod "+to);
        count++;

        count += towerOfHanoi(n-1,aux,to,from);
        return count;
    }
}
