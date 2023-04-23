package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums，请编写一个能够返回数组 “中心下标” 的方法。
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * 如果数组不存在中心下标，返回 -1 。如果数组有多个中心下标，应该返回最靠近左边的那一个。
 * 注意：中心下标可能出现在数组的两端。
 * 复杂度分析
 * 时间复杂度：O(n)O(n)，其中 nn 为数组的长度。
 *
 * 空间复杂度：O(1)O(1)。
 */
public class Solution35 {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        long time1 = System.currentTimeMillis();
        int target = 5;
        int result = pivotIndexOfficial(nums,target);
        System.out.println(result);
        long time2 = System.currentTimeMillis();
        System.out.println("运行毫秒数："+(time2-time1));
    }
    public static int pivotIndex(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0;i < nums.length;i++){
            int leftSumValue = LeftSum(nums,i);
            int rightSumValue = RightSum(nums,i);
            if(leftSumValue == rightSumValue){
                list.add(i);
            }
        }
        return list.get(0);
    }

    private static int LeftSum(int[] nums,int i){
        int leftSumValue = 0;
        for(int j = 0;j < i;j++){
            leftSumValue = leftSumValue + nums[j];
        }
        return leftSumValue;
    }
    private static int RightSum(int[] nums,int i){
        int rightSumValue = 0;
        for(int j = i + 1;j < nums.length;j++){
            rightSumValue = rightSumValue + nums[j];
        }
        return rightSumValue;
    }
  //暴力解决
  public static int pivotIndex(int[] nums,int target) {
      int sum = 0;
      for (int i = 0; i < nums.length; ++i) {
          if(nums[i] >= target) {
              return i;
          }
      }
      return nums.length;
  }

    //官方结题
    public static int pivotIndexOfficial(int[] arr,int target) {
        int low = 0; // 开始位置
        int high = arr.length - 1; // 结束 位置
        while(low <= high) {
            int middle = (low + high) / 2;
            if (target == arr[middle]) {
                return middle; //返回查询到的索引位置
            }else if (target > arr[middle]) {
                low = middle + 1;
            }else {
                high = middle - 1;
            }
        }
        //上面循环完毕，说明未找到，返回-1
        return -1;
    }


    public static int AA(int[] arr,int target){
        int left =0;
        int right = arr.length -1;
        while (left<=right){
            int middle = (left + right) / 2;
            if(arr[middle] == target){
                return middle;
            }else if(arr[middle]>target){
                right = middle -1;
            }else{
                left = middle +1;
            }
        }
        return  -1;
    }
}
