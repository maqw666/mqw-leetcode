package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 输入：nums = [1], target = 0
 * 输出：-1
 */
public class Solution33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 6;
        Map<Integer,Integer> maps = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            maps.put(nums[i],i);
        }
        Arrays.sort(nums);
        int result = search(nums, target);
        if(result != -1){
            System.out.println(maps.get(target));
        }else {
            System.out.println(result);
        }
    }
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int result = -1;
        while(low <= high){
            int mid = (low+high)/2;
            if(target == nums[mid]){
                result = mid;
                break;
            }else if(target>nums[mid]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return result;
    }

}
