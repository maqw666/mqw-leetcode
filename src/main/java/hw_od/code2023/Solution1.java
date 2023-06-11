package hw_od.code2023;

import org.apache.commons.lang.ArrayUtils;

import java.util.*;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;

/**
 * 宜居星球改造计划
 */
public class Solution1 {
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        // 处理输入
        Scanner in = new Scanner(System.in);
        ArrayList<String[]> matrix = new ArrayList<>();
        while (in.hasNextLine()) {
            String line = in.nextLine();
            //空行跳出
            if ("".equals(line)) {
                break;
            } else {
                matrix.add(line.split(" "));
            }
        }
        int N = matrix.size();
        int M = matrix.get(0).length;
        ArrayList<int[]> yes_area = new ArrayList<>();
        int no_count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(matrix.get(i)[j].equals("YES")) {
                    yes_area.add(new int[] {i, j});
                } else {
                    no_count++;
                }
            }
        }

        // 特殊情况排除
        if (yes_area.size() == 0) {
            System.out.println(-1);
            return;
        }
        if (yes_area.size() == N * M) {
            System.out.println(0);
            return;
        }

        System.out.println(bfs(yes_area,matrix,M,N,no_count));
        return;
    }

    public static int bfs(ArrayList<int[]> yes_area, ArrayList<String[]> matrix,int M, int N,int no_count) {
        int result = 0;

        while (yes_area.size() > 0 && no_count > 0) {
            ArrayList<int[]> new_yes_pos = new ArrayList<>();
            //yes 地区就是BFS的多个源头
            for (int[] pos : yes_area) {
                for (int i=0;i<4;i++) {
                    int new_x = pos[0] + directions[i][0];
                    int new_y = pos[1] + directions[i][1];

                    if (new_x >= 0 && new_x < N && new_y >= 0&& new_y < M&& "NO".equals(matrix.get(new_x)[new_y])) {
                        matrix.get(new_x)[new_y] = "YES";
                        new_yes_pos.add(new int[] {new_x, new_y});
                        no_count--;
                    }
                }
            }

            result++;
            yes_area = new_yes_pos;
        }

        if (no_count == 0) {
            return result;
        } else {
            return -1;
        }
    }
}


