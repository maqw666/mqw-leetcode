package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 例子1：
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 输入: s = ""
 * 输出: 0
 */
public class Solution3 {
    public static void main(String[] args) {
        String str = "bbbbbbb";
        int result = getlengthOfLongestSubstring(str);
        System.out.println(result);
    }


    //方法1
    private static int getlengthOfLongestSubstring(String str) {
        List<Character> charList = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if(!charList.contains(c)){
                charList.add(c);
            }
        }
        return charList.size();
    }

    //方法2
    private static int getlengthOfLongestSubstring2(String str) {
        List<Character> charList = new ArrayList<Character>();
        for (int i = 0; i < str.length(); i++) {
            Character c = str.charAt(i);
            if(!charList.contains(c)){
                charList.add(c);
            }
        }
        return charList.size();
    }

}
