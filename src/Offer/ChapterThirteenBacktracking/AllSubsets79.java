package Offer.ChapterThirteenBacktracking;

import java.util.ArrayList;
import java.util.List;

public class AllSubsets79 {
    int [] nums;
    int n;
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) 
    {
        this.nums = nums;
        this.n = nums.length;
        backtrace(0);
        return res;
    }

    public void backtrace(int idx)
    {
        if (idx == n)
        {
            res.add(new ArrayList<>(path));
            return ;
        }

        backtrace(idx + 1);

        path.add(nums[idx]);
        backtrace(idx + 1);
        path.remove(path.size() - 1);
    }


    public static void main(String[] args) {
        int[] nums = {1,2};
        AllSubsets79 asub = new AllSubsets79();
        asub.subsets(nums);

    }
}
