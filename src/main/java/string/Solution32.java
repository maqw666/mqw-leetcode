package string;

/**
 * 32. 最长有效括号--困难
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 输入：s = ""
 * 输出：0
 * 提示：
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 */
public class Solution32 {
    public static void main(String[] args) {
        String s = "()(())";
        int result = longestValidParentheses(s);
        System.out.println(result);
    }

    public static int longestValidParentheses(String s) {
        int longest = 0;
        int begin = 0;
        char first;
        char second;
        int end = s.length() - 2;
        while (begin <= end) {
            first = s.charAt(begin);
            second = s.charAt(begin + 1);
            if (first == '(' && second == '(') {
                longest = 0;
                begin = begin + 1;
            } else if (first == '(' && second == ')') {
                longest = longest + 2;
                begin = begin + 2;
            } else if(first == ')' && second == '('){
                begin = begin + 1;
            } else {
                begin = begin + 2;
            }
        }
        return longest;
    }
}
