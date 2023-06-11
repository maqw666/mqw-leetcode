package hw_od.code2023;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 数据最节约的备份方法
 */
public class Solution9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] fileArr = Arrays.stream(scanner.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(fileArr);
        int left =0;
        int right = fileArr.length + 1;
        while(left <right){
            int mid = left + (right -left)/2;
            if(calculate(mid,fileArr)){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(left);
    }

    public static boolean calculate(int mid,int[] fileArr){
        int[] nums = new int[mid];
        for(int i=0;i<mid;i++){
            nums[i] = 500;
        }
        for (int i = fileArr.length-1; i >=0; i--) {
            int file= fileArr[i];
            Arrays.sort(nums);
            if(nums[mid-1] >=file){
                nums[mid-1] -= file;
            }else{
                return false;
            }
        }
        return true;
    }

}
