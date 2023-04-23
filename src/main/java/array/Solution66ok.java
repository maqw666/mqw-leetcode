package array;

public class Solution66ok {
    public static void main(String[] args) {
        int[] arr = {9};
        plusOne(arr);
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] = digits[i] + 1;
                for (int j = i + 1; j < len; j++) {
                    digits[j] = 0;
                }
                return digits;
            }
        }
        int[] res = new int[digits.length+1];
        res[0] = 0;
        return res;
    }

    private static int[] getAddArr(int[] digits) {
        int[] res = new int[digits.length+1];
        res[0] = 1;
        return res;
    }
}
