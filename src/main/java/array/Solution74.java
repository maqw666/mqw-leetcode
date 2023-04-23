package array;

/**
 * 74. 搜索二维矩阵-中等
 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：

 每行中的整数从左到右按升序排列。
 每行的第一个整数大于前一行的最后一个整数。
 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 输出：true
 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 输出：false
 提示：

 m == matrix.length
 n == matrix[i].length
 1 <= m, n <= 100
 -104 <= matrix[i][j], target <= 104
 */
public class Solution74 {
    public static void main(String[] args) {
        int[][] grid = {{1,3,5,7,8},{10,11,16,20,21},{23,30,34,60,72}};

        int result = binarySearchFirstColumn(grid, 11);
        System.out.println(result);
        boolean boolResult = binarySearchRow(grid[result], 11);
        System.out.println(boolResult);
        /*int result = minPathSum(grid);
        System.out.println(result);*/
    }
    private static int binarySearchFirstColumn(int[][] arr,int target){
        int begin = -1,end = arr.length - 1;
        while (begin < end){
            int mid = (begin + end) / 2;
            if(arr[mid][0] <= target){
                begin = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return begin;
    }

    private static boolean binarySearchRow(int[] arr,int target){
        int begin = 0,end = arr.length;
        while (begin < end){
            int mid = (begin + end) / 2;
            if(arr[mid] == target){
                return true;
            }else if(arr[mid] < target){
                begin = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return false;
    }

    /*public static boolean minPathSum(int[][] matrix, int target) {
        grid
        return false;
    }*/
}
