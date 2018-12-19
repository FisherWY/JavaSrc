package lesson03_expand;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: Fisher
 * @Date: 2018/9/26 2:31 PM
 */
public class test02 {
    public static void main(String args[]){
        SimpleDateFormat myformat1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = new Date();
        System.out.println("3天后的时间：" + myformat1.format(new Date(d.getTime() + (long)3*24*60*60*1000)));
    }
}
