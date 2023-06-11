package hw_od.code2023;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 阿里巴巴找黄金宝箱(V)
 */
public class Solution12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] arr = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int k = Integer.parseInt(in.nextLine());

        int window_sum = 0;
        for (int i = 0; i < k; i++) {
            window_sum += arr[i];
        }

        int result = window_sum;
        for (int i = 1; i <= arr.length - k; i++) {
            window_sum -= arr[i - 1];
            window_sum += arr[i + k - 1];
            result = Math.max(result, window_sum);
        }

        System.out.println(result);
        return;
    }
}
