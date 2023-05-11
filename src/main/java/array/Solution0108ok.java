package array;

/**
 *面试题 01.08. 零矩阵 --中等
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 *
 */
public class Solution0108ok {
    public static void main(String[] args) {
        int[][] intervals = {{1,1,1},{1,0,1},{1,1,1}};
        setZeroes(intervals);
    }

    public static void setZeroes(int[][] matrix) {
        int len = matrix.length;
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j < len; j++) {
                if(matrix[i][j] ==0){
                    setZeroesH(matrix,i);
                    setZeroesL(matrix,j);
                }
            }
        }
    }

    public static void setZeroesH(int[][] matrix,int i) {
        for (int j = 0; j < matrix.length; j++) {
            matrix[i][j] = 0;
        }
    }

    public static void setZeroesL(int[][] matrix,int j) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }

    /**
     * 使用两个标记数组
     * @param matrix
     */
    public static void setZeroes1(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] ==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i <m ; i++) {
            for (int j = 0; j < n; j++) {
                if(row[i] || col[j]){
                    matrix[i][j] =0;
                }
            }
        }

    }


    /**
     * 使用两个标记变量
     * @param matrix
     */
    public static void setZeroes2(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag_row0 = false,flag_col0= false;


    }

}
