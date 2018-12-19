package lesson04;

import java.util.Scanner;

/**
 * @Author: Fisher
 * @Date: 2018/9/30 2:41 PM
 */
public class getRamdomNum {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        System.out.println("输入要产生随机数的个数:");
        int i1 = Integer.parseInt(scan.nextLine());
        System.out.println("产生随机数的范围:");
        int i2 = Integer.parseInt(scan.nextLine());
        for (int i=0; i<i1; i++){
            System.out.print((int)(Math.random()*i2) + " ");
        }
        scan.close();
    }
}
