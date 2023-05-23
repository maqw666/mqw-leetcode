package hw_od.code2023;

import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * 宜居星球改造
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


    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<List<String>> arrList = new ArrayList<List<String>>();
        Set<String> params = new HashSet<String>();
       /* while (sc.hasNext()) {
            String[] arr = sc.nextLine().split(" ");
            arrList.add(Arrays.asList(arr));
        }*/
        int m = 4;
        for (int i = 0; i < m; i++) {
            String[] arr = sc.nextLine().split(" ");
            arrList.add(Arrays.asList(arr));
        }
        int rows = arrList.size();
        int cols = arrList.get(0).size();
        String[][] parmsChanges = new String[rows][cols];
        boolean[][] ifchanges = new boolean[rows][cols];
        int index = 0;
        while (true) {
            index++;
            for (int i = 0; i < arrList.size(); i++) {
                for (int j = 0; j < arrList.get(0).size(); j++) {
                    if ("YES".equals(arrList.get(i).get(j)) && !ifchanges[i][j]) {
                        //上
                        ifchanges[i][j] = true;
                        parmsChanges[i][j] = "YES";
                        if (i > 1) {
                            if ("NO".equals(arrList.get(i - 1).get(j)) && !ifchanges[i - 1][j]) {
                                parmsChanges[i - 1][j] = "YES";
                                ifchanges[i - 1][j] = true;
                            }
                        }
                        // 下
                        if ("NO".equals(arrList.get(i + 1).get(j)) && !ifchanges[i + 1][j]) {
                            parmsChanges[i + 1][j] = "YES";
                            ifchanges[i + 1][j] = true;
                        }
                        //左
                        if (j > 1) {
                            if ("NO".equals(arrList.get(i).get(j - 1)) && !ifchanges[i][j-1]) {
                                parmsChanges[i][j - 1] = "YES";
                                ifchanges[i][j - 1] = true;
                            }
                        }
                        //右
                        if ("NO".equals(arrList.get(i).get(j + 1)) && !ifchanges[i][j+1]) {
                            parmsChanges[i][j + 1] = "YES";
                            ifchanges[i][j + 1] = true;
                        }
                    }else if("NA".equals(arrList.get(i).get(j))){
                        System.out.println(-1);
                        return;
                    }
                }
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    params.add(parmsChanges[i][j]);
                }
            }
            if(params.size()==1){
                System.out.println(index);
                return;
            }
        }

    }
}
