package Offer.ChapterOneInt;

import java.util.HashMap;
import java.util.Map;

public class SingleNum {

    public int numCount(int[] nums){
        Map<Integer, Integer> numcount =  new HashMap<>();
        for (int num : nums) {
            numcount.put(num, numcount.getOrDefault(num, 0) + 1);
        }

        int ans = 0;
       for (Map.Entry<Integer, Integer> entry : numcount.entrySet()) {
           int key = entry.getKey();
           int value = entry.getValue();
           if(value == 1){
              ans = key; 
              break;
           } 

       }

        return ans;
    }
    public static void main(String[] args) {
       int[] num = {0, 1, 0, 1, 0, 1, 100};
       SingleNum singleNum =  new SingleNum();
       int a = singleNum.numCount(num);
       
       System.out.println(a);



    }

       
    
}
