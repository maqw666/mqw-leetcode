package hw_od;

import java.util.*;

/**
 * 5. 租车绿环岛
 * 部门组织绿岛骑行团建活动。租用公共双人自行车，每辆自行车最多坐两人，做最大载重M。给出部门每个人的体重，请问最多需要租用多少双人自行车。输入描述:
 * 第一行两个数字m、n，分别代表自行车限重，部门总人数。第二行，n个数字，代表每个人的体重，体重都小于等于自行车限重m。0<m<=200
 * 0<n<=1000000
 * 输出描述:
 * 最小需要的双人自行车数量。
 * 示例1 输入输出示例仅供调试，后台判题数据一般不包含示例输入
 * 3 4
 * 3 2 2 1
 *
 * 输出
 */
public class Solution5 {
    public static void main1(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        int maxW = Integer.parseInt(line1.split(" ")[0]);
        int nums = Integer.parseInt(line1.split(" ")[1]);
        String line2 = sc.nextLine();
        String[] arr = line2.split(" ");

        Arrays.sort(arr);
        int left =0;
        int right = nums-1;
        int res = 0;
        while(left <=right){
            int leftW = Integer.parseInt(arr[left]);
            int rightW = Integer.parseInt(arr[right]);
            if(leftW + rightW>=maxW){
                res++;
                right--;
                if(left==right){
                    break;
                }
            }else{
                left++;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        int maxW = Integer.parseInt(line1.split(" ")[0]);
        int nums = Integer.parseInt(line1.split(" ")[1]);
        String line2 = sc.nextLine();
        String[] arr = line2.split(" ");
        List<Integer> weights = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
           weights.add(Integer.parseInt(arr[i]));
        }
        Collections.sort(weights);
        int left =0;
        int right = weights.size()-1;
        int minBikes=0;
        //当前重量
        int tempWight = weights.get(right) + weights.get(left);
        while(left <right){
            if(tempWight <=maxW){
                left++;
            }
            right--;
            minBikes++;
            tempWight = weights.get(right) + weights.get(left);
        }
        if(left ==right){
            minBikes++;
        }
        System.out.println(minBikes);
    }

}
