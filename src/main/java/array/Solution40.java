package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II --中等
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * 说明：
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。
 *输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class Solution40 {
    static List<List<Integer>> res = new ArrayList<>();
    static List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        int[] candidates = {2,5,2,1,2};
        //排序周：1 2 2 2 5
        List<List<Integer>> lists = combinationSum2(candidates, 5);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backTrack(candidates,target,0,0);
        return res;
    }

    private static void backTrack(int[] candidates, int target, int sum, int startIndex) {
        if(target == sum){
            res.add(new ArrayList<>(ans));
            return;
        }
        for (int i = startIndex; i < candidates.length && sum + candidates[i] <= target; i++) {
            //核心代码：当不是第一次循环，并且当前元素等于前一个元素时，跳过。即回溯之后跳过相同项
            if(i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            sum = sum + candidates[i];
            ans.add(candidates[i]);
            backTrack(candidates,target,sum,i+1);//递归
            ans.remove(ans.size() - 1);
            sum = sum - candidates[i];//回溯
        }
    }
}
