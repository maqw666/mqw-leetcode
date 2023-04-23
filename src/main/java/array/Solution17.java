package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 */
public class Solution17 {
    public static void main(String[] args) {
        String str = "235";
        List<String> result = letterCombinationsOffice(str);
        System.out.println(result);
    }


    public static List<String> letterCombinationsOffice(String digits) {
        List<String> combinations = new ArrayList<String>();
        if (digits.length() == 0) {
            return combinations;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
        return combinations;
    }

    public static void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                combination.append(letters.charAt(i));
                backtrack(combinations, phoneMap, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        Map<Integer,String> maps = new HashMap<>();
        maps.put(2,"abc");
        maps.put(3,"def");
        maps.put(4,"ghi");
        maps.put(5,"jkl");
        maps.put(6,"mno");
        maps.put(7,"pgrs");
        maps.put(8,"tuv");
        maps.put(9,"wxyz");
        return digitalZiStr(maps,digits);
    }
    private static List<String> digitalZiStr(Map<Integer, String> maps, String digits) {
        int len = digits.length();
        List<String> list = new ArrayList<String>();
        switch (len){
            case 2:
                list = twoDigital(maps,digits);
                break;
            case 3:
                list = threeDigital(maps,digits);
                break;
        }
        return list;

    }

    private static List<String> threeDigital(Map<Integer, String> maps, String digits) {
        int a =  Integer.parseInt(String.valueOf(digits.charAt(0)));
        int b =  Integer.parseInt(String.valueOf(digits.charAt(1)));
        int c =  Integer.parseInt(String.valueOf(digits.charAt(2)));
        List<String> lists = new ArrayList<>();
        String str1 = maps.get(a);
        String str2 = maps.get(b);
        String str3 = maps.get(c);
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                for (int k = 0; k < str3.length(); k++) {
                    StringBuffer sb = new StringBuffer();
                    sb.append(str1.charAt(i));
                    sb.append(str2.charAt(j));
                    sb.append(str3.charAt(k));
                    lists.add(sb.toString());
                }
            }
        }
        return lists;
    }

    private static List<String> twoDigital(Map<Integer, String> maps, String digits) {
        int i =  Integer.parseInt(String.valueOf(digits.charAt(0)));
        int j =  Integer.parseInt(String.valueOf(digits.charAt(1)));
        List<String> lists = new ArrayList<>();
        String str1 = maps.get(i);
        String str2 = maps.get(j);
        for (int k = 0; k < str1.length(); k++) {
            for (int l = 0; l < str2.length(); l++) {
                StringBuffer sb = new StringBuffer();
                sb.append(str1.charAt(k));
                sb.append(str2.charAt(l));
                lists.add(sb.toString());
            }
        }
        return lists;
    }

}
