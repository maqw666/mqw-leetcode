package hw_od;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * 一、题目描述 字符串重新排序
 * 给定一个字串s，s包含以空格分隔的若干个单词，请对s进行如下处理后输出：
 *
 * 1、单词内部调整
 *
 * 对每个单词字母重新按字典序排序。
 *
 * 2、单词间顺序调整:
 *
 * 统计每个单词出现的次数，并按次数降序排列；
 * 次数相同时，按单词长度升序排列；
 * 次数和单词长度均相同时，按字典序升序排列。
 * 请输出处理后的字符串，每个单词以一个空格分隔。
 *二、输入描述
 * 行宁符串，每个宁符取值范围: [a-zA-Z0-9]以及空格，宁符串长度范围: [1,1000]。
 *
 * 三、输出描述
 * 重新排序后的宁符串，每个单词间隔1个空格，且首属无空格
 */
public class Solution2 {
    public static void main(String[] args) {
       // what are you are you are
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String[] wordsArr = line.split(" ");
        Map<String,Integer> maps = new HashMap<String,Integer>();
        for (int i = 0; i < wordsArr.length; i++) {
            String newWord = wordInSort(wordsArr[i]);
            int val = maps.getOrDefault(newWord, 0);
            maps.put(newWord,val+1);
        }
        ArrayList<Map.Entry<String, Integer>> entries = new ArrayList<>(maps.entrySet());
        entries.sort((a,b)->{
            String key1= a.getKey();
            String key2 = b.getKey();
            Integer value1 = a.getValue();
            Integer value2 = b.getValue();
            if(value1 !=value2){
                return value2 - value1;
            }else{
                if(key1.length() !=key2.length()){
                    return key1.length()-key2.length();
                }else{
                    return key1.compareTo(key2);
                }
            }
        });

        StringBuilder stringBuilder = new StringBuilder();
        for(Map.Entry<String,Integer> entry:entries){
            String key = entry.getKey();
            Integer value = entry.getValue();
            for (int i = 0; i < value; i++) {
                stringBuilder.append(key).append(" ");
            }
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        System.out.println(stringBuilder);

    }

    public static String wordInSort(String word){
        char[] chars = word.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);

    }
}
