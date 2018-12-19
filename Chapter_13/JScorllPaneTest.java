package Chapter_13;

import javax.swing.*;
import java.awt.*;

/**
 * @Author: Fisher
 * @Date: 2018/11/8 10:00 PM
 */
public class JScorllPaneTest extends JFrame {
    public JScorllPaneTest() throws HeadlessException {
        Container c = getContentPane();
        JTextArea ta = new JTextArea(20,50);
        JScrollPane sp = new JScrollPane(ta);
        c.add(sp);

        setTitle("带滚动条的文字编译器");
        setSize(200,200);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String args[]){
        new JScorllPaneTest();
    }
}
