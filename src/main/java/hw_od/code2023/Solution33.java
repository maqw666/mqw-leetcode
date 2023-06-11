package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;

/**
 * 报文重排序
 */
public class Solution33 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.nextLine();
        String[] input_strs = in.nextLine().split(" ");

        Map<Integer, String> order_map = new HashMap<>();
        for(int i=0; i<input_strs.length; i++){
            String str = input_strs[i];
            int number_pos = 0;
            for(int j=0; j<str.length(); j++){
                if(Character.isDigit(str.charAt(j))){
                    number_pos = j;
                    break;
                }
            }
            order_map.put(Integer.parseInt(str.substring(number_pos)), str.substring(0, number_pos));
        }

        String output_str = "";
        for(int i=1; i<=N; i++){
            output_str += order_map.get(i);
            if (i!=N){
                output_str += " ";
            }
        }

        System.out.println(output_str);
        return;
    }
    // 并查集模板
    class UF {
        int[] item;
        int output_strult;

        public UF(int n) {
            item = new int[n + 1];
            output_strult = n;
            for (int i = 0; i < n; i++) item[i] = i;
        }

        public int find(int x) {
            if (x != item[x]) {
                return (item[x] = find(item[x]));
            }
            return x;
        }

        public void union_connect(int x, int y) {
            int x_item = find(x);
            int y_item = find(y);

            if (x_item != y_item) {
                item[y_item] = x_item;
                output_strult--;
            }
        }
    }
}




