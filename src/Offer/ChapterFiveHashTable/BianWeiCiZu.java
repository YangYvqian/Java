/* 
    ########################################################################面试题33：变位词组########################################################################
    
                                                                题目：给定一组单词，请将它们按照变位词分组。
                                                                例如，输入一组单词["eat"，"tea"，"tan"，"ate"，"nat"，"bat"]，
                                                                这组单词可以分成3组，分别是["eat"，"tea"，"ate"]、["tan"，"nat"]和["bat"]。
                                                                假设单词中只包含英文小写字母。

   ########################################################################面试题33：变位词组########################################################################
    
*/



package Offer.ChapterFiveHashTable;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class BianWeiCiZu  {

    public List<List<String>> groupAnagrams(String[] strs){
        
        int hash[] = {2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97,101};

        Map<Long,List<String>> groups = new HashMap<>();
        for(String str:strs){
            long wordHash = 1;
            for (int i = 0; i < str.length(); ++i) {
                wordHash *= hash[str.charAt(i) - 'a'];
            }

            groups.putIfAbsent(wordHash, new LinkedList<String>());
            groups.get(wordHash).add(str);
        }
        

        return new LinkedList<>(groups.values());
 
        
    }
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        BianWeiCiZu t = new BianWeiCiZu();
        List<List<String>> c = t.groupAnagrams(str);
        System.out.println(c);
        
    }


   
    
}
