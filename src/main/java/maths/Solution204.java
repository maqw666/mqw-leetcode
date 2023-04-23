package maths;

/**
 * 204. 计数质数
 *给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 * 示例 1：
 * 输入：n = 10
 * 输出：4
 * 解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
 * 示例 2：
 * 输入：n = 0
 * 输出：0
 * 示例 3：
 * 输入：n = 1
 * 输出：0
 *  提示：
 * 0 <= n <= 5 * 106
 */
public class Solution204 {
    public static void main(String[] args) {
        int result = countPrimes(0);
        System.out.println(result);
    }

    /**
     * 超出运行时间限制
     * @param n
     * @return
     */
    public static int countPrimes(int n) {
        if(n==0 || n==1){
            return 0;
        }
        boolean isFlag = true;
        int count = 0;
        for(int i =2;i< n;i++){
            for(int j=2;j<i;j++){
                if(i % j ==0){
                    isFlag = false;
                    break;
                }
            }
            if(isFlag) {
                count++;
            }else{
                isFlag = true;
            }
        }
        return count;
    }

    /**
     * 超出运行时间限制
     * @param n
     * @return
     */
    public static int countPrimes2(int n) {
        if(n==0 || n==1){
            return 0;
        }
        boolean isFlag = true;
        int count = 0;
        for(int i =2;i< n;i++){
            count += isPrime(i) ? 1:0;

        }
        return count;
    }

    public static boolean isPrime(int x){
        for (int i = 2; i*i <= x ; i++) {
            if(x % i ==0){
                return false;
            }
        }
        return true;
    }

}
