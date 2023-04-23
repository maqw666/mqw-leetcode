package array;

public class Solution23 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate1(nums,3);
        System.out.println(nums);
    }

    /**
     * 时间复杂度： O(n)O(n)O(n)，其中 nnn 为数组的长度。
     * 空间复杂度： O(n)O(n)O(n)。
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        int[] arr = new int[len];
        for(int i=0;i<len;i++){
            arr[(k+i) % len] = nums[i];
        }
        System.arraycopy(arr,0,nums,0,len);
    }

    public static  void rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }
}
