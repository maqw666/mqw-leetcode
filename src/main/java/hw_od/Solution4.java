package hw_od;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 箱子之字型摆放
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input_str = in.nextLine();
        String[] split = input_str.split(" ");
        String str = split[0];
        int n = Integer.parseInt(split[1]);

        //将n行格子看作是n个数组
        List<List<Character>> lists = new ArrayList<>();
        for(int i = 0;i<n;i++){
            lists.add(new ArrayList<>());
        }
        int index =0;
        //控制下一个字符归属到哪个数组
        boolean flag = true;
        char[] chars = str.toCharArray();
        for(char c:chars){
            if(index==-1){
                index =0;
                flag = true;
            }
            if(index ==n){
                index = n-1;
                flag = false;
            }
            lists.get(index).add(c);
            if(flag){
                index++;
            }else{
                index--;
            }
        }
        for(List<Character> list:lists){
            for(Character c:list){
                System.out.println(c);
            }
            System.out.println();
        }
    }

}
