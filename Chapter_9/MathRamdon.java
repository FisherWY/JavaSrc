package Chapter_9;

/**
 * @ Editor: Fisher
 * @ Date: 2018/9/5 下午10:54
 * @ Param:
 * @ Return:
 **/
public class MathRamdon {
    public static int GetEvenNum(double num1, double num2) {
        //产生num1～num2之间的随机数
        int s = (int) num1 + (int) (Math.random() * (num2 - num1));
        //判断随机数是否为偶数
        if (s % 2 == 0) {
            return s;
        } else {
            return s + 1;
        }
    }

    public static char MathRandomChar(char ch1, char ch2) {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    public static void main(String args[]) {
        System.out.println("任意一个2～32之间的偶数：" + GetEvenNum(2, 32));
        System.out.println("a-z之间的任意字符：" + MathRandomChar('a', 'z'));
    }
}
