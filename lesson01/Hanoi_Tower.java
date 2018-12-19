package lesson01;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/9 下午6:12
 */
public class Hanoi_Tower {
    public static void Move(char src, char dest) {
        System.out.println(src + "-->" + dest);
    }

    public static void Hanoi(int n, char src, char medium, char dest) {
        if (n == 1)
            Move(src, dest);
        else {
            Hanoi(n - 1, src, dest, medium);
            Move(src, dest);
            Hanoi(n - 1, medium, src, dest);
        }
    }

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("输入盘片的数量：");
        int m = scan.nextInt();
        scan.close();
        Hanoi(m, 'A', 'B', 'C');;
    }
}