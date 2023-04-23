package array;

/**
 * 77. 组合-中等
 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 你可以按 任何顺序 返回答案。
 输入：n = 4, k = 2
 输出：
 [
 [2,4],
 [3,4],
 [2,3],
 [1,2],
 [1,3],
 [1,4],
 ]
 输入：n = 1, k = 1
 输出：[[1]]
 提示：
 1 <= n <= 20
 1 <= k <= n
 */
public class Solution77 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        int result = minPathSum(grid);
        System.out.println(result);
    }
    public static int minPathSum(int[][] grid){
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0){
                    continue;
                }else if(i==0){
                    grid[i][j] = grid[i][j-1] + grid[i][j];
                }else if(j == 0){
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                }else{
                    grid[i][j] = Math.min(grid[i-1][j],grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
