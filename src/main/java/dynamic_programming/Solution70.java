package dynamic_programming;

/**
 * 70.爬楼梯
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 解释：有两种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶
 * 2. 2 阶
 * 示例 2：
 *
 * 输入：n = 3
 * 输出：3
 * 解释：有三种方法可以爬到楼顶。
 * 1. 1 阶 + 1 阶 + 1 阶
 * 2. 1 阶 + 2 阶
 * 3. 2 阶 + 1 阶
 * 提示：
 * 1 <= n <= 45
 */
public class Solution70 {
    public static void main(String[] args) {
        int res = climbStairs(10);
        System.out.println(res);
    }

    /**
     标签：动态规划
     本问题其实常规解法可以分成多个子问题，爬第n阶楼梯的方法数量，等于 2 部分之和
     1. 爬上 n−1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
     2.爬上 n−2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
     所以我们得到公式 dp[n]=dp[n−1]+dp[n−2]
     同时需要初始化dp[0] = 1和dp[1] = 1
     * 时间复杂度O(n)
     * @param n
     * @return
     */
    public static  int climbStairs(int n) {
        if(n==1){
            return 1;
        }
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
