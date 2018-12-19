package lesson02;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/12 下午3:14
 */
public class Payment {
    final static int basic = 3000;

    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static double count(int type) {
        if (type == 1) {
            return basic + basic * 0.1 + basic * 0.2 + 300;
        } else
            return basic + basic * 0.2 + basic * 0.2 + 1000 + 1000;
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        do {
            String s = scan.nextLine();
            if (!isNumeric(s)){
                System.out.println("输入有误，请重新输入：");
                continue;
            }
            int type = Integer.parseInt(s);
            if (type != 1 && type != 2) {
                System.out.println("输入有误，请重新输入：");
            } else {
                System.out.println("工资：" + count(type));
                break;
            }
        } while (true);
    }
}
