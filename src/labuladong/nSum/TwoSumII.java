package labuladong.nSum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSumII {
    Set<Integer> sum = new HashSet<>();
    List<Integer> nums = new ArrayList<>();

    public void add(int number) {
        // 记录所有可能组成的和
        for (int n : nums)
            sum.add(n + number);
        nums.add(number);
    }
    
    public boolean find(int value) {
        return sum.contains(value);
    }

    public static void main(String[] args) {
        TwoSumII TSII = new TwoSumII();
        TSII.add(2);
        TSII.add(3);
        TSII.add(3);
        TSII.add(6);
        boolean tt = TSII.find(5);
        System.out.println(tt);
    }
}
