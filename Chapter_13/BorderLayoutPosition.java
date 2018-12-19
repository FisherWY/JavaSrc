package Chapter_13;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Fisher
 * @Date: 2018/11/8 9:08 PM
 */
public class BorderLayoutPosition extends JFrame {
    String[] border = {BorderLayout.CENTER, BorderLayout.NORTH, BorderLayout.SOUTH, BorderLayout.WEST, BorderLayout.EAST};
    String[] buttonName = {"center", "north", "south", "west", "east"};
    public BorderLayoutPosition(){
        setTitle("这个窗体使用边界布局管理器");
        Container c = getContentPane();
        setLayout(new BorderLayout());
        for (int i=0; i<border.length; i++){
            c.add(border[i], new JButton(buttonName[i]));
        }
        setSize(350,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        new BorderLayoutPosition();
    }
}
