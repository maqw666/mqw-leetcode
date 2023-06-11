package hw_od.code2023;

import java.util.Scanner;
import java.util.*;

/**
 * 字符串化繁为简
 */
public class Solution10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String tmpResult = "";
        LinkedList<TreeSet<Character>> equalChars = new LinkedList<>();

        boolean flag = false;

        // 分割字符
        for (int i = 0; i < inputStr.length(); i++) {
            char c = inputStr.charAt(i);
            if (c == '(') {
                flag = true;
                equalChars.add(new TreeSet<>());
            } else if (c == ')') {
                flag = false;
                if (equalChars.getLast().size() == 0) equalChars.removeLast();
            } else {
                if (!flag) {
                    tmpResult += c;
                }
                else equalChars.getLast().add(c);
            }
        }

        // 合并
        outer:
        while (true) {
            for (int i = 0; i < equalChars.size(); i++) {
                for (int j = i + 1; j < equalChars.size(); j++) {
                    if (check(equalChars.get(i), equalChars.get(j))) {
                        equalChars.get(i).addAll(equalChars.get(j));
                        equalChars.remove(j);
                        continue outer;
                    }
                }
            }
            break;
        }

        char[] tmpResArr = tmpResult.toCharArray();

        // 开始替换
        for (TreeSet<Character> eq : equalChars) {
            Character t = eq.first();
            for (int i = 0; i < tmpResArr.length; i++) {
                if (eq.contains(tmpResArr[i])) tmpResArr[i] = t;
            }
        }
        System.out.println(tmpResArr.length == 0 ? "0" : new String(tmpResArr));
        return;
    }

    public static boolean check(TreeSet<Character> treeSet1, TreeSet<Character> treeSet2) {
        for (char c = 'a'; c <= 'z'; c++) {
            char uc = (char) (c - 32);
            if ((treeSet1.contains(c) || treeSet1.contains(uc)) && (treeSet2.contains(c) || treeSet2.contains(uc))) {
                return true;
            }
        }
        return false;
    }
}