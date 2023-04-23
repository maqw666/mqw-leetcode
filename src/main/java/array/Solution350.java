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
 * 1 <= nums1.length, nums2.length <= 1000
 * 0 <= nums1[i], nums2[i] <= 1000
 */
public class Solution350 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,2,1};
        int[] nums2 = {2,2};
        intersect(nums1,nums2);
    }

    /**
     * 哈希方法
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] res;
        if(nums1.length > nums2.length){
            res = new int[nums1.length];
        }else{
            res = new int[nums2.length];
        }
        Map<Integer,Integer> maps = new HashMap<Integer, Integer>();
        //先对nums1进行遍历，求出每个数 及其 在集合中的个数
        for (int num:nums1){
            int count = maps.getOrDefault(num,0) + 1;
            maps.put(num,count);
        }
        int index = 0;
        for(int num:nums2){
            int count = maps.getOrDefault(num,0);
            if(count >0){
                res[index++] = num;
                count--;
                if(count>0) {
                    maps.put(num, count);
                }/*else{
                    maps.remove(num);
                }*/
            }
        }
        return Arrays.copyOfRange(res,0,index);
    }
}
