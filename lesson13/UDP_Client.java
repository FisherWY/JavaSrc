package lesson13;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Author: Fisher
 * @Date: 2018/12/24 9:10 PM
 */
public class UDP_Client extends Thread{
    int port = 8848;
    InetAddress inetAddress = null;
    DatagramPacket packet = null;
    MulticastSocket socket = null;

    UDP_Client() {
        try {
            inetAddress = InetAddress.getByName("224.0.0.1");
            socket = new MulticastSocket(port);
            socket.joinGroup(inetAddress);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while (true) {
            byte data[] = new byte[1024];
            packet = new DatagramPacket(data, data.length, inetAddress, port);
            try {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("收到消息：" + message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        UDP_Client client = new UDP_Client();
        client.start();
    }
}
