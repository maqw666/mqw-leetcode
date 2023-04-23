package maths;

/**
 * 326. 3 的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 *
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 *示例 1：
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 *
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 *
 * 输入：n = 45
 * 输出：false
 *  
 *
 * 提示：
 *
 * -231 <= n <= 231 - 1
 *  
 *、
 */
public class Solution326 {
    public static void main(String[] args) {
        //System.out.println(1/3);
        //System.out.println(5/3);
        System.out.println(isPowerOfThree1(12));
    }

    public static boolean isPowerOfThree(int n) {
        if(n==0){
            return false;
        }
        if(n==1){
            return true;
        }
        while (n>0){
            if(n % 3==0 && (n / 3) ==1){
                return true;
            }
            n = n / 3;
        }
        return false;
    }

    public static boolean isPowerOfThree1(int n) {

        while (n !=0 && n % 3==0){
            n = n / 3;
        }
        return n==1;
    }

}
