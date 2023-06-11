package array;

/**
 * 打家劫舍2
 */
public class Solution213 {
    public static void main(String[] args) {
        int[] nums = {2,3,2,5,3};
        int result = rob(nums);
        System.out.println(result);
    }

    public static int rob(int[] nums) {
        int len = nums.length;
        if(len ==1){
            return nums[0];
        }else if(len ==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(robRange(nums,0,len-2),robRange(nums,1,len-1));
    }
    public static int robRange(int[] nums,int start,int end){
        int first = nums[start],second = Math.max(nums[start],nums[start+1]);
        for(int i=start + 2;i <=end;i++){
            int temp =second;
            second = Math.max(first+nums[i],second);
            first = temp;
        }
        return second;
    }

}
