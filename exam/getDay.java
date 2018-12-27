package exam;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/12/26 9:18 PM
 */
public class getDay {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入日期:(如2001年3月5日)");
        String strDate = sc.next();

        int year = Integer.parseInt(strDate.substring(0,strDate.indexOf("年")));
        int month = Integer.parseInt(strDate.substring(strDate.indexOf("年")+1,strDate.indexOf("月")));
        int day = Integer.parseInt(strDate.substring(strDate.indexOf("月")+1,strDate.indexOf("日")));

        int sum = 0;
        int count = 0;

        while (count < month) {
            switch (count) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    sum = sum + 31;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    sum = sum + 30;
                    break;
                case 2:
                    if(year%4==0 || year%400==0)  //若是闰年
                        sum = sum + 29;
                    else
                        sum += 28;
                    break;
            }
            count++;
        }
        System.out.println("你给的日期是那一年中的第 " + (sum+day) + "天");
    }
}
