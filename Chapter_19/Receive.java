package Chapter_19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Author: Fisher
 * @Date: 2018/12/24 8:48 PM
 */
public class Receive extends JFrame implements Runnable, ActionListener {
    int port = 9898;
    InetAddress group = null;
    MulticastSocket socket = null;

    //可视化组件
    JButton ince = new JButton("开始接受");
    JButton stop = new JButton("停止接受");
    JTextArea inceAr = new JTextArea(10,10);
    JTextArea inced = new JTextArea(10,10);

    Thread thread;
    boolean b = false;

    public  Receive(){
        super("广播数据报");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        thread = new Thread(this);
        //绑定单击事件
        ince.addActionListener(this);
        stop.addActionListener(this);
        //指定文本域中文字的颜色
        inceAr.setForeground(Color.BLUE);
        //将按钮组放在窗口上边
        JPanel north = new JPanel();
        north.add(ince);
        north.add(stop);
        add(north, BorderLayout.NORTH);
        //将文本域组放在窗口中间
        JPanel center = new JPanel();
        center.add(inceAr);
        center.add(inced);
        add(center, BorderLayout.CENTER);
        //刷新
        validate();

        try {
            group = InetAddress.getByName("224.0.0.1");
            socket = new MulticastSocket(port);
            socket.joinGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }

        setBounds(100,50,360,380);
        setVisible(true);
    }

    public void run() {
        while (true) {
            byte data[] = new byte[1024];
            DatagramPacket packet = null;
            //待接受的数据包
            packet = new DatagramPacket(data, data.length, group, port);

            try {
                //获取数据包中的内容
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                inceAr.setText("正在接受的内容：\n" + message);
                inced.append(message + "\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (b == true) {
                break;
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ince) {
            ince.setBackground(Color.red);
            stop.setBackground(Color.yellow);
            if (!thread.isAlive()) {
                thread = new Thread(this);
            }
            thread.start();
            b = false;
        }
        if (e.getSource() == stop) {
            ince.setBackground(Color.yellow);
            stop.setBackground(Color.red);
            b = true;
        }
    }

    public static void main(String args[]) {
        Receive rec = new Receive();
        rec.setSize(460,200);
    }
}
