package hw_od.code2023;

import java.util.Scanner;

/**
 * 数字游戏
 */
public class Solution6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] nums = new int[n];
            for(int i=0;i<n;i++){
                nums[i] = scanner.nextInt();
            }
            int sum = 0;
            boolean ifFlag = false;
            int[] arr = new int[m];
            arr[0] = 1;
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                sum %= m;
                if(arr[sum] !=0){
                    ifFlag = true;
                    break;
                }
                arr[sum]++;
            }
            System.out.println(ifFlag ? 1 : 0);
        }
        return;
    }
}
