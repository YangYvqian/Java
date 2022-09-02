package Offer.ChapterOneInt;

public class BitCountOnes {
    public int[] countBits(int num){
        int [] result = new int[num+1];
        for (int i = 0; i < num; i++) {
            int j = i;
            while(j != 0){
                result[i]++;
                j = j & (j-1);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int num = 4;
        BitCountOnes t = new BitCountOnes();
        int[] a = t.countBits(num);
        for (int i : a) {
            System.out.println(i);
        }
        
    }
}
