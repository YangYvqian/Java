package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

    List<List<Integer>> result = new LinkedList<>();

        if(nums.length==0) return result;
        dfs(nums,0,new LinkedList<>(),result);
        return result;

    }


    public static void dfs(int[] nums, int index,LinkedList<Integer> subset,List<List<Integer>> result){
        if(index==nums.length){
            result.add(new LinkedList<>(subset));
        }else if(index<nums.length){
            dfs(nums,getNext(nums,index),subset,result);
            subset.add(nums[index]);
            dfs(nums,index+1,subset,result);
            subset.removeLast();
        }
    }


    public static int getNext(int[] nums,int index){
        int next = index;
        while(next<nums.length && nums[next]==nums[index]){
            next++;
        }

        return next;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2};

        subsetsWithDup(nums);
    }
}