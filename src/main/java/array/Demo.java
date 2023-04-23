package array;

public class Demo {

    private static int age;//用static修饰的成员变量静态变量或者叫做类变量
    public String name;   //成员变量也叫做实例变量

    public static void show(){//静态函数
        Demo d = new Demo();//因为静态先于对象加载如果需要访问必须要创建对象才能访问
        d.name = "张三";//静态方法不能直接访问非静态的成员变量
        /*d.showDemo();//静态方法不能直接访问非静态的成员函数
        System.out.println(d.name);*/
       /* System.out.println(d.name);*/
       // System.out.println(name);
    }
    public void showDemo(){//成员函数
        age = 10;//可以直接访问静态变量
        show();//也可以直接访问静态函数
        System.out.println(age);
    }

    public static void main(String[] args) {
        show();
    }
}
