package Chapter_17;

/**
 * @Author: Fisher
 * @Date: 2018/11/3 8:36 PM
 */
interface Constants{
    int Constants_A = 1;
    int Constants_B = 12;
}
public class ConstantsTest {
    //将常量放置在枚举类型中
    enum Constants2 {
        Constants_A,
        Constants_B
    }
    //使用接口定义常量
    public static void doit(int c){
        switch (c) {
            case Constants.Constants_A:
                System.out.println("doit Constants_A");
                break;
            case Constants.Constants_B:
                System.out.println("doit Constants_B");
                break;
        }
    }

    //定义一个参数对象是枚举类型的方法
    public static void doit2(Constants2 c) {
        switch (c) {
            case Constants_A:
                System.out.println("doit2 Constants_A");
                break;
            case Constants_B:
                System.out.println("doit2 Constants_B");
                break;
        }
    }

    public static void main(String args[]){
        ConstantsTest.doit(Constants.Constants_A);
        ConstantsTest.doit2(Constants2.Constants_B);
        ConstantsTest.doit2(Constants2.Constants_A);
        ConstantsTest.doit(3);
    }
}
