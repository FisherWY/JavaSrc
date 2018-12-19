package Chapter_13;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

/**
 * @Author: Fisher
 * @Date: 2018/11/7 8:55 PM
 */
public class MyImageIcon extends JFrame {
    public MyImageIcon() {
        Container container = getContentPane();
        //创建一个标签
        JLabel jl = new JLabel("这是一个JFrame窗体", JLabel.CENTER);
        //获取图片所在的URL
        URL url = MyImageIcon.class.getResource("../image/apple-touch-icon-next.png");
        //实例化Icon对象
        Icon icon = new ImageIcon(url);
        //为标签设置图片
        jl.setIcon(icon);
        //设置文字放置在标签中间
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        //设置标签为不透明状态
        jl.setOpaque(true);
        //添加标签到容器中
        container.add(jl);
        //设置窗体大小以及是否可见
        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        new MyImageIcon();
    }
}
