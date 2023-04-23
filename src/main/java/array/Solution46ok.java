package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 46-全排列-中等
 * 给定一个不含重复数字的数组 nums ，返回其所有可能的全排列 。你可以 按任意顺序 返回答案。
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 输入：nums = [1]
 * 输出：[[1]]
 * 提示：
 *
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class Solution46ok {

    public static void main(String[] args) {
        int[] nums = {2,1,3,4};
        List<List<Integer>> result = permute(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        //使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums,len,0,path,used,res);
        return res;
    }

    private static void dfs(int[] nums,int len,int depth,List<Integer> path,boolean[] used,List<List<Integer>> res){
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        //在非叶子节点处，产生不同的分支，这易操作的语义是，在还未选择的数中一次选择一个元素作为下一个位置
        //这显然得通过一个循环实现
        for(int i =0;i < len;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(nums,len,depth+1,path,used,res);
                //注意：下面这两行代码发生回溯，回溯发生在从深层节点回到浅层节点的过程，代码在形式上和递归之前是对称的。
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
