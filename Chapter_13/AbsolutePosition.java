package Chapter_13;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Fisher
 * @Date: 2018/11/7 9:37 PM
 */
public class AbsolutePosition extends JFrame {
    public AbsolutePosition() {
        setTitle("本窗口使用绝对布局");      //设置该窗体的标题
        setLayout(null);        //使该窗体取消布局管理器设置
        setBounds(0,0,300,200);     //绝对定位窗体的位置与大小
        Container c = getContentPane();     //创建容器对象
        //创建按钮
        JButton b1 = new JButton("按钮1");
        JButton b2 = new JButton("按钮2");
        //设置按钮位置与大小
        b1.setBounds(10,30,80,30);
        b2.setBounds(60,70,100,20);

        c.add(b1);
        c.add(b2);

        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        new AbsolutePosition();
    }
}
