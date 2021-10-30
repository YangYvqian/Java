package labuladong.nSum;

import java.util.HashMap;

public class TwoSum {
    int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer, Integer> index = new HashMap<>();
        // 构造一个哈希表：元素映射到相应的索引
        for (int i = 0; i < n; i++)
            index.put(nums[i], i);
        
        for (int i = 0; i < n; i++) {
            int other = target - nums[i];
            // 如果 other 存在且不是 nums[i] 本身
            if (index.containsKey(other) && index.get(other) != i){
                // int d = index.get(other);
                return new int[] {i, index.get(other)};
            }
                
        }
        
        return new int[] {-1, -1};
    }

    public static void main(String[] args) {
        int[] nums={1,3,3,6};
        int target = 6;
        TwoSum ts = new TwoSum();
        int[] res = ts.twoSum(nums, target);
        System.out.println(res);
    }
}
