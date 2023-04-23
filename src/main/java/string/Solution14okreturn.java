package string;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 * 提示：
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] 仅由小写英文字母组成
 */
public class Solution14okreturn {
    public static void main(String[] args) {
        String[] strsArr = {"flower", "flow", "flight"};
        String result = longestCommonPrefix(strsArr);
        System.out.println(result);
    }

    /**
     * 横向扫描
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        int len = strs.length;
        String prex = strs[0];

        for (int i = 1; i < len; i++) {
            prex = getLongestCommPrefix(prex, strs[i]);
            if (prex.length() == 0) {
                break;
            }
        }
        return prex;
    }

    public static String getLongestCommPrefix(String prex1, String prex2) {
        int minLen = Math.min(prex1.length(), prex2.length());
        int index = 0;
        while (index < minLen && prex1.charAt(index) == prex2.charAt(index)) {
            index++;
        }
        return prex1.substring(0, index);
    }

}
