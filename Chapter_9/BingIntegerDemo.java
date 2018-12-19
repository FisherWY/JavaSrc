package Chapter_9;

import java.math.BigInteger;

public class BingIntegerDemo {
    public static void main(String args[]) {
        BigInteger b = new BigInteger("4");     //实例化一个大数字
        //取该大数字加 2 的操作
        System.out.println("加法操作：" + b.add(new BigInteger("2")));
        System.out.println("减法操作：" + b.subtract(new BigInteger("2")));
        System.out.println("乘法操作：" + b.multiply(new BigInteger("2")));
        System.out.println("除法操作：" + b.divide(new BigInteger("2")));
        System.out.println("取商：" + b.divideAndRemainder(new BigInteger("3"))[0]);
        System.out.println("取余数：" + b.divideAndRemainder(new BigInteger("3"))[1]);
        System.out.println("做2次方操作：" + b.pow(2));
        System.out.println("取相反数操作：" + b.negate());
    }
}
