package array;

import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 345. 反转字符串中的元音字母--简单
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 * 提示：
 * 1 <= s.length <= 3 * 105
 * s 由 可打印的 ASCII 字符组成

 */
public class Solution345 {
    public static void main(String[] args) {
        String s = "leetcode";
        String res = reverseVowels(s);
        System.out.println(res);
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        List<Character> yyList = Arrays.asList('a', 'e', 'i', 'o', 'u','A','E','I','O','U');
        char[] arr = s.toCharArray();
        int i =  0,j = s.length() - 1;
        while(i<=j){
            if(yyList.contains(arr[i]) && yyList.contains(arr[j])){
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }else if(yyList.contains(arr[i]) && !yyList.contains(arr[j])){
                j--;
            }else if(!yyList.contains(arr[i]) && yyList.contains(arr[j])){
                i++;
            }else{
                i++;
                j--;
            }
        }
        return new String(arr);
    }
}
