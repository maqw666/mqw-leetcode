package hw_od.code2023;


import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 阿里巴巴找黄金宝箱(III)
 */
public class Solution13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int n = in.nextInt();
        boolean flag = false;
        HashMap<Integer, Integer> num_count = new HashMap<>();

        for (int i=0;i<nums.length;i++) {
            if (num_count.containsKey(nums[i])) {
                if (i-num_count.get(nums[i]) <= n){
                    System.out.println(num_count.get(nums[i]));
                    return;
                } else {
                    num_count.put(nums[i], i);
                }
            }else {
                num_count.put(nums[i], i);
            }
        }

        System.out.println(-1);
        return;
    }
}
