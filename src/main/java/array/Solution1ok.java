package array;

import java.util.HashMap;
import java.util.Map;

/**
 1.两数之和
 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 输入：nums = [2,7,11,15], target = 9
 输出：[0,1]
 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 输入：nums = [3,2,4], target = 6
 输出：[1,2]
 输入：nums = [3,3], target = 6
 输出：[0,1]
 提示：
 2 <= nums.length <= 104
 -109 <= nums[i] <= 109
 -109 <= target <= 109
 只会存在一个有效答案fa
 */
public class Solution1ok {
    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15,12,17};
        int[] result = twoSum(arr, 9);
        System.out.println(result);
    }

  private  static  int[] twoSum(int[] arr,int target){
      Map<Integer,Integer> maps = new HashMap<>();
      for(int i =0;i< arr.length;i++){
            if(maps.containsKey(target - arr[i])){
                return new int[]{i,maps.get(target-arr[i])};
            }
          maps.put(arr[i],i);
      }
      return new int[0];
  }
}
