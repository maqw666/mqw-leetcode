package hw_od.code2023;

import java.util.*;

/**
 * 找出两个整数数组中同时出现的整数
 */
public class Solution3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums1= Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int[] nums2=Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        Map<Integer,Integer> nums1_map = new HashMap<Integer,Integer>();
        Map<Integer,Integer> nums2_map = new HashMap<Integer,Integer>();
        for(int num:nums1){
            nums1_map.put(num,nums1_map.getOrDefault(num,0)+1);
        }
        for(int num:nums2){
            nums2_map.put(num,nums2_map.getOrDefault(num,0)+1);
        }
        boolean flag =true;
        Map<Integer, TreeSet<Integer>> same_num_map = new HashMap<Integer,TreeSet<Integer>>();
        for(Integer num:nums1_map.keySet()){
            if(nums2_map.containsKey(num)){
                flag =false;
                int count = Math.min(nums1_map.get(num),nums2_map.get(num));
                same_num_map.putIfAbsent(count,new TreeSet<>());
                same_num_map.get(count).add(num);
            }
        }
        if(flag){
            System.out.println("NULL");
            return;
        }
        same_num_map.keySet().stream().sorted().forEach(
                count ->{
                    StringJoiner sj = new StringJoiner(",",count+":","");
                    for(Integer num:same_num_map.get(count)){
                        sj.add(num+"");
                    }
                    System.out.println(sj.toString());
                }
        );
        return;
    }
}
