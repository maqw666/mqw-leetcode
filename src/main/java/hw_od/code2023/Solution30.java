package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 模拟消息队列
 */
public class Solution30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] producers = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] consumers = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = producers.length;
        int m = consumers.length;

        // 发布信息
        int[][] producer_map = new int[producers.length / 2][];
        for (int i = 0, k = 0; i < producers.length; i += 2) {
            producer_map[k++] = new int[] {producers[i], producers[i + 1]};
        }
        Arrays.sort(producer_map, (a, b) -> a[0] - b[0]);

        // 消费信息
        int[][] consumer_map = new int[consumers.length / 2][];
        for (int j = 0, k = 0; j < consumers.length; j += 2) {
            consumer_map[k++] = new int[] {consumers[j], consumers[j + 1]};
        }

        // 构造消费关系
        ArrayList<ArrayList<Integer>> relation_map = new ArrayList<>();
        for (int j = 0; j < consumer_map.length; j++) {
            relation_map.add(new ArrayList<>());
        }

        // 遍历发布者
        for (int i = 0;i<producer_map.length;i++) {
            for (int j = consumer_map.length - 1; j >= 0; j--) {
                //是否能被订阅到
                if (producer_map[i][0] >= consumer_map[j][0] && producer_map[i][0] < consumer_map[j][1]) {
                    relation_map.get(j).add(producer_map[i][1]);
                    break;
                }
            }
        }

        // 打印
        for (int i=0;i<relation_map.size();i++) {
            if (relation_map.get(i).size() == 0) {
                System.out.println("-1");
            } else {
                String result = "";
                for (Integer x : relation_map.get(i)) {
                    result += x;
                }
                System.out.println(result);
            }
        }

        return;
    }
}