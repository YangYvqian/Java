package leetCode;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Makesquare {
    public static boolean makesquare(int[] matchsticks) {

        IntStream arr = Arrays.stream(matchsticks);
        int sum = arr.sum();

        int flag = 0;;
        if(sum%4==0){
            flag = sum/4;
        }else{
            return false;
        }
        int subsum = 0;
        Arrays.sort(matchsticks);
        for(int i=0;i<matchsticks.length;i++){
            if(subsum!=flag && subsum<flag){
                subsum = subsum+matchsticks[i];
                continue;
            }else if(subsum==flag){
                subsum = 0;
                continue;
            }if(subsum>flag){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] arr = {10,6,5,5,5,3,3,3,2,2,2,2};
        boolean res = makesquare(arr);
        System.out.println(res);
    }
}
