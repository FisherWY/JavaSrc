package Chapter_19;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author Fisher
 * @Date 2018/12/24 10:23
 **/
public class MyTcp {
    private BufferedReader reader;
    private BufferedWriter writer;
    private ServerSocket serverSocket;
    private Socket socket;

    void getserver(){
        try {
            serverSocket = new ServerSocket(8998);
            System.out.println("服务器套接字已经创建成功");
            while (true) {
                System.out.println("等待客户机的连接");
                socket = serverSocket.accept();     //实例化socket对象
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientMsg();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void getClientMsg() {
        try {
            while (true) {
                System.out.println("客户机：" + reader.readLine());
                writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                writer.write("ok\n");
                writer.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (reader != null) {
                reader.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]){
        MyTcp tcp = new MyTcp();
        tcp.getserver();
    }
}
