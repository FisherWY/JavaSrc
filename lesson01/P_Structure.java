package lesson01;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/9 下午4:35
 */
public class P_Structure {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int ErrorTime = 0;
        final String name = "Fisher";
        final String psw = "12345678";
        System.out.println("欢迎登录！");
        do {
            System.out.println("请输入用户名：");
            String user = scan.nextLine();
            System.out.println("请输入密码：");
            String pass = scan.nextLine();
            if (user.equals(name) && pass.equals(psw)) {
                System.out.println(name + "，登录成功");
                break;
            } else {
                ErrorTime++;
                if (ErrorTime == 3) {
                    System.out.println("你都已经错了三次了，我都开始怀疑你了！");
                    break;
                }
                System.out.println("用户名密码错误，请重新输入：");
            }
        } while (ErrorTime < 3);
        scan.close();
    }
}
