package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Collectors;
import java.math.BigInteger;
import java.util.stream.Stream;

/**
 * 数据分类
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 座位调整
 */
public class Solution26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] positions = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int result = 0;

        for (int i = 0; i < positions.length; i++) {
            if (positions[i] == 0) {
                //考虑左边界
                boolean flag1 = i == 0 || positions[i - 1] == 0;
                //考虑右边界
                boolean flag2 = i == positions.length - 1 || positions[i + 1] == 0;
                if (flag1 && flag2) {
                    result++;
                    positions[i] = 1;
                    i++;
                }
            }
        }

        System.out.println(result);
        return;
    }
}
