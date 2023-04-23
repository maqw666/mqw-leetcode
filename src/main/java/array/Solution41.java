package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 41. 缺失的第一个正数-困难
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 * 输入：nums = [1,2,0]   0 1 2
 * 输出：3
 * 输入：nums = [3,4,-1,1]    -1 1 3  4
 * 输出：2
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *  * 输入：nums = [0,2,2,1,1]
 *  * 输出：3
 * 提示：
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 */
public class Solution41 {
    public static void main(String[] args) {
        int[] arrs = {0,2,2,1,1};   //0 1 1 2 2
        int result = firstMissingPositive3(arrs);
        System.out.println(result);
    }
    public static int firstMissingPositive(int[] nums) {
        int result = 1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] > 0){
                if(nums[i] == result){
                    result++;
                }else if(nums[i]>result){
                   break;
                }
            }
        }
        return result;
    }

    /**
     * 复杂度分析：
     * 时间复杂度：O(N)O(N)，这里 NN 表示数组的长度。第 1 次遍历了数组，第 2 次遍历了区间 [1, len] 里的元素。
     * 空间复杂度：O(N)O(N)，把 NN 个数存在哈希表里面，使用了 NN 个空间。
     * @param nums
     * @return
     */
    public int firstMissingPositive1(int[] nums) {
        int len = nums.length;
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            hashSet.add(num);
        }
        for (int i = 1; i <= len ; i++) {
            if (!hashSet.contains(i)){
                return i;
            }
        }
        return len + 1;
    }

    /**
     复杂度分析：
     时间复杂度：O(N \log N)O(NlogN)，这里 NN 表示数组的长度。时间复杂度主要消耗在排序上，排序使用 O(N\log N)O(NlogN)。二分查找使用每一步使用的时间复杂度是 O(\log N)O(logN)，整体上仍然是 O(N \log N)O(NlogN)；
     空间复杂度：O(1)O(1)。
     */
    public static int firstMissingPositive3(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        for (int i = 1; i <= len; i++) {
            int res = binarySearch(nums, i);
            if (res == -1) {
                return i;
            }
        }
        return len + 1;
    }

    private static int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
//            int mid = (left + right) >>> 1;
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
