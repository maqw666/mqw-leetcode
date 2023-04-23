package array;

/**
 * 31.下一个排列
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 输入：nums = [1]
 * 输出：[1]
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * 思路：标准的“下一个排列”算法可以描述为：
 *
 * 从后向前查找第一个相邻升序的元素对 (i,j)，满足 A[i] < A[j]。此时 [j,end) 必然是降序
 * 在 [j,end) 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i]、A[k] 分别就是上文所说的「小数」、「大数」
 * 将 A[i] 与 A[k] 交换
 * 可以断定这时 [j,end) 必然是降序，逆置 [j,end)，使其升序
 * 如果在步骤 1 找不到符合的相邻元素对，说明当前 [begin,end) 为一个降序顺序，则直接跳到步骤 4
 *
 比如 nums = [1,2,7,4,3,1]，下一个排列是什么？
 我们找到第一个最大索引是 nums[1] = 2
 再找到第二个最大索引是 nums[4] = 3
 交换，nums = [1,3,7,4,2,1];  134721
 翻转，nums = [1,3,1,2,4,7]    1274
 [1,2,7,4,2,3,1]
 [1,2,7,4,3,2,1]
 [1,2,7,4,3,1,2]
 */
public class Solution31 {
    public static void main(String[] args) {
        int[] nums = {1,2,7,4,3,1};
        nextPermutation(nums);
        System.out.println(nums);
    }

    public static void nextPermutation(int[] nums){
        if(nums == null || nums.length == 0) {
            return;
        }
        int firstIndex = -1;
        for (int i = nums.length - 2; i >=0 ; i--) {
            if(nums[i] < nums[i+1]){
                firstIndex = i;
                break;
            }
        }
        //找不到说明是倒序排列
        if(firstIndex == -1){
            reverse(nums,0,nums.length-1);
            return;
        }
        int secondIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if(nums[i]>nums[firstIndex]){
                secondIndex = i;
                break;
            }
        }
        swap(nums,firstIndex,secondIndex);
        reverse(nums,firstIndex+1,nums.length-1);
        return;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i<j){
            swap(nums,i++,j--);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
