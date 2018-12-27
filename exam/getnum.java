package exam;

/**
 * @Author: Fisher
 * @Date: 2018/12/26 8:55 PM
 */
public class getnum {
    public static void main(String args[]) {
        int x,y,z;
        for (x = 0; x <= 20; x++) {
            for (y = 0; y <=34; y++) {
                z = 100 - x - y;
                if ((x+y+z==100) && (5*x+3*y+z/3==100)) {
                    System.out.println(x + " " + y + " " + z);
                }
            }
        }
    }
}
