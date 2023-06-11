package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * 数据分类
 */
public class Solution15 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        int[] nums = new int[12];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = in.nextInt();
        }
        int c = nums[0];
        int b = nums[1];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 2; i < nums.length; i++) {
            int r = intByteSum(nums[i]) % b;
            if (r < c) map.put(r, map.containsKey(r) ? map.get(r) + 1 : 1);
        }

        int max = 0;
        for (Integer value : map.values()) {
            if (value > max) max = value;
        }
        System.out.println(max);
    }

    public static int intByteSum(int x) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (byte) (x >> (i * 8));
        }
        return sum;
    }
}
