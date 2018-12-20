package Chapter_18;

import javax.swing.*;
import java.awt.*;

/**
 * @Author Fisher
 * @Date ${Date} ${Time}
 **/
public class JoinTest extends JFrame {
    private Thread threadA;
    private Thread threadB;
    final JProgressBar progressBarA = new JProgressBar();
    final JProgressBar progressBarB = new JProgressBar();
    int count = 0;
    public static void main(String args[]){
        init(new JoinTest(), 1000, 500);
    }

    public JoinTest(){
        super();
        getContentPane().add(progressBarA, BorderLayout.NORTH);
        getContentPane().add(progressBarB, BorderLayout.SOUTH);
        progressBarA.setBorderPainted(true);
        progressBarB.setBorderPainted(true);

        threadA = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
//                gogogogo();
                while (true) {
//                    gogogogo();
                    progressBarA.setValue(++count);
                    try{
                        Thread.sleep(100);
                        threadB.join();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    if (count == 100) {
                        break;
                    }
                }
                gogogogo();
            }
        });
//        gogogogo();
        threadA.start();

        threadB = new Thread(new Runnable() {
            int count = 0;
            @Override
            public void run() {
                while (true) {
                    progressBarB.setValue(++count);
                    try{
                        Thread.sleep(100);
//                        threadA.notify();
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    if (count == 100) {
                        break;
                    }
                }
            }
        });
        threadB.start();
    }

    public static void init(JFrame frame, int width, int height){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width,height);
        frame.setVisible(true);
    }

    private static void gogogogo(){
        System.out.println("runrunrunrunrnrunurn");
    }
}
