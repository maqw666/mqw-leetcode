package array;

/**
 * 498. 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 *
 */
public class Solutioin498 {
    public static void main(String[] args) {

    }

    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int pos = 0;
        for (int i = 0; i < m+n-1; i++) {
            if(i % 2==1){
                int x = i<n ? 0: i-n+1;
                int y = i<n ? i:n-1;
                while(x<m && y>=0){
                    res[pos] = mat[x][y];
                    pos++;
                    x++;
                    y--;
                }
            }else{
                int x = i<m ? i:m-1;
                int y = i<m ? 0:i-m+1;
                while(y<n && x>=0){
                    res[pos] = mat[x][y];
                    pos++;
                    x--;
                    y++;
                }
            }
        }
        return res;
    }
}
