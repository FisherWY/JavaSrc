package lesson03;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/18 下午10:20
 */
public class CountAndSumNum {
    public static int AddNum(int a, int i) {
        int sum = 0;
        while (i >= 0) {
            sum = sum * 10 + a;
            i--;
        }
        return sum;
    }

    public static void main(String args[]) {
        Integer sum = 0, a = 0;
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println("请输入0-9的数：");
            a = scan.nextInt();
            if (a >= 0 && a <= 9)
                break;
        }
        System.out.println("请输入叠加次数：");
        Integer b = scan.nextInt();
        for (int i = 0; i < b; i++) {
            sum = sum + AddNum(a, i);
        }
        System.out.println("累加结果：" + sum);
        scan.close();
    }
}
