package hw_od.code2023;
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * 食堂供餐
 */
import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 食堂供餐
 */
public class Solution27 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int N = in.nextInt();
        int M = in.nextInt();
        int[] P = new int[N];

        int amount = 0;
        for(int i=0; i<N; i++){
            P[i] = in.nextInt();
            amount += P[i];
        }

        int left = 0;
        int right = amount - M;
        while (left < right){
            //二分法
            int mid = (left + right) / 2;
            if(check(mid,M,N,P)){
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }

    public static boolean check(int speed, int total, int N, int[] P){
        boolean result = true;
        for(int i=0; i<N; i++){
            total -= P[i];
            if(total < 0){
                result = false;
                break;
            }
            total += speed;
        }

        return result;
    }
}
