package leetCode;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
    
public class CombinationSum2{
    
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new LinkedList<>();

        if(candidates.length==0){
            return result;
        }

        dfs(candidates,target,0,new LinkedList<>(),result);
        return result;
    }

    public static void dfs(int[] candidates,int target,int index,LinkedList<Integer> subset,List<List<Integer>> result){
        if(target==0){
            result.add(new LinkedList<>(subset));
        }else if(target>0 && index<candidates.length){
            dfs(candidates,target,getNext(candidates,index),subset,result);
            subset.add(candidates[index]);
            dfs(candidates,target-candidates[index],index+1,subset,result);
            subset.removeLast();
        }
    }

    public static int getNext(int[] candidates, int index){
        int next = index;
        while(next<candidates.length && candidates[index]==candidates[next]){
            next++;
        }
        return next;
    }

    public static void main(String[] args) {
        int[] nums = {10,1,2,7,6,1,5};
        int t = 8;
        List<List<Integer>> a = combinationSum2(nums,t);
        System.out.println(a);

    }
}
