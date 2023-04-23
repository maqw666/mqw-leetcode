package array;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 * 提示：
 * 1 <= target <= 109
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class Solution209 {
    public static void main(String[] args) {
        int[] nums = {1,4,4};
        int result = minSubArrayLen1(4, nums);
        System.out.println(result);
    }

    public static int minSubArrayLen1(int s, int[] nums) {
        int lo =0,hi=0,sum=0,min=Integer.MAX_VALUE;
        while(lo< nums.length){
            sum += nums[hi];
            hi++;
            while(sum >= s){
                min = Math.min(min,hi-lo);
                lo++;
            }
        }
        return min == Integer.MAX_VALUE ? 0:min;

    }

    /**
     * 使用双索引滑动
     * @param target
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = -1;
        int sum = 0;
        int res = nums.length + 1;
        while (l < nums.length){
            if(sum < target && (r+1)<nums.length){
                r++;
                sum += nums[r];
            }else{
                sum -= nums[l];
                l++;
            }
            if(sum >= target){
                res = Math.min(res,r-l+1);
            }
        }
        if(res == nums.length + 1){
            return 0;
        }
        return res;
    }
}
