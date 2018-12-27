package exam;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/12/25 8:49 PM
 */
public class TestAdd {
    public static void main(String args[]) {
        int sum = 0, x;
        Scanner scanner = new Scanner(System.in);
        x = scanner.nextInt();
        while (x != 0) {
            int cache = 1;
            for (int i=1; i<=x; i++) {
                cache *= i;
            }
            sum += cache;
            x--;
        }
        System.out.println(sum);
        scanner.close();
    }
}
