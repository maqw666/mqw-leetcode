package array;

/**
 * 75. 颜色分类-中等
 给定一个包含红色、白色和蓝色，一共 n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 此题中，我们使用整数 0、 1 和 2 分别表示红色、白色和蓝色。
 输入：nums = [2,0,2,1,1,0]
 输出：[0,0,1,1,2,2]
 输入：nums = [2,0,1]
 输出：[0,1,2]
 输入：nums = [0]
 输出：[0]
 输入：nums = [1]
 输出：[1]
 提示：
 n == nums.length
 1 <= n <= 300
 nums[i] 为 0、1 或 2
 */
public class Solution75return {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
    }
    public static void sortColors(int[] nums) {
        int low = 0,high = nums.length - 1;
        quickSort(nums,0,high);
    }

    /**
     * 单指针
     * @param nums
     */
    public static void sortColors1(int[] nums) {
        int high = nums.length - 1;
        int prt = 0;
        //第一次遍历，把所有的0放到最左边
        for (int i = 0; i < high; i++) {
            if(nums[i] ==0){
                int temp = nums[i];
                nums[i] = nums[prt];
                nums[prt] = temp;
                prt++;
            }
        }
        for (int i = prt; i <high ; i++) {
            if(nums[i] ==1){
                int temp = nums[i];
                nums[i] = nums[prt];
                nums[prt] = temp;
                prt++;
            }
        }

    }

    /**
     * 双指针  没看懂--
     * @param nums
     */
    public static void sortColors2(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }



    /**
     * 快速排序 ，太重了--此实现方式
     * @param nums
     * @param low
     * @param high
     */
    public static void quickSort(int[] nums,int low,int high){
        int i,j,pivot;
        //结束条件
        if(low >= high){
            return;
        }
        i = low;
        j = high;
//选择的节点，这里选择的数组的第一个数作为节点
        pivot = nums[low];
        while(i < j){
            //从右往左找比节点小的数，循环结束要么找到了，要么i=j
            while(nums[j]>pivot && i<j){
                j--;
            }
            //从左往右找比节点大的数，循环结束要么找到了，要么i=j
            while(nums[i]<= pivot && i<j){
                i++;
            }
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        //i==j 一轮循环结束，交换节点的数和相遇点的数
        nums[low] = nums[i];
        nums[i] = pivot;
        quickSort(nums,low,i-1);
        quickSort(nums,i+1,high);
    }
}
