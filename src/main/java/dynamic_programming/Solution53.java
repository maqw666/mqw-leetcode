package dynamic_programming;

import java.util.Arrays;
import java.util.Collections;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * 示例 1：
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 */
public class Solution53 {
    public static void main(String[] args) {
        Integer[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray1(arr);
        System.out.println(result);

    }

    /**
     * 当前值
     * 之前和
     * 当前和
     * 最大和
     * 贪心算法: 若当前指针所指元素之前的和小于0，则丢弃当前元素之前的数列
     * 时间复杂度：O(N),只遍历一次数组
     * 空间复杂度：O(1),只使用了常量空间
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int pre =0,maxAns = nums[0];
        for(int x:nums){
            //pre-当前和 当前指针所指元素之前的和小于0，则丢弃当前元素之前的数列
            pre = Math.max(pre+x,x);
            //取最大和
            maxAns = Math.max(maxAns,pre);
        }
        return maxAns;
    }

    /**
     *  动态规划：若前一个元素大于0，则将其加到当前元素上
     *  时间复杂度：O(N),只遍历一次数组
     *  空间复杂度：O(1),只使用了常量空间
     * @param nums
     * @return
     */
    public static int maxSubArray1(Integer[] nums){
        int n = nums.length;

        for (int i = 1; i < n; i++) {
           if(nums[i-1] >0){
               nums[i] += nums[i-1];
           }
        }
        return (int) Collections.max(Arrays.asList(nums));

    }

}
