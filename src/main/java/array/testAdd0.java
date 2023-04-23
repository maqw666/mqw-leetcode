package array;

public class testAdd0 {
    public static void main(String[] args) {
        String s = autoGenericCode("0", 3);
        String s1 = autoGenericCode(s, 3);

        System.out.println(s);
        System.out.println(s1);





    }


    /**
     * 不够位数的在前面补0，保留num的长度位数字
     * @param code
     * @return
     */
    private static String autoGenericCode(String code, int num) {
        String result = "";
        // 保留num的位数
        // 0 代表前面补充0
        // num 代表长度为4
        // d 代表参数为正数型
        result = String.format("%0" + num + "d", Integer.parseInt(code) + 1);

        return result;
    }
}
