package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 35. 搜索插入位置 -简单
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * 示例 1:
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为 无重复元素 的 升序 排列数组
 * -104 <= target <= 104
 */
public class Solution35ok {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        searchInsert(nums,4);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0,right = nums.length-1;
        while(left<=right ){
            int mid = (right - left)/2 + left;
            if(target>nums[mid]){
                left = mid +1;
            }else if(target<nums[mid]){
                right = mid -1;
            }else{
                return mid;
            }
        }
        return left;
    }

    /**
     * 此方法不太行，有些实例通不过。
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert1(int[] nums, int target) {
        int left =0;
        int right = nums.length;
        while(left<right){
            int mid= (right-left)/2 + left;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return left+1;
    }

}
