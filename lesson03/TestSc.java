package lesson03;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/18 下午9:30
 */
public class TestSc {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        Integer num = scan.nextInt();
        Integer a = num;
        Integer b = 0;
        while(a!=0){
            b = b*10 + a%10;
            a = a/10;
        }
        if (num.intValue()==b.intValue()){
            System.out.println(num + "是回文数");
        } else {
            System.out.println(num + "不是回文数");
        }
        scan.close();
    }
}
