package array;

/**
 * 60. 62. 不同路径 -中等
 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 问总共有多少条不同的路径？
 输入：m = 3, n = 7
 输出：28
 输入：m = 3, n = 2
 输出：3
 解释：
 从左上角开始，总共有 3 条路径可以到达右下角。
 1. 向右 -> 向下 -> 向下
 2. 向下 -> 向下 -> 向右
 3. 向下 -> 向右 -> 向下
 输入：m = 7, n = 3
 输出：28
 输入：m = 3, n = 3
 输出：6
 提示：
 1 <= m, n <= 100
 题目数据保证答案小于等于 2 * 109
 */
public class Solution62ok {
    public static void main(String[] args) {
        int result = uniquePaths2(3, 7);
        System.out.println(result);
    }
    public static int uniquePaths(int m, int n) {
        int[][] f = new int[m][n];
        for (int i = 0; i < m; ++i) {
            f[i][0] = 1;
        }
        for (int j = 0; j < n; ++j) {
            f[0][j] = 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                f[i][j] = f[i - 1][j] + f[i][j - 1];
            }
        }
        return f[m - 1][n - 1];
    }

    public static int uniquePaths1(int m,int n){
        long ans = 1;
        for(int x=n,y =1;y < m;++x,++y){
            ans = ans * x / y;
        }
        return (int) ans;
    }

    public static int uniquePaths2(int m,int n){
        long ans = 1;
        int x = fi(m-1);
        int y = fi(n-1);
        int z = fi(m+n-2);
        return z/(x*y);
    }
    public static int fi(int n){
       if(n==0){
           return 1;
       }
        return n * fi(n-1);
    }
}
