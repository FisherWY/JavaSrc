package lesson13;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Fisher
 * @Date 2018/12/24 17:32
 **/
public class User_Server {
    private ServerSocket serverSocket;
    private Socket socket;
    private ObjectInputStream inputStream;

    public void Connect() {
        try {
            serverSocket = new ServerSocket(8998);
            System.out.println("服务器套接字创建成功");
            System.out.println("等待客户机的连接");
            while (true) {
                socket = serverSocket.accept();
                inputStream = new ObjectInputStream(socket.getInputStream());
                getObj();
            }
        } catch (IOException e) {
            System.out.println("服务器套接字创建失败");
            e.printStackTrace();
        }

    }

    public void getObj() {
        try {
            Object obj = inputStream.readObject();
            User u = (User)obj;
            System.out.println(u.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("传输的数据不是对象");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("io流错误");
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        User_Server server = new User_Server();
        server.Connect();
    }
}
