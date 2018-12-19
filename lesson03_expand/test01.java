package lesson03_expand;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Fisher
 * @Date: 2018/9/26 2:29 PM
 */
public class test01 {
    public static void main(String args[]){
        SimpleDateFormat myformat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        System.out.println("现在的时间：" + myformat1.format(d));
    }
}
