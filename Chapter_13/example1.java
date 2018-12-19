package Chapter_13;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Fisher
 * @Date: 2018/11/7 3:28 PM
 */

//定义一个类继承JFrame类
public class example1 extends JFrame{
    //定义一个CreateJFrame方法
    public void CreateJFrame(String tittle){
        //实例化一个JFrame对象
        JFrame jf = new JFrame(tittle);
        //获取一个容器
        Container container = jf.getContentPane();
        //创建一个JLabel标签
        JLabel jl = new JLabel("这是一个JFrame窗体");
        //使标签上的文字居中
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        //将标签添加到容器中
        container.add(jl);
        //设置容器背景色
        container.setBackground(Color.WHITE);
        //使窗体可见
        jf.setVisible(true);
        //窗体大小
        jf.setSize(800,600);
        //设置窗体关闭方式
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        new example1().CreateJFrame("创建一个JFrame窗体");
    }
}
