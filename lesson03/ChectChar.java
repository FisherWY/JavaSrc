package lesson03;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/18 下午7:49
 */
public class ChectChar {
    public static void main(String args[]) {
        int count = 0;
        Scanner scan = new Scanner(System.in);
        System.out.println("输入任意一段英文：");
        String str = scan.nextLine();
        System.out.println("输入任意一个英文字母：");
        String str1 = scan.next();
        scan.close();
        for (int i = 0; i < str.length(); i++) {
            String substr = str.substring(i, i + 1);
            if (substr.equals(str1))
                count++;
        }
        System.out.println("字符" + str1 + "出现了" + count + "次");
    }
}
