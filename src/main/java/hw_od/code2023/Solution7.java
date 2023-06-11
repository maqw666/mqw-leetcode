package hw_od.code2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 跳房子2
 */
public class Solution7 {
    public static int sumIndex = Integer.MAX_VALUE;
    public static int count;
    public static List<Integer> res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        count = Integer.parseInt(scanner.nextLine());
        String[] strs = scanner.nextLine().replace("[", "").replace("]", "").split(",");
        int[] nums = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
        dfs(nums,3,new ArrayList<>(),new ArrayList<>(),0);

        StringBuilder sb= new StringBuilder();
        sb.append("[");
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i));
            if(res.size()-1 !=i){
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb.toString());
    }
    public static void dfs(int[] nums,int n,List<Integer> list,List<Integer> indexList,int index){
        if(n==0){
            int total =0;
            int tempIndexSum = 0;
            for(int i=0;i<3;i++){
                total += list.get(i);
                tempIndexSum += indexList.get(i);
            }
            if(count == total && tempIndexSum <sumIndex){
                sumIndex = tempIndexSum;
                res = new ArrayList<>(list);
            }
        }else{
            for (int i = index; i < nums.length; i++) {
                list.add(nums[i]);
                indexList.add(i);
                dfs(nums,n-1,list,indexList,i+1);
                list.remove(indexList.size()-1);
                indexList.remove(indexList.size() - 1);
            }
        }
    }
}
