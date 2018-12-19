package lesson03;

import java.text.SimpleDateFormat;
import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/18 下午8:19
 */
public class IDCardTest {
    public static String rule = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
            "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";

    //假设18位身份证号码:41000119910101123X  410001 19910101 123X
    //^开头
    //[1-9] 第一位1-9中的一个      4
    //\\d{5} 五位数字           10001（前六位省市县地区）
    //(18|19|20)                19（现阶段可能取值范围18xx-20xx年）
    //\\d{2}                    91（年份）
    //((0[1-9])|(10|11|12))     01（月份）
    //(([0-2][1-9])|10|20|30|31)01（日期）
    //\\d{3} 三位数字            123（第十七位奇数代表男，偶数代表女）
    //[0-9Xx] 0123456789Xx其中的一个 X（第十八位为校验值）
    //$结尾
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入身份证号码：");
        String id = scan.nextLine();
        while (!id.matches(rule)) {
            System.out.println("请输入正确的身份证号码：");
            id = scan.nextLine();
        }
        System.out.println("出生年月日：" + id.substring(6, 14));
        scan.close();
    }
}
