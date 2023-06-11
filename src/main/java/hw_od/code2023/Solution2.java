package hw_od.code2023;

import java.util.*;

/**
 * 阿里巴巴找黄金宝箱(II)
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(",");
        Map<String,Integer> num_map = new HashMap<String,Integer>();
        for(int i=0;i<strs.length;i++){
            String str = strs[i];
            num_map.put(str,num_map.getOrDefault(str,0)+1);
        }
        List<Map.Entry<String,Integer>> num_list = new ArrayList<Map.Entry<String,Integer>>(num_map.entrySet());
        num_list.sort((a,b)->{
            return b.getValue() - a.getValue();
        });
        int count =0;
        int result=0;
        int half=(int) Math.ceil((double)strs.length/2);
        for(int i=0;i<num_list.size();i++){
            count +=num_list.get(i).getValue();
            result++;
            if(count >=half){
                break;
            }
        }
        System.out.println(result);
        return;
    }
}
