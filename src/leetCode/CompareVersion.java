package leetCode;

import java.security.Timestamp;
import java.sql.Time;
import java.util.Timer;

public class CompareVersion {

    public static int compareVersion(String s1,String s2){
   
        
        String[] cs1 = s1.contains(".")?s1.split("\\."):new String[]{s1};
        String[] cs2 = s2.contains(".")?s2.split("\\."):new String[]{s2};

        int len1 = cs1.length;
        int len2 = cs2.length;
        int min = Math.min(len1, len2);

        int flag = 1;
        int i;
       for(i=0;i<min;i++){
            int str1 = Integer.parseInt(cs1[i]);
            int str2 = Integer.parseInt(cs2[i]);

            if(str1==str2 && i==min-1){
                flag = 2;
            }else if(str1==str2 && i<min){
                continue;
            }else if(str1>str2){
                return 1;
            }else if(str1<str2){
                return -1;
            }
       }
        
       if(flag==2){
            if(len1>len2){
                while(i<len1){
                    int str3 = Integer.parseInt(cs1[i]);
                    if(str3!=0){
                        return 1;
                    }
                    i++;
                }
            }else{
                while(i<len2){
                    int str3 = Integer.parseInt(cs2[i]);
                    if(str3!=0){
                        return -1;
                    }
                    i++;
                }
            }
       }

        return 0;

        
    }



    public static void main(String[] args) {
        

        String s3 = "1.0.1";
        String s4 = "1";
        int res3 = compareVersion(s3, s4);
        System.out.println(res3);
        

        // String s6 = "1.0.1";
        // String s5 = "1";
        // int res3 = compareVersion(s5, s6);


        // int a = 0011;
        // int b = 01;
        // System.out.println(a<b);


    }
    
}
