package array;

import java.util.Arrays;

/**
 * 88.合并两个有序数组-简单
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 *
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 *
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 * 解释：需要合并 [1,2,3] 和 [2,5,6] 。
 * 合并结果是 [1,2,2,3,5,6] ，其中斜体加粗标注的为 nums1 中的元素。
 * 示例 2：
 * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
 * 输出：[1]
 * 解释：需要合并 [1] 和 [] 。
 * 合并结果是 [1] 。
 * 示例 3：
 * 输入：nums1 = [0], m = 0, nums2 = [1], n = 1
 * 输出：[1]
 * 解释：需要合并的数组是 [] 和 [1] 。
 * 合并结果是 [1] 。
 * 注意，因为 m = 0 ，所以 nums1 中没有元素。nums1 中仅存的 0 仅仅是为了确保合并结果可以顺利存放到 nums1 中。
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 */
public class Solution88ok {
    public static void main(String[] args) {
        int[] nums1={1,2,3};
        int[] nums2={2,3,4};
        int[] merge = merge1(nums1, 3, nums2, 3);
        System.out.println(merge);
    }
    //自己答案
    public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m+n];
        int i = 0,j = 0,index =0;
        while (i< m || j < n){
            if(i == m && index <(m+n)){
                res[index++] = nums2[j++];
            } else if(j==n && index <(m+n)){
                res[index++] = nums1[i++];
            } else if(nums1[i] <nums2[j]){
                res[index++] = nums1[i];
                i++;
            }else if(nums1[i] >nums2[j]){
                res[index++] = nums2[j];
                j++;
            }else{
                res[index++]=nums1[i];
                res[index++]=nums2[j];
                i++;
                j++;
            }
        }
        return res;
    }
    //官方答案1
    public static int[] merge1(int[] nums1, int m, int[] nums2, int n) {
        int p1 =0,p2=0;
        int cur=0;
        int[] sorted = new int[m+n];
        while(p1 < m || p2 < n){
            if(p1==m){
                cur = nums2[p2++];
            }else if(p2==n){
                cur = nums1[p1++];
            }else if(nums1[p1] <nums2[p2]){
                cur = nums1[p1++];
            }else{
                cur = nums2[p2++];
            }
            sorted[p1+p2-1] = cur;
        }
        for(int i=0;i <m+n;i++){
            nums1[i] = sorted[i];
        }
        return nums1;
    }

    //官方答案2
    public  void merge2(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i < n;++i){
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
    }

}