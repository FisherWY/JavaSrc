package Chapter_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Fisher
 * @Date: 2018/11/9 7:26 PM
 */
public class SimpleEvent extends JFrame {
    private JButton jb = new JButton("我是按钮");
    public SimpleEvent(){
        setLayout(null);
        add(jb);
        jb.setBounds(10,10,100,30);
        //为按钮添加一个ActionListener接口对象
        jb.addActionListener(new jbAction());

        setTitle("sdad");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    class jbAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            jb.setText("我被点击了");
        }
    }

    public static void main(String args[]){
        new SimpleEvent();
    }
}
