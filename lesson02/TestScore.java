package lesson02;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/12 下午2:44
 */
public class TestScore {
    public static boolean isNumeric(String str){
        for (int i = str.length();--i>=0;){
            if (!Character.isDigit(str.charAt(i))){
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        int ErrorTime = 0;
        Scanner scan = new Scanner(System.in);
        do {
            String s = scan.nextLine();
            if (!isNumeric(s)){
                System.out.println("输入不是数字，请重新输入：");
                continue;
            }
            int a = Integer.parseInt(s);
//            System.out.println("输入的分数：" + a);
            if (a < 0 || a > 100) {
                ErrorTime++;
                if (ErrorTime == 5) {
                    System.out.println("错误次数过多了，你分神了？");
                }
                System.out.println("输入的数字越界，请重新输入：");
            } else if (a < 60 && a >= 0) {
                System.out.println("不及格");
                break;
            } else if (a >= 60 && a < 70) {
                System.out.println("及格");
                break;
            } else if (a >= 70 && a < 80) {
                System.out.println("中等");
                break;
            } else if (a >= 80 && a < 90) {
                System.out.println("良好");
                break;
            } else if (a >= 90 && a <= 100) {
                System.out.println("优秀");
                break;
            } else break;
        } while (ErrorTime < 5);
        scan.close();
    }
}
