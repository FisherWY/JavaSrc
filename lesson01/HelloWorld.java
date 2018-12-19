package lesson01;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/9 下午12:55
 */
public class HelloWorld {
    public static void main(String args[]) {
        System.out.println("请输入你的名字：");
        Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println("Hi " + name + "，欢迎进入Java");
        scan.close();
    }
}
