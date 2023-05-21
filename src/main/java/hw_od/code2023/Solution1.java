package hw_od.code2023;

import org.apache.commons.lang.ArrayUtils;

import java.util.*;

/**
 * 宜居星球改造
 */
public class Solution1 {
    public static void main(String[] args) {
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
