package leetCode;

import java.util.Arrays;


public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s){
        int a  = (s + s).indexOf(s, 1);
        return (s + s).indexOf(s, 1) != s.length();
    }



    public static void main(String[] args) {
        
        String s = "abab";
        boolean res = repeatedSubstringPattern(s);
        System.out.println(res);
        
    }
}
