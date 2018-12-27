package Chapter_19;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * @Author: Fisher
 * @Date: 2018/12/24 8:42 PM
 */
public class Weather extends Thread {
    String weather = "节目预报：八点有大型晚会，请收听";
    int port = 9898;
    InetAddress inetAddress = null;
    MulticastSocket socket = null;

    Weather() {
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
            byte data[] = weather.getBytes();
            //打包数据
            packet = new DatagramPacket(data, data.length, inetAddress, port);
            System.out.println(new String(data));
            try {
                socket.send(packet);
                sleep(3000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        Weather w = new Weather();
        w.start();
    }
}
