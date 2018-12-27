package lesson13;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @Author Fisher
 * @Date 2018/12/24 10:33
 **/
public class MyClient extends JFrame {
    private PrintWriter writer;
    private BufferedReader reader;
    private Socket socket;

    private Container container;
    private JTextArea textArea = new JTextArea();
    private JTextField textField = new JTextField();
    private JButton button = new JButton();
    private JScrollPane scrollPane = new JScrollPane();

    public MyClient(String tittle) {
        //布局配置
        super(tittle);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        //getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(textArea);

        button.setText("发送");

        container = this.getContentPane();
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(textField, BorderLayout.SOUTH);
        container.add(button, BorderLayout.EAST);

        //textfiled监听事件
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendmsg();
            }
        });

        //button监听事件
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendmsg();
            }
        });
    }

    private void connect() {
        textArea.append("尝试连接\n");
        try {
            socket = new Socket("127.0.0.1", 8998);
            writer = new PrintWriter(socket.getOutputStream(), true);
            textArea.append("完成连接\n");
        } catch (Exception e) {
            textArea.append("无法连接到服务器,错误信息：" + e.getMessage());
            e.printStackTrace();
        }
    }

    private void sendmsg() {
        try {
            if (textField.getText().equals("")) {
                textArea.append("不能发送空的消息\n");
            } else {
                writer.println(textField.getText());
                textArea.append("发送至服务器的消息：" + textField.getText() + '\n');
                textArea.setSelectionEnd(textArea.getText().length());
                textField.setText("");
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                textArea.append("服务器回传消息：" + reader.readLine() + "\n");
            }
        } catch (Exception e1) {
            textArea.append("无法发送消息，错误信息：" + e1.getMessage());
            e1.printStackTrace();
        }
    }

    public static void main(String args[]) {
        MyClient client = new MyClient("a");
        client.setSize(400, 400);
        client.setVisible(true);
        client.connect();
    }
}
