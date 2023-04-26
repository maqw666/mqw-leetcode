package array;

/**
 * 26. 删除有序数组中的重复项
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 为什么返回数值是整数，但输出的答案是数组呢?
 * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
 * 输入：nums = [1,1,2]
 * 输出：2, nums = [1,2]
 * 解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。
 * 输入：nums = [0,0,1,1,1,2,2,3,3,4]
 * 输出：5, nums = [0,1,2,3,4]
 * 解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。
 * 提示：
 * 0 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 */
public class Solution26ok {
    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,};
        int result = removeDuplicates1(nums);
        System.out.println(result);
    }

    /**
     * 双指针
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        if(nums ==null || nums.length ==0){
            return 0;
        }
       int p = 0;
       int q = 1;
       while(q <nums.length){
           if(nums[p] !=nums[q]){
               nums[p+1] = nums[q];
               p++;
               q++;
           }
           q++;
       }
       return p+1;
    }

    public int remove(int[] nums){
        //nums = [0,0,1,1,1,2,2,3,3,4]
        if(nums ==null || nums.length ==0){
            return 0;
        }

        int len = nums.length;

        int j = 0,i=1;
        while(j<i && i<len){
            if(nums[i] !=nums[j]){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }else{
                i++;
                j++;
            }
        }
        return j;
    }

}
