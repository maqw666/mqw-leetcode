package array;

/**
 * 215. 数组中的第K个最大元素 -中等
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 *
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 *
 * 你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [3,2,1,5,6,4], k = 2
 * 输出: 5
 * 示例 2:
 *
 * 输入: [3,2,3,1,2,4,5,5,6], k = 4
 * 输出: 4
 *  
 *
 * 提示：
 *
 * 1 <= k <= nums.length <= 105
 * -104 <= nums[i] <= 104

 */
public class Solution215ok {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int result = findKthLargest(nums, 4);
        System.out.println(result);
    }

    public static int findKthLargest(int[] nums, int k) {
        int low = 0,high = nums.length - 1;
        quickSort(nums,low,high);
        return nums[high+1-k];
    }

    public static void quickSort(int[] nums, int low,int high){
        int i,j,pivot;
        while(low >= high){
            return;
        }
        i = low;
        j = high;
        pivot = nums[low];
        while(i<j){
            while (nums[j] >=pivot && i<j){
                j--;
            }
            while (nums[i] <=pivot && i<j){
                i++;
            }
            if(i<j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[low] = nums[i];
        nums[i] = pivot;
        quickSort(nums,low,i-1);
        quickSort(nums,i+1,high);
    }
}
