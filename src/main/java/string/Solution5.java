package string;

/**
 * 5. 最长回文子串 -中等
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * 示例 1：
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 * 示例 2：
 * 输入：s = "cbbd"
 * 输出："bb"
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 *
 */
public class Solution5 {
    public static void main(String[] args) {
        String s = "baabbad";
        String s1 = longParlindrome(s);
        System.out.println(s1);
    }

    //暴力解法
    public static  String longParlindrome(String s){
        int len = s.length();
        if(len <2){
            return s;
        }
        int maxLen = 1;
        int begin =0;
        //s.charAt(i) 每次都会检查数组小标越界，因此先转换成字符数组，这一步非必需
        char[] charArray = s.toCharArray();
        //枚举所有长度严格大于1的子串，charArray[i..j]
        for(int i=0;i<len -1;i++){
            for(int j=i+1;j<len;j++){
                if(j-i+1 >maxLen && validPalindromic(charArray,i,j)){
                    maxLen = j-i+1;
                    begin =i;
                }
            }
        }
        return s.substring(begin,begin+maxLen);
    }

    private static boolean validPalindromic(char[] charArray, int left, int right){
        while(left <right){
            if(charArray[left] !=charArray[right]){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
