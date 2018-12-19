package Chapter_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Author: Fisher
 * @Date: 2018/11/7 5:44 PM
 */

class MyJDialog extends JDialog{
    public MyJDialog(MyFrame frame){
        super(frame, "第一个JDialog窗体", true);
        Container container = getContentPane();
        container.add(new JLabel("这是一个对话框"));
        setBounds(120,120,100,100);
    }
}
public class MyFrame extends JFrame{
    public static void main(String args[]){
        new MyFrame();
    }
    public MyFrame(){
//        JFrame jf = new JFrame();


        Container container = getContentPane();
        container.setLayout(new GridLayout(1,2));

        JLabel jl = new JLabel("这是一个JFrame窗体");
        jl.setVisible(true);
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        container.add(jl);

        JButton bl = new JButton("弹出对话框");
        bl.setVisible(true);
        bl.setHorizontalAlignment(SwingConstants.LEFT);
        bl.setBounds(10,10,100,21);
        bl.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new MyJDialog(MyFrame.this).setVisible(true);
            }
        });
        container.add(bl);


        setSize(800,600);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
