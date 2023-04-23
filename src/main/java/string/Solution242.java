package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 */
public class Solution242 {
    public static void main(String[] args) {
        String s = "rat", t = "car";
        boolean anagram = isAnagram1(s, t);
        System.out.println(anagram);
    }

    //自己编码不太对
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charsMaps = new HashMap<Character, Integer>();
        Map<Character, Integer> charsMapt = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            charsMaps.put(s.charAt(i), charsMaps.getOrDefault(s.charAt(i), 0) + 1);
            charsMapt.put(t.charAt(i), charsMapt.getOrDefault(t.charAt(i), 0) + 1);
        }
        if (charsMaps.size() != charsMapt.size()) {
            return false;
        } else {
            for (Character c : charsMaps.keySet()) {
                if (charsMaps.get(c) != charsMapt.get(c)) {
                    return false;
                }
            }
        }
        return true;
    }

    //官方解题1
    public static boolean isAnagram1(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> charsMaps = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            charsMaps.put(s.charAt(i), charsMaps.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            charsMaps.put(t.charAt(i),charsMaps.getOrDefault(t.charAt(i),0) - 1);
            if(charsMaps.get(t.charAt(i)) <0){
                return false;
            }
        }
        return true;
    }
}
