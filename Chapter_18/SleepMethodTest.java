package Chapter_18;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/**
 * @Author Fisher
 * @Date ${Date} ${Time}
 **/
public class SleepMethodTest extends JFrame {
    private Thread t;
    private static Color[] color = {Color.BLACK, Color.BLUE, Color.YELLOW, Color.CYAN, Color.GRAY, Color.GREEN, Color.ORANGE, Color.RED, Color.PINK};
    private static final Random rand = new Random();
    private static Color getC(){
        return color[rand.nextInt(color.length)];
    }

    public SleepMethodTest(){
        t = new Thread(new Runnable() {
            int x = 30;
            int y = 50;
            @Override
            public void run() {
                while (true){
                    try{
                        Thread.sleep(100);
                    } catch (Exception e){
                        e.printStackTrace();
                    }
                    //获取组件绘图上下文对象
                    Graphics graphics = getGraphics();
                    graphics.setColor(getC());
                    //绘制直线并递增垂直坐标
                    graphics.drawLine(x,y,100,y++);
                    if (y >= 80) {
                        y = 50;
                    }

                }
            }
        });
        t.start();
    }

    public static void main(String args[]){
        init(new SleepMethodTest(), 100, 100);
    }

    public static void init(JFrame frame, int width, int height){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
