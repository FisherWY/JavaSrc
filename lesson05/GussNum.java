package lesson05;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/30 5:18 PM
 */
public class GussNum {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        do {
            int gess = (int) (Math.random() * 20);
            int time = 0;
            System.out.println("开始猜吧");
            while (true) {
                Integer a = scan.nextInt();
                time++;
                if (a.equals(gess)) {
                    System.out.println("答对了，就是" + gess);
                    System.out.println("总共猜的次数：" + time);
                    break;
                } else if (a < gess) {
                    System.out.println("小了");
                } else {
                    System.out.println("大了");
                }
            }
            System.out.println("继续吗？(任意键继续，输入exit退出):");
        } while (!scan.next().equals("exit"));
        System.out.println("游戏结束");
        scan.close();
    }
}
