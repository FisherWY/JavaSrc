package lesson03;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/18 下午10:40
 */
public class ForSale {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入生产日期(yyyy-MM-dd):");
        String start = scan.nextLine();
        String[] date = start.split("-");
        SimpleDateFormat myformat = new SimpleDateFormat("yyyy-MM-dd");
        //
        Calendar c = Calendar.getInstance();
        c.set(Integer.parseInt(date[0]), Integer.parseInt(date[1]), Integer.parseInt(date[2]));
        System.out.println("输入的日期：" + c.getTime());
        c.add(Calendar.DATE, 180);
        System.out.println("180天之后：" + c.getTime());
        //System.out.println(c.get(Calendar.DAY_OF_WEEK));
        c.add(Calendar.DATE, -c.get(Calendar.DAY_OF_WEEK)%7);
        System.out.println("最近的一个星期六：" + c.getTime());
        System.out.println("应在此日销售：" + myformat.format(c.getTime()));
        //
        scan.close();
    }
}
