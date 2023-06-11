package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import java.util.HashMap;

/**
 * 寻找最大价值的矿堆
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 寻找最大价值的矿堆
 */
public class Solution28 {
    public static int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        //题目没有说明大小，所以整个最大情况
        int[][] matrix = new int[300][300];

        int index = 0;
        while(in.hasNext()){
            String input_str = in.nextLine();
            for(int i = 0; i < input_str.length(); i++){
                matrix[index][i] = Integer.parseInt(String.valueOf(input_str.charAt(i)));
            }
            index+=1;
        }

        int max_value  = 0 ;
        for(int i = 0 ; i < 300 ; i ++){
            for(int j = 0; j < 300 ; j++){
                max_value = Math.max(max_value, dfs(0,i,j,matrix));
            }
        }

        System.out.println(max_value);

        return;
    }

    public static int dfs(int max_value, int x ,int y, int[][] matrix){
        if(matrix[x][y] == 0){
            return max_value;
        }

        max_value += matrix[x][y];
        matrix[x][y] = 0 ;
        //四个方向
        for (int i=0;i<4;i++) {
            int new_x = x + directions[i][0];
            int new_y = y + directions[i][1];

            if( new_x>=0 && new_x<300 && new_y>=0 && new_y<300 &&matrix[new_x][new_y] > 0){
                max_value = dfs(max_value,new_x, new_y, matrix);
            }
        }
        return max_value;
    }
}


