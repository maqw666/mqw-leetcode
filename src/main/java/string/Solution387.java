package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符-简单
 * 给定一个字符串 s ，找到 它的第一个不重复的字符，并返回它的索引 。如果不存在，则返回 -1 。
 * 示例 1：
 * 输入: s = "leetcode"
 * 输出: 0
 * 示例 2:
 * 输入: s = "loveleetcode"
 * 输出: 2
 * 示例 3:
 * 输入: s = "aabb"
 * 输出: -1
 * 提示:
 * 1 <= s.length <= 105
 * s 只包含小写字母
 */
public class Solution387 {
    public static void main(String[] args) {
        int res = firstUniqChar("loveleetcode");
        System.out.println(res);
    }

    public static int firstUniqChar(String s) {
        int n = s.length();
        Map<Character,Integer> charList = new HashMap<Character,Integer>();
        for (int i = 0; i < n; i++) {
            int count = charList.get(s.charAt(i)) ==null ? 0:charList.get(s.charAt(i));
            charList.put(s.charAt(i),count + 1);
        }
        for (int i = 0; i < n; i++) {
            if(charList.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
