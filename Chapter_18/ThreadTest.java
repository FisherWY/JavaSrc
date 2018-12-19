package Chapter_18;

/**
 * @Author: Fisher
 * @Date: 2018/11/28 11:12 AM
 */
public class ThreadTest extends Thread {
    private int count = 10;
    @Override
    public void run(){
        while(true){
            System.out.println(count+" ");
            if (--count == 0)
                return;
        }
    }

    public static void main(String args[]){
        new ThreadTest().run();
    }
}
