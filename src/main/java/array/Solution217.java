package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 *给你一个整数数组 nums 。如果任一值在数组中出现 至少两次 ，返回 true ；如果数组中每个元素互不相同，返回 false 。
 */
public class Solution217 {
    public static void main(String[] args) {
        int[]  nums = {1,2,3,22,4,8};
        System.out.println(containsDuplicate(nums));
    }
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            //如果 Set 集合中不包含要添加的对象，则添加对象并返回 true，否则返回 false
            if(!sets.add(nums[i]))
                return true;
        }
        return false;
    }
}
