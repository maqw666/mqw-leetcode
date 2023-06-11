package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;

/**
 * 代表团坐车
 */
public class Solution25 {
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        Integer[] nums = Arrays.stream(in.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);

        int target = Integer.parseInt(in.nextLine());
        int n = nums.length;

        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= target; j++) {
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - num];
                }
            }
        }

        System.out.println(dp[n][target]);
        return;
    }
}


