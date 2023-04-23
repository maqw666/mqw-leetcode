package array;

import java.util.*;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器。
 输入：[1,8,6,2,5,4,8,3,7]
 输出：49
 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 输入：height = [1,1]
 输出：1
 输入：height = [4,3,2,1,4]
 输出：16
 输入：height = [1,2,1]
 输出：2
 n = height.length
 2 <= n <= 3 * 104
 0 <= height[i] <= 3 * 104
 */
public class Solution11 {
    public static void main(String[] args) {
        int[] arrs = {1,8,6,2,5,4,8,3,7};
        int result = maxAreaOffice(arrs);
        System.out.println(result);
    }
    public static int maxArea(int[] height) {
        Map<Integer,Integer> maps = new HashMap<Integer,Integer>();
        List<Integer> lists = new ArrayList<Integer>();
        String[] strs = new String[height.length];
        for (int i = 0; i < height.length; i++) {
            strs[i]=i+"-"+height[i];
        }
        for (int i = 0; i < strs.length - 1; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                int i0 = Integer.parseInt(strs[i].split("-")[0]);
                int i1 = Integer.parseInt(strs[i].split("-")[1]);
                int j0 = Integer.parseInt(strs[j].split("-")[0]);
                int j1 = Integer.parseInt(strs[j].split("-")[1]);
                int len = j0 - i0;
                int high = Math.min(i1,j1);
                lists.add(len*high);
            }
        }
        int max = (int) Collections.max(lists);
        return max;
    }
    //官方
    public static int maxAreaOffice(int[] height) {
        int l = 0,r = height.length-1;
        int ans  = 0;
        while(l < r){
            int area = Math.min(height[l],height[r])*(r - l);
            ans = Math.max(ans,area);
            if(height[l] <= height[r]){
               ++l;
            }else{
                --r;
            }
        }
        return ans;
    }
}
