package lesson13;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @Author Fisher
 * @Date 2018/12/24 17:42
 **/
public class User_Client {
    private Socket socket;
    private ObjectOutputStream outputStream;

    public void Connect() {
        try {
            socket = new Socket("127.0.0.1", 8998);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            System.out.println("无法连接到服务器");
            e.printStackTrace();
        }
    }

    public void sendMsg() {
        try {
            User u = new User("213", "dhasj", "boy", "tiananmen", "sdasd");
            outputStream.writeObject(u);
            outputStream.flush();
        } catch (IOException e) {
            System.out.println("无法发送对象到服务器");
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        User_Client client = new User_Client();
        client.Connect();
        client.sendMsg();
    }
}
