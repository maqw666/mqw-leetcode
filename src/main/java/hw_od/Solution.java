package hw_od;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 投篮大赛
 * 你现在是一场采用特殊赛制投篮大赛的记录员。这场比赛由若干回合组成，过去几回合的得分可能会影响以后几回合的得分比赛开始时，记录是空白的。
 * 你会得到一个记录操作的字符串列表 opsQ，其中ops是你需要记录的第i项操作，ops遵循下述规则:
 * 。整数x-表示本回合新获得分数x
 * “+”- 表示本回合新获得的得分是前两次得分的总和。
 * 。“D”- 表示本回合新获得的得分是前一次得分的两倍。
 * 。“C”- 表示本回合没有分数，并且前一次得分无效，将其从记录中移除.
 * 请你返回记录中所有得分的总和。
 * 示例1:
 * 输入: 5 2 C D +
 * 输出: 30
 * 解释:
 * “5”-记录加5，记录现在是[5]
 * “2”-记录加2，记录现在是[5,2]
 * “C”-使前一次得分的记录无效并将其移除，记录现在是[5].
 * “D”-记录加2*5=10，记录现在是[5，101.
 * “+”-记录加5+10=15，记录现在是[5，10，15].
 * 所有得分的总和5+10+15=30
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line1 = sc.nextLine();
        String[] scores = line1.split(" ");
        List<Integer> resList = new ArrayList<Integer>();

        for (int i = 0; i < scores.length; i++) {
            if("+".equals(scores[i])){
                if(resList.size()<2){
                    System.out.println(-1);
                    return;
                }
                resList.add(resList.get(resList.size()-1) + resList.get(resList.size()-2));
            }else if("D".equals(scores[i])){
                if(resList.size()<1){
                    System.out.println(-1);
                    return;
                }
                resList.add(resList.get(resList.size()-1) * 2);
            }else if("C".equals(scores[i])){
                if(resList.size()<1){
                    System.out.println(-1);
                    return;
                }
                resList.remove(resList.size()-1);
            } else{
                resList.add(Integer.parseInt(scores[i]));
            }
        }
        //算总分数
        if(resList.size() ==0){
            System.out.println(0);
        }else{
            System.out.println(resList.stream().reduce(Integer::sum).get());
        }
    }
}
