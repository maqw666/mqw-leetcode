package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 经典屏保
 */
public class Solution11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int t = in.nextInt();

        int x_step = 1, y_step = 1;
        int width = 800, height = 600;

        for(int i=0; i<t; i++){
            if(x == 0){
                x_step = 1;
            }
            if(y == 0){
                y_step = 1;
            }
            if(x + 50 == width){
                x_step = -1;
            }
            if(y + 25 == height){
                y_step = -1;
            }

            x += x_step;
            y += y_step;

        }

        System.out.println(x + " " + y);
        return;
    }
}