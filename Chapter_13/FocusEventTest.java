package Chapter_13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * @Author: Fisher
 * @Date: 2018/11/9 7:34 PM
 */
public class FocusEventTest extends JFrame {
    public FocusEventTest(){
        JTextField jt1 = new JTextField("请单击其他文本框",10);
        JTextField jt2 = new JTextField("请单击我",10);

        //Container container = getContentPane();
        setLayout(new GridLayout(2,1,5,5));
        add(jt1);
        add(jt2);

        jt1.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                JOptionPane.showMessageDialog(null,"文本框失去焦点");
            }

            @Override
            public void focusLost(FocusEvent e) {
                //JOptionPane.showMessageDialog(null,"----");
            }
        });


        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        new FocusEventTest();
    }
}
