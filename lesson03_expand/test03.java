package lesson03_expand;

import java.net.CacheRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/26 2:55 PM
 */
public class test03 {
    public static void main(String args[]) {
        SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
        Scanner scan = new Scanner(System.in);
        System.out.println("输入出生日期（yyyy-MM-dd）:");
        String[] input = scan.nextLine().split("-");
        Calendar birth = Calendar.getInstance();
        birth.set(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
        Calendar today = Calendar.getInstance();
        int week = 0;
        while (birth.before(today)) {
            if (birth.get(Calendar.YEAR) == today.get(Calendar.YEAR) && birth.get(Calendar.MONTH) == today.get(Calendar.MONTH) && birth.get(Calendar.DAY_OF_WEEK_IN_MONTH) == today.get(Calendar.DAY_OF_WEEK_IN_MONTH))
                break;
            else {
                birth.add(Calendar.DAY_OF_YEAR, 7);
                week += 1;
            }
        }
        System.out.println("出生到现在已经 " + week + " 周");
        scan.close();
    }
}
