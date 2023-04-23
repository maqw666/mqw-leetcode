package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和-中等
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 *输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 * 提示：
 * 1 <= candidates.length <= 30
 * 1 <= candidates[i] <= 200
 * candidate 中的每个元素都是独一无二的。
 * 1 <= target <= 500
 */
public class Solution39 {

    static List<List<Integer>> res = new ArrayList<>();
    static  List<Integer> ans = new ArrayList<>();
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        List<List<Integer>> lists = combinationSum(candidates, 7);
        System.out.println(lists);
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            sum = sum + candidates[i];
            ans.add(candidates[i]);
            backTrack(candidates,target,sum,i);
            ans.remove(ans.size() - 1);
            sum = sum - candidates[i];

        }
    }

}
