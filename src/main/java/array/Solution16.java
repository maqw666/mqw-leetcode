package array;

import java.util.*;

/**
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 *
 * 返回这三个数的和。
 *
 * 假定每组输入只存在恰好一个解。
 *
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * 提示：
 *
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class Solution16 {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int result = threeSumClosest(nums, 1);
        System.out.println(result);
    }

    public static int threeSumClosest(int[] nums, int target) {
        List<Integer> targetList = new ArrayList<Integer>();
        Map<Integer,Integer> maps = new HashMap<Integer,Integer>();
        for (int i = 0; i < nums.length -2; i++) {
            for (int j = i+1; j < nums.length -1 ; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    int t = nums[i] + nums[j] +nums[k] - target;
                    int res = Math.abs(t);
                    maps.put(res,(t+target));
                    targetList.add(res);
                }
            }
        }
        Integer min = Collections.min(targetList);
        Integer result = maps.get(min);

        return result;
    }
}
