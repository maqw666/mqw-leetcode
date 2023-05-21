package hw_od;

import java.util.Scanner;

/**
 * 对称美学
 * 对称就是最大的美学，现有一道关于对称字符串的美学。已知:
 * 第1个字符串: R
 * 第2个字符串: BR
 * 第3个字符串: RBBR
 * 第4个字符串: BRRBRBBR
 * 第5个字符串: RBBRBRRBBRRBRBBR
 * 相信你已经发现规律了，没错!就是第i个字符串=第i-1号字符串的 取反Q+第i-1号字符串。取反即(R->B.B->R)现在告诉你n和k，让你求得第n个字符串的第k个字符是多少。(k的编号从0开始)
 * 输入描述
 * 第一行输入一个T，表示有T组用例:
 * 接下来输入T行，每行输入两个数字，表示n，k1 <= T <= 100;
 * 1 <= n <= 64;
 * 0 <= k < 2^(n-1);
 * 输出描述
 * 输出T行表示答案
 * 输出blue表示字符是B;输出red表示字符是R;示例一输入
 */
public class Solution6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i=0;i< t;i++){
            long n = in.nextLong();
            double k = in.nextDouble();
            String res = find(n,k) =='R' ? "red":"blue";
            System.out.println(res);
        }
    }

    private static char find(long n,double k){
        if(n==1){
            return 'R';
        }
        if(n ==2){
            if(k ==0)
                return 'B';
            else
                return 'R';
        }

        double len = 1L << (n-2);
        //如果k在后半段，则与前一个字符串相同
        if(k >=len){
            double pos = k - len;
            return find(n-1,pos);
        }else{
            //如果k在前半段，则与前一个字符串相反
            return find(n-1,k) == 'R' ? 'B':'R';
        }
    }

}
