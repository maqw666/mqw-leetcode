package array;

public class Solution7 {
    public static void main(String[] args) {
        int result = reverse(6324351);
        System.out.println(result);
    }
    public static   int reverse(int x) {

        if(x>=0){
            String xstr = String.valueOf(x);
            char[] chars = xstr.toCharArray();

            int  len = chars.length;
            for(int left = 0,right = len -1;left<right;left++,right--){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }
            String res = "";
            for(char c:chars){
                res += c;
            }
            return Integer.parseInt(res);
        }else{
            String xstr = String.valueOf(x);
            char[] chars = xstr.substring(1,xstr.length()).toCharArray();

            int  len = chars.length;
            for(int left = 0,right = len -1;left<right;left++,right--){
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
            }
            String res = "";
            for(char c:chars){
                res += c;
            }
            return ~(Integer.parseInt(res) - 1);
        }
    }
}
