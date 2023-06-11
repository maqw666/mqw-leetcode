package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 阿里巴巴找黄金宝箱(IV)
 */
public class Solution38 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] nums = Arrays.stream(in.nextLine().split(",")).mapToInt(Integer::parseInt).toArray();
        LinkedList<int[]> stack = new LinkedList<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);

        nextGreaterElements(nums, stack, res);

        if (stack.size() != 1) {
            nextGreaterElements(nums, stack, res);
        }

        String result = "";
        for (int v : res) {
            result += v + ",";
        }
        System.out.println(result.substring(0, result.length()-1));
        return;
    }

    public static void nextGreaterElements(int[] nums, LinkedList<int[]> stack, int[] res) {
        for (int i = 0; i < nums.length; i++) {
            int ele = nums[i];
            while (true) {
                if (stack.size() == 0) {
                    stack.add(new int[] {ele, i});
                    break;
                } else {
                    int[] peek = stack.get(stack.size() - 1);
                    int peekEle = peek[0];
                    int peekIdx = peek[1];

                    if (ele > peekEle) {
                        res[peekIdx] = ele;
                        stack.removeLast();
                    } else {
                        stack.add(new int[] {ele, i});
                        break;
                    }
                }
            }
        }
    }
}