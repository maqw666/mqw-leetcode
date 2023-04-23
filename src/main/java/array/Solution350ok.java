package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 示例 2:
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 提示：
 *
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class Solution350ok {
    public static void main(String[] args) {
        int[] num1 = {1,2,1,4,9};
        int[] num2 = {1,2,1};
        intersect2(num1,num2);
    }
    // nums1 1,2,1,4,9    num2 1,2,1
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer,Integer> maps = new HashMap<Integer, Integer>();

        for(int num:nums1){
            int count = maps.getOrDefault(num, 0) + 1;
            maps.put(num,count);
        }
        int[] res = new int[nums1.length+nums2.length];
        int index = 0;
        for(int num:nums2){
            int count = maps.getOrDefault(num,0);
            if(count >0){
                count--;
                res[index++] = num;
                if(count>0){
                    maps.put(num,count);
                }else{
                    maps.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }

    public static int[] intersect2(int[] nums1, int[] nums2) {
        Map<Integer,Integer> maps = new HashMap<Integer, Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int index1 = 0,index2 = 0,index = 0;
        int[] res = new int[Math.min(nums1.length,nums2.length)];
        while(index1 < nums1.length && index2< nums2.length){
            if(nums1[index1] > nums2[index2]){
                index2++;
            }else if(nums1[index1] < nums2[index2]){
                index1++;
            }else{
                res[index]=nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
