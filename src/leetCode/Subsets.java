package leetCode;

import java.util.LinkedList;

import java.util.List;

public class Subsets {
    
    public static List<List<Integer>> subsets(int[] nums){
        List<List<Integer>> result = new LinkedList<>();

        if(nums.length==0) return result;

        dfs(nums,0,new LinkedList<>(),result);
        

        return result;
    }



    public static void dfs(int[] nums,int index,LinkedList<Integer> subset,List<List<Integer>> result){
        if(index == nums.length){
            result.add(new LinkedList<>(subset));
        }else if(index < nums.length){
            subset.add(nums[index]);
            subset.size();
            dfs(nums, index+1, subset, result);
            subset.removeLast();
            dfs(nums, index+1, subset, result);
            
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> a = subsets(nums);
        System.out.println(a);

    }
}
