package Chapter_13;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Fisher
 * @Date: 2018/11/7 8:26 PM
 */
public class DrawIcon implements Icon {
    private int width;
    private int height;

    @Override
    public int getIconWidth() {
        return width;
    }

    @Override
    public int getIconHeight() {
        return height;
    }

    public DrawIcon(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x, y, width, height);
    }


    public static void main(String args[]){
        DrawIcon icon = new DrawIcon(15,15);
        //创建一个标签，并设置标签上的文字在标签正中间
        JLabel j = new JLabel("测试", icon, SwingConstants.CENTER);
        JFrame jf = new JFrame();
        Container c = jf.getContentPane();
        c.add(j);
        jf.setVisible(true);
        jf.setSize(200,150);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
