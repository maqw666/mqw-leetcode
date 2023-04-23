package string;

/**
 * 76. 最小覆盖子串-困难
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *注意：
 *
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 *提示：
 * 1 <= s.length, t.length <= 105
 * s 和 t 由英文字母组成
 */
public class Solution76 {
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
