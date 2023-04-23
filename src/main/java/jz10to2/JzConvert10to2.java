package jz10to2;

import java.util.Scanner;

public class JzConvert10to2 {
    public static void main(String[] args) {
        System.out.println("请输入10进制数据：");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            int num = Integer.parseInt(sc.next());
            String result = BaseSystem_2(num);
            System.out.println("转2进制的结果为："+ result);
        }

    }

    public static String BaseSystem_2(int num){
        String base = "";
        int sys = 0;
        while(true){
            //余数
            sys = num % 2;
            //取商
            num = num / 2;
            base = sys + base;
            if(num < 2){
                sys = num % 2;
                base = sys + base;
                break;
            }
        }
        return base;
    }
}
