package string;

/**
 * 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 *
 * 示例 1：
 * 输入：haystack = "ssadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * 提示：
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class Solution28ok {
    public static void main(String[] args) {
        String haystack = "ssadbutsad", needle = "sad";
        int res = strStr(haystack, needle);
        System.out.println(res);
    }

    /**
     * 暴力解法
     * 让字符串needle与字符串haystack的所有长度为m的子串均匹配一次
     * 为了减少不必要的匹配，我们每次匹配失败即立刻停止当前子串的匹配，对下一个子串集训匹配。
     * 如果当前子串匹配成功，我们返回当前子串的开始位置即可，如果所有子串都匹配失败，则返回-1.
     * 时间复杂度：O(n*m)
     * 空间复杂度：O(1)
     * @param haystack
     * @param needle
     * @return
     */
    public static int strStr(String haystack, String needle) {
        int m = haystack.length(),n = needle.length();
        for (int i = 0; i + n <= m; i++) {
            boolean flag = true;
            for (int j = 0; j < n; j++) {
                if(haystack.charAt(i+j) !=needle.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}
