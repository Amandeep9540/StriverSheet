package zrandomQuestion;

import java.util.ArrayList;
import java.util.List;

public class LastKNumProduct1352 {
    public static void main(String[] args) {
        ProductOfNumbers productOfNumbers = new ProductOfNumbers();
        productOfNumbers.add(3);        // [3]
        productOfNumbers.add(0);        // [3,0]
        productOfNumbers.add(2);        // [3,0,2]
        productOfNumbers.add(5);        // [3,0,2,5]
        productOfNumbers.add(4);        // [3,0,2,5,4]

        System.out.println(productOfNumbers.getProduct(2)); // 20
        System.out.println(productOfNumbers.getProduct(3)); // 40
        System.out.println(productOfNumbers.getProduct(4)); // 0

        productOfNumbers.add(8);

        System.out.println(productOfNumbers.getProduct(2)); // 32
    }
}

class ProductOfNumbers {
        List<Integer> stream = new ArrayList<>();
        List<Integer> prefixProduct = new ArrayList<>();
    public ProductOfNumbers() {

    }

    public void add(int num) {
        stream.add(num);
        if(num == 0){
            prefixProduct = new ArrayList<>();
        }else if(prefixProduct.isEmpty()){
            prefixProduct.add(num);
        }else{
            int lastProduct = prefixProduct.get(prefixProduct.size()-1);
            prefixProduct.add(lastProduct*num);
        }
    }

    public int getProduct(int k) {
        if(prefixProduct.size() < k){
            return 0;
        }else if(prefixProduct.size() == k){
            return prefixProduct.get(prefixProduct.size()-1);
        }
        int totalProduct = prefixProduct.get(prefixProduct.size()-1);
        int beforeKProduct = prefixProduct.get(prefixProduct.size() - (k+1));
        return totalProduct/beforeKProduct;
    }
}
