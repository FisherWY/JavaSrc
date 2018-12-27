package exam;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/12/25 9:02 PM
 */
public class Test1 {
    public static void main(String args[]) {
        int[] a = new int[21];
        int count = 0;
        Random random = new Random();
        Boolean exist = false;
        while (count < 21) {
            Integer num = random.nextInt(100);
            for (int i=0; i<count; i++) {
                if (num == a[i]) {
                    exist = true;
                    break;
                }
            }
            if (exist) {
                exist = false;
            } else {
                a[count] = num;
                count++;
            }
        }
        for (int x : a) {
            System.out.print(x + "  ");
        }
    }
}
