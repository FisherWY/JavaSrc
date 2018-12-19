package lesson03_expand;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/26 10:40 AM
 */
public class test00 {
    public static void main(String args[]) {
        System.out.println("字符串输出每一个字符");
        String s = "asdbasdafsfa";
        char[] c = s.toCharArray();
        for (char x : c) {
            System.out.print(x + " ");
        }

        System.out.println("\n请输入IP地址：");
        String regex = "^(((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))\\.){3}((\\d{1,2})|(1\\d{2})|(2[0-4]\\d)|(25[0-5]))$";
        boolean isIP = false;
        Scanner scan = new Scanner(System.in);
        do {
            String ip = scan.nextLine();
            if (ip.matches(regex)) {
                isIP = true;
                String[] s1 = ip.split("\\.");
                int i = Integer.parseInt(s1[0]);
                if (i > 0 && i <= 126) {
                    System.out.println("A类IP");
                } else if (i >= 128 && i <= 191) {
                    System.out.println("B类IP");
                } else if (i >= 193 && i <= 223) {
                    System.out.println("C类IP");
                }
            } else {
                System.out.println("IP地址格式不正确，请重新输入：");
            }
        } while (isIP == false);

        String regex1 = "(^[1-9]\\d{5}(18|19|20)\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}[0-9Xx]$)|" +
                "(^[1-9]\\d{5}\\d{2}((0[1-9])|(10|11|12))(([0-2][1-9])|10|20|30|31)\\d{3}$)";
        boolean isID = false;
        System.out.println("请输入身份证号");
        do {
            String s2 = scan.nextLine();
            if (s2.matches(regex1)) {
                isID = true;
                String s3 = s2.substring(6, 14);
                SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
                Calendar c1 = Calendar.getInstance();
                System.out.println(s2.substring(6, 10) + " " + Integer.parseInt(s2.substring(10, 12)) + " " + Integer.parseInt(s2.substring(12, 14)));
                c1.set(Integer.parseInt(s2.substring(6, 10)), Integer.parseInt(s2.substring(10, 12))-1, Integer.parseInt(s2.substring(12, 14)));    //??????
                System.out.println("出生日期：" + myformat.format(c1.getTime()));
                //
                c1.add(Calendar.MONTH, 1);      //??????
                Calendar today = Calendar.getInstance();
                int week = 0;
                while (c1.before(today)) {
                    if (c1.get(Calendar.YEAR) == today.get(Calendar.YEAR) && c1.get(Calendar.MONTH) == today.get(Calendar.MONTH) && c1.get(Calendar.DAY_OF_WEEK_IN_MONTH) == today.get(Calendar.DAY_OF_WEEK_IN_MONTH))
                        break;
                    else {
                        c1.add(Calendar.DAY_OF_YEAR, 7);
                        week += 1;
                    }
                }
                System.out.println("出生到现在已经 " + week + " 周");
            } else {
                System.out.println("身份证格式不正确，请重新输入：");
            }
        } while (isID == false);


        scan.close();
    }
}
