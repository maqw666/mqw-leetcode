package string;

/**
 * 125. 验证回文串
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "A man, a plan, a canal: Panama"
 * 输出：true
 * 解释："amanaplanacanalpanama" 是回文串。
 * 示例 2：
 * <p>
 * 输入：s = "race a car"
 * 输出：false
 * 解释："raceacar" 不是回文串。
 * 示例 3：
 * <p>
 * 输入：s = " "
 * 输出：true
 * 解释：在移除非字母数字字符之后，s 是一个空字符串 "" 。
 * 由于空字符串正着反着读都一样，所以是回文串。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 105
 * s 仅由可打印的 ASCII 字符组成
 */
public class Solution125ok {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean res = isPalindrome1(s);
        System.out.println(res);
        //System.out.println(5 / 2);
    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String newS = sb.toString();
        int m = newS.length();
        for (int i = 0; i < m / 2; i++) {
            if (newS.charAt(i) != newS.charAt(m - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome1(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(Character.toLowerCase(s.charAt(i)));
            }
        }
        String newS = sb.toString();
        int right = newS.length() - 1;
        int left = 0;
        while(left < right){
            if (newS.charAt(left) != newS.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
