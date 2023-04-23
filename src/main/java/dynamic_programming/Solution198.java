package dynamic_programming;

/**
 * 198.打家劫舍 -中等
 *  你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 *     给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * 输入：[1,2,3,1]
 *输出：4
  *   解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
  *        偷窃到的最高金额 = 1 + 3 = 4 。
  *   输入：[2,7,9,3,1]
  *   输出：12
  *   解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
  *        偷窃到的最高金额 = 2 + 9 + 1 = 12 。
  *   提示：
  *
  *   1 <= nums.length <= 100
  *   0 <= nums[i] <= 400
 */
public class Solution198 {
    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1,9};
        System.out.println(rob(nums));
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public static int rob(int[] nums) {
        if(nums.length ==0 || nums==null){
            return 0;
        }
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        int[] dept = new int[len];
        dept[0] = nums[0];
        dept[1] = Math.max(nums[0],nums[1]);
        for(int i = 2;i<len;i++){
            dept[i] = Math.max(dept[i-2] + nums[i],dept[i-1]);
        }
        return dept[len -1];
    }

}
