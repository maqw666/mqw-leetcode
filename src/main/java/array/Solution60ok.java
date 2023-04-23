package array;

import java.util.Arrays;

/**
 * 60. 排列序列-困难
 给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。
 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 "123"
 "132"
 "213"
 "231"
 "312"
 "321"
 给定 n 和 k，返回第 k 个排列。
 输入：n = 3, k = 3
 输出："213"
 输入：n = 4, k = 9
 输出："2314"
 输入：n = 3, k = 1
 输出："123"
 提示：

 1 <= n <= 9
 1 <= k <= n!
 */
public class Solution60ok {
    static int r = 0;
    private static boolean[] used;
    //阶层数组
    private static int[] factorial;
    private static int n;
    private static int k;
    public static void main(String[] args) {
        String result = getPermutation(4, 19);
        System.out.println(result);
    }
    public static String getPermutation(int n, int k){
        Solution60ok.n = n;
        Solution60ok.k = k;
        calculateFactorial(n);
        //查找全排列需要的布尔数组
        used = new boolean[n+1];
        Arrays.fill(used,false);
        StringBuilder path = new StringBuilder();
        dfs(0,path);
        return path.toString();
    }
    //计算阶层数组
    private static void calculateFactorial(int n){
        factorial = new int[n+1];
        factorial[0] = 1;
        for(int i =1;i<= n;i++){
            factorial[i] = factorial[i-1] * i;
        }
    }
    //在这一步之前已经选择了几个数字，其值恰好等于这一步需要确定的下标位置
    private static void dfs(int index,StringBuilder path){
        if(index == n){
            return;
        }
        //计算还未确定的数字的全排列的个数，第1次进入的时候是n-1
        int cnt = factorial[n-1-index];
        for(int i = 1;i<=n;i++){
            if(used[i]){
                continue;
            }
            if(cnt < k){
                k -= cnt;
                continue;
            }
            path.append(i);
            used[i] = true;
            dfs(index + 1,path);
            //注意1：不可以回溯（重置变量），算法设计是一下子来到叶子节点，没有回头的过程
            //注意2：这里要加return 后面的数没有必要遍历去尝试了。
        }
    }









    /*
    回溯算法
    public static String getPermutation(int n, int k) {
        int[] nums = generateArr(n);
        List<Integer> result = permute(nums,k);
        String str = "";
        for (int i = 0; i < result.size(); i++) {
            str += result.get(i);
        }
        return str;
    }

    private static int[] generateArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }

    public static List<Integer> permute(int[] nums,int k){
        int len = nums.length;
        //使用一个动态数组保存所有可能的全排列
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return null;
        }
        boolean[] used = new boolean[len];
        List<Integer> path = new ArrayList<>();
        dfs(nums,0,path,used,res,k);
        return res.get(k-1);
    }

    private static void dfs(int[] nums,int depth,List<Integer> path,boolean[] used,List<List<Integer>> res,int k){
        if(depth == nums.length){
            res.add(new ArrayList<>(path));
            r++;
            return;
        }
        //在非叶子节点处，产生不同的分支，这易操作的语义是，在还未选择的数中一次选择一个元素作为下一个位置
        //这显然得通过一个循环实现
        for(int i =0;i < nums.length;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                if(r !=k) {
                    dfs(nums, depth + 1, path, used, res, k);
                }else{
                    break;
                }
                //注意：下面这两行代码发生回溯，回溯发生在从深层节点回到浅层节点的过程，代码在形式上和递归之前是对称的。
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }*/
}
