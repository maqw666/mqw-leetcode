package hw_od;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 简单的自动曝光
 * 一个图像有n个像素点，存储在一个长度为n的数组img里，每个像素点的取值范围[0,255]的正整数。
 * 请你给图像每个像素点值加上一个整数k(可以是负数》，得到新图newImg，使得新图newImg的所有像素平均值最接近中位值128.
 * 请输出这个整数k。
 * 输入描述
 * n个整数，中间用空格分开
 * 例如
 * oooo
 * 4个数值，中间用空格分开
 * 输出描述
 * 个整数k
 * 补充说明
 * ·1 <= n <= 100
 * 如有多个整数k都满足，输出小的那个k新图的像素值会自动截取到[0.255]范围。当新像素值<0，其值会更改为0，当新像素值>255，其值会更改为255:
 * 例如如newlmg=”-1 -2 256”会自动更改为”00 255”
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例输入
 * 0000
 * 输出
 * 128
 */
public class Solution7 {
    //
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        Integer result=null;
        double min_diff = 256;
        //转为数组
        List<Integer> nums = Arrays.stream(line1.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        for (int i = -127; i <=128 ; i++) {
            double sum = 0;
            for (int j = 0; j < nums.size(); j++) {
                sum += Math.max(0,Math.min((nums.get(j) +i),255));
            }
            //与中位数的差距
            double diff = Math.abs(sum / nums.size() - 128);
            if(diff <min_diff){
                min_diff = diff;
                result = i;
            }else if(diff ==min_diff && result !=null){
                result = Math.min(result,i);
            }
        }
        System.out.println(result);
    }
}
