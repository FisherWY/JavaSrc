package lesson01;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/9 下午5:47
 */
public class FibonacciNum {
    public static int Fibonacci(int n) {
        if (n == 1 || n == 2)
            return 1;
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("请输入年份：");
        int Year = scan.nextInt();
        scan.close();
        System.out.println("共有" + Fibonacci(Year * 12) + "对兔子");
    }
}
