package leetCode;

import java.util.LinkedList;
import java.util.List;

import javax.print.attribute.standard.Sides;

public class CombinationSum3 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        if(n==0) return result;
        dfs(n,k,n,1,new LinkedList<>(),result);
        return result;

    }

    public static void dfs(int t, int k, int n, int index, LinkedList<Integer> subset, List<List<Integer>> result){
        if(n==0 && subset.size()==k){
            result.add(new LinkedList<>(subset));
        }else if(k>0&&index<=n){
            dfs(t,k,n,getNext(index,result,t),subset,result);
            subset.add(index);
            dfs(t,k,n-index,index+1,subset,result);
            subset.removeLast();
        }
    }

    public static int getNext(int index,List<List<Integer>> result,int n){

        LinkedList<Integer> temp = new LinkedList<>();
        for(List<Integer> sub:result){
            for (Integer i : sub) {
                temp.add(i);
            }
            
        }

        int next = index;
        while( next<n && temp.contains(next)){
            
            next++;

        }

        if(!temp.contains(next)){
            next++;
        }
  
        
        return next;
    }
    public static void main(String[] args) {
        List<List<Integer>> res =combinationSum3(2, 18);
        System.out.println(res);
    }
}
    

