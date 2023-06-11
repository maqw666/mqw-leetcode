package hw_od.code2023;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 跳格子2
 */
public class Solution8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] nums = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int res = output(nums);
        System.out.println(res);
    }
    public static int output(int[] nums){
        int len = nums.length;
        if(len ==1){
            return nums[0];
        }else if(len ==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(getMaxScore(nums,0,len-1),getMaxScore(nums,1,len-1));
    }

    public static int getMaxScore(int[] nums,int start,int end){
        int one = nums[start],two = Math.max(nums[start],nums[start+1]);
        for(int i=start + 2;i <=end;i++){
            int temp =two;
            two = Math.max(one+nums[i],two);
            one = temp;
        }
        return two;
    }
}
