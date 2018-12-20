package lesson11;

import java.util.Random;

/**
 * @Author Fisher
 * @Date 2018/12/5 14:40
 **/
public class homework3 {
    private static class customer implements Runnable {

        private Random number = new Random();
        //选衣服,试衣服的时间
        private int time = number.nextInt(10);
        private int time1 = number.nextInt(10);
        private int using = 0;

        @Override
        public void run() {
            try {
                System.out.println("正在选衣服,时间: " + time1 + "min");
                Thread.sleep(time1 * 1000);
                time1 = number.nextInt(20) + 10;
                fun();
                using--;
                System.out.println("正在结账,时间: 5min");
                Thread.sleep(5000);
                System.out.println("购物完毕,欢迎下次光临");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void fun() {
            if (using < 2) {
                synchronized ("") {
                    using++;
                    System.out.println("正在试衣服,时间: " + time + "min");
                    try {
                        Thread.sleep(time * 1000);
                        time = number.nextInt(20) + 10;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }


    public static void main(String args[]){
        customer c = new customer();
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);
        Thread t3 = new Thread(c);
        Thread t4 = new Thread(c);
        Thread t5 = new Thread(c);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
