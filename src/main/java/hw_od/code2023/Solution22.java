package hw_od.code2023;

/**
 * 阿里巴巴找黄金宝箱-I
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;

public class Solution22 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        String[] input_str = in.nextLine().split(",");
        int[] nums = Arrays.stream(input_str).mapToInt(Integer::parseInt).toArray();
        System.out.println(pivotIndex(nums));
        return;
    }

    public static int pivotIndex(int[] nums) {
        int total = Arrays.stream(nums).sum();
        int sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (2 * sum + nums[i] == total) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    // 并查集模板
    class UF {
        int[] item;
        int result;

        public UF(int n) {
            item = new int[n + 1];
            result = n;
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
                result--;
            }
        }
    }
}




