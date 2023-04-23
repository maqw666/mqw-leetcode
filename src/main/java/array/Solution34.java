package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置 --中等
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * 输入：nums = [5,7,7,8,8,10], target = 8
 * 输出：[3,4]
 * 输入：nums = [5,7,7,8,8,10], target = 6
 * 输出：[-1,-1]
 * 输入：nums = [], target = 0
 * 输出：[-1,-1]
 * 提示：
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums 是一个非递减数组
 * -109 <= target <= 109
 * 1 8 8 8 8 9 10
 */
public class Solution34 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,3};
        int[] result = searchRange2(nums, 2);
        System.out.println(result);
    }

    /**
     * 个人
     *
     * @param nums
     * @param target 1,2   2
     * @return
     */
    public static int[] searchRange2(int[] nums, int target) {
        int[] result = {-1,-1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if(result[0] == -1){
                    result[0] = i;
                }
                result[1] = Math.max(result[1],i);
            }
        }
        return result;
    }

    /**
     * 个人
     *
     * @param nums
     * @param target 1,2   2
     * @return
     */
    public static int[] searchRange1(int[] nums, int target) {
        int[] result = new int[2];
        boolean flag = true;

        for (int i = 0; i < nums.length; i++) {

            if (nums.length == 1) {
                if (nums[i] == target) {
                    result[0] = i;
                    result[1] = i;
                } else {
                    result[0] = -1;
                    result[1] = -1;
                }
            } else {
                if (nums[i] == target) {
                    if (flag) {
                        result[0] = i;
                        flag = false;
                    } else {
                        result[1] = Math.max(result[1], i);
                    }
                }
            }


        }
        if (result[1] == 0 && result[0] != 0) {
            result[1] = result[0];
        }

        if ((nums == null || nums.length == 0) || (result[0] == 0 && result[1] == 0 && nums.length > 1 && flag)) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        return result;
    }


    public static int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        List<Integer> lists = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        int begin = 0;
        int end = nums.length - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (target == nums[mid]) {
                lists.add(mid);
                begin = mid + 1;
            } else if (target > nums[mid]) {
                begin = mid + 1;
            } else if (target < nums[mid]) {
                end = mid - 1;
            }
        }
        return result;
    }
}
