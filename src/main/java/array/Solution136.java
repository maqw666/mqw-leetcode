package array;

import java.util.Arrays;

/**
 * 136.只出现一次的数字
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 *
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 * 示例 1 ：
 * 输入：nums = [2,2,1]
 * 输出：1
 * 示例 2 ：
 * 输入：nums = [4,1,2,1,2]
 * 输出：4
 * 示例 3 ：
 * 输入：nums = [1]
 * 输出：1
 *
 * 1 1 2 3 3 4 4 5 5 6 6
 * 1 2 2 3 3 4 4
 * 1 1 2 2 3
 */
public class Solution136 {
    public static void main(String[] args) {
        int[] nums = {2,3,2,1,1};
        int[] nums1 = {1,2,3,2,3};
        int[] num2 ={2,1,2,1,3,4,4};
        System.out.println(singleNumber(num2));
    }

    public static int singleNumber(int[] nums) {
        Arrays.sort(nums);
        int sValue = nums[0];
        int eValue = nums[nums.length-1];
        for (int i = 1; i < nums.length-1; i++) {
            if(nums[i] != nums[i-1] && nums[i] != nums[i+1]){
                return nums[i];
            }
            if(nums[i] != nums[i-1] && nums[i-1] == sValue){
                return sValue;
            }
            if(nums[i] != nums[i+1] && nums[i] == eValue){
                return eValue;
            }
        }
        return -1;
    }

    public static int singleNumber1(int[] nums) {
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            single ^= nums[i];
        }
        return single;
    }
}
