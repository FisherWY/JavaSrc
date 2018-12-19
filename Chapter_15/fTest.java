package Chapter_15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.jar.JarFile;

/**
 * @Author: Fisher
 * @Date: 2018/11/16 9:16 PM
 */
public class fTest extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel jContentPanel = null;        //面板对象
    private JTextArea jtextarea = null;         //文本域对象
    private JPanel controlPanel = null;         //面板对象
    private JButton openButton = null;          //打开按钮
    private JButton closeButton = null;         //关闭按钮

    private JButton getOpenButton(){
        if (openButton == null){
            openButton = new JButton();
            openButton.setText("写入文件");
            openButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File file = new File("word.txt");
                    try{
                        FileWriter out = new FileWriter(file);
                        String s = jtextarea.getText();
                        out.write(s);
                        out.close();
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }
            });
        }
        return openButton;
    }

    private JButton getCloseButton(){
        if (closeButton == null){
            closeButton = new JButton();
            closeButton.setText("读取文件");
            closeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    File file = new File("word.txt");
                    try {
                        FileReader in = new FileReader(file);
                        char s[] = new char[1024];
                        int len = in.read(s);
                        jtextarea.setText(new String(s, 0 ,len));
                        in.close();
                    }catch (Exception e1){
                        e1.printStackTrace();
                    }
                }
            });
        }
        return closeButton;
    }

    public fTest(){
        super();
        initialize();
    }

    private void initialize(){
        this.setSize(300,200);
        this.setContentPane(getJpanel());
        this.setTitle("xiagao");
    }

    private JPanel getJpanel(){
        if (jContentPanel == null){
            jContentPanel = new JPanel();
            jContentPanel.setLayout(new BorderLayout());
            jContentPanel.add(jtextarea, BorderLayout.CENTER);
            jContentPanel.add(openButton, BorderLayout.WEST);
            jContentPanel.add(closeButton, BorderLayout.EAST);

        }

        return jContentPanel;
    }

    public static void main(String args[]){
        fTest thisclass = new fTest();
        thisclass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        thisclass.setVisible(true);
    }

}
