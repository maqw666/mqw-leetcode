package array;

/**
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 * 注意：中心下标可能出现在数组的两端。
 * 复杂度分析
 * 时间复杂度：O(n)O(n)，其中 nn 为数组的长度。
 *
 * 空间复杂度：O(1)O(1)。
 */
public class Solution14a {
    public static void main(String[] args) {
        int[][] nums ={{1,2,3},{4,5,6},{7,8,9}};
        long time1 = System.currentTimeMillis();
        int[][] result = rotate(nums);
        System.out.println(result);
        long time2 = System.currentTimeMillis();
        System.out.println("运行毫秒数："+(time2-time1));
    }

    public static int[][] rotate(int[][] matrix) {
        int n = matrix.length;
        int[][] resultArrs = new int[n][];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                resultArrs[i][j] = matrix[n-j-1][i];
            }
        }
        return resultArrs;
    }

}
