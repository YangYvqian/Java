package leetCode;


public class RepeatedSubstringPattern {
    public static boolean repeatedSubstringPattern(String s){
        return (s + s).indexOf(s, 1) != s.length();
    }



    public static void main(String[] args) {
        
        String s = "abab";
        boolean res = repeatedSubstringPattern(s);
        System.out.println(res);
        
    }
}
