package Chapter_15;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @Author Fisher
 * @Date ${Date} ${Time}
 **/
public class DataStream {
    public static void main(String args[]){
        try {
            FileOutputStream fs = new FileOutputStream("Word.txt");
            DataOutputStream ds = new DataOutputStream(fs);
            ds.writeUTF("使用writeUTF()方法写入数据;");
            ds.writeChars("使用writeChars()方法写入数据;");
            ds.writeBytes("使用writeBytes()方法写入数据;");
            ds.close();

            FileInputStream fi = new FileInputStream("Word.txt");
            DataInputStream di = new DataInputStream(fi);
            System.out.println(di.readUTF());
            System.out.println(di.readChar());
            System.out.println(di.readByte());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
