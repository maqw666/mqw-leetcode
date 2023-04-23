package array;

/**
 * 59. 螺旋矩阵 II -中等
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 输入：n = 1
 * 输出：[[1]]
 * 提示：
 * 1 <= n <= 20
 */
public class Solution59ok {
    public static void main(String[] args) {
        int[][] ints = generateMatrix(4);
        System.out.println(ints);
    }

    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int t =0,r = n -1,b = n -1,l =0;
        int num = 1,end = n*n;
        while(num <= end){
            for (int i = l; i <= r; i++) {
                res[t][i] = num++;
            }
            t++;
            for (int i = t; i <= b; i++) {
                res[i][r] = num++;
            }
            r--;
            for (int i = r; i >= l; i--) {
                res[b][i] = num++;
            }
            b--;
            for (int i = b; i >=t; i--) {
                res[i][l] = num++;
            }
            l++;
        }
        return res;
        
    }

}
