package exam;

import java.util.Scanner;

/**
 * @Author Fisher
 * @Date 2018/12/17 10:28
 **/
public class PrintTr {
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        System.out.print("plz input line: ");
        int m = in.nextInt();       //从键盘接收输入
        int n = m;      //列元素个数
        int arr[][] = new int[m][n];
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if ( j<(m-i) || j>=(m+i)) {     //输出等腰三角形两边空格
                    System.out.print("  ");
                }
                else if ( j==(m-i) || j==(m+i-1) ) {    //计算并输出等腰三角形两个腰
                    arr[i][j] = 1;
                    System.out.printf("%-3d", arr[i][j]);
                }
                else if ((i+j)%2==0 && m%2==0 || (i+j)%2==1 && m%2==1) {
                    System.out.print("  ");
                }
                else {
                    arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
                    System.out.printf("%-3d", arr[i][j]);
                }
            }
            System.out.println();
        }
        in.close();
    }
}
