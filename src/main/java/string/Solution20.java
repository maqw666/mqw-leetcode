package string;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 20.有效的括号:简单
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 输入：s = "()"
 输出：true
 输入：s = "()[]{}"
 输出：true
 输入：s = "(]"
 输出：false
 输入：s = "([)]"
 输出：false
 输入：s = "{[]}"
 输出：true
 复杂度分析
 时间复杂度：O(n)O(n)，其中 nn 是字符串 ss 的长度。
 空间复杂度：O(n + |\Sigma|)O(n+∣Σ∣)，其中 \SigmaΣ 表示字符集，本题中字符串只包含 66 种括号，|\Sigma| = 6∣Σ∣=6。栈中的字符数量为 O(n)O(n)，而哈希表使用的空间为 O(|\Sigma|)O(∣Σ∣)，相加即可得到总空间复杂度。
 */
public class Solution20 {
    public static void main(String[] args) {
        String s = "([)]";
        String s1 = "{[]}";
        boolean result = isValid(s1);
        System.out.println(result);
    }
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                Character peek = stack.peek();
                Character character = pairs.get(ch);
                if (stack.isEmpty() || !stack.peek().equals(pairs.get(ch))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
