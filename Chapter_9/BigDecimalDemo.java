package Chapter_9;

import java.math.BigDecimal;

/**
 * @ Editor: Fisher
 * @ Date: 2018/9/7 下午9:39
 * @ Param:
 * @ Return:
 **/
public class BigDecimalDemo {
    static final int location = 10;

    //定义加法方法，参数为加数和被加数，返回两数之和
    public BigDecimal add(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.add(b2);
    }

    //定义减法方法，参数为减数与被减数，返回两数之差
    public BigDecimal sub(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.subtract(b2);
    }

    //定义乘法方法，参数为乘数与被乘数，返回两数之积
    public BigDecimal mul(double value1, double value2) {
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.multiply(b2);
    }

    //定义除法方法，参数为除数与被除数以及商后面的小数点位数
    public BigDecimal div(double value1, double value2) {
        return div(value1, value2, location);
    }

    public BigDecimal div(double value1, double value2, int b) {
        if (b < 0) {
            System.out.println("b的值一定要大于0");
        }
        BigDecimal b1 = new BigDecimal(Double.toString(value1));
        BigDecimal b2 = new BigDecimal(Double.toString(value2));
        return b1.divide(b2, b, BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String args[]) {
        BigDecimalDemo b = new BigDecimalDemo();
        System.out.println("两个数字相加结果：" + b.add(-7.5, 8.9));
        System.out.println("两个数字相减结果：" + b.sub(-7.5, 8.9));
        System.out.println("两个数字相乘结果：" + b.mul(-7.5, 8.9));
        System.out.println("两个数字相除结果：" + b.div(-7.5, 8.9, 5));
    }
}
