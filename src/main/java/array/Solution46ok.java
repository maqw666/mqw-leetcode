package array;

import java.util.ArrayList;
import java.util.Collections;
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
        int[] nums = {2,1,3};
        List<List<Integer>> result = permute1(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        List<Integer> output = new ArrayList<Integer>();
        for (int num : nums) {
            output.add(num);
        }

        int n = nums.length;
        backtrack(n, output, res, 0);
        return res;
    }

    public static void backtrack(int n, List<Integer> output, List<List<Integer>> res, int first) {
        // 所有数都填完了
        if (first == n) {
            res.add(new ArrayList<Integer>(output));
        }
        for (int i = first; i < n; i++) {
            // 动态维护数组
            Collections.swap(output, first, i);
            // 继续递归填下一个数
            backtrack(n, output, res, first + 1);
            // 撤销操作
            Collections.swap(output, first, i);
        }
    }


    //置换
    public static List<List<Integer>> permute(int[] nums){
        int len = nums.length;
        //使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        boolean[] if_used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums,len,0,path,if_used,res);
        return res;
    }
    //dfs深度优先搜索
    // bfs-广度优先算法
    private static void dfs(int[] nums,int len,int count,List<Integer> child,boolean[] if_used,List<List<Integer>> res){
        if(count == len){
            res.add(new ArrayList<>(child));
            return;
        }
        //在非叶子节点处，产生不同的分支，这易操作的语义是，在还未选择的数中一次选择一个元素作为下一个位置
        //这显然得通过一个循环实现
        for(int i =0;i < len;i++){
            if(!if_used[i]){
                child.add(nums[i]);
                if_used[i] = true;
                dfs(nums,len,count+1,child,if_used,res);
                //注意：下面这两行代码发生回溯，回溯发生在从深层节点回到浅层节点的过程，代码在形式上和递归之前是对称的。
                if_used[i] = false;
                child.remove(child.size() - 1);
            }
        }
    }
}
