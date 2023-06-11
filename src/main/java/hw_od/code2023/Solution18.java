package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 组装最大可靠性设备
 */
public class Solution18 {
    static class Item {
        int reliability;
        int price;

        public Item(int reliability, int price) {
            this.reliability = reliability;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //输入处理
        int s = in.nextInt();
        int n = in.nextInt();
        int total = in.nextInt();

        TreeSet<Integer> reliabilities = new TreeSet<>();
        ArrayList<ArrayList<Item>> kinds = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            kinds.add(new ArrayList<>());
        }

        for (int i = 0; i < total; i++) {
            int type = in.nextInt();
            int reliability = in.nextInt();
            reliabilities.add(reliability);
            int price = in.nextInt();
            kinds.get(type).add(new Item(reliability, price));
        }

        int result = -1;

        // 按照可靠性排序
        for (ArrayList<Item> kind : kinds) {
            kind.sort((a, b) -> a.reliability - b.reliability);
        }

        // 转为数组
        Integer[] temp_list = reliabilities.toArray(new Integer[0]);

        int left = 0;
        int right = temp_list.length - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            if (check(kinds, temp_list[mid], s)) {
                result = temp_list[mid];
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);
    }

    // 判断可靠性是否可以保证所有种类器件都能选到，且价格之和小于s
    public static boolean check(ArrayList<ArrayList<Item>> kinds, int maxReliability, int s) {
        int sum = 0;
        for (ArrayList<Item> kind : kinds) {
            int idx = binarySearch(kind, maxReliability);
            if (idx < 0) {
                idx = -idx - 1;
            }
            if (idx == kind.size()) {
                return false;
            }

            sum += kind.get(idx).price;
        }

        return sum <= s;
    }

    //二分查找，找到一个可靠性>=maxReliability
    public static int binarySearch(ArrayList<Item> kind, int target) {
        int left = 0;
        int right = kind.size() - 1;

        while (left <= right) {
            int mid = (left + right) >> 1;
            Item Item = kind.get(mid);

            if (Item.reliability > target) {
                right = mid - 1;
            } else if (Item.reliability < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return -left - 1;
    }
}