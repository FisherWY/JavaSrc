package Chapter_13;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Fisher
 * @Date: 2018/11/8 8:37 PM
 */
public class FlowLayoutPosition extends JFrame {
    public FlowLayoutPosition(){
        setTitle("本窗体使用流布局管理器");
        Container c = getContentPane();
        //设置窗体使用流布局管理器，使组件右对齐，并且设置组件之间的水平间隔与垂直间隔
        setLayout(new FlowLayout(2, 100, 5));
        for (int i=0; i<10; i++) {
            c.add(new JButton("button" + i));
        }
        setSize(300,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        new FlowLayoutPosition();
    }
}
