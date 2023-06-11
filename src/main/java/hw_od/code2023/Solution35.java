package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 矩阵稀疏扫描
 */
public class Solution35 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        int[] rowZeroCount = new int[m];
        int[] colZeroCount = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (in.nextInt() == 0) {
                    rowZeroCount[i]++;
                    colZeroCount[j]++;
                }
            }
        }

        System.out.println(Arrays.stream(rowZeroCount).filter(val -> val >= n / 2).count());
        System.out.println(Arrays.stream(colZeroCount).filter(val -> val >= m / 2).count());
    }
}