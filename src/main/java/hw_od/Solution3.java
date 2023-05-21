package hw_od;

import java.util.*;

/**
 * 题目描述 :酒店预订
 *
 * 放暑假了，小明决定到某旅游景点游玩，他在网上搜索到了各种价位的酒店（长度为n的数组A），他的心理价位是x元，请帮他筛选出k个最接近x元的酒店（n>=k>0）,并由低到高打印酒店的价格。
 * 输入描述
 *
 * 第一行：n, k, x
 * 第二行：A[0] A[1] A[2]…A[n-1]
 * 9,4,7
 * 1 2 5 10 7 8 9 13 16
 * 输出描述
 *
 * 从低到高打印筛选出的酒店价格
 *
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        int count = Integer.parseInt(line1.split(" ")[1]);
        int likePrice = Integer.parseInt(line1.split(" ")[2]);

        String line2 = sc.nextLine();
        String[] arr = line2.split(" ");
        Map<Integer,Integer> maps = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.length; i++) {
            int price = Integer.parseInt(arr[i]);
            int value = Math.abs(likePrice-price);
            maps.put(value,price);
        }
        Set<Map.Entry<Integer, Integer>> entries = maps.entrySet();
        List<Map.Entry<Integer,Integer>> list = new ArrayList<>(maps.entrySet());
        list.sort((a,b)->{
            int key1 = a.getKey();
            int key2 = b.getKey();
            if(key1 !=key2) {
                return key1 - key2;
            }else{
                return a.getValue() - b.getValue();
            }
        });

        StringBuilder sb = new StringBuilder();
        int index =0;
        for(Map.Entry<Integer,Integer> entry:list){
            index++;
            sb.append(entry.getValue()).append(" ");
            if(index ==count){
                System.out.println(sb.deleteCharAt(sb.length()-1));
                return;
            }
        }
    }
}
