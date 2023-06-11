package hw_od.code2023;

import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 五子棋迷
 */
public class Solution24 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = in.nextInt();
        in.nextLine();
        int[] nums = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findMaxMatchIndex(nums, target));
        return;
    }

    public static int findMaxMatchIndex(int[] nums, int target) {
        int maxVal = Integer.MIN_VALUE;
        int midDist = 0;
        int resIndex = -1;
        int count = nums.length;
        for (int i = 0; i < count; i++) {
            if (nums[i] == 0) {
                int left = i - 1;
                int right = i + 1;
                int leftCount = 0;
                int rightCount = 0;
                while (left >= 0 && nums[left] == target && leftCount < maxVal - 1) {
                    leftCount++;
                    left--;
                }

                if (leftCount > 4) {
                    continue;
                }

                rightCount = leftCount;

                while (right < count && nums[right] == target && rightCount < maxVal - 1) {
                    rightCount++;
                    right++;
                }

                int totalCount = leftCount + rightCount;
                int distToMid = Math.abs(i - count / 2);

                if (totalCount > maxVal || (totalCount == maxVal && distToMid < midDist)) {
                    maxVal = totalCount;
                    resIndex = i;
                    midDist = distToMid;
                }
            }
        }

        return resIndex;
    }
}