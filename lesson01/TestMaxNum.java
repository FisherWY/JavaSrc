package lesson01;

/**
 * @Author: Fisher
 * @Date: 2018/9/9 下午5:24
 */
public class TestMaxNum {
    public static void main(String args[]) {
        long Start = System.currentTimeMillis();
        System.out.println("Max Int: " + Integer.MAX_VALUE);
        System.out.println("Min Int: " + Integer.MIN_VALUE);
        System.out.println("Min Long: " + Long.MIN_VALUE);
        System.out.println("Min Long: " + Long.MAX_VALUE);
        long End = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (End - Start) + " ms");
    }
}
