package lesson13;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Author: Fisher
 * @Date: 2018/12/24 8:42 PM
 */
public class UDP_Server extends Thread {
    String message = "Helloworld";
    int port = 8848;
    InetAddress inetAddress = null;
    MulticastSocket socket = null;

    UDP_Server() {
        try {
            inetAddress = InetAddress.getByName("224.0.0.1");
            socket = new MulticastSocket(port);
            socket.setTimeToLive(1);        //指定发送范围是本地网络
            socket.joinGroup(inetAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run(){
        while (true) {
            DatagramPacket packet = null;
            byte data[] = message.getBytes();
            //打包数据
            packet = new DatagramPacket(data, data.length, inetAddress, port);
            System.out.println("发送消息：" + new String(data));
            try {
                socket.send(packet);
                sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        UDP_Server w = new UDP_Server();
        w.start();
    }
}
