package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 最长公共后缀
 */
public class Solution29 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().replace("[","").replace("]","").replace("\"","").split(",");

        String result = strs[0];
        for(int i = 1; i < strs.length ; i ++){
            int length1 = result.length();
            int length2 = strs[i].length();
            int j = 1;
            while(length1 -j >=0 && length2 - j >= 0 && result.charAt(length1 -j) == strs[i].charAt(length2 - j)){
                j++;
            }
            if(j==1){
                System.out.print("@Zero");
                return ;
            }
            result = result.substring(length1-j+1);
        }
        System.out.print(result);
        return;
    }

}
