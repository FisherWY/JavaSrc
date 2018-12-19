package Chapter_19;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Author: Fisher
 * @Date: 2018/12/19 10:25 AM
 */
public class Address {
    public static void main(String args[]){
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            System.out.println("本机名：" + ip.getHostName());
            System.out.println("本机ip：" + ip.getHostAddress());
            System.out.println(ip.getAddress());
            System.out.println(ip.getCanonicalHostName());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
