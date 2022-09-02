package Offer.ChapterOneInt;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;






public class MaxProduct{

    public int maxProduct(String[] str){

        Map<String, Map<Character, Integer>> map = new HashMap<>();
        for (String s : str) {
            Map<Character, Integer> submap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                submap.put(s.charAt(i), 1);
            }
            map.put(s, submap);
        }
        int res=0;
        for (String s : str) {
             Map<Character, Integer> a = map.get(s);
            Set<Character> keys = a.keySet();
            for (String sub : str) {
                int i = 0;
                for (; i < sub.length(); i++) {
                    
                    if(keys.contains(sub.charAt(i))) break;
                }
                if(i == sub.length()){
                    int prod = s.length() * sub.length();
                    res = Math.max(res, prod);
                }
                
            }
            
        }
        System.out.println(res);

        return res;
    }

    public static void main(String[] args) {
        String[] str = {"abcwe", "foo", "bar", "fxyzd", "abcdef"};
        MaxProduct maxProduct = new MaxProduct();
        maxProduct.maxProduct(str);
        
    }
}