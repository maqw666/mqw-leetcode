package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 724. 寻找数组的中心下标--简单
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 * 注意：中心下标可能出现在数组的两端。
 * 复杂度分析
 * 时间复杂度：O(n)O(n)，其中 nn 为数组的长度。
 * 空间复杂度：O(1)O(1)
 * 输入：nums = [1, 7, 3, 6, 5, 6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * 示例 2：
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * 示例 3：
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 * 提示：
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 */
public class Solution724ok {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        long time1 = System.currentTimeMillis();
        int result = pivotIndex(nums);
        System.out.println(result);
        long time2 = System.currentTimeMillis();
        System.out.println("运行毫秒数："+(time2-time1));
    }
    public static int pivotIndex(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i < nums.length;i++){
            int leftSumValue = LeftSum(nums,i);
            int rightSumValue = RightSum(nums,i);
            if(leftSumValue == rightSumValue){
                list.add(i);
            }
        }
        return list.size() ==0?-1:list.get(0);
    }

    private static int LeftSum(int[] nums,int i){
        int leftSumValue = 0;
        for(int j = 0;j < i;j++){
            leftSumValue = leftSumValue + nums[j];
        }
        return leftSumValue;
    }
    private static int RightSum(int[] nums,int i){
        int rightSumValue = 0;
        for(int j = i + 1;j < nums.length;j++){
            rightSumValue = rightSumValue + nums[j];
        }
        return rightSumValue;
    }
  //官方结题
  public static int pivotIndexOfficial(int[] nums) {
      int total = Arrays.stream(nums).sum();
      int sum = 0;
      for (int i = 0; i < nums.length; ++i) {
          if (2 * sum + nums[i] == total) {
              return i;
          }
          sum += nums[i];
      }
      return -1;
  }
}
