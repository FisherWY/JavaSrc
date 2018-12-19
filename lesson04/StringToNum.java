package lesson04;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/30 2:17 PM
 */
public class StringToNum {
    public static void main(String args[]){
        String isInt = "(^[0-9]\\d*)";
        String isFloat = "(^[0-9]\\d*\\.{1}[0-9]\\d*)";
        Scanner scan = new Scanner(System.in);
        System.out.println("输入一串数字：");
        String s1 = scan.nextLine();
        if (s1.matches(isInt)){
            Integer i1 = Integer.parseInt(s1);
            System.out.println("整数:" + i1);
        } else if (s1.matches(isFloat)){
            Double d1 = Double.parseDouble(s1);
            DecimalFormat myformat = new DecimalFormat("'$'#.00");
            System.out.println("浮点数:" + myformat.format(d1));
        } else {
            System.out.println("输入了非数字！");
        }
        scan.close();
    }
}
