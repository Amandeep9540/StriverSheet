package greedyAlgo.easy;

public class LemonadeChange860 {
    public static void main(String[] args) {
        int[] bills = {5,5,10,10,20};
        System.out.println("is -- "+lemonadeChange(bills));
    }

    public static boolean lemonadeChange(int[] bills) {
        int fiveBills = 0;
        int tenBills = 0;

        for(int bill : bills){
            if(bill == 10){
                tenBills++;
                if(fiveBills == 0) return false;
                fiveBills--;
            }else if(bill == 20){
                //combination 10 + 5 or 5+5+5
                if(tenBills > 0 && fiveBills > 0){
                    tenBills--;fiveBills--;
                }else if(fiveBills >= 3){
                    fiveBills -= 3;
                }else{
                    return false;
                }
            }else{
                fiveBills++;
            }
        }
        return true;
    }
}
