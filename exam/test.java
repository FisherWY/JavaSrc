package exam;

/**
 * @Author: Fisher
 * @Date: 2018/12/25 9:25 PM
 */
public class test {
    static void fun(){
        System.out.println("go");
    }
    public static void main(String args[]) {
        long x = 100;
        long y = ++x+--x;
        System.out.println(x);
        System.out.println(y);
        fun();
    }
}
