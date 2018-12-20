package lesson11;

/**
 * @Author Fisher
 *
 **/
public class ThreadTest {
    private static class ThreadB extends Thread {
        private int count = 0;

        @Override
        public void run() {
            while (true) {
                try {
                    count++;
                    System.out.println("Thread线程输出: " + count);
                    if (count == 10) {
                        this.interrupt();
                        break;
                    }
                    this.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    private static class ThreadA extends Thread implements Runnable {
        private int count = 0;

        @Override
        public void run() {
            while (true) {
                try {
                    count++;
                    System.out.println("Runnable接口线程输出: " + count);
                    if (count == 10) {
                        this.interrupt();
                        break;
                    }
                    this.sleep(100);
                } catch (InterruptedException e) {
                    break;
                }
            }
        }
    }

    public static void main(String args[]) {
        Thread t1 = new Thread(new ThreadA());
        t1.start();
        Thread t2 = new Thread(new ThreadB());
        t2.start();
//        new ThreadA().run();
//        new ThreadB().run();
    }
}
