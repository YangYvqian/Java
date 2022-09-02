/* 
    ########################################################################面试题34：外星语言是否能排序########################################################################
   
            题目：有一门外星语言，它的字母表刚好包含所有的英文小写字母，只是字母表的顺序不同。给定一组单词和字母表顺序，请判断这些单词是否按照字母表的顺序排序。               
            例如，输入一组单词["offer"，"is"，"coming"]，以及字母表顺序"zyxwvutsrqponmlkjihgfedcba",由于字母'o'在字母表中位于'i'的前面,因此单词"offer"排在"is"的前面     
            同样，由于字母'i'在字母表中位于'c'的前面，因此单词"is"排在"coming"的前面。因此，这一组单词是按照字母表顺序排序的，应该输出true。                              
    
    ########################################################################面试题34：外星语言是否能排序########################################################################
*/


package Offer.ChapterFiveHashTable;

public class WaiXingLanguageWhethetSort {
    public boolean isAlienSorted(String[] words, String order){

        int[] orderArray = new int[order.length()];
        for (int i = 0; i < order.length(); ++i) {
            orderArray[order.charAt(i)-'a'] = i;
        }

        for (int i = 0; i < words.length - 1; ++i) {
            if (!isSorted(words[i], words[i+1], orderArray)){
                return false;
            }
        }

        return true;
    }


    public boolean isSorted(String word1, String word2, int[] order){
        int i = 0;
        for(; i < word1.length() && i < word2.length(); ++i){
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);
            if(order[ch1-'a']<order[ch2-'a']){
                return true;
            }

            if(order[ch1-'a']>order[ch2-'a']){
                return false;
            }
        }

        return i == word1.length();
    }


public static void main(String[] args) {
    String[] words = {"offer","isd","is"};
    String order = "zyxwvutsrqponmlkjihgfedcba";
    WaiXingLanguageWhethetSort wx = new WaiXingLanguageWhethetSort();
    boolean c = wx.isAlienSorted(words, order);
    System.out.println(c);
}


    
}
